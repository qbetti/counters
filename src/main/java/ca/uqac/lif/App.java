package ca.uqac.lif;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.method.names.KillRingContentMngrSequence;
import ca.uqac.lif.method.names.LineManagerSeries;
import ca.uqac.lif.method.names.LineMngrOccurencesBeforeUndoMngr;

public class App {

    public static void main(String[] args) throws Connector.ConnectorException {
        KillRingContentMngrSequence.main(args);
        LineManagerSeries.main(args);
        LineMngrOccurencesBeforeUndoMngr.main(args);
    }
}
