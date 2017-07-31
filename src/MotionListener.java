package src;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

import yahoofinance.*;

/**
 * Created by joshuareno on 7/17/17.
 */

public class MotionListener extends Listener{
    private static LeapStatus status;

    /**
     * Sets information from Leap Motion Controller
     * @param controller
     */
    public void onInit(Controller controller) {
        setInitString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    /**
     * Sets information from Leap Motion Controller
     * @param controller
     */
    public void onConnect(Controller controller) {
        setConnectString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    /**
     * Sets information from Leap Motion Controller
     * @param controller
     */
    public void onDisconnect(Controller controller) {
        setDisconnectString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    /**
     * Sets information from Leap Motion Controller
     * @param controller
     */
    public void onExit(Controller controller) {
        setExitString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    /**
     * Sets information from Leap Motion Controller
     * @param controller
     */
    public void onFrame(Controller controller) {}

    /**
     * Sets the status of the Controller
     */
    public void setInitString() {
        status = LeapStatus.INITIALIZED;
    }

    /**
     * Sets the status of the Controller
     */
    public void setConnectString() {
        status = LeapStatus.CONNECTED;
    }

    /**
     * Sets the status of the Controller
     */
    public void setDisconnectString() {
        status = LeapStatus.DISCONNECTED;
    }

    /**
     * Sets the status of the Controller
     */
    public void setExitString() {
        status = LeapStatus.EXITED;
    }

    /**
     * Returns the status of the Leap Motion Controller
     * @return Status
     */
    public static LeapStatus getStatus() {
        return status;
    }
}
