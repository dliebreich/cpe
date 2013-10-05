package com.daveliebreich.homework;

import com.opower.connectionpool.ConnectionPool;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: davel
 * Date: 10/3/13
 * Time: 9:27 PM
 * Homework
 */
public class DaveLConnectionPool implements ConnectionPool {
    private Integer size;

    public DaveLConnectionPool(Integer size) {
        this.size = size;
    }

    public DaveLConnectionPool() {
        this(0);
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (size > 0) {
            return new DaveLConnectionWrapper();  //To change body of implemented methods use File | Settings | File Templates.
        } else {
            return null;
        }
    }

    @Override
    public void releaseConnection(Connection connection) throws SQLException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
