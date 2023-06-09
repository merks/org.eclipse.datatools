/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.enablement.dbdefinition.junittest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.datatools.connectivity.sqm.core.definition.DatabaseDefinition;
import org.eclipse.datatools.connectivity.sqm.internal.core.RDBCorePlugin;
import org.eclipse.datatools.modelbase.dbdefinition.PredefinedDataTypeDefinition;

import junit.framework.TestCase;

public class MySQLTest extends TestCase {
	
	//=========================Version 4.0=======================================
	private final int MAXIMUM_IDENTIFIER_LENGTH_COLUMN_4 = 64;
	private final int MAXIMUM_IDENTIFIER_LENGTH_DATABASE_4 = 64;
	private final int MAXIMUM_IDENTIFIER_LENGTH_TABLE_4 = 64;
	
	private final int MAXIMUM_LENGTH_BLOB_4 = 65536;
	private final int MAXIMUM_LENGTH_CHAR_4 = 255;
	private final int MAXIMUM_LENGTH_VARCHAR_4 = 255;
	
	private final int MAXIMUM_PRECISION_DECIMAL_4 = 64;
	private final int MAXIMUM_PRECISION_NUMERIC_4 = 64;	
	
    //=========================Version 4.1=======================================
	private final int MAXIMUM_IDENTIFIER_LENGTH_COLUMN_41 = 64;
	private final int MAXIMUM_IDENTIFIER_LENGTH_DATABASE_41 = 64;
	private final int MAXIMUM_IDENTIFIER_LENGTH_TABLE_41 = 64;
	
	private final int MAXIMUM_LENGTH_BLOB_41 = 65536;
	private final int MAXIMUM_LENGTH_CHAR_41 = 255;
	private final int MAXIMUM_LENGTH_VARCHAR_41 = 255;
	
	private final int MAXIMUM_PRECISION_DECIMAL_41 = 64;
	private final int MAXIMUM_PRECISION_NUMERIC_41 = 64;
	//==========================================================================================
	
	private final String strProduct = "MySql";
	private final String PACKAGE_NAME = "org.eclipse.datatools.enablement.dbdefinition.junittest";
	
	private int expectedMaxPrecision = 0;
	private int expectedMaxLength = 0;
	private int expectedIdentifierLength = 0;
	private int actualIdentifierLength = 0;

	
	private Iterator productVersion = null;
	private Iterator dataType;
	private List dataTypeList;
	private ArrayList definitionCollection = new ArrayList();
	private ArrayList dbInformationCollection = new ArrayList();
	
	private String strProductVersion = null;

	private DatabaseDefinition definition = null;
	private PredefinedDataTypeDefinition typeDefinition = null;

	
	public void setUp(){
		
		try{	
			productVersion = RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getVersions(strProduct);
			assertNotNull("\nMethod: getVersions()" +
						  "\nError: The method returns a NULL value in startUp()", productVersion);
					
			while(productVersion.hasNext())
			{
				strProductVersion = productVersion.next().toString();
				definition = RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getDefinition(strProduct, strProductVersion);
				assertNotNull("\nMethod: getDefinition()" +
							  "\nError: The method returns a NULL value in startUp()", definition);
					
				dbInformationCollection.add(strProductVersion);
				definitionCollection.add(definition);
			}
		}
		catch(Exception e){
			fail("\nMethod: setUp()" +
				 "\nException: " + e.toString() +
			     "\nDescription: The set up is incomplete");
		}
	}
	
//==========================================Version 4.0==============================================
		
