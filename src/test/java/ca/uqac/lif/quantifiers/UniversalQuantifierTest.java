package ca.uqac.lif.quantifiers;

import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.numbers.IsGreaterThan;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniversalQuantifierTest {

    @Test
    public void test1() {
        Quantify quantify = new UniversalQuantifier(5, IsGreaterThan.instance);
        assertEquals(Troolean.INCONCLUSIVE, quantify.getValue(6));
        assertEquals(Troolean.INCONCLUSIVE, quantify.getValue(12));
        assertEquals(Troolean.FALSE, quantify.getValue(5));
        assertEquals(Troolean.FALSE, quantify.getValue(4));
        assertEquals(Troolean.FALSE, quantify.getValue(7));
        assertEquals(Troolean.FALSE, quantify.getValue(11));
        assertEquals(Troolean.FALSE, quantify.getValue(9));
    }

}