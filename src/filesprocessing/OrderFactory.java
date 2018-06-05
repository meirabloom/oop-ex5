package filesprocessing;
import filesprocessing.order.*;


public class OrderFactory {

    private static final String HASHTAG = "#";
    private static final String ABS = "abs";
    private static final String SIZE = "size";
    private static final String TYPE = "type";
    private static final String REVERSE = "REVERSE";

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
            case "":
                return new AbsOrder(false,lineNum);
            default:
                return new AbsOrder(lineNum);
        }
    }
}
