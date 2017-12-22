package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;

public class CountSimple extends Count {

    private int counter;

    public CountSimple(Troolean.Value toCount) {
        super(toCount);
        this.counter = 0;
    }

    public Integer getValue(Troolean.Value troolean) throws FunctionException {
        if(toCount == troolean)
            counter++;

        return counter;
    }
}
