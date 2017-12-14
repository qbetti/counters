package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountSimpleTest {

    @Test
    public void testTrue() throws FunctionException {
        CountSimple count = new CountSimple(Troolean.TRUE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 0, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Troolean.TRUE));
    }

    @Test
    public void testFalse() throws FunctionException {
        CountSimple count = new CountSimple(Troolean.FALSE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 2, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 4, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 4, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Troolean.TRUE));
    }

    @Test
    public void testInconclusive() throws FunctionException {
        CountSimple count = new CountSimple(Troolean.INCONCLUSIVE);
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 2, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Troolean.TRUE));
    }
}