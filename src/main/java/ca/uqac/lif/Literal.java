package ca.uqac.lif;

public class Literal {

    public static final String DIR_RESOURCES = "";
    public static final String DIR_TRACES = DIR_RESOURCES + "traces/";

    public static final String FILE_METHOD_NAMES = DIR_TRACES + "method_names.txt";
    public static final String FILE_AD_LOG = DIR_TRACES + "active_directory.txt";


    public static final String METHOD_LINE_MANAGER = "org/gjt/sp/jedit/buffer/LineManager";
    public static final String METHOD_KILL_RING = "org/gjt/sp/jedit/buffer/KillRing";
    public static final String METHOD_CONTENT_MANAGER = "org/gjt/sp/jedit/buffer/ContentManager";
    public static final String METHOD_UNDO_MANAGER = "org/gjt/sp/jedit/buffer/UndoManager";

    public static final String EVENT_LOGON  = "Logon";
    public static final String EVENT_LOGOFF = "Logoff";
    public static final String EVENT_SPU = "Sensitive Privilege Use";

    public static final String RESULTS_DIR = "results/";
    public static final String RESULTS_METHOD_NAMES_PROP_0 = RESULTS_DIR + "mn_prop0.csv";
    public static final String RESULTS_METHOD_NAMES_PROP_1 = RESULTS_DIR + "mn_prop1.csv";
    public static final String RESULTS_METHOD_NAMES_PROP_2 = RESULTS_DIR + "mn_prop2.csv";
    public static final String RESULTS_AD_PROP_0 = RESULTS_DIR + "ad_prop0.csv";
    public static final String RESULTS_AD_PROP_1 = RESULTS_DIR + "ad_prop1.csv";
    public static final String RESULTS_AD_PROP_2 = RESULTS_DIR + "ad_prop2.csv";
    public static final String RESULTS_AD_PROP_3 = RESULTS_DIR + "ad_prop3.csv";
    public static final String RESULTS_AD_PROP_4 = RESULTS_DIR + "ad_prop4.csv";
}
