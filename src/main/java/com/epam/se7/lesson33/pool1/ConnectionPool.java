package com.epam.se7.lesson33.pool1;

import lombok.experimental.Delegate;

import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public class ConnectionPool {

    private static final ConnectionPool INSTANCE = new ConnectionPool();
    private List<PooledConnection> freeConnections;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private Integer connectionNumber;
    private Semaphore semaphore;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setConnectionNumber(Integer connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    private ConnectionPool() {
    }

    public void initConnections() throws SQLException {
        try {
            Class.forName(driverClassName);
            semaphore = new Semaphore(connectionNumber);
            freeConnections = new LinkedList<>();
            for (int i = 0; i < connectionNumber; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                PooledConnection pooledConnection = new PooledConnection(connection);
                freeConnections.add(pooledConnection);
            }
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public Optional<Connection> getConnection() {
        if (semaphore.tryAcquire()) {
            PooledConnection pooledConnection = freeConnections.remove(0);
            return Optional.of(pooledConnection);
        }
        return Optional.empty();
    }

    public void closeConnections() {
        int releaseNumber = connectionNumber - semaphore.availablePermits();
        semaphore.release(releaseNumber);

    }

    private class PooledConnection implements Connection {

        @Delegate(types = Connection.class, excludes = AutoCloseable.class)
        private Connection connection;

        public PooledConnection(Connection connection) throws SQLException {
            this.connection = connection;
            this.connection.setAutoCommit(true);
        }

        @Override
        public void close() throws SQLException {
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            freeConnections.add(this);
            semaphore.release();
        }
    }
}
