package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.functions.UnaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public abstract class Quantify extends UnaryFunction<Object, Troolean>{

    protected final int toCompareWith;

    private final BinaryFunction comparator;

    public Quantify(int toCompareWith, BinaryFunction<?, ?, Boolean> comparator) {
        super(Object.class, Troolean.class);
        this.toCompareWith = toCompareWith;
        this.comparator = comparator;
    }

    @Override
    public Troolean getValue(Object input) {
        return quantify((Boolean) comparator.getValue(input, toCompareWith));
    }

    public abstract Troolean quantify(boolean b);
}
