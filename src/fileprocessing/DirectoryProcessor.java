package fileprocessing;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DirectoryProcessor {
    private SectionParsing sectionParsing;
    private List<Section> sectionList;

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
    }

    public static void main(String[] args) {
        File sourcedir = new File(args[0]);
        File commandfile =new File( args[1]);
        new DirectoryProcessor(commandfile, sourcedir);
    }
}