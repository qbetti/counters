package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.ltl.Troolean;


public class UniversalQuantifier extends Quantify {

    private Troolean.Value quantified;

    public UniversalQuantifier(int toCompareWith, BinaryFunction<?, ?, Boolean> comparator) {
        super(toCompareWith, comparator);
        this.quantified = null;
    }

    @Override
    public Troolean.Value quantify(boolean b) {
        if(quantified != null) {
            return quantified;

        } else if(b) {
            return Troolean.Value.INCONCLUSIVE;

        } else {
            quantified = Troolean.Value.FALSE;
            return quantified;
        }
    }
}
