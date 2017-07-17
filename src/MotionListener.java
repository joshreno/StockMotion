/**
 * Created by joshuareno on 7/17/17.
 */
package src;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

public class MotionListener extends Listener{
    private String initString;
    private String connectString;
    private String disconnectString;
    private String exitString;


    public void onInit(Controller controller) {
        initString = "initialized";
    }

    public void onConnect(Controller controller) {
        connectString = "Connected";
    }

    public void onDisconnect(Controller controller) {
        disconnectString = "Disconnected";
    }

    public void onExit(Controller controller) {
        exitString = "Exited";
    }

    public void onFrame(Controller controller) {}

    public void setInitString(String initString) {
        this.initString = initString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public void setDisconnectString(String disconnectString) {
        this.disconnectString = disconnectString;
    }

    public void setExitString(String exitString) {
        this.exitString = exitString;
    }

    public String getInitString() {
        return initString;
    }

    public String getConnectString() {
        return connectString;
    }

    public String getDisconnectString() {
        return disconnectString;
    }

    public String getExitString() {
        return exitString;
    }
}
