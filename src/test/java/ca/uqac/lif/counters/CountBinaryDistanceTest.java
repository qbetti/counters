package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountBinaryDistanceTest {

    @Test
    public void testTrue () throws FunctionException {
        CountBinaryDistance count = new CountBinaryDistance(Troolean.TRUE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE, Troolean.FALSE));
        assertEquals((Integer) 0, count.getValue(Troolean.FALSE, Troolean.TRUE));
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 0, count.getValue(Troolean.FALSE, Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE, Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE, Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE, Troolean.INCONCLUSIVE));

        CountBinaryDistance count1 = new CountBinaryDistance(Troolean.TRUE);
        assertEquals((Integer) 0, count1.getValue(Troolean.FALSE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count1.getValue(Troolean.TRUE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 0, count1.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 0, count1.getValue(Troolean.TRUE, Troolean.TRUE));
        assertEquals((Integer) 0, count1.getValue(Troolean.FALSE, Troolean.FALSE));
        assertEquals((Integer) 0, count1.getValue(Troolean.TRUE, Troolean.FALSE));
    }

    @Test
    public void testFalse () throws FunctionException {
        CountBinaryDistance count = new CountBinaryDistance(Troolean.FALSE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE, Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE, Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE, Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE, Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE, Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE, Troolean.INCONCLUSIVE));

        CountBinaryDistance count1 = new CountBinaryDistance(Troolean.FALSE);
        assertEquals((Integer) 1, count1.getValue(Troolean.FALSE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count1.getValue(Troolean.TRUE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count1.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 1, count1.getValue(Troolean.TRUE, Troolean.TRUE));
        assertEquals((Integer) 0, count1.getValue(Troolean.FALSE, Troolean.FALSE));
        assertEquals((Integer) 0, count1.getValue(Troolean.TRUE, Troolean.FALSE));
    }

    @Test
    public void testInconclusive () throws FunctionException {
        CountBinaryDistance count = new CountBinaryDistance(Troolean.INCONCLUSIVE);
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE, Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE, Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE, Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE, Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE, Troolean.TRUE));
        assertEquals((Integer) 0, count.getValue(Troolean.TRUE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 0, count.getValue(Troolean.FALSE, Troolean.INCONCLUSIVE));

        CountBinaryDistance count1 = new CountBinaryDistance(Troolean.INCONCLUSIVE);
        assertEquals((Integer) 0, count1.getValue(Troolean.FALSE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 0, count1.getValue(Troolean.TRUE, Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count1.getValue(Troolean.INCONCLUSIVE, Troolean.TRUE));
        assertEquals((Integer) 2, count1.getValue(Troolean.TRUE, Troolean.TRUE));
        assertEquals((Integer) 2, count1.getValue(Troolean.FALSE, Troolean.FALSE));
        assertEquals((Integer) 2, count1.getValue(Troolean.TRUE, Troolean.FALSE));
    }
}