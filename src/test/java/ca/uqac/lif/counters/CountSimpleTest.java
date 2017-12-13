package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountSimpleTest {

    @Test
    public void testTrue() throws FunctionException {
        CountSimple count = new CountSimple(Troolean.TRUE);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 0);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 0);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 1);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 2);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 2);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 2);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 3);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 4);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 4);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 4);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 5);
    }

    @Test
    public void testFalse() throws FunctionException {
        CountSimple count = new CountSimple(Troolean.FALSE);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 0);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 1);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 1);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 1);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 2);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 2);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 2);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 2);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 3);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 3);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 3);
    }

    @Test
    public void testInconclusive() throws FunctionException {
        CountSimple count = new CountSimple(Troolean.INCONCLUSIVE);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 1);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 1);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 1);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 1);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 1);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 2);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 2);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 2);
        assertEquals(count.getValue(Troolean.FALSE),        (Integer) 2);
        assertEquals(count.getValue(Troolean.INCONCLUSIVE), (Integer) 3);
        assertEquals(count.getValue(Troolean.TRUE),         (Integer) 3);
    }
}