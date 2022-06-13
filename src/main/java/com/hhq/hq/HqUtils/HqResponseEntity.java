package com.hhq.hq.HqUtils;

import java.util.HashMap;
import java.util.Map;

public class HqResponseEntity {

    public static final String ERRORS_KEY = "errors";

    private final String message;
    private final int code;
    private final Map<String, Object> data = new HashMap();

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public HqResponseEntity putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    private HqResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static HqResponseEntity ok() {
        return new HqResponseEntity(200, "Ok");
    }

    public static HqResponseEntity notFound() {
        return new HqResponseEntity(404, "Not Found");
    }

    public static HqResponseEntity badRequest() {
        return new HqResponseEntity(400, "Bad Request");
    }

    public static HqResponseEntity forbidden() {
        return new HqResponseEntity(403, "Forbidden");
    }

    public static HqResponseEntity unauthorized() {
        return new HqResponseEntity(401, "unauthorized");
    }
    public static HqResponseEntity tokenExpired() {
        return new HqResponseEntity(501, "Token has expired");
    }


    public static HqResponseEntity serverInternalError() {
        return new HqResponseEntity(500, "Server Internal Error");
    }

    public static HqResponseEntity customerError(int code,String message) {
        return new HqResponseEntity(code, message);
    }
}
