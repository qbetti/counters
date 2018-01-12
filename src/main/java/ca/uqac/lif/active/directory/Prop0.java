package ca.uqac.lif.active.directory;

import ca.uqac.lif.Literal;
import ca.uqac.lif.Util;
import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.Pullable;
import ca.uqac.lif.cep.functions.Constant;
import ca.uqac.lif.cep.functions.ConstantProcessor;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.io.LineReader;
import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.numbers.Division;
import ca.uqac.lif.cep.numbers.IsGreaterThan;
import ca.uqac.lif.cep.numbers.Subtraction;
import ca.uqac.lif.cep.tmf.Fork;
import ca.uqac.lif.cep.tmf.Pump;
import ca.uqac.lif.cep.tmf.SimpleFilter;
import ca.uqac.lif.counters.Count;
import ca.uqac.lif.counters.CountLocal;
import ca.uqac.lif.counters.CountSimple;
import ca.uqac.lif.quantifiers.PropositionalQuantifier;

public class Prop0 {

    public static void main(String[] args) throws Connector.ConnectorException {
        LineReader lr = Util.getLineReaderOnFile(Literal.FILE_AD_LOG);
        Fork fork = new Fork(2);
        ConstantProcessor trooleanTrueFeeder = new ConstantProcessor(new Constant(Troolean.Value.TRUE));

        Processor matchesLogonEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGON);
        Processor matchesLogoffEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGOFF);

        Processor lastLogon = new FunctionProcessor(new CountLocal(Troolean.Value.TRUE));
        Processor lastLogoff = new FunctionProcessor(new CountLocal(Troolean.Value.TRUE));

        Processor quantifier = new FunctionProcessor(new PropositionalQuantifier(0, IsGreaterThan.instance));
        Processor inBetweenLogonLogoffCounter = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));
        Processor lengthCounter = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));

        Processor subtraction = new FunctionProcessor(Subtraction.instance);
        Processor division = new FunctionProcessor(Division.instance);



        Connector.connect(trooleanTrueFeeder, lengthCounter);

        Connector.connect(lr, fork);
        Connector.connect(fork, 0, matchesLogonEvent, 0);
        Connector.connect(fork, 1, matchesLogoffEvent, 0);

        Connector.connect(matchesLogonEvent, lastLogon);
        Connector.connect(matchesLogoffEvent, lastLogoff);

        // Logoff on first input for subtraction
        Connector.connect(lastLogoff, 0, subtraction, 0);
        Connector.connect(lastLogon, 0, subtraction, 1);
        Connector.connect(subtraction, quantifier);
        Connector.connect(quantifier, inBetweenLogonLogoffCounter);

        Connector.connect(inBetweenLogonLogoffCounter, 0, division, 0);
        Connector.connect(lengthCounter, 0, division, 1);

        Pullable pullable = division.getPullableOutput();
        Number number = null;
        while (pullable.hasNext()) {
            number = (Number) pullable.pull();
            System.out.println(number.toString());
        }

        System.out.println("Result: " + number.toString());
    }


}
