package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.Equals;
import ca.uqac.lif.cep.ltl.Troolean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExistentialQuantifierTest {

    @Test
    public void test1() {
        Quantify quantify = new ExistentialQuantifier(3, Equals.instance);
        assertEquals(Troolean.INCONCLUSIVE, quantify.getValue(0));
        assertEquals(Troolean.INCONCLUSIVE, quantify.getValue(1));
        assertEquals(Troolean.INCONCLUSIVE, quantify.getValue(2));
        assertEquals(Troolean.TRUE, quantify.getValue(3));
        assertEquals(Troolean.TRUE, quantify.getValue(4));
        assertEquals(Troolean.TRUE, quantify.getValue(5));
        assertEquals(Troolean.TRUE, quantify.getValue(0));
    }

}