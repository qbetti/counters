package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;

public class CountSimple extends Count {

    private int counter;

    public CountSimple(Troolean toCount) {
        super(toCount);
        this.counter = 0;
    }

    public Integer getValue(Troolean troolean) throws FunctionException {
        if(isTrooleanToCount(troolean))
            counter++;

        return counter;
    }
}
