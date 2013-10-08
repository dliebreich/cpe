package com.daveliebreich.homework;

import com.google.common.collect.Queues;
import com.opower.connectionpool.ConnectionPool;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: davel
 * Date: 10/3/13
 * Time: 9:27 PM
 * Homework
 */
public class DaveLConnectionPool implements ConnectionPool {
    private Integer size;
    private Deque<DaveLConnectionWrapper> in_use;
    private Deque<DaveLConnectionWrapper> available;

    public DaveLConnectionPool(Integer size) {
        com.google.common.base.Preconditions.checkArgument(size >= 0);
        in_use = Queues.synchronizedDeque(new ArrayDeque<DaveLConnectionWrapper>(size));
        available = Queues.synchronizedDeque(new ArrayDeque<DaveLConnectionWrapper>(size));

        for (int index = 0; index < size; index++) {
            available.add(new DaveLConnectionWrapper());
        }
        this.size = size;
    }

    public DaveLConnectionPool() {
        this(0);
    }

    @Override
    public Connection getConnection() throws SQLException {
        DaveLConnectionWrapper connection = available.pollFirst();
        if (connection != null) {
            in_use.add(connection);
        }

        return connection;
    }

    @Override
    public void releaseConnection(Connection connection) throws SQLException {
        if (connection == null) {
            throw new RuntimeException();
        }

        if (in_use.remove(connection)) {
            available.addLast((DaveLConnectionWrapper) connection);
        } else {
            throw new RuntimeException();
        }
    }

    public Integer availableConnectionCount() {
        return available.size();
    }
}
