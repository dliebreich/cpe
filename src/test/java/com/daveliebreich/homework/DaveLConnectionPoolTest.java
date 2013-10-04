package com.daveliebreich.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 * Created with IntelliJ IDEA.
 * User: davel
 * Date: 10/3/13
 * Time: 9:29 PM
 * Homework Assignment
 */
public class DaveLConnectionPoolTest {
    private DaveLConnectionPool cp;

    @Test
    public void testGetConnection() throws Exception {
        Assert.assertThat(cp.getConnection(), is(nullValue()) );

    }

    @Test
    public void testReleaseConnection() throws Exception {
        cp.releaseConnection(null);

    }

    @Before
    public void setUp() throws Exception {
        cp = new DaveLConnectionPool();

    }
}
