package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;

public class CountDistance extends Count {

    private int currentIndex;
    private int firstValidIndex;

    public CountDistance(Troolean.Value toCount) {
        super(toCount);
        this.currentIndex = 1;
        this.firstValidIndex = 0;
    }

    @Override
    public Integer getValue(Troolean.Value troolean) throws FunctionException {
        if(firstValidIndex == 0 && toCount == troolean)
            firstValidIndex = currentIndex;

        currentIndex++;
        return firstValidIndex;
    }
}
