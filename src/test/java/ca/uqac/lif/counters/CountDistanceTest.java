package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean.Value;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDistanceTest {

    @Test
    public void testTrue () throws FunctionException {
        CountDistance count = new CountDistance(Value.TRUE);
        assertEquals((Integer) 0, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 0, count.getValue(Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.FALSE));
    }

    @Test
    public void testFalse () throws FunctionException {
        CountDistance count = new CountDistance(Value.FALSE);
        assertEquals((Integer) 0, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Value.FALSE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.FALSE));
        assertEquals((Integer) 2, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.FALSE));
        assertEquals((Integer) 2, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.FALSE));
    }

    @Test
    public void testInconclusive () throws FunctionException {
        CountDistance count = new CountDistance(Value.INCONCLUSIVE);
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
    }
}