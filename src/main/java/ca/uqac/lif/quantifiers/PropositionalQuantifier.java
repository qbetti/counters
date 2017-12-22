package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public class PropositionalQuantifier extends Quantify {

    public PropositionalQuantifier(int toCompareWith, BinaryFunction<?, ?, Boolean> comparator) {
        super(toCompareWith, comparator);
    }

    @Override
    public Troolean quantify(boolean b) {
        return b ? Troolean.TRUE : Troolean.FALSE;
    }
}
