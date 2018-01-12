package ca.uqac.lif;

import ca.uqac.lif.active.directory.*;
import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.method.names.MNProp1;
import ca.uqac.lif.method.names.MNProp0;
import ca.uqac.lif.method.names.MNProp2;

public class App {

    public static void main(String[] args) throws Connector.ConnectorException {
        for(int i = 0; i < 5; i++) {
            MNProp0.main(args);
            MNProp1.main(args);
            MNProp2.main(args);
        }

        for(int i = 0; i < 5; i++) {
            ADProp0.main(args);
            ADProp1.main(args);
            ADProp2.main(args);
            ADProp3.main(args);
            ADProp4.main(args);
        }
    }
}
