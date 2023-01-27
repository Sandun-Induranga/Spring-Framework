package lk.ijse.spring.dto;

import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class ResponseMessage {
    String state;
    String message;
    ArrayList<CustomerDTO> data;

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

    public ArrayList<CustomerDTO> getData() {
        return data;
    }

    public void setData(ArrayList<CustomerDTO> data) {
        this.data = data;
    }

    public ResponseMessage() {
    }

    public ResponseMessage(String state, String message, ArrayList<CustomerDTO> data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
}
