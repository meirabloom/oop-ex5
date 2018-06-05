package filesprocessing;
import java.io.File;
import java.util.List;

public class DirectoryProcessor {
    private SectionParsing sectionParsing;
    private List<Section> sectionList;
    final static String BadSubsectionName = "Bad subsection name";
    final static String ERROR = "ERROR";
    /**Constructor*/

    public DirectoryProcessor(File commandfile, File sourcedir){
        sectionParsing =  new SectionParsing(commandfile);
        sectionList = sectionParsing.readCommandFile();
        if (sectionList !=null) {
            for (Section section : sectionList) {
                section.getFile(sourcedir);
                section.printWarning();
                section.printFile();
            }
        }
        else {
            System.err.println(ERROR+": "+BadSubsectionName);
        }
    }

    public static void main(String[] args) {
        File sourcedir = new File(args[0]);
        File commandfile =new File( args[1]);
        new DirectoryProcessor(commandfile, sourcedir);
    }
}