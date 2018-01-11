package ca.uqac.lif.method.names;

import ca.uqac.lif.CSVResultWriter;
import ca.uqac.lif.Literal;
import ca.uqac.lif.Util;
import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.Pullable;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.io.LineReader;
import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.tmf.Fork;
import ca.uqac.lif.counters.CountBinaryDistance;

public class KillRingContentMngrSequence {

    public static void main(String[] args) throws Connector.ConnectorException {
        LineReader lr = Util.getLineReaderOnFile(Literal.FILE_METHOD_NAMES);

        Fork fork = new Fork(2);

        Processor matchesKillRingMethod = Util.buildStringMatchToTrooleanProcessor(Literal.METHOD_KILL_RING);
        Processor matchesContentMngrMethod = Util.buildStringMatchToTrooleanProcessor(Literal.METHOD_CONTENT_MANAGER);

        Connector.connect(lr, fork);
        Connector.connect(fork, 0, matchesKillRingMethod, 0);
        Connector.connect(fork, 1, matchesContentMngrMethod, 0);

        Processor countBinaryDistance = new FunctionProcessor(new CountBinaryDistance(Troolean.Value.TRUE));
        Connector.connect(matchesKillRingMethod, 0, countBinaryDistance, 0);
        Connector.connect(matchesContentMngrMethod, 0, countBinaryDistance, 1);

        Pullable pullable = countBinaryDistance.getPullableOutput();

        boolean found = false;

        long startTime = System.currentTimeMillis();

        CSVResultWriter resultWriter = new CSVResultWriter("killring_result.csv", 100000L);
        while(pullable.hasNext()) {
            Integer interval = (Integer) pullable.pull();
            if(interval != 0 && !found) {
                System.out.println("Interval between KillRing and ContentManager calls is " + interval);
                found = true;
            }
            resultWriter.write();
        }

        resultWriter.close();

        System.out.println("Done in " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
