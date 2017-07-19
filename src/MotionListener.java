package src;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

/**
 * Created by joshuareno on 7/17/17.
 */

public class MotionListener extends Listener{
    private String initString = "Initialized";
    private String connectString = "Connected";
    private String disconnectString = "Disconnected";
    private String exitString = "Exited";

    private String string;

    public void onInit(Controller controller) {
        string = initString;
    }

    public void onConnect(Controller controller) {
        string = connectString;
    }

    public void onDisconnect(Controller controller) {
        string = disconnectString;
    }

    public void onExit(Controller controller) {
        string = exitString;
    }

    public void onFrame(Controller controller) {}

    public void setInitString() {
        string = initString;
    }

    public void setConnectString(String connectString) {
        string = connectString;
    }

    public void setDisconnectString(String disconnectString) {
        string = disconnectString;
    }

    public void setExitString(String exitString) {
        string = exitString;
    }

    public String getString() {
        return string;
    }
}
