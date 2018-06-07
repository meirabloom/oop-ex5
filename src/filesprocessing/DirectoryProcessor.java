package filesprocessing;
import java.io.IOException;
import java.io.File;
import java.util.List;

/**
 * the main class that runs the program. receives files and a file of commands
 */
public class DirectoryProcessor {

    private final static String ERROR = "ERROR: ";
    private final static String WRONG_USAGE = "Wrong usage. Should receive 2 arguments";
    private final static String WRONG_USAGE2 = "Wrong usage. problem with sourcedir or commandfile";
    private final static int SOURCEDIR = 0;
    private final static int COMMAND_FILE = 1;
    private final static int VALID_LENGTH = 2;

    /**Constructor*/

    /**
     * @param commandfile - file of commands
     * @param sourcedir - directory of files
     */
    public DirectoryProcessor(File commandfile, File sourcedir){
       try {
           SectionParsing sectionParsing = new SectionParsing(commandfile);
           List<Section> sectionList = sectionParsing.readCommandFile();
           if (sectionList != null) {
               for (Section section : sectionList) {
                   section.getFile(sourcedir);
                   section.printWarning();
                   section.printFile();
               }
           }
       }
       catch (IOException e){
           System.err.println(ERROR + WRONG_USAGE2);
       }
    }

    /**
     * the main methods that runs the program. filters according to the commands, and prints an error if the
     * arguments are not valid
     * @param args - the directories from the command line- the files to filter and order, and the commands
     */
    public static void main(String[] args) {
        if (args.length == VALID_LENGTH) {
            File sourcedir = new File(args[SOURCEDIR]);
            File commandfile = new File(args[COMMAND_FILE]);
            new DirectoryProcessor(commandfile, sourcedir);
        }
        else {
            System.err.println(ERROR+ WRONG_USAGE);
        }
    }
}