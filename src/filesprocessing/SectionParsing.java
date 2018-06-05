package filesprocessing;
import filesprocessing.Filter.Filter;
import filesprocessing.order.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SectionParsing {

    private final static String FILTER = "FILTER";
    private final static String ORDER = "ORDER";
    private final static String ERROR = "ERROR";
    private String filterLine;
    private String orderLine;
    private int filterLineNum;
    private int orderLineNum;
    private File commandFile;
    private Filter sectionFilter;
    private Order sectionOrder;
    private List<Section>sectionList;
    private FilterFactory filterFactory = new FilterFactory();
    private OrderFactory orderFactory = new OrderFactory();

    public SectionParsing(File commandFile) {
        this.commandFile = commandFile;
    }

    public List<Section> readCommandFile() {

        sectionList = new ArrayList<>();
        int counter = 1;
        try (FileReader fileReader = new FileReader(this.commandFile)){
            BufferedReader read = new BufferedReader(fileReader);
            String lineFromFile;
            lineFromFile = read.readLine();

            while (lineFromFile != null) {
                //  Filter
                if (lineFromFile.equals(FILTER)) {
                    filterLine = read.readLine();
                    counter++;
                    filterLineNum = counter;
                    sectionFilter = filterFactory.findFilter(filterLine, filterLineNum);
                }
                else { //  if the word FILTER is not the first line in the sub-Section
                    return null;
                }
                //  Order
                lineFromFile = read.readLine();
                counter++;
                if (lineFromFile.equals(ORDER)){
                    orderLine = read.readLine();
                    counter++;
                    orderLineNum =counter;
                    if (orderLine == null){
                        lineFromFile = orderLine;
                        orderLine = "null";
                        sectionOrder = orderFactory.createOrder(orderLine,orderLineNum);
                    }
                    if (orderLine.equals(FILTER)){
                        lineFromFile = orderLine;
                        orderLine ="";
                        sectionOrder = orderFactory.createOrder(orderLine,orderLineNum);
                    }
                    else if (orderLine.equals(ORDER)){
                        return null;
                    }
                    else {
                        lineFromFile = read.readLine();
                        counter++;
                        sectionOrder = orderFactory.createOrder(orderLine,orderLineNum);
                    }
                }else {  //  if the word ORDER is not the first line in the sub-Section
                    return null;
                }
                sectionList.add(new Section(sectionFilter,sectionOrder));

            }
            return sectionList;
        }
        catch (FileNotFoundException e) {
            System.err.println(ERROR+": FileNotFoundException");
        } catch (IOException e) {
            System.err.println(ERROR+": IOException");
        }
        return null;
    }
}
