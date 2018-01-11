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
import ca.uqac.lif.cep.numbers.IsLessThan;
import ca.uqac.lif.cep.numbers.Subtraction;
import ca.uqac.lif.cep.tmf.Fork;
import ca.uqac.lif.counters.CountLocal;
import ca.uqac.lif.quantifiers.ExistentialQuantifier;

/**
 * Est-ce qu’il existe une série ininterrompue d’appel de la fct org/gjt/sp/jedit/buffer/LineManager
 * de longueur de plus 10 (test du nombre max d’appel récursifs) :
 * (\exists_{<0}L{ \top}\{not p} - L{ \top}\{p})  où p = org/gjt/sp/jedit/buffer/LineManager
 */
public class MNProp0 {


    public static void main(String[] args) throws Connector.ConnectorException {
        LineReader lr = Util.getLineReaderOnFile(Literal.FILE_METHOD_NAMES);
        Processor matchLineManagerMethod = Util.buildStringMatchToTrooleanProcessor(Literal.METHOD_LINE_MANAGER);
        Fork fork = new Fork(2);
        Processor countLastMatch = new FunctionProcessor(new CountLocal(Troolean.Value.TRUE));
        Processor countLastNotMatch = new FunctionProcessor(new CountLocal(Troolean.Value.FALSE));
        Processor diff = new FunctionProcessor(Subtraction.instance);
        Processor quantify = new FunctionProcessor(new ExistentialQuantifier(-10, IsLessThan.instance));


        Connector.connect(lr, matchLineManagerMethod);
        Connector.connect(matchLineManagerMethod, fork);
        Connector.connect(fork, 0, countLastMatch, 0);
        Connector.connect(fork, 1, countLastNotMatch, 0);
        Connector.connect(countLastNotMatch, 0, diff, 0);
        Connector.connect(countLastMatch, 0, diff, 1);
        Connector.connect(diff, quantify);


        Pullable pullable = quantify.getPullableOutput();
        int i = 1;
        boolean found = false;
        long startTime = System.currentTimeMillis();

        CSVResultWriter writer = new CSVResultWriter(Literal.RESULTS_METHOD_NAMES_PROP_0, 100000);

        while(pullable.hasNext()) {

            if(Troolean.Value.TRUE == ((Troolean) pullable.pull()).getValue() && !found) {
                System.out.println("Uninterrupted series of \""+ Literal.METHOD_LINE_MANAGER +"\" calls found, first at position " + i);
                found = true;
            }
            i++;
            writer.write();
        }

        writer.close();
        System.out.println("Done in " + (System.currentTimeMillis() - startTime) + "ms");

    }
}
