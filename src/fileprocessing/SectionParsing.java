package fileprocessing;
import java.io.*;


public class SectionParsing {

    String commandFile;

    public SectionParsing(String commandFile){
        this.commandFile = commandFile;
    }

    public void readCommandFile() throws FileNotFoundException {

        File file = new File(this.commandFile);
        BufferedReader lineFromFile = new BufferedReader(new FileReader(file));

    }
}
