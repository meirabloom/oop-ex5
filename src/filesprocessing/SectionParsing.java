package filesprocessing;
import filesprocessing.Filter.Filter;
import filesprocessing.order.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * parses the command file and creates section objects
 */
public class SectionParsing {

    private final static String ERROR = "ERROR: ";
    private final static String FILTER = "FILTER";
    private final static String ORDER = "ORDER";
    private final static String BAD_SUBSECTION_NAME = "Bad subsection name";
    private final static String FILE_NOT_FOUND_EXCEPTION = "FILE_NOT_FOUND_EXCEPTION";
    private final static String IOException = "IOException";
    private File commandFile;
    private Filter sectionFilter;
    private Order sectionOrder;
    private List<Section>sectionList;
    private FilterFactory filterFactory = new FilterFactory();
    private OrderFactory orderFactory = new OrderFactory();

    /**
     * @param commandFile - the file with the commands
     */
    public SectionParsing(File commandFile) {
        this.commandFile = commandFile;
    }

    /**
     * Creates a Section object with the types of Filter and Order Object that are required on order tp
     * process the files
     * @return - the section object
     * @throws IOException - if the command file cannot be reached
     */
    public List<Section> readCommandFile() throws IOException {

        sectionList = new ArrayList<>();
        int counter = 1;
        FileReader fileReader = new FileReader(this.commandFile);
        BufferedReader read = new BufferedReader(fileReader);
        String lineFromFile;
        lineFromFile = read.readLine();
        try {
            while (lineFromFile != null) {
                    //  Filter
                    if (lineFromFile.equals(FILTER)) {
                        String filterLine = read.readLine();
                        if (filterLine == null){ //if filter Line is null we change it so filterFactory does
                            //get null , and the sub-section will get "Bad subsection name" when ORDER will
                            //be null.
                            filterLine = "";
                        }
                        counter++;
                        int filterLineNum = counter;
                        sectionFilter = filterFactory.findFilter(filterLine, filterLineNum);
                    } else { //  if the word FILTER is not the first line in the sub-Section
                        System.err.println(ERROR + BAD_SUBSECTION_NAME);
                        return null;
                    }
                    //  Order
                    lineFromFile = read.readLine();
                    counter++;
                    if (lineFromFile == null){
                        System.err.println(ERROR + BAD_SUBSECTION_NAME);
                        return null;
                    }
                    if (lineFromFile.equals(ORDER)) {
                        String orderLine = read.readLine();
                        counter++;
                        int orderLineNum = counter;
                        if (orderLine == null || orderLine.equals(FILTER)) {
                            lineFromFile = orderLine;
                            orderLine = "";
                            sectionOrder = orderFactory.createOrder(orderLine, orderLineNum);
                        }
                         else {
                            lineFromFile = read.readLine();
                            counter++;
                            sectionOrder = orderFactory.createOrder(orderLine, orderLineNum);
                        }
                    } else {  //  if the word ORDER is not the first line in the sub-Section
                        System.err.println(ERROR + ": " + BAD_SUBSECTION_NAME);
                        return null;
                    }
                    sectionList.add(new Section(sectionFilter, sectionOrder));
                }
            read.close();
        }
                catch (FileNotFoundException e) {
                    System.err.println(ERROR +FILE_NOT_FOUND_EXCEPTION);
                    return null;
                }
                catch (IOException e) {
                    System.err.println(ERROR +IOException);
                    return null;
                }

            return sectionList;
        }

}
