package com.daveliebreich.homework;

import com.google.common.collect.Queues;
import com.opower.connectionpool.ConnectionPool;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A simple connection pool to manage a set of {@link jave.sql.Connection} objects.
 *
 */
public class DaveLConnectionPool implements ConnectionPool {
    private Integer size;
    private Deque<DaveLConnectionWrapper> in_use;
    private Deque<DaveLConnectionWrapper> available;

    //TODO constructor that takes a ConnectionFactory param
    //TODO lazy mode - create connections when needed
    //TODO lazy inactivity reaper - if none avail, check in_use for unused
    //TODO - can I use Queue instead of Deque?

    /**
     * Create a pool with specified size, and instantiate all Connection objects
     *
     * @param size the size of the pool
     */
    public DaveLConnectionPool(Integer size) {
        com.google.common.base.Preconditions.checkArgument(size >= 0);
        in_use = Queues.synchronizedDeque(new ArrayDeque<DaveLConnectionWrapper>(size));
        available = Queues.synchronizedDeque(new ArrayDeque<DaveLConnectionWrapper>(size));

        for (int index = 0; index < size; index++) {
            available.add(new DaveLConnectionWrapper(null));
        }
        this.size = size;
    }

    /**
     * Create a pool of size 0
     */
    public DaveLConnectionPool() {
        this(0);
    }

    /**
     * Returns the least recently returned connection, or null if there are no connections available
     *
     * @return a connection object, or null
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        DaveLConnectionWrapper connection = available.pollFirst();
        if (connection != null) {
            in_use.add(connection);
        }

        return connection;
    }

    /**
     * connection is returned to the pool
     *
     * Attempting to return null, or to return a connection object not originally from this pool, will
     * throw an exception
     *
     * @param connection the connection to return to the pool
     * @throws SQLException
     */
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

    /**
     * The number of connection objects available in the pool
     *
     * @return number of connection objects available in the pool
     */
    public Integer availableConnectionCount() {
        return available.size();
    }
}
