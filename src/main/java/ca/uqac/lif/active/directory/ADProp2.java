package ca.uqac.lif.active.directory;

import ca.uqac.lif.CSVResultWriter;
import ca.uqac.lif.CustomFinally;
import ca.uqac.lif.Literal;
import ca.uqac.lif.Util;
import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.Pullable;
import ca.uqac.lif.cep.functions.Equals;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.io.LineReader;
import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.numbers.Subtraction;
import ca.uqac.lif.cep.tmf.Fork;
import ca.uqac.lif.counters.CountLocal;
import ca.uqac.lif.counters.CountSimple;
import ca.uqac.lif.quantifiers.PropositionalQuantifier;

/**
 * Combien de paires logon-> logoff sont présentes dans la trace
 */
public class ADProp2 {

    public static void main(String[] args) throws Connector.ConnectorException {
        LineReader lr = Util.getLineReaderOnFile(Literal.FILE_AD_LOG);
        Fork fork = new Fork(2);
        Fork forkLogon = new Fork(2);

        Processor matchesLogonEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGON);
        Processor matchesLogoffEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGOFF);

        Processor subtraction = new FunctionProcessor(Subtraction.instance);
        Processor and = new FunctionProcessor(Troolean.AND_FUNCTION);

        Processor lastLogon = new FunctionProcessor(new CountLocal(Troolean.Value.TRUE));
        Processor lastLogoff = new FunctionProcessor(new CountLocal(Troolean.Value.TRUE));
        Processor finalCount = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));

        Processor intervalEqualTo1 = new FunctionProcessor(new PropositionalQuantifier(1, Equals.instance));

        CustomFinally customFinally = new CustomFinally();

        Connector.connect(lr, fork);
        Connector.connect(fork, 0, matchesLogonEvent, 0);
        Connector.connect(fork, 1, matchesLogoffEvent, 0);

        Connector.connect(matchesLogonEvent, forkLogon);
        Connector.connect(forkLogon, 0, lastLogon, 0);
        Connector.connect(forkLogon, 1, customFinally, 0);

        Connector.connect(matchesLogoffEvent, lastLogoff);

        Connector.connect(lastLogoff, 0, subtraction, 0);
        Connector.connect(lastLogon, 0, subtraction, 1);
        Connector.connect(subtraction, intervalEqualTo1);

        Connector.connect(intervalEqualTo1, 0, and, 0);
        Connector.connect(customFinally, 0, and, 1);
        Connector.connect(and, finalCount);

        Pullable pullable = finalCount.getPullableOutput();

        int i = 1;
        int result = 0;
        CSVResultWriter writer = new CSVResultWriter(Literal.RESULTS_AD_PROP_2, 10000);
        while(pullable.hasNext()) {
            result = ((Number) pullable.pull()).intValue();
//            System.out.println(i+ ": " + pullable.pull());
            writer.write();
            i++;
        }
        writer.close();
        System.out.println(result + " logon/logoff pairs have been found");

    }

}
