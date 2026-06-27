package src.services;

import src.interfaces.IDiaStrategy;
import src.strategies.*;

import java.util.HashMap;
import java.util.Map;

public class DiaStrategySelector {
    
    private Map<String, IDiaStrategy> strategies;

    public DiaStrategySelector() {
        strategies = new HashMap<>();
        strategies.put("segunda-feira", new SegundaStrategy());
        strategies.put("terça-feira", new TercaStrategy());
        strategies.put("quarta-feira", new QuartaStrategy());
        strategies.put("quinta-feira", new QuintaStrategy());
        strategies.put("sexta-feira", new SextaStrategy());
        strategies.put("sábado", new SabadoStrategy());
        strategies.put("domingo", new DomingoStrategy());
    }

    public IDiaStrategy getStrategy(String dia) {
        return strategies.getOrDefault(dia.toLowerCase(), new NullDiaStrategy());
    }
}
