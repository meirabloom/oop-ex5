package fileprocessing;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DirectoryProcessor {
    private SectionParsing sectionParsing;
    private File sourcedir;
    private File commandfile;
    private List<Section> sectionList;



    public DirectoryProcessor(File commandfile){
        sectionParsing =  new SectionParsing(commandfile);
        sectionList = sectionParsing.readCommandFile();

        for (Section section :sectionList ){
            section.printWarning();
            section.printFile();
        }

    }

    public static void main(String[] args) throws IOException {
        File sourcedir = new File(args[0]);
        File commandfile =new File( args[1]);
        new DirectoryProcessor(commandfile);
    }
}