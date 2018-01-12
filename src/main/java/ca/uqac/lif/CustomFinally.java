package ca.uqac.lif;

import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.ProcessorException;
import ca.uqac.lif.cep.UniformProcessor;
import ca.uqac.lif.cep.ltl.Troolean;

public class CustomFinally extends UniformProcessor {

    private boolean hasBeenTrueOnce;

    public CustomFinally() {
        super(1, 1);
        this.hasBeenTrueOnce = false;
    }

    @Override
    protected boolean compute(Object[] inputs, Object[] outputs) {
        Troolean.Value value = (Troolean.Value) inputs[0];

        if(hasBeenTrueOnce) {
            outputs[0] = Troolean.Value.TRUE;

        } else {
            if(value == Troolean.Value.TRUE) {
                outputs[0] = value;
                hasBeenTrueOnce = true;
            } else {
                outputs[0] = Troolean.Value.INCONCLUSIVE;
            }
        }
        return true;
    }

    @Override
    public CustomFinally clone() {
        return new CustomFinally();
    }
}
