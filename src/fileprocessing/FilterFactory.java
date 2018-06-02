package fileprocessing;

public class FilterFactory {

    final static String not = "NOT";
    final static String separator = "#";
    final static int filer = 0;
    final static int value = 1;
    final static int antherValue = 2;

    final static String greater_than = "greater_than";
    final static String between = "between";
    final static String smaller_than = "smaller_than";
    final static String file = "file";
    final static String contains = "contains";
    final static String prefix = "prefix";
    final static String suffix = "suffix";
    final static String writable = "writable";
    final static String executable = "executable";
    final static String hidden = "hidden";
    final static String all = "all";


    public FilterFactory(String filterLine,int filterLineNum){
        String[] separatedFilter = filterLine.split(separator);
        switch (separatedFilter[filer]){
            case greater_than:{

            }

            case between:{
            }

            case  smaller_than:{
            }


        }


    }

    private boolean hasNot(String[] filterLine){
        for ( String str : filterLine){
            if (str.equals(not)){
                return true;
            }
        }
        return false;
    }
}
