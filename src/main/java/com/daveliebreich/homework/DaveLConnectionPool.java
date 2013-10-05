package com.daveliebreich.homework;

import com.opower.connectionpool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: davel
 * Date: 10/3/13
 * Time: 9:27 PM
 * Homework
 */
public class DaveLConnectionPool implements ConnectionPool {
    private Integer size;
    private List<DaveLConnectionWrapper> in_use;

    public DaveLConnectionPool(Integer size) {
        com.google.common.base.Preconditions.checkArgument(size >= 0);
        in_use = new ArrayList<DaveLConnectionWrapper>(size);
        this.size = size;
    }

    public DaveLConnectionPool() {
        this(0);
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (size > 0) {
            size--;
            DaveLConnectionWrapper connection = new DaveLConnectionWrapper();
            in_use.add(connection);
            return connection;  //To change body of implemented methods use File | Settings | File Templates.
        } else {
            return null;
        }
    }

    @Override
    public void releaseConnection(Connection connection) throws SQLException {
        if (connection == null) {
            throw new RuntimeException();
        }

        if (in_use.remove(connection)) {
            size++;
        } else {
            throw new RuntimeException();
        }
    }

}
