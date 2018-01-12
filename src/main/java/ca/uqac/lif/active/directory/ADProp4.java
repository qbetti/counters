package ca.uqac.lif.active.directory;

import ca.uqac.lif.CustomFinally;
import ca.uqac.lif.Literal;
import ca.uqac.lif.Util;
import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.Pullable;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.io.LineReader;
import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.numbers.Subtraction;
import ca.uqac.lif.cep.tmf.Fork;
import ca.uqac.lif.counters.CountSimple;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Combien de Sensitive Privilege Use sont présent entre un logon
 * et un log off (C’est la première propriété du troisème exmaple de la section 5).
 */
public class ADProp4 {

    public static void main(String[] args) throws Connector.ConnectorException {
        LineReader lr = Util.getLineReaderOnFile(Literal.FILE_AD_LOG);
        Fork forkInit = new Fork(3);
        Fork forkSPU = new Fork(2);

        CustomFinally finallyLogon = new CustomFinally();
        CustomFinally finallyLogoff = new CustomFinally();

        FunctionProcessor and0 = new FunctionProcessor(Troolean.AND_FUNCTION);
        FunctionProcessor and1 = new FunctionProcessor(Troolean.AND_FUNCTION);
        FunctionProcessor sub = new FunctionProcessor(Subtraction.instance);

        Processor matchesLogonEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGON);
        Processor matchesLogoffEvent = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_LOGOFF);
        Processor matchesSensitivePrivilegeUse = Util.buildStringMatchToTrooleanProcessor(Literal.EVENT_SPU);

        Processor counter0 = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));
        Processor counter1 = new FunctionProcessor(new CountSimple(Troolean.Value.TRUE));


        Connector.connect(lr, forkInit);
        Connector.connect(forkInit, 0, matchesLogonEvent, 0);
        Connector.connect(forkInit, 1, matchesLogoffEvent, 0);
        Connector.connect(forkInit, 2, matchesSensitivePrivilegeUse, 0);

        Connector.connect(matchesLogonEvent, 0, finallyLogon, 0);
        Connector.connect(matchesLogoffEvent, 0, finallyLogoff, 0);
        Connector.connect(matchesSensitivePrivilegeUse, forkSPU);

        Connector.connect(forkSPU, 0, and0, 0);
        Connector.connect(finallyLogon, 0, and0, 1);

        Connector.connect(forkSPU, 1, and1, 0);
        Connector.connect(finallyLogoff, 0, and1, 1);

        Connector.connect(and0, counter0);
        Connector.connect(and1, counter1);

        Connector.connect(counter0, 0, sub, 0);
        Connector.connect(counter1, 0, sub, 1);

        Pullable pullable = sub.getPullableOutput();

        while (pullable.hasNext()) {
            System.out.println(pullable.pull());
        }
    }

}
