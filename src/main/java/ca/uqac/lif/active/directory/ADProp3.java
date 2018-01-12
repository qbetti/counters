package ca.uqac.lif.active.directory;

import ca.uqac.lif.Literal;
import ca.uqac.lif.Util;
import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.Pullable;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.io.LineReader;
import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.numbers.IsLessThan;
import ca.uqac.lif.cep.numbers.Subtraction;
import ca.uqac.lif.cep.tmf.Fork;
import ca.uqac.lif.counters.CountSimple;
import ca.uqac.lif.quantifiers.ExistentialQuantifier;

/**
 * Est-ce qu’il y a un point dans la trace où jusqu’à ce point,
 * plus de logoff ont eu lieu que de logon (\exists_{<0}C{ \top}\{logon} - C{ \top}\{lofoff})
 */
public class ADProp3 {

    public static void main(String[] args) throws Connector.ConnectorException {
        LineReader lr = Util.getLineReaderOnFile(Literal.FILE_AD_LOG);
        Fork fork = new Fork(2);

        Processor matchesLogonEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGON);
        Processor matchesLogoffEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGOFF);

        Processor counterLogon = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));
        Processor counterLogoff = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));

        Processor quantifier = new FunctionProcessor(new ExistentialQuantifier(0, IsLessThan.instance));

        Processor sub = new FunctionProcessor(Subtraction.instance);

        Connector.connect(lr, fork);
        Connector.connect(fork, 0, matchesLogonEvent, 0);
        Connector.connect(fork, 1, matchesLogoffEvent, 0);

        Connector.connect(matchesLogonEvent, counterLogon);
        Connector.connect(matchesLogoffEvent, counterLogoff);

        Connector.connect(counterLogon, 0, sub, 0);
        Connector.connect(counterLogoff, 0, sub, 1);

        Connector.connect(sub, quantifier);


        Pullable pullable = quantifier.getPullableOutput();
        while (pullable.hasNext()) {
            System.out.println(pullable.pull());
        }

    }
}
