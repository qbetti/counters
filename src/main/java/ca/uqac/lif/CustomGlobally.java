package ca.uqac.lif;

import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.ProcessorException;
import ca.uqac.lif.cep.UniformProcessor;
import ca.uqac.lif.cep.ltl.Troolean;

public class CustomGlobally extends UniformProcessor {

    private boolean hasBeenFalseOnce;

    public CustomGlobally() {
        super(1, 1);
        this.hasBeenFalseOnce = false;
    }

    @Override
    protected boolean compute(Object[] inputs, Object[] outputs) throws ProcessorException {
        Troolean.Value value = (Troolean.Value) inputs[0];

        if(hasBeenFalseOnce) {
            outputs[0] = Troolean.Value.FALSE;

        } else {
            if(value == Troolean.Value.FALSE) {
                outputs[0] = value;
                hasBeenFalseOnce = true;
            } else {
                outputs[0] = Troolean.Value.INCONCLUSIVE;
            }
        }
        return true;
    }

    @Override
    public Processor clone() {
        return new CustomGlobally();
    }
}
