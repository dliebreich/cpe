package com.daveliebreich.homework;

import java.sql.Connection;

/**
 * Used by {@link DaveLConnectionPool} to create {@link java.sql.Connection} objects for the pool
 */
public interface DaveLConnectionPoolConnectionFactory {
    public Connection getConnection();
}
