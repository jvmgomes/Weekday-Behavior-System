# Weekday Behavior System

Sistema que identifica o dia da semana e exibe uma mensagem motivacional com prioridade do dia, delegando o comportamento a estratégias específicas.

## Estrutura das estratégias

A interface `IDiaStrategy` define o contrato que todas as estratégias seguem — um método `getPrioridade()` e um `executar(nome, tarefa)`. Cada dia da semana tem sua própria classe que implementa esse contrato:

| Dia | Estratégia | Prioridade |
|---|---|---|
| Segunda | `SegundaStrategy` | ALTA |
| Terça | `TercaStrategy` | ALTA |
| Quarta | `QuartaStrategy` | MEDIA |
| Quinta | `QuintaStrategy` | MEDIA |
| Sexta | `SextaStrategy` | BAIXA |
| Sábado | `SabadoStrategy` | BAIXA |
| Domingo | `DomingoStrategy` | BAIXA |
| Inválido | `NullDiaStrategy` | N/A |

O `DiaStrategySelector` guarda essas estratégias em um `HashMap` e sempre devolve uma instância válida — nunca `null`.

## Questões de reflexão

**1. Como evitar verificações repetidas de nulo no código principal?**

O próprio seletor nunca retorna `null`. Se o dia não for encontrado, ele já devolve um `NullDiaStrategy`. O `Main` simplesmente chama `strategy.executar(...)` sem precisar checar nada.

**2. Qual padrão representa a ausência de estratégia de forma segura?**

**Null Object.** Em vez de retornar `null` quando não há estratégia, retorna-se um objeto que implementa a mesma interface com comportamento neutro.

**3. Como esse padrão foi incorporado à solução?**

`NullDiaStrategy` implementa `IDiaStrategy` normalmente, mas só exibe uma mensagem informando que nenhuma ação foi executada. O seletor a usa como fallback automático, então o restante do código não precisa saber que o dia era inválido.

## Exemplos de execução

**Entrada válida — quarta-feira**
```
=== Day Planner Menu ===
Escolha uma opção: 1

Opção: 3
Digite seu nome: Ana
Digite a tarefa do dia: Implementar relatório

Usuário: Ana
Dia consultado: quarta-feira
Prioridade: MEDIA
Mensagem: Ana, dia de revisão: verifique o andamento de "Implementar relatório".
```

**Entrada inválida**
```
=== Day Planner Menu ===
Escolha uma opção: 2

Digite o dia da semana: funday

Dia não reconhecido. A estratégia padrão (NullDiaStrategy) está disponível.
Escolha uma opção: 1

Digite seu nome: Ana
Digite a tarefa do dia: Implementar relatório

Dia inválido ou sem estratégia associada. Nenhuma ação foi executada.
```