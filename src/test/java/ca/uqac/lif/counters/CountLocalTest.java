package ca.uqac.lif.counters;

import ca.uqac.lif.cep.functions.FunctionException;
import ca.uqac.lif.cep.ltl.Troolean;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountLocalTest {

    @Test
    public void testTrue () throws FunctionException {
        CountLocal count = new CountLocal(Troolean.TRUE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 0, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 3, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 3, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 7, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 8, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 8, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 8, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 11, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 12, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 12, count.getValue(Troolean.FALSE));
    }

    @Test
    public void testFalse () throws FunctionException {
        CountLocal count = new CountLocal(Troolean.FALSE);
        assertEquals((Integer) 0, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 2, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 2, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 4, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 4, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 4, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 4, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 9, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 9, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 9, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 9, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 13, count.getValue(Troolean.FALSE));
    }

    @Test
    public void testInconclusive () throws FunctionException {
        CountLocal count = new CountLocal(Troolean.INCONCLUSIVE);
        assertEquals((Integer) 1, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 1, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 1, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 5, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 6, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 6, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 6, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 6, count.getValue(Troolean.FALSE));
        assertEquals((Integer) 10, count.getValue(Troolean.INCONCLUSIVE));
        assertEquals((Integer) 10, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 10, count.getValue(Troolean.TRUE));
        assertEquals((Integer) 10, count.getValue(Troolean.FALSE));
    }
}