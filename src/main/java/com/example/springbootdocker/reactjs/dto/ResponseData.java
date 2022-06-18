package com.example.springbootdocker.reactjs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ResponseData<T> {
    private String status;
    private String path;
    private String errorCode;
    private String errorDesc;
    private T data;

    public ResponseData(T data) {
        this.data = data;
    }

    public void print() {
        System.out.println(data);
    }

    public ResponseData<Object> ok(String path, T data) {
        ResponseData<Object> responseData = new ResponseData<>();
        responseData.setStatus(HttpStatus.OK.toString());
        responseData.setPath(path);
        responseData.setData(data);
        return responseData;
    }

    public static void main(String[] args) {
        ResponseData<String> responseData = new ResponseData<>("123");
        responseData.print();
        ResponseData<Integer> responseData1 = new ResponseData<>(123);
        responseData1.print();
    }
}
