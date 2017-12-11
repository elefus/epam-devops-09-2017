package com.epam.se6.lesson30.practice;

public interface WebServer {

    void service(HttpRequest request, HttpResponse response);
}

//localhost:10000/add?left=10&right=20
//localhost:10000/mult?left=10&right=20
//localhost:10000/getFile?file=...
