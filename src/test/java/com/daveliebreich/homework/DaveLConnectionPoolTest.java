package com.daveliebreich.homework;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created with IntelliJ IDEA.
 * User: davel
 * Date: 10/3/13
 * Time: 9:29 PM
 * Homework Assignment
 */
public class DaveLConnectionPoolTest {
    private DaveLConnectionPool defaultConnectionPool;
    private DaveLConnectionPool sizeOneConnectionPool;
    private DaveLConnectionPool secondSizeOneConnectionPool;

    @Before
    public void setUp() throws Exception {
        defaultConnectionPool = new DaveLConnectionPool();
        sizeOneConnectionPool = new DaveLConnectionPool(1);
        secondSizeOneConnectionPool = new DaveLConnectionPool(1);

    }

    @Test
    public void testGetConnection() throws Exception {
        assertThat(defaultConnectionPool.getConnection(), is(nullValue()));

    }

    @Test(expected = RuntimeException.class)
    public void testCanNotReturnNullToPool() throws Exception {
        defaultConnectionPool.releaseConnection(null);

    }

    @Test
    public void testCanReturnConnectionToPool() throws Exception {
        Connection first = sizeOneConnectionPool.getConnection();
        sizeOneConnectionPool.releaseConnection(first);
        Connection second = sizeOneConnectionPool.getConnection();

        assertThat(second, notNullValue());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSizeThrows() throws Exception {
        new DaveLConnectionPool(-1);

    }

    @Test
    public void testPoolDoesNotReturnMoreThanSizeConnections() throws Exception {
        Connection connectionFirst = sizeOneConnectionPool.getConnection();
        Connection connectionSecond = sizeOneConnectionPool.getConnection();

        assertThat(connectionSecond, nullValue());

    }

    @Test
    public void testCreatePoolOfOneConnection() throws Exception {
        Connection connection = sizeOneConnectionPool.getConnection();
        assertThat(connection, notNullValue());

    }

    @Test(expected = RuntimeException.class)
    public void testReturningSameConnectionTwiceThrows() throws Exception {
        Connection connection = sizeOneConnectionPool.getConnection();
        sizeOneConnectionPool.releaseConnection(connection);
        sizeOneConnectionPool.releaseConnection(connection);

    }

    @Test(expected = RuntimeException.class)
    public void testReturningConnectionFromOtherPoolThrows() throws Exception {
        Connection connection = sizeOneConnectionPool.getConnection();
        Connection secondConnection = secondSizeOneConnectionPool.getConnection();

        sizeOneConnectionPool.releaseConnection(secondConnection);

    }
}
