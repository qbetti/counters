package ca.uqac.lif;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.Pullable;
import ca.uqac.lif.cep.functions.Constant;
import ca.uqac.lif.cep.functions.Equals;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.ltl.TrooleanCast;
import ca.uqac.lif.cep.strings.StringMatches;
import ca.uqac.lif.cep.tmf.QueueSource;
import ca.uqac.lif.counters.CountSimple;
import ca.uqac.lif.quantifiers.PropositionalQuantifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GlobalTest {

    @Test
    public void test1() throws Connector.ConnectorException {
        QueueSource source = new QueueSource();
        source.loop(false);
        source.addEvent("a");
        source.addEvent("a");
        source.addEvent("a");
        source.addEvent("b");
        source.addEvent("a");

        Processor aConst = new FunctionProcessor(new Constant("a"));
        Processor isEqualToA = new FunctionProcessor(StringMatches.instance);
        Processor castToTroolean = new FunctionProcessor(TrooleanCast.instance);

        Connector.connect(source, 0, isEqualToA, 0);
        Connector.connect(aConst, 0, isEqualToA, 1);
        Connector.connect(isEqualToA, castToTroolean);

        Processor counter = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));
        Processor quantifier = new FunctionProcessor(new PropositionalQuantifier(3, Equals.instance));

        Connector.connect(castToTroolean, counter, quantifier);

        Pullable p = quantifier.getPullableOutput();
        assertEquals(Troolean.FALSE, (Troolean) p.pull());
        assertEquals(Troolean.FALSE, (Troolean) p.pull());
        assertEquals(Troolean.TRUE,  (Troolean) p.pull());
        assertEquals(Troolean.TRUE,  (Troolean) p.pull());
        assertEquals(Troolean.FALSE, (Troolean) p.pull());
        assertFalse(p.hasNext());
    }

}
