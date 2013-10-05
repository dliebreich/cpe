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

    @Test
    public void testGetConnection() throws Exception {
        assertThat(defaultConnectionPool.getConnection(), is(nullValue()));

    }

    @Test
    public void testReleaseConnection() throws Exception {
        defaultConnectionPool.releaseConnection(null);

    }

    @Before
    public void setUp() throws Exception {
        defaultConnectionPool = new DaveLConnectionPool();
        sizeOneConnectionPool = new DaveLConnectionPool(1);

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
}
