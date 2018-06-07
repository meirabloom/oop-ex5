package filesprocessing;
import filesprocessing.order.*;

/**
 * returns the required order object according to the command
 */
public class OrderFactory {

    private static final String HASHTAG = "#";
    private static final String ABS = "abs";
    private static final String SIZE = "size";
    private static final String TYPE = "type";
    private static final String EMPTY_STRING = "";
    private static final String REVERSE = "REVERSE";

    /**
     *
     * @param orderMethod - the string representing the required order
     * @param lineNum - the number of the line of the string
     * @return - the order object according to the requirement
     */
    public Order createOrder(String orderMethod, int lineNum){
        String[] args = orderMethod.split(HASHTAG);
        boolean toReverse = args[args.length - 1].equals(REVERSE);
        switch (args[0]){
            case ABS:
                return new AbsOrder(toReverse,lineNum);
            case SIZE:
                return new SizeOrder(toReverse, lineNum);
            case TYPE:
                return new TypeOrder(toReverse,lineNum);
            case EMPTY_STRING:
                return new AbsOrder(false,lineNum);
            default:
                return new AbsOrder(lineNum);
        }
    }
}
