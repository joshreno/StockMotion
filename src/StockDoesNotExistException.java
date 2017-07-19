package src;

import java.io.IOException;

/**
 * Created by joshuareno on 7/17/17.
 */

public class StockDoesNotExistException extends Exception {
    public StockDoesNotExistException(String message) {
        super("Stock: " + message + " does not exist.");
    }
}
