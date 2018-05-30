package fileprocessing;

public class Section {

    private String filterLine;
    private int filterLineNum;
    private String orderLine;
    private int orderLineNum;

    Section(String filterLine, String orderLine ){
        this.filterLine = filterLine;
        this.orderLine = orderLine;
    }

    Section(String filterLine){
        this.filterLine = filterLine;
    }
}
