package fileprocessing;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DirectoryProcessor {

    public static void main(String[] args) throws IOException {

        File sourcedir = new File(args[0]);
        File commandfile =new File( args[1]);
        new SectionParsing(commandfile);


    }
}