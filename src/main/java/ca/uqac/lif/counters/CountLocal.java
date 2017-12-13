package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;

public class CountLocal extends Count {

    private int currentIndex;
    private int lastValidIndex;

    public CountLocal(Troolean toCount) {
        super(toCount);
        this.currentIndex = 1;
        this.lastValidIndex = 0;
    }

    public Integer getValue(Troolean troolean) throws FunctionException {
        if(isTrooleanToCount(troolean))
            lastValidIndex = currentIndex;

        currentIndex++;
        return lastValidIndex;
    }
}
