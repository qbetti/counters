package ca.uqac.lif;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CSVResultWriter {

    private long counter;
    private long startingTime;
    private long rate;
    private PrintWriter writer;

    public CSVResultWriter(String filePath, long rate) {
        counter = 0;
        startingTime = -1;
        try {
            writer = new PrintWriter(filePath, "UTF-8");
            writer.println("Number of events, Time (ms)");

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        this.rate = rate;
    }

    public void write() {
        if(startingTime == -1)
            startingTime = System.currentTimeMillis();

        counter++;
        if(counter == 1 || (counter % rate == 0)) {

            long timeElapse = System.currentTimeMillis() - startingTime;
            writer.println(counter + "," + timeElapse);
        }
    }

    public void close() {
        startingTime = -1;
        counter = 0;
        writer.close();
    }

}
