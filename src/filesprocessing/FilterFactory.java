package filesprocessing;

import filesprocessing.Filter.*;

import java.util.Arrays;

/**
 * The filter factory, receives a String and returns the proper filter to it. if the String isn’t valid it
 * returns the All Filter.
 */
public class FilterFactory {

    private final static String NOT = "NOT";
    private final static String SEPARATOR = "#";
    private final static int FILER = 0;
    private final static int VALUE = 1;
    private final static int ANOTHER_VALUE = 2;
    private final static int LENGTH_OF_TWO = 2;
    private final static int LENGTH_OF_THREE = 3;

    private final static String GREATER_THAN = "greater_than";
    private final static String BETWEEN = "between";
    private final static String SMALLER_THAN = "smaller_than";
    private final static String FILE = "file";
    private final static String CONTAINS = "contains";
    private final static String PREFIX = "prefix";
    private final static String SUFFIX= "suffix";
    private final static String WRITABLE = "writable";
    private final static String EXECUTABLE = "executable";
    private final static String HIDDEN = "hidden";
    private final static String ALL = "all";


    /**
     * default constructor
     */
    public FilterFactory() { }

    /**
     * returns the required filter according to the string command
     * @param filterLine - a string representing the required filter
     * @param filterLineNum - the line number of the required filter
     * @return Filter object
     */
    public Filter findFilter(String filterLine, int filterLineNum){
        String[] separatedFilter = filterLine.split(SEPARATOR);
        boolean hasNot = separatedFilter[separatedFilter.length - 1].equals(NOT);
        if (hasNot){
             separatedFilter =Arrays.copyOfRange(separatedFilter , 0 ,separatedFilter.length-1);
        }
        switch (separatedFilter[FILER]) {
            case GREATER_THAN: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new Greater(Double.parseDouble(separatedFilter[VALUE]), filterLineNum,
                            hasNot);
                }
                break;
            }
            case BETWEEN: {
                if (separatedFilter.length == LENGTH_OF_THREE) {
                    return new between(Double.parseDouble(separatedFilter[VALUE]),
                            Double.parseDouble(separatedFilter[ANOTHER_VALUE]), filterLineNum, hasNot);
                }
                break;
            }
            case SMALLER_THAN: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new smaller(Double.parseDouble(separatedFilter[VALUE]), filterLineNum,
                            hasNot);
                }
                break;
            }
            case FILE: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new FileFilter(separatedFilter[VALUE], filterLineNum, hasNot);
                }
                break;
            }
            case CONTAINS: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new contains(separatedFilter[VALUE], filterLineNum, hasNot);
                }
                break;
            }
            case PREFIX: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new prefix(separatedFilter[VALUE], filterLineNum, hasNot);
                }
                break;
            }
            case SUFFIX: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new suffix(separatedFilter[VALUE], filterLineNum, hasNot);
                }
            break;
            }
            case WRITABLE: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new writable(separatedFilter[VALUE], filterLineNum, hasNot);
                }
                break;
            }
            case EXECUTABLE: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new executable(separatedFilter[VALUE], filterLineNum, hasNot);
                }
                break;
            }
            case HIDDEN: {
                if (separatedFilter.length == LENGTH_OF_TWO) {
                    return new hidden(separatedFilter[VALUE], filterLineNum, hasNot);
                }
                break;
            }
            case ALL: {
                return new FilterAll(filterLineNum, hasNot, false);
            }
        }
        return new FilterAll(filterLineNum, hasNot, true);
    }

}
