package edu.itplusz.bibliospring.backend.repository.jdbc;

import edu.itplusz.bibliospring.backend.repository.RepositoryExeption;
import edu.itplusz.bibliospring.backend.utils.PropertyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.LinkedList;

public class ConnectionManager {
    private LinkedList<Connection> pool;
    private static ConnectionManager instance;
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionManager.class);

    private ConnectionManager() {
        pool = new LinkedList<>();
        try {
            Class.forName(PropertyProvider.getProperty("JDBC_DRIVER"));
            for (int i = 0; i < 10; i++) {
                pool.add(DriverManager.getConnection(PropertyProvider.getProperty("JDBC_URL"),"root","alma"));
            }
            System.out.println("pool initialized successfully");
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error("error:initialization failed",e);
            throw new RepositoryExeption("error:initialization failed",e);
            //throw new RuntimeException(e);
        }
    }

    public synchronized static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        if (!pool.isEmpty()) {
            return pool.pop();
        }
        return null;
    }

    public void returnConnection(Connection connection) {
        if (pool.size() < Integer.parseInt(PropertyProvider.getProperty("POOL_SIZE"))) {
            pool.push(connection);
        }
    }
}
