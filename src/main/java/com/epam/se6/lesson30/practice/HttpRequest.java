package com.epam.se6.lesson30.practice;

import java.io.InputStream;
import java.util.Map;

public interface HttpRequest {

    Method getMethod();
    String getURI();
    String getProtocol();
    Map<String, String> getHeaders();
    String getHeader(String header);
    InputStream getInputStream();
    Session getSession();

    enum Method {
        GET,
        POST,
        PUT,
        DELETE,
        UPDATE
    }
}
