package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.functions.Equals;
import ca.uqac.lif.cep.ltl.Troolean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropositionalQuantifierTest {

    @Test
    public void test1() {
        Quantify quantify = new PropositionalQuantifier(3, Equals.instance);
        assertEquals(Troolean.FALSE, quantify.getValue(1));
        assertEquals(Troolean.FALSE, quantify.getValue(2));
        assertEquals(Troolean.TRUE, quantify.getValue(3));
        assertEquals(Troolean.TRUE, quantify.getValue(3));
        assertEquals(Troolean.FALSE, quantify.getValue(4));
    }
}