package ca.uqac.lif;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.GroupProcessor;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.functions.Constant;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.io.LineReader;
import ca.uqac.lif.cep.ltl.TrooleanCast;
import ca.uqac.lif.cep.strings.StringMatches;

public class Util {

    public static LineReader getLineReaderOnFile(String filePath) {
        LineReader lr = new LineReader(Util.class.getClassLoader().getResourceAsStream(filePath));
        lr.addCrlf(false);

        return lr;
    }

    public static Processor buildStringMatchToTrooleanProcessor(String toMatch) throws Connector.ConnectorException {
        GroupProcessor group = new GroupProcessor(1,1);

        Processor constantToMatch = new FunctionProcessor(new Constant(toMatch));
        Processor methodFilter = new FunctionProcessor(StringMatches.instance);
        Processor castToTroolean = new FunctionProcessor(TrooleanCast.instance);

        group.associateInput(0, methodFilter, 0);
        Connector.connect(constantToMatch, 0, methodFilter, 1);
        Connector.connect(methodFilter, castToTroolean);

        group.associateOutput(0, castToTroolean, 0);
        return group;
    }

}
