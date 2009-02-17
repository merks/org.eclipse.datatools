/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.connectivity.sqm.internal.core.connection;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.datatools.connectivity.sqm.internal.core.RDBCorePlugin;

public class ResultSetAdapter implements ResultSet {
	private ResultSet resultSet;
	private StatementAdapter statement;
	
	public ResultSetAdapter(StatementAdapter statement, ResultSet resultSet) {
		this.statement = statement;
		this.resultSet = resultSet;
	}
	public boolean absolute(int arg0) throws SQLException {
		return resultSet.absolute(arg0);
	}
	public void afterLast() throws SQLException {
		resultSet.afterLast();
	}
	public void beforeFirst() throws SQLException {
		resultSet.beforeFirst();
	}
	public void cancelRowUpdates() throws SQLException {
		resultSet.cancelRowUpdates();
	}
	public void clearWarnings() throws SQLException {
		resultSet.clearWarnings();
	}
	public void close() throws SQLException {
		resultSet.close();
	}
	public void deleteRow() throws SQLException {
		resultSet.deleteRow();
	}
	public boolean equals(Object arg0) {
		return resultSet.equals(arg0);
	}
	public int findColumn(String arg0) throws SQLException {
		return resultSet.findColumn(arg0);
	}
	public boolean first() throws SQLException {
		return resultSet.first();
	}
	public Array getArray(int arg0) throws SQLException {
		return resultSet.getArray(arg0);
	}
	public Array getArray(String arg0) throws SQLException {
		return resultSet.getArray(arg0);
	}
	public InputStream getAsciiStream(int arg0) throws SQLException {
		return resultSet.getAsciiStream(arg0);
	}
	public InputStream getAsciiStream(String arg0) throws SQLException {
		return resultSet.getAsciiStream(arg0);
	}
	public BigDecimal getBigDecimal(int arg0) throws SQLException {
		return resultSet.getBigDecimal(arg0);
	}
	public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
		return resultSet.getBigDecimal(arg0, arg1);
	}
	public BigDecimal getBigDecimal(String arg0) throws SQLException {
		return resultSet.getBigDecimal(arg0);
	}
	public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
		return resultSet.getBigDecimal(arg0, arg1);
	}
	public InputStream getBinaryStream(int arg0) throws SQLException {
		return resultSet.getBinaryStream(arg0);
	}
	public InputStream getBinaryStream(String arg0) throws SQLException {
		return resultSet.getBinaryStream(arg0);
	}
	public Blob getBlob(int arg0) throws SQLException {
		return resultSet.getBlob(arg0);
	}
	public Blob getBlob(String arg0) throws SQLException {
		return resultSet.getBlob(arg0);
	}
	public boolean getBoolean(int arg0) throws SQLException {
		return resultSet.getBoolean(arg0);
	}
	public boolean getBoolean(String arg0) throws SQLException {
		return resultSet.getBoolean(arg0);
	}
	public byte getByte(int arg0) throws SQLException {
		return resultSet.getByte(arg0);
	}
	public byte getByte(String arg0) throws SQLException {
		return resultSet.getByte(arg0);
	}
	public byte[] getBytes(int arg0) throws SQLException {
		return resultSet.getBytes(arg0);
	}
	public byte[] getBytes(String arg0) throws SQLException {
		return resultSet.getBytes(arg0);
	}
	public Reader getCharacterStream(int arg0) throws SQLException {
		return resultSet.getCharacterStream(arg0);
	}
	public Reader getCharacterStream(String arg0) throws SQLException {
		return resultSet.getCharacterStream(arg0);
	}
	public Clob getClob(int arg0) throws SQLException {
		return resultSet.getClob(arg0);
	}
	public Clob getClob(String arg0) throws SQLException {
		return resultSet.getClob(arg0);
	}
	public int getConcurrency() throws SQLException {
		return resultSet.getConcurrency();
	}
	public String getCursorName() throws SQLException {
		return resultSet.getCursorName();
	}
	public Date getDate(int arg0) throws SQLException {
		return resultSet.getDate(arg0);
	}
	public Date getDate(int arg0, Calendar arg1) throws SQLException {
		return resultSet.getDate(arg0, arg1);
	}
	public Date getDate(String arg0) throws SQLException {
		return resultSet.getDate(arg0);
	}
	public Date getDate(String arg0, Calendar arg1) throws SQLException {
		return resultSet.getDate(arg0, arg1);
	}
	public double getDouble(int arg0) throws SQLException {
		return resultSet.getDouble(arg0);
	}
	public double getDouble(String arg0) throws SQLException {
		return resultSet.getDouble(arg0);
	}
	public int getFetchDirection() throws SQLException {
		return resultSet.getFetchDirection();
	}
	public int getFetchSize() throws SQLException {
		return resultSet.getFetchSize();
	}
	public float getFloat(int arg0) throws SQLException {
		return resultSet.getFloat(arg0);
	}
	public float getFloat(String arg0) throws SQLException {
		return resultSet.getFloat(arg0);
	}
	public int getInt(int arg0) throws SQLException {
		try {
			return resultSet.getInt(arg0);			
		}
		catch(SQLException e) {
		    IStatus status = new Status(IStatus.ERROR, RDBCorePlugin.getDefault().getBundle().getSymbolicName(), IStatus.ERROR,
		            e.getClass().getName(),
		            e);
			RDBCorePlugin.getDefault().getLog().log(status);
			ConnectionInfoImpl info =  (ConnectionInfoImpl) ((ConnectionAdapter) this.statement.getConnection()).getConnectionInfo();
			info.onSQLException(this.statement.getConnection(), e);
	        throw e;
		}
	}
	public int getInt(String arg0) throws SQLException {
		try {
			return resultSet.getInt(arg0);
		}
		catch(SQLException e) {
		    IStatus status = new Status(IStatus.ERROR, RDBCorePlugin.getDefault().getBundle().getSymbolicName(), IStatus.ERROR,
		            e.getClass().getName(),
		            e);
			RDBCorePlugin.getDefault().getLog().log(status);
	        throw e;
		}
	}
	public long getLong(int arg0) throws SQLException {
		return resultSet.getLong(arg0);
	}
	public long getLong(String arg0) throws SQLException {
		return resultSet.getLong(arg0);
	}
	public ResultSetMetaData getMetaData() throws SQLException {
		return resultSet.getMetaData();
	}
	public Object getObject(int arg0) throws SQLException {
		return resultSet.getObject(arg0);
	}
	public Object getObject(int arg0, Map arg1) throws SQLException {
		return resultSet.getObject(arg0, arg1);
	}
	public Object getObject(String arg0) throws SQLException {
		return resultSet.getObject(arg0);
	}
	public Object getObject(String arg0, Map arg1) throws SQLException {
		return resultSet.getObject(arg0, arg1);
	}
	public Ref getRef(int arg0) throws SQLException {
		return resultSet.getRef(arg0);
	}
	public Ref getRef(String arg0) throws SQLException {
		return resultSet.getRef(arg0);
	}
	public int getRow() throws SQLException {
		return resultSet.getRow();
	}
	public short getShort(int arg0) throws SQLException {
		return resultSet.getShort(arg0);
	}
	public short getShort(String arg0) throws SQLException {
		return resultSet.getShort(arg0);
	}
	public Statement getStatement() throws SQLException {
		return resultSet.getStatement();
	}
	public String getString(int arg0) throws SQLException {
		try {
			return resultSet.getString(arg0);
		}
		catch(SQLException e) {
		    IStatus status = new Status(IStatus.ERROR, RDBCorePlugin.getDefault().getBundle().getSymbolicName(), IStatus.ERROR,
		            e.getClass().getName(),
		            e);
			RDBCorePlugin.getDefault().getLog().log(status);
	        throw e;
		}
	}
	public String getString(String arg0) throws SQLException {
		try {
			return resultSet.getString(arg0);
		}
		catch(SQLException e) {
		    IStatus status = new Status(IStatus.ERROR, RDBCorePlugin.getDefault().getBundle().getSymbolicName(), IStatus.ERROR,
		            e.getClass().getName(),
		            e);
			RDBCorePlugin.getDefault().getLog().log(status);
	        throw e;
		}
	}
	public Time getTime(int arg0) throws SQLException {
		return resultSet.getTime(arg0);
	}
	public Time getTime(int arg0, Calendar arg1) throws SQLException {
		return resultSet.getTime(arg0, arg1);
	}
	public Time getTime(String arg0) throws SQLException {
		return resultSet.getTime(arg0);
	}
	public Time getTime(String arg0, Calendar arg1) throws SQLException {
		return resultSet.getTime(arg0, arg1);
	}
	public Timestamp getTimestamp(int arg0) throws SQLException {
		return resultSet.getTimestamp(arg0);
	}
	public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
		return resultSet.getTimestamp(arg0, arg1);
	}
	public Timestamp getTimestamp(String arg0) throws SQLException {
		return resultSet.getTimestamp(arg0);
	}
	public Timestamp getTimestamp(String arg0, Calendar arg1)
			throws SQLException {
		return resultSet.getTimestamp(arg0, arg1);
	}
	public int getType() throws SQLException {
		return resultSet.getType();
	}
	public InputStream getUnicodeStream(int arg0) throws SQLException {
		return resultSet.getUnicodeStream(arg0);
	}
	public InputStream getUnicodeStream(String arg0) throws SQLException {
		return resultSet.getUnicodeStream(arg0);
	}
	public URL getURL(int arg0) throws SQLException {
		return resultSet.getURL(arg0);
	}
	public URL getURL(String arg0) throws SQLException {
		return resultSet.getURL(arg0);
	}
	public SQLWarning getWarnings() throws SQLException {
		return resultSet.getWarnings();
	}
	public int hashCode() {
		return resultSet.hashCode();
	}
	public void insertRow() throws SQLException {
		resultSet.insertRow();
	}
	public boolean isAfterLast() throws SQLException {
		return resultSet.isAfterLast();
	}
	public boolean isBeforeFirst() throws SQLException {
		return resultSet.isBeforeFirst();
	}
	public boolean isFirst() throws SQLException {
		return resultSet.isFirst();
	}
	public boolean isLast() throws SQLException {
		return resultSet.isLast();
	}
	public boolean last() throws SQLException {
		return resultSet.last();
	}
	public void moveToCurrentRow() throws SQLException {
		resultSet.moveToCurrentRow();
	}
	public void moveToInsertRow() throws SQLException {
		resultSet.moveToInsertRow();
	}
	public boolean next() throws SQLException {
		return resultSet.next();
	}
	public boolean previous() throws SQLException {
		return resultSet.previous();
	}
	public void refreshRow() throws SQLException {
		resultSet.refreshRow();
	}
	public boolean relative(int arg0) throws SQLException {
		return resultSet.relative(arg0);
	}
	public boolean rowDeleted() throws SQLException {
		return resultSet.rowDeleted();
	}
	public boolean rowInserted() throws SQLException {
		return resultSet.rowInserted();
	}
	public boolean rowUpdated() throws SQLException {
		return resultSet.rowUpdated();
	}
	public void setFetchDirection(int arg0) throws SQLException {
		resultSet.setFetchDirection(arg0);
	}
	public void setFetchSize(int arg0) throws SQLException {
		resultSet.setFetchSize(arg0);
	}
	public String toString() {
		return resultSet.toString();
	}
	public void updateArray(int arg0, Array arg1) throws SQLException {
		resultSet.updateArray(arg0, arg1);
	}
	public void updateArray(String arg0, Array arg1) throws SQLException {
		resultSet.updateArray(arg0, arg1);
	}
	public void updateAsciiStream(int arg0, InputStream arg1, int arg2)
			throws SQLException {
		resultSet.updateAsciiStream(arg0, arg1, arg2);
	}
	public void updateAsciiStream(String arg0, InputStream arg1, int arg2)
			throws SQLException {
		resultSet.updateAsciiStream(arg0, arg1, arg2);
	}
	public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
		resultSet.updateBigDecimal(arg0, arg1);
	}
	public void updateBigDecimal(String arg0, BigDecimal arg1)
			throws SQLException {
		resultSet.updateBigDecimal(arg0, arg1);
	}
	public void updateBinaryStream(int arg0, InputStream arg1, int arg2)
			throws SQLException {
		resultSet.updateBinaryStream(arg0, arg1, arg2);
	}
	public void updateBinaryStream(String arg0, InputStream arg1, int arg2)
			throws SQLException {
		resultSet.updateBinaryStream(arg0, arg1, arg2);
	}
	public void updateBlob(int arg0, Blob arg1) throws SQLException {
		resultSet.updateBlob(arg0, arg1);
	}
	public void updateBlob(String arg0, Blob arg1) throws SQLException {
		resultSet.updateBlob(arg0, arg1);
	}
	public void updateBoolean(int arg0, boolean arg1) throws SQLException {
		resultSet.updateBoolean(arg0, arg1);
	}
	public void updateBoolean(String arg0, boolean arg1) throws SQLException {
		resultSet.updateBoolean(arg0, arg1);
	}
	public void updateByte(int arg0, byte arg1) throws SQLException {
		resultSet.updateByte(arg0, arg1);
	}
	public void updateByte(String arg0, byte arg1) throws SQLException {
		resultSet.updateByte(arg0, arg1);
	}
	public void updateBytes(int arg0, byte[] arg1) throws SQLException {
		resultSet.updateBytes(arg0, arg1);
	}
	public void updateBytes(String arg0, byte[] arg1) throws SQLException {
		resultSet.updateBytes(arg0, arg1);
	}
	public void updateCharacterStream(int arg0, Reader arg1, int arg2)
			throws SQLException {
		resultSet.updateCharacterStream(arg0, arg1, arg2);
	}
	public void updateCharacterStream(String arg0, Reader arg1, int arg2)
			throws SQLException {
		resultSet.updateCharacterStream(arg0, arg1, arg2);
	}
	public void updateClob(int arg0, Clob arg1) throws SQLException {
		resultSet.updateClob(arg0, arg1);
	}
	public void updateClob(String arg0, Clob arg1) throws SQLException {
		resultSet.updateClob(arg0, arg1);
	}
	public void updateDate(int arg0, Date arg1) throws SQLException {
		resultSet.updateDate(arg0, arg1);
	}
	public void updateDate(String arg0, Date arg1) throws SQLException {
		resultSet.updateDate(arg0, arg1);
	}
	public void updateDouble(int arg0, double arg1) throws SQLException {
		resultSet.updateDouble(arg0, arg1);
	}
	public void updateDouble(String arg0, double arg1) throws SQLException {
		resultSet.updateDouble(arg0, arg1);
	}
	public void updateFloat(int arg0, float arg1) throws SQLException {
		resultSet.updateFloat(arg0, arg1);
	}
	public void updateFloat(String arg0, float arg1) throws SQLException {
		resultSet.updateFloat(arg0, arg1);
	}
	public void updateInt(int arg0, int arg1) throws SQLException {
		resultSet.updateInt(arg0, arg1);
	}
	public void updateInt(String arg0, int arg1) throws SQLException {
		resultSet.updateInt(arg0, arg1);
	}
	public void updateLong(int arg0, long arg1) throws SQLException {
		resultSet.updateLong(arg0, arg1);
	}
	public void updateLong(String arg0, long arg1) throws SQLException {
		resultSet.updateLong(arg0, arg1);
	}
	public void updateNull(int arg0) throws SQLException {
		resultSet.updateNull(arg0);
	}
	public void updateNull(String arg0) throws SQLException {
		resultSet.updateNull(arg0);
	}
	public void updateObject(int arg0, Object arg1) throws SQLException {
		resultSet.updateObject(arg0, arg1);
	}
	public void updateObject(int arg0, Object arg1, int arg2)
			throws SQLException {
		resultSet.updateObject(arg0, arg1, arg2);
	}
	public void updateObject(String arg0, Object arg1) throws SQLException {
		resultSet.updateObject(arg0, arg1);
	}
	public void updateObject(String arg0, Object arg1, int arg2)
			throws SQLException {
		resultSet.updateObject(arg0, arg1, arg2);
	}
	public void updateRef(int arg0, Ref arg1) throws SQLException {
		resultSet.updateRef(arg0, arg1);
	}
	public void updateRef(String arg0, Ref arg1) throws SQLException {
		resultSet.updateRef(arg0, arg1);
	}
	public void updateRow() throws SQLException {
		resultSet.updateRow();
	}
	public void updateShort(int arg0, short arg1) throws SQLException {
		resultSet.updateShort(arg0, arg1);
	}
	public void updateShort(String arg0, short arg1) throws SQLException {
		resultSet.updateShort(arg0, arg1);
	}
	public void updateString(int arg0, String arg1) throws SQLException {
		resultSet.updateString(arg0, arg1);
	}
	public void updateString(String arg0, String arg1) throws SQLException {
		resultSet.updateString(arg0, arg1);
	}
	public void updateTime(int arg0, Time arg1) throws SQLException {
		resultSet.updateTime(arg0, arg1);
	}
	public void updateTime(String arg0, Time arg1) throws SQLException {
		resultSet.updateTime(arg0, arg1);
	}
	public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
		resultSet.updateTimestamp(arg0, arg1);
	}
	public void updateTimestamp(String arg0, Timestamp arg1)
			throws SQLException {
		resultSet.updateTimestamp(arg0, arg1);
	}
	public boolean wasNull() throws SQLException {
		return resultSet.wasNull();
	}
}
