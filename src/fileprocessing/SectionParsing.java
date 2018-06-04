package fileprocessing;
import fileprocessing.Filter.Filter;
import fileprocessing.order.Order;

import java.io.*;
import java.util.List;


public class SectionParsing {

    private final static String filter = "FILTER";
    private final static String order = "ORDER";
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

        int counter =1;
        try (FileReader fileReader = new FileReader(this.commandFile)){
            BufferedReader read = new BufferedReader(fileReader);
            String lineFromFile;
            lineFromFile = read.readLine();

            while (lineFromFile != null) {
                //  Filter
                if (lineFromFile.equals(filter)) {
                    filterLine = read.readLine();
                    counter++;
                    filterLineNum = counter;
                    sectionFilter = filterFactory.findFilter(filterLine, filterLineNum);
                }
                else { //  if the word FILTER is not the first line in the sub-Section
                    return null; //TODO: 04/06/2018 להוסיף שגיאה
                }

                //  Order
                lineFromFile = read.readLine();
                counter++;
                if (lineFromFile.equals(order)){
                    orderLine = read.readLine();
                    counter++;
                    orderLineNum =counter;
                    if (orderLine.equals(filter)){
                        lineFromFile = orderLine;
                        orderLine ="";
                        //sectionOrder = orderFactory.createOrder(orderLine,orderLineNum);
                    }
                    else if (orderLine.equals(order)){
                        return null;// TODO: 04/06/2018 להוסיף שגיאה
                    }
                    else {
                        //sectionOrder = orderFactory.createOrder(orderLine,orderLineNum);
                        // TODO: 04/06/2018 ask how she did this
                    }
                }else {  //  if the word ORDER is not the first line in the sub-Section
                    return null; // TODO: 04/06/2018 להוסיף שגיאה
                }
                sectionList.add(new Section(sectionFilter,sectionOrder));
            }
            return sectionList;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
