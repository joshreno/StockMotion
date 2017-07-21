package src;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

/**
 * Created by joshuareno on 7/17/17.
 */

public class MotionListener extends Listener{
    private LeapStatus status;

    public void onInit(Controller controller) {
        setInitString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    public void onConnect(Controller controller) {
        setConnectString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    public void onDisconnect(Controller controller) {
        setDisconnectString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    public void onExit(Controller controller) {
        setExitString();
        StockMotion.getStockScreen().getControlInformation().setStatusString(status);
    }

    public void onFrame(Controller controller) {}

    public void setInitString() {
        status = LeapStatus.INITIALIZED;
    }

    public void setConnectString() {
        status = LeapStatus.CONNECTED;
    }

    public void setDisconnectString() {
        status = LeapStatus.DISCONNECTED;
    }

    public void setExitString() {
        status = LeapStatus.EXITED;
    }

    public LeapStatus getStatus() {
        return status;
    }
}
