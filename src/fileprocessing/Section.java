package fileprocessing;

import fileprocessing.Filter.Filter;
import fileprocessing.order.Order;

import java.lang.reflect.Array;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Section {

    Filter myFilter;
    Order myOrder;
    ArrayList<File> filteredFile;

    Section(Filter filter, Order order){
        this.myFilter = filter;
        this.myOrder = order;
        ArrayList<File> filteredFile = new ArrayList<>();
    }

    void getFile(File sourceDir){
        File[] sourceDirFiles = sourceDir.listFiles(File::isFile);
        for (File file : sourceDirFiles) {
            if (myFilter.doFilter(file)) {
                filteredFile.add(file);
            }
        }
        myOrder.orderFiles(filteredFile);
    }

    void printFile(){
        Iterator filesInOrder = filteredFile.iterator();
        while (filesInOrder.hasNext()){
            System.out.println(filesInOrder.next().toString());
        }
    }

    void getWarning(){
        if (myFilter.hasWarning()){
            myFilter.printWarning();
        }
        //todo hasWarning, printWarning for order
    }
}
