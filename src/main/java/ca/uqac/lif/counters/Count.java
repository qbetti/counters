package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.functions.UnaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public abstract class Count extends UnaryFunction<Troolean.Value, Integer>{

    protected final Troolean.Value toCount;

    public Count(Troolean.Value toCount) {
        super(Troolean.Value.class, Integer.class);
        this.toCount = toCount;
    }
}
