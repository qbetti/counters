package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;

public class ExistentialQuantifier extends Quantify {

    private Troolean quantified;

    public ExistentialQuantifier(int toCompareWith, BinaryFunction<?, ?, Boolean> comparator) {
        super(toCompareWith, comparator);
        this.quantified = null;
    }

    @Override
    public Troolean quantify(boolean b) {
        if(quantified != null) {
            return quantified;

        } else if(b) {
            quantified = Troolean.TRUE;
            return quantified;

        } else {
            return Troolean.INCONCLUSIVE;
        }
    }
}
