package fileprocessing;

import fileprocessing.Filter.Filter;
import fileprocessing.order.Order;

import java.lang.reflect.Array;
import java.io.File;

public class Section {

    Filter myFilter;
    Order myOrder;
    File sourceDir;

    Section(Filter filter, Order order){
        this.myFilter = filter;
        this.myOrder = order;
    }

    void getFile(File file){
        myOrder.orderFiles( myFilter.doFilter());
    }

    void printFile(){
//        for (file : sourceDir)
//        }
    }

    void getWarning(){
        if (myFilter.hasWarning()){
            myFilter.printWarning();
        }
    }
}
