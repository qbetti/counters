package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public abstract class CountBinary extends BinaryFunction<Troolean.Value, Troolean.Value, Integer> {

    protected final Troolean.Value toCount;

    public CountBinary(Troolean.Value toCount) {
        super(Troolean.Value.class, Troolean.Value.class, Integer.class);
        this.toCount = toCount;
    }
}
