package com.epam.se7.lesson33.pool3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {

    private static ConnectionPool instance;
    private ArrayList<Connection> freeConnections = new ArrayList<Connection>();
    private String URL;
    private String user;
    private String password;
    private int maxConnections;

    private ConnectionPool(String driverName, String url, String user, String password, int maxConnections) {
        this.maxConnections = maxConnections;
        this.password = password;
        this.user = user;
        this.URL = url;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Can't find driver with name: ", ex);
        }
    }

    static synchronized public ConnectionPool getInstance(String driverName, String url, String user, String password, int maxConnections) {
        if (instance == null) {
            instance = new ConnectionPool(driverName, url, user, password, maxConnections);
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        Connection con;
        if (!freeConnections.isEmpty()) {
            con = freeConnections.remove(freeConnections.size() - 1);
            try {
                if (con.isClosed()) {
                    con = getConnection();
                }
            } catch (Exception e) {
                con = getConnection();
            }
        } else {
            con = newConnection();
        }
        return con;
    }

    private Connection newConnection() {
        try {
            if (user == null) {
                return DriverManager.getConnection(URL);
            } else {
                return DriverManager.getConnection(URL, user, password);
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public synchronized void freeConnection(Connection con) {
        if ((con != null) && (freeConnections.size() <= maxConnections)) {
            freeConnections.add(con);
        }
    }

    public synchronized void release() {
        for (Connection con : freeConnections) {
            try {
                con.close();
                // "Closed connection for pool „
            } catch (SQLException e) {
                // "Can't close connection for pool „
            }
        }
        freeConnections.clear();
    }
}