	public void testGetMaximumPrecision_DECIMAL_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.0"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxPrecision = MAXIMUM_PRECISION_DECIMAL_4;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("DECIMAL"))
							{								
								assertEquals(getAssertionFailureMessage("getMaximumPrecision()", dbInformationCollection.get(i), "DECIMAL"),
										expectedMaxPrecision, typeDefinition.getMaximumPrecision());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumPrecision()", dbInformationCollection.get(0), e));
			}
		}
	}
	
	public void testGetMaximumPrecision_NUMERIC_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.0"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxPrecision = MAXIMUM_PRECISION_NUMERIC_4;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("NUMERIC"))
							{	
								assertEquals(getAssertionFailureMessage("getMaximumPrecision()", dbInformationCollection.get(i), "NUMERIC"),
										expectedMaxPrecision, typeDefinition.getMaximumPrecision());
							}
						}
					}
				}
								
			}catch(Exception e){
				fail(getExceptionMessage("getMaximumPrecision()", dbInformationCollection.get(0), e));
			}
		}
	}
	
	public void testGetMaximumLength_CHAR_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.0"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxLength = MAXIMUM_LENGTH_CHAR_4;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("CHAR"))
							{	
								assertEquals(getAssertionFailureMessage("getMaximumLength()", dbInformationCollection.get(i), "CHAR"),
										expectedMaxLength, typeDefinition.getMaximumLength());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumLength()", dbInformationCollection.get(0), e));
			}
		}
	}
	
	public void testGetMaximumLength_VARCHAR_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.0"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxLength = MAXIMUM_LENGTH_VARCHAR_4;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("VARCHAR"))
							{
								assertEquals(getAssertionFailureMessage("getMaximumLength()", dbInformationCollection.get(i), "VARCHAR"),
										expectedMaxLength, typeDefinition.getMaximumLength());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumLength()", dbInformationCollection.get(0), e));
			}
		}
	}
	
	public void testGetMaximumLength_BLOB_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.0"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxLength = MAXIMUM_LENGTH_BLOB_4;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("BLOB"))
							{
								assertEquals(getAssertionFailureMessage("getMaximumLength()", dbInformationCollection.get(i), "BLOB"),
										expectedMaxLength, typeDefinition.getMaximumLength());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumLength()", dbInformationCollection.get(0), e));
			}
		}
	}
	
	public void testGetDatabaseMaximumIdentifierLength_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				if((dbInformationCollection.get(i).toString()).equals("4.0"))
				{
					actualIdentifierLength = ((DatabaseDefinition)definitionCollection.get(i)).getDatabaseMaximumIdentifierLength();
					expectedIdentifierLength = MAXIMUM_IDENTIFIER_LENGTH_DATABASE_4;
				
					assertEquals(getAssertionFailureMessage("getDatabaseMaximumIdentifierLength()", dbInformationCollection.get(i), ""),
							expectedIdentifierLength, actualIdentifierLength);
				}
				
			}catch(Exception e){
				fail(getExceptionMessage("getDatabaseMaximumIdentifierLength()", dbInformationCollection.get(0), e));
			}
		}
	}
	
	public void testGetTableMaximumIdentifierLength_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				if((dbInformationCollection.get(i).toString()).equals("4.0"))
				{
					actualIdentifierLength = ((DatabaseDefinition)definitionCollection.get(i)).getTableMaximumIdentifierLength();
					expectedIdentifierLength = MAXIMUM_IDENTIFIER_LENGTH_TABLE_4;
				
					assertEquals(getAssertionFailureMessage("getTableMaximumIdentifierLength()", dbInformationCollection.get(i), ""),
							expectedIdentifierLength, actualIdentifierLength);
				}
			
			}catch(Exception e){
				fail(getExceptionMessage("getTableMaximumIdentifierLength()", dbInformationCollection.get(0), e));
			}
		}
	}
	
	public void testGetColumnMaximumIdentifierLength_4(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				if((dbInformationCollection.get(i).toString()).equals("4.0"))
				{
					actualIdentifierLength = ((DatabaseDefinition)definitionCollection.get(i)).getColumnMaximumIdentifierLength();
					expectedIdentifierLength = MAXIMUM_IDENTIFIER_LENGTH_COLUMN_4;
				
					assertEquals(getAssertionFailureMessage("getColumnMaximumIdentifierLength()", dbInformationCollection.get(i), ""),
							expectedIdentifierLength, actualIdentifierLength);
				}
				
			}catch(Exception e){
				fail(getExceptionMessage("getColumnMaximumIdentifierLength()", dbInformationCollection.get(0), e));
			}
		}
	}
	
