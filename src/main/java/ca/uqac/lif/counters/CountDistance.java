package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;

public class CountDistance extends Count {

    private int currentIndex;
    private int firstValidIndex;

    public CountDistance(Troolean toCount) {
        super(toCount);
        this.currentIndex = 1;
        this.firstValidIndex = 0;
    }

    public Integer getValue(Troolean troolean) throws FunctionException {
        if(firstValidIndex == 0 && isTrooleanToCount(troolean))
            firstValidIndex = currentIndex;

        currentIndex++;
        return firstValidIndex;
    }
}
