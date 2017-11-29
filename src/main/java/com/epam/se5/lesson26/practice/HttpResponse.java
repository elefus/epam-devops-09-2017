package com.epam.se5.lesson26.practice;

import java.io.OutputStream;

public interface HttpResponse {

    void setProtocol(String protocol);
    void setResponseCode(ResponseCode code);
    void setHeader(String name, String value);
    void setServerHeader(String value);
    void setContentType(String value);
    void setContentLength(String value);
    OutputStream getOutputStream();

    enum ResponseCode {
        OK(200, "OK"),
        BAD_REQUEST(400, "Bad request"),
        UNAUTHORIZED(401, "Unauthorized"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not found");

        private final int code;
        private final String description;

        ResponseCode(int code, String description) {
            this.code = code;
            this.description = description;
        }
    }
}
