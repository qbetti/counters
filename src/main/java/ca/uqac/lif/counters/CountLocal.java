package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;

public class CountLocal extends Count {

    private int currentIndex;
    private int lastValidIndex;

    public CountLocal(Troolean.Value toCount) {
        super(toCount);
        this.currentIndex = 1;
        this.lastValidIndex = 0;
    }

    @Override
    public Integer getValue(Troolean.Value troolean) throws FunctionException {
        if(toCount == troolean)
            lastValidIndex = currentIndex;

        currentIndex++;
        return lastValidIndex;
    }
}
