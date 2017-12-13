package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.functions.UnaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public abstract class Quantify extends UnaryFunction<Integer, Troolean>{

    protected final int toCompareWith;

    private final BinaryFunction<Number, Number, Boolean> comparator;

    public Quantify(int toCompareWith, BinaryFunction<Number, Number, Boolean> comparator) {
        super(Integer.class, Troolean.class);
        this.toCompareWith = toCompareWith;
        this.comparator = comparator;
    }

    public Troolean getValue(Integer input) throws FunctionException {
        return quantify(comparator.getValue(input, toCompareWith));
    }

    public abstract Troolean quantify(boolean b);
}
