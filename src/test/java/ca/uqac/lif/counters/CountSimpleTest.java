package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean.Value;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountSimpleTest {

    @Test
    public void testTrue() throws FunctionException {
        CountSimple count = new CountSimple(Value.TRUE);
        assertEquals((Integer) 0, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 0, count.getValue(Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Value.TRUE));
    }

    @Test
    public void testFalse() throws FunctionException {
        CountSimple count = new CountSimple(Value.FALSE);
        assertEquals((Integer) 0, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.FALSE));
        assertEquals((Integer) 2, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 3, count.getValue(Value.FALSE));
        assertEquals((Integer) 4, count.getValue(Value.FALSE));
        assertEquals((Integer) 4, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Value.TRUE));
    }

    @Test
    public void testInconclusive() throws FunctionException {
        CountSimple count = new CountSimple(Value.INCONCLUSIVE);
        assertEquals((Integer) 1, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
        assertEquals((Integer) 1, count.getValue(Value.TRUE));
        assertEquals((Integer) 1, count.getValue(Value.FALSE));
        assertEquals((Integer) 2, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.TRUE));
        assertEquals((Integer) 2, count.getValue(Value.FALSE));
        assertEquals((Integer) 2, count.getValue(Value.FALSE));
        assertEquals((Integer) 3, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Value.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Value.TRUE));
    }
}