package fileprocessing;

import fileprocessing.Filter.*;

public class FilterFactory {

    private final static String not = "NOT";
    private final static String separator = "#";
    private final static int filer = 0;
    private final static int value = 1;
    private final static int antherValue = 2;

    private final static String greater_than = "greater_than";
    private final static String between = "between";
    private final static String smaller_than = "smaller_than";
    private final static String file = "file";
    private final static String contains = "contains";
    private final static String prefix = "prefix";
    private final static String suffix = "suffix";
    private final static String writable = "writable";
    private final static String executable = "executable";
    private final static String hidden = "hidden";
    private final static String all = "all";




    public FilterFactory() { }

    public Filter findFilter(String filterLine, int filterLineNum){
        String[] separatedFilter = filterLine.split(separator);
        boolean hasNot = hasNot(separatedFilter);

        switch (separatedFilter[filer]) {
            case greater_than: {
                return new Greater(Double.parseDouble(separatedFilter[value]), filterLineNum,
                        hasNot);
            }
            case between: {
                return new between(Double.parseDouble(separatedFilter[value]),
                        Double.parseDouble(separatedFilter[antherValue]), filterLineNum, hasNot);
            }
            case smaller_than: {
                return new smaller(Double.parseDouble(separatedFilter[value]), filterLineNum,
                        hasNot);
            }
            case file: {
                return new FileFilter(separatedFilter[value], filterLineNum, hasNot);
            }
            case contains: {
                return new contains(separatedFilter[value], filterLineNum, hasNot);
            }
            case prefix: {
                return new prefix(separatedFilter[value], filterLineNum, hasNot);
            }
            case suffix: {
                return new suffix(separatedFilter[value], filterLineNum, hasNot);
            }
            case writable: {
                return new writable(separatedFilter[value], filterLineNum, hasNot);
            }
            case executable: {
                return new executable(separatedFilter[value], filterLineNum, hasNot);
            }
            case hidden: {
                return new hidden(separatedFilter[value], filterLineNum, hasNot);
            }
            case all: {
                return new FilterAll(filterLineNum, hasNot, false);
            }
        }
        return new FilterAll(filterLineNum, hasNot, true);
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
