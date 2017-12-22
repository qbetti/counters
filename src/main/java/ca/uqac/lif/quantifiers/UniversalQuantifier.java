package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;


public class UniversalQuantifier extends Quantify {

    private Troolean quantified;

    public UniversalQuantifier(int toCompareWith, BinaryFunction<?, ?, Boolean> comparator) {
        super(toCompareWith, comparator);
        this.quantified = null;
    }

    @Override
    public Troolean quantify(boolean b) {
        if(quantified != null) {
            return quantified;

        } else if(b) {
            return Troolean.INCONCLUSIVE;

        } else {
            quantified = Troolean.FALSE;
            return quantified;
        }
    }
}
