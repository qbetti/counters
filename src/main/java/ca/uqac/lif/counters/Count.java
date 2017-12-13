package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.functions.UnaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public abstract class Count extends UnaryFunction<Troolean, Integer>{

    protected final Troolean toCount;

    public Count(Troolean toCount) {
        super(Troolean.class, Integer.class);
        this.toCount = toCount;
    }

    protected boolean isTrooleanToCount(Troolean troolean) {
        return toCount.getValue() == troolean.getValue();
    }
}
