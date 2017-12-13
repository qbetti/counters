package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public abstract class CountBinary extends BinaryFunction<Troolean, Troolean, Integer> {

    protected final Troolean toCount;

    public CountBinary(Troolean toCount) {
        super(Troolean.class, Troolean.class, Integer.class);
        this.toCount = toCount;
    }
}
