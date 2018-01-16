/*******************************************************************************
 * Copyright (c) 2005, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.enablement.ibm.db2.catalog.util;

import java.sql.Connection;
import org.eclipse.datatools.enablement.ibm.db2.catalog.JavaProcedureInfo;
import org.eclipse.datatools.enablement.ibm.db2.model.DB2Procedure;

public interface JavaProcedureProvider {
    public JavaProcedureInfo getProviderInstance(DB2Procedure sp, Connection connection);
}