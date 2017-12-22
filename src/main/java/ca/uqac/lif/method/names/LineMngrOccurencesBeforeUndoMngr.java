package ca.uqac.lif.method.names;

import ca.uqac.lif.CustomGlobally;
import ca.uqac.lif.Literal;
import ca.uqac.lif.Util;
import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.Pullable;
import ca.uqac.lif.cep.functions.FunctionProcessor;
import ca.uqac.lif.cep.io.LineReader;
import ca.uqac.lif.cep.ltl.Troolean;
import ca.uqac.lif.cep.tmf.Fork;
import ca.uqac.lif.counters.CountSimple;

public class LineMngrOccurencesBeforeUndoMngr {

    public static void main(String[] args) throws Connector.ConnectorException {
        LineReader lr = Util.getLineReaderOnFile(Literal.FILE_METHOD_NAMES);

        Fork fork = new Fork(2);

        Processor matchesLineMngrMethod = Util.buildStringMatchToTrooleanProcessor(Literal.METHOD_LINE_MANAGER);
        Processor matchesUndoMngrMethod = Util.buildStringMatchToTrooleanProcessor(Literal.METHOD_UNDO_MANAGER);

        Connector.connect(lr, fork);
        Connector.connect(fork, 0, matchesLineMngrMethod, 0);
        Connector.connect(fork, 1, matchesUndoMngrMethod, 0);

        Processor and = new FunctionProcessor(Troolean.AND_FUNCTION);

        CustomGlobally globally = new CustomGlobally();
        Connector.connect(matchesUndoMngrMethod, new FunctionProcessor(Troolean.NOT_FUNCTION), globally);

        Connector.connect(matchesLineMngrMethod, 0, and, 0);
        Connector.connect(globally, 0, and, 1);

        Processor counter = new FunctionProcessor(new CountSimple(Troolean.Value.INCONCLUSIVE));
        Connector.connect(and, counter);

        Pullable pullable = counter.getPullableOutput();

        int i = 1, pos = 0;
        boolean found = false;
        Integer result = 0;
        while(pullable.hasNext()) {
             result = (Integer) pullable.pull();

            if(!found && result != 0) {
                pos = i;
                found = true;
            }
            i++;
        }

        System.out.println(result +" LineManager found before first UndoManager, first LineManager at position "+ pos);
    }

}
