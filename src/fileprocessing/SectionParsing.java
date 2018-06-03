package fileprocessing;
import java.io.*;


public class SectionParsing {

    String commandFile;

    public SectionParsing(String commandFile){
        this.commandFile = commandFile;
    }

    public void readCommandFile() throws FileNotFoundException {

        try {
        File file = new File(this.commandFile);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String lineFromFile;
        lineFromFile = read.readLine();


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