//==========================================Version 4.1==============================================
	
	public void testGetMaximumPrecision_DECIMAL_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.1"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxPrecision = MAXIMUM_PRECISION_DECIMAL_41;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("DECIMAL"))
							{								
								assertEquals(getAssertionFailureMessage("getMaximumPrecision()", dbInformationCollection.get(i), "DECIMAL"),
										expectedMaxPrecision, typeDefinition.getMaximumPrecision());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumPrecision()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	public void testGetMaximumPrecision_NUMERIC_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.1"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxPrecision = MAXIMUM_PRECISION_NUMERIC_41;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("NUMERIC"))
							{	
								assertEquals(getAssertionFailureMessage("getMaximumPrecision()", dbInformationCollection.get(i), "NUMERIC"),
										expectedMaxPrecision, typeDefinition.getMaximumPrecision());
							}
						}
					}
				}
								
			}catch(Exception e){
				fail(getExceptionMessage("getMaximumPrecision()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	public void testGetMaximumLength_CHAR_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.1"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxLength = MAXIMUM_LENGTH_CHAR_41;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("CHAR"))
							{
								assertEquals(getAssertionFailureMessage("getMaximumLength()", dbInformationCollection.get(i), "CHAR"),
										expectedMaxLength, typeDefinition.getMaximumLength());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumLength()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	public void testGetMaximumLength_VARCHAR_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.1"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxLength = MAXIMUM_LENGTH_VARCHAR_41;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("VARCHAR"))
							{
								assertEquals(getAssertionFailureMessage("getMaximumLength()", dbInformationCollection.get(i), "VARCHAR"),
										expectedMaxLength, typeDefinition.getMaximumLength());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumLength()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	public void testGetMaximumLength_BLOB_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				dataType = ((DatabaseDefinition)definitionCollection.get(i)).getPredefinedDataTypes();
				
				while(dataType.hasNext())
				{
					typeDefinition = (PredefinedDataTypeDefinition) dataType.next();
					
					if((dbInformationCollection.get(i).toString()).equals("4.1"))
					{
						dataTypeList = typeDefinition.getName();
						expectedMaxLength = MAXIMUM_LENGTH_BLOB_41;
						
						for(int j = 0; j < dataTypeList.size(); j++)
						{
							if((dataTypeList.get(j)).equals("BLOB"))
							{	
								assertEquals(getAssertionFailureMessage("getMaximumLength()", dbInformationCollection.get(i), "BLOB"),
										expectedMaxLength, typeDefinition.getMaximumLength());
							}
						}
					}
				}

			}catch(Exception e){
				fail(getExceptionMessage("getMaximumLength()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	public void testGetDatabaseMaximumIdentifierLength_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				if((dbInformationCollection.get(i).toString()).equals("4.1"))
				{
					actualIdentifierLength = ((DatabaseDefinition)definitionCollection.get(i)).getDatabaseMaximumIdentifierLength();
					expectedIdentifierLength = MAXIMUM_IDENTIFIER_LENGTH_DATABASE_41;
				
					assertEquals(getAssertionFailureMessage("getDatabaseMaximumIdentifierLength()", dbInformationCollection.get(i), ""),
							expectedIdentifierLength, actualIdentifierLength);
				}
				
			}catch(Exception e){
				fail(getExceptionMessage("getDatabaseMaximumIdentifierLength()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	public void testGetTableMaximumIdentifierLength_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				if((dbInformationCollection.get(i).toString()).equals("4.1"))
				{
					actualIdentifierLength = ((DatabaseDefinition)definitionCollection.get(i)).getTableMaximumIdentifierLength();
					expectedIdentifierLength = MAXIMUM_IDENTIFIER_LENGTH_TABLE_41;
				
					assertEquals(getAssertionFailureMessage("getTableMaximumIdentifierLength()", dbInformationCollection.get(i), ""),
							expectedIdentifierLength, actualIdentifierLength);
				}
			
			}catch(Exception e){
				fail(getExceptionMessage("getTableMaximumIdentifierLength()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	public void testGetColumnMaximumIdentifierLength_41(){
		
		for(int i = 0; i < definitionCollection.size(); i++)
		{
			try{
				if((dbInformationCollection.get(i).toString()).equals("4.1"))
				{
					actualIdentifierLength = ((DatabaseDefinition)definitionCollection.get(i)).getColumnMaximumIdentifierLength();
					expectedIdentifierLength = MAXIMUM_IDENTIFIER_LENGTH_COLUMN_41;
				
					assertEquals(getAssertionFailureMessage("getColumnMaximumIdentifierLength()", dbInformationCollection.get(i), ""),
							expectedIdentifierLength, actualIdentifierLength);
				}
				
			}catch(Exception e){
				fail(getExceptionMessage("getColumnMaximumIdentifierLength()", dbInformationCollection.get(1), e));
			}
		}
	}
	
	private String getAssertionFailureMessage(String methodName, Object versionName, String dataName){
		
		String temp = "\nData type: ";
		
		if(dataName.equals(""))
		{
			temp = "";
		}
		
		return ("\nPackage: " + PACKAGE_NAME +
				"\nMethod: " + methodName +
			    "\nProduct: " + strProduct +
		        "\nVersion: " + versionName +
		        temp + dataName +
		        "\nResult: The actual value does not agree with vendor doc. ");
	}
	
	private String getExceptionMessage(String methodName, Object versionName, Exception e){
		
		return ("\nMethod: " + methodName + 
				"\nProduct: " + strProduct + 
			    "\nVersion: " + versionName +
		        "\nException: " + e.toString() +
		        "\nDescription: The exception is thrown in the test case");
	}
	
	public void tearDown(){
		
		expectedMaxPrecision = 0;
		expectedMaxLength = 0;
		expectedIdentifierLength = 0;
		actualIdentifierLength = 0;
		
		productVersion = null;
		dataType = null;
		dataTypeList = null;
		definitionCollection = new ArrayList();
		dbInformationCollection = new ArrayList();
		
		strProductVersion = null;

		
		definition = null;
		typeDefinition = null;
	}

}
