package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.functions.UnaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public abstract class Quantify extends UnaryFunction<Number, Troolean.Value>{

    protected final int toCompareWith;

    private final BinaryFunction comparator;

    public Quantify(int toCompareWith, BinaryFunction<?, ?, Boolean> comparator) {
        super(Number.class, Troolean.Value.class);
        this.toCompareWith = toCompareWith;
        this.comparator = comparator;
    }

    @Override
    public Troolean.Value getValue(Number input) {
        return quantify((Boolean) comparator.getValue(input.intValue(), toCompareWith));
    }

    public abstract Troolean.Value quantify(boolean b);
}
