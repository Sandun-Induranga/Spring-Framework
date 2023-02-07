package lk.ijse.spring.util;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class ResponseUtil {
    String state;
    String message;
    Object data;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseUtil() {
    }

    public ResponseUtil(String state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
}
