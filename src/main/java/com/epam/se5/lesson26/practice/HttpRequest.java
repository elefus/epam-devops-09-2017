package com.epam.se5.lesson26.practice;

import java.io.InputStream;
import java.util.Map;

public interface HttpRequest {

    Method getMethod();
    String getURI();
    String getProtocol();
    Map<String, String> getHeaders();
    String getHeader(String header);
    InputStream getInputStream();

    enum Method {
        GET,
        POST,
        PUT,
        DELETE,
        UPDATE
    }
}
