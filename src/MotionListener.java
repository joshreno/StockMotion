package src;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

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
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
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
    public void onFrame(Controller controller) {
        Frame frame = new controller.frame();
        for (Hand hand : frame.hands()) {
            String handType = hand.isLeft() ? "Left hand" : "Right hand";
            Vector normal = hand.palmNormal();
            Vector direction = hand.direction();
            Arm arm = hand.arm();
        }

        GestureList gestures = frame.gestures();
        for (int i = 0; i < gestures.count(); i++) {
            Gesture gesture = gestures.get(i);
            switch (gesture.type()) {
                case TYPE_CIRCLE:
                    CircleGesture circle = new CircleGesture(gesture);
                    break;
                case TYPE_SWIPE:
                    SwipeGesture swipe = new SwipeGesture(gesture);
                    break;
                case TYPE_SCREEN_TAP:
                    ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
                    break;
                case TYPE_KEY_TAP:
                    KeyTapGesture keyTap = new KeyTapGesture(gesture);
                    break;
                default:
                    break;
            }
        }
    }

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
