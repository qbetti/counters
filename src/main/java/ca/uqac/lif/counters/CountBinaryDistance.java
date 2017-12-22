package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;

public class CountBinaryDistance extends CountBinary {

    private final CountDistance count1;
    private final CountDistance count2;

    public CountBinaryDistance(Troolean.Value toCount) {
        super(toCount);
        this.count1 = new CountDistance(toCount);
        this.count2 = new CountDistance(toCount);
    }

    @Override
    public Integer getValue(Troolean.Value troolean1, Troolean.Value troolean2) {
        int dist1 = 0, dist2 = 0;

        try {
            dist1 = count1.getValue(troolean1);
            dist2 = count2.getValue(troolean2);
        } catch (FunctionException e) {
            e.printStackTrace();
        }

        return Integer.max(dist1 - dist2, 0);
    }
}
