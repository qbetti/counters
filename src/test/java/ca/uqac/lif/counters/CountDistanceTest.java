package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDistanceTest {

    @Test
    public void testTrue () throws FunctionException {
        CountDistance count = new CountDistance(Troolean.TRUE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 0, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE));
    }

    @Test
    public void testFalse () throws FunctionException {
        CountDistance count = new CountDistance(Troolean.FALSE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 2, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 2, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
    }

    @Test
    public void testInconclusive () throws FunctionException {
        CountDistance count = new CountDistance(Troolean.INCONCLUSIVE);
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
    }
}