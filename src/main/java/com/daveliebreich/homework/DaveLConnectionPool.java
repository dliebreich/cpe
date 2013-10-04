package com.daveliebreich.homework;

import com.opower.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: davel
 * Date: 10/3/13
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class DaveLConnectionPool implements ConnectionPool {
    @Override
    public Connection getConnection() throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void releaseConnection(Connection connection) throws SQLException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
