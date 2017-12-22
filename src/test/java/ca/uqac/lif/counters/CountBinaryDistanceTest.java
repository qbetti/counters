package ca.uqac.lif.counters;

import ca.uqac.lif.cep.ltl.Troolean.Value;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CountBinaryDistanceTest {

    @Test
    public void testTrue () {
        CountBinaryDistance count = new CountBinaryDistance(Value.TRUE);
        assertEquals((Integer) 0, count.getValue(Value.INCONCLUSIVE, Value.FALSE));
        assertEquals((Integer) 0, count.getValue(Value.FALSE, Value.TRUE));
        assertEquals((Integer) 0, count.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 0, count.getValue(Value.FALSE, Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE, Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE, Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE, Value.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Value.FALSE, Value.INCONCLUSIVE));

        CountBinaryDistance count1 = new CountBinaryDistance(Value.TRUE);
        assertEquals((Integer) 0, count1.getValue(Value.FALSE, Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count1.getValue(Value.TRUE, Value.INCONCLUSIVE));
        assertEquals((Integer) 0, count1.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 0, count1.getValue(Value.TRUE, Value.TRUE));
        assertEquals((Integer) 0, count1.getValue(Value.FALSE, Value.FALSE));
        assertEquals((Integer) 0, count1.getValue(Value.TRUE, Value.FALSE));
    }

    @Test
    public void testFalse () {
        CountBinaryDistance count = new CountBinaryDistance(Value.FALSE);
        assertEquals((Integer) 0, count.getValue(Value.INCONCLUSIVE, Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE, Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE, Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE, Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE, Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE, Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE, Value.INCONCLUSIVE));

        CountBinaryDistance count1 = new CountBinaryDistance(Value.FALSE);
        assertEquals((Integer) 1, count1.getValue(Value.FALSE, Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count1.getValue(Value.TRUE, Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count1.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 1, count1.getValue(Value.TRUE, Value.TRUE));
        assertEquals((Integer) 0, count1.getValue(Value.FALSE, Value.FALSE));
        assertEquals((Integer) 0, count1.getValue(Value.TRUE, Value.FALSE));
    }

    @Test
    public void testInconclusive () {
        CountBinaryDistance count = new CountBinaryDistance(Value.INCONCLUSIVE);
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE, Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE, Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE, Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE, Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE, Value.TRUE));
        assertEquals((Integer) 0, count.getValue(Value.TRUE, Value.INCONCLUSIVE));
        assertEquals((Integer) 0, count.getValue(Value.FALSE, Value.INCONCLUSIVE));

        CountBinaryDistance count1 = new CountBinaryDistance(Value.INCONCLUSIVE);
        assertEquals((Integer) 0, count1.getValue(Value.FALSE, Value.INCONCLUSIVE));
        assertEquals((Integer) 0, count1.getValue(Value.TRUE, Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count1.getValue(Value.INCONCLUSIVE, Value.TRUE));
        assertEquals((Integer) 2, count1.getValue(Value.TRUE, Value.TRUE));
        assertEquals((Integer) 2, count1.getValue(Value.FALSE, Value.FALSE));
        assertEquals((Integer) 2, count1.getValue(Value.TRUE, Value.FALSE));
    }
}