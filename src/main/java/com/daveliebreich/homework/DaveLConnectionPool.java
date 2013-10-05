package com.daveliebreich.homework;

import com.opower.connectionpool.ConnectionPool;

import java.sql.*;
import java.util.Map;
import java.util.Properties;

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

    private class DaveLConnectionWrapper implements Connection {
        @Override
        public Statement createStatement() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public PreparedStatement prepareStatement(String s) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public CallableStatement prepareCall(String s) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String nativeSQL(String s) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setAutoCommit(boolean b) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void commit() throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void rollback() throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void close() throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public boolean isClosed() throws SQLException {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setReadOnly(boolean b) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setCatalog(String s) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String getCatalog() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setTransactionIsolation(int i) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void clearWarnings() throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Statement createStatement(int i, int i2) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i, int i2) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public CallableStatement prepareCall(String s, int i, int i2) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> stringClassMap) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setHoldability(int i) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public int getHoldability() throws SQLException {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Savepoint setSavepoint(String s) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Statement createStatement(int i, int i2, int i3) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i, int i2, int i3) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public CallableStatement prepareCall(String s, int i, int i2, int i3) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public PreparedStatement prepareStatement(String s, int[] ints) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public PreparedStatement prepareStatement(String s, String[] strings) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Clob createClob() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Blob createBlob() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public NClob createNClob() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public boolean isValid(int i) throws SQLException {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setClientInfo(String s, String s2) throws SQLClientInfoException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String getClientInfo(String s) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Array createArrayOf(String s, Object[] objects) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Struct createStruct(String s, Object[] objects) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public <T> T unwrap(Class<T> tClass) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public boolean isWrapperFor(Class<?> aClass) throws SQLException {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
