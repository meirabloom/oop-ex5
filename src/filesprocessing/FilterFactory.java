package filesprocessing;

import filesprocessing.Filter.*;

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
                if (separatedFilter.length >= 2) {
                    return new Greater(Double.parseDouble(separatedFilter[value]), filterLineNum,
                            hasNot);
                }
                break;
            }
            case between: {
                if (separatedFilter.length >= 3) {
                    return new between(Double.parseDouble(separatedFilter[value]),
                            Double.parseDouble(separatedFilter[antherValue]), filterLineNum, hasNot);
                }
                break;
            }
            case smaller_than: {
                if (separatedFilter.length >= 2) {
                    return new smaller(Double.parseDouble(separatedFilter[value]), filterLineNum,
                            hasNot);
                }
                break;
            }
            case file: {
                if (separatedFilter.length >= 2) {
                    return new FileFilter(separatedFilter[value], filterLineNum, hasNot);
                }
                break;
            }
            case contains: {
                if (separatedFilter.length >= 2) {
                    return new contains(separatedFilter[value], filterLineNum, hasNot);
                }
                break;
            }
            case prefix: {
                if (separatedFilter.length >= 2) {
                    return new prefix(separatedFilter[value], filterLineNum, hasNot);
                }
                break;
            }
            case suffix: {
                if (separatedFilter.length >= 2) {
                    return new suffix(separatedFilter[value], filterLineNum, hasNot);
                }
            break;
            }
            case writable: {
                if (separatedFilter.length >= 2) {
                    return new writable(separatedFilter[value], filterLineNum, hasNot);
                }
                break;
            }
            case executable: {
                if (separatedFilter.length >= 2) {
                    return new executable(separatedFilter[value], filterLineNum, hasNot);
                }
                break;
            }
            case hidden: {
                if (separatedFilter.length >= 2) {
                    return new hidden(separatedFilter[value], filterLineNum, hasNot);
                }
                break;
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
