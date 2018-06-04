package fileprocessing;
import fileprocessing.order.*;


public class OrderFactory {

    private static final String HASHTAG = "#";
    private static final String ABS = "abs";
    private static final String SIZE = "size";
    private static final String TYPE = "type";
    private static final String EMPTY_COMMAND = " ";
    private static final String REVERSE = "REVERSE";

    public Order createOrder(String orderMethod){
        String[] args = orderMethod.split(HASHTAG);
        boolean toReverse = args[args.length - 1].equals(REVERSE);
        switch (args[0]){
            case ABS:
                return new AbsOrder(toReverse);
            case SIZE:
                return new SizeOrder(toReverse);
            case TYPE:
                return new TypeOrder(toReverse);
            case EMPTY_COMMAND:
                return new AbsOrder(toReverse);
            default:
                return new AbsOrder(false);
        }
    }
}
