/*******************************************************************************
 * Copyright (c) 2008 Ingres Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Ingres Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.enablement.ingres.internal.ui.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.datatools.sqltools.core.DatabaseIdentifier;
import org.eclipse.datatools.sqltools.core.ProcIdentifier;
import org.eclipse.datatools.sqltools.core.dbitem.ParameterDescriptor;
import org.eclipse.datatools.sqltools.core.profile.NoSuchProfileException;
import org.eclipse.datatools.sqltools.editor.core.connection.IConnectionTracker;
import org.eclipse.datatools.sqltools.routineeditor.launching.LaunchHelper;
import org.eclipse.datatools.sqltools.routineeditor.parameter.ParameterInOutWrapper;
import org.eclipse.datatools.sqltools.routineeditor.result.CallableSQLResultRunnable;
import org.eclipse.debug.core.ILaunchConfiguration;

/**
 * The class CallableSupportRunnalbe has been overrriden to provide return
 * values in stored procedure calls.
 * 
 * @author enrico.schenk@ingres.com
 */
public class IngresCallableSQLResultRunnable extends CallableSQLResultRunnable {

	public IngresCallableSQLResultRunnable(Connection con,
			ILaunchConfiguration configuration, boolean closeCon,
			IConnectionTracker tracker, DatabaseIdentifier databaseIdentifier)
			throws CoreException, SQLException, NoSuchProfileException {
		super(con, configuration, closeCon, tracker, databaseIdentifier);
	}

	protected Statement prepareStatement(Connection connection)
			throws SQLException {

		CallableStatement cstmt = connection.prepareCall(_sql);
		if (_configuration != null) {
			ProcIdentifier proc;
			try {
				proc = LaunchHelper.readProcIdentifier(_configuration);
				if (proc != null) {
					_procName = proc.getProcName();
					_pws = LaunchHelper.getAllParameterWrappersByOrder(proc);

					// The call
					// _sql =
					// LaunchHelper.constructCallableStatementSQLString(configuration);
					// (called in the constructor of this class parents class)
					// creates always an SQL string with a result
					// parameter, but there is no result object in _pws
					// (generated by LaunchUI)

					// Add a placeholder for the return parameter wrapper
					ParameterInOutWrapper piow = createReturnParameterWrapper();
					ParameterInOutWrapper[] pws = new ParameterInOutWrapper[_pws.length + 1];
					System.arraycopy(_pws, 0, pws, 1, _pws.length);
					pws[0] = piow;
					_pws = pws;

					setInParameter(cstmt, _pws);
					registerOutParameter(cstmt, _pws);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cstmt;
	}

	private ParameterInOutWrapper createReturnParameterWrapper() {
		DatabaseIdentifier databaseIdentifier = _databaseIdentifier;
		String name = "return"; //$NON-NLS-1$
		int parmType = DatabaseMetaData.procedureColumnReturn;
		int sqlDataType = Types.VARCHAR;
		int precision = 0;
		short scale = 0;
		String typeName = "VARCHAR"; //$NON-NLS-1$
		short nullable = 1;
		String comment = ""; //$NON-NLS-1$

		ParameterDescriptor pd = new ParameterDescriptor(databaseIdentifier,
				name, parmType, sqlDataType, precision, scale, typeName,
				nullable, comment);
		ParameterInOutWrapper piow = new ParameterInOutWrapper(pd);
		return piow;
	}

}
