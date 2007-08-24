/**
 *************************************************************************
 * Copyright (c) 2006, 2007 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation - initial API and implementation
 *  
 *************************************************************************
 *
 * $Id: DesignUtil.java,v 1.12 2007/08/23 03:53:48 lchan Exp $
 */

package org.eclipse.datatools.connectivity.oda.design.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.datatools.connectivity.oda.design.DataSourceDesign;
import org.eclipse.datatools.connectivity.oda.design.DesignFactory;
import org.eclipse.datatools.connectivity.oda.design.DesignPackage;
import org.eclipse.datatools.connectivity.oda.design.DesignSessionRequest;
import org.eclipse.datatools.connectivity.oda.design.Properties;
import org.eclipse.datatools.connectivity.oda.design.Property;
import org.eclipse.datatools.connectivity.oda.design.nls.Messages;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * [<b>Provisional</b>] An utility class to handle the 
 * ODA Design API objects.
 * @generated NOT
 */
public class DesignUtil
{
    private static Diagnostician sm_diagnostician;
    
    // trace logging variables
    private static final String sm_loggerName = "org.eclipse.datatools.connectivity.oda.design.util"; //$NON-NLS-1$
    private static String sm_className;
    private static Logger sm_logger;
    
    // class has static methods only; not intended to instantiate
    private DesignUtil()
    {
    }
    
    /**
     * Validates the given EMF object is valid and has all required
     * elements. 
     * @param eObject   an EMF object
     * @throws IllegalStateException    if the given object is not valid
     *                  and have error diagnostics;
     *                  the exception thrown includes all error and warning
     *                  diagnostic messages found in given object
     */
    public static void validateObject( EObject eObject )
        throws IllegalStateException
    {
        final String context = "validateObject";  //$NON-NLS-1$
        
        Diagnostic diagnostic = diagnoseObject( eObject );
        if( diagnostic == null || 
            diagnostic.getSeverity() == Diagnostic.OK )
            return;     // eObject is valid
        
        // found error diagnostic(s), thrown exception 
        // with all error and warning messages
        if( diagnostic.getSeverity() == Diagnostic.ERROR )
        {
            String errWarnMsg = getDiagnosticMessages( diagnostic, 
                                        Diagnostic.ERROR,
                                        Diagnostic.WARNING );
    
            throw new IllegalStateException( errWarnMsg );
        }
        
        // only found warning or informational diagnostic(s), 
        // simply log it; the given object is considered valid
        String diagnosticMsg = getDiagnosticMessages( diagnostic, 
                                    Diagnostic.WARNING,
                                    Diagnostic.INFO );
        
        if( diagnostic.getSeverity() == Diagnostic.WARNING )
        {
            Throwable ex = new DiagnosticException( diagnostic );           
            getLogger().logp( Level.WARNING, sm_className, context,
                                diagnosticMsg, ex ); 
        }
        else    // informational diagnostic(s) only
        {
            getLogger().logp( Level.INFO, sm_className, context,
                                diagnosticMsg ); 
        }
        return;     // eObject is considered valid
    }

    /**
     * Diagnoses the given EMF object, and returns the diagnostic result found. 
     * @param eObject   an EMF object
     * @return  the diagnostic result, or null if no diagnostic result found 
     */
    public static Diagnostic diagnoseObject( EObject eObject )
    {
        if( ! canDiagnose() )
            return null;    // assumes eObject is valid
        
        Diagnostician designDiagnostician = getDiagnostician();
        return designDiagnostician.validate( eObject );
    }
    
    /**
     * Returns the Diagnostician for the ODA Design model,
     * using a validator registry with specialized design validator(s).
     * @return Diagnostician
     */
    private static Diagnostician getDiagnostician()
    {
        if( sm_diagnostician == null )
        {
            EValidator.Registry eValidatorRegistry = EValidator.Registry.INSTANCE;
            
            // add specialized design validator(s) to registry
            // for use by Diagnostician
            eValidatorRegistry.put( DesignPackage.Literals.DATA_SET_QUERY.eContainer(),
                                    new DesignValidator() );
            sm_diagnostician = new Diagnostician( eValidatorRegistry );
        }
        
        return sm_diagnostician;
    }
    
    /**
     * Concatenates and returns all messages of the two specified messageTypes
     * from given diagnostic.
     */   
    private static String getDiagnosticMessages( Diagnostic diagnostic,
                                    int messageType1, int messageType2 )
    {
        if( diagnostic == null )
            return null;

        String errMsg = diagnostic.getMessage();
        for( Iterator i = diagnostic.getChildren().iterator(); i.hasNext();)
        {
            Diagnostic childDiagnostic = (Diagnostic) i.next();
            if( childDiagnostic.getSeverity() == messageType1 ||
                childDiagnostic.getSeverity() == messageType2 )
            {
                errMsg += "\n" + childDiagnostic.getMessage(); //$NON-NLS-1$
            }
        }

        return errMsg;
    }
    
    /**
     * When loading EMF plugins in a runtime web application in Eclipse 3.3, 
     * Plugin.start() of 3 EMF plug-ins were not called. 
     * This led to null bundles of those EMF plug-ins, and triggers NPE when tried 
     * to use the associated resource bundles (Eclipse Bugzilla 200892).
     * Before a fix is available, this work-around attempts to detect this use case,
     * and logs a warning message. 
     * The caller can then avoid the use of the emf.ecore Diagnostician class, 
     * which triggers a NPE in accessing its resource bundle.
     */
    private static boolean canDiagnose()
    {
        return true;
        
        /* below workaround assumes that EMF is used in 
         * plugin mode, which is not necessarily true; 
         * keep the code commented for now
         */
/*        
        final String methodName = "canDiagnose()"; //$NON-NLS-1$   
        final String CANT_DIAGNOSE_WARNING_MSG = "Unable to diagnose ODA design objects, possibly due to unavailablity of the EcorePlugin resource bundle";  //$NON-NLS-1$

        boolean canDiagnose = ( EcorePlugin.getPlugin() != null &&
                 EcorePlugin.getPlugin().getBundle() != null );
        
        if( ! canDiagnose )
            getLogger().logp( Level.WARNING, sm_className, methodName, CANT_DIAGNOSE_WARNING_MSG );
        
        return canDiagnose;
*/    }
    
    /**
     * Converts the public and private properties defined in an 
     * ODA data source design definition, and returns in a combined
     * java.util.Properties collection.
     * @param dataSourceDesign
     * @return
     */
    public static java.util.Properties convertDataSourceProperties( DataSourceDesign dataSourceDesign )
    {
        java.util.Properties publicProps = convertDesignProperties( 
                dataSourceDesign.getPublicProperties() );
        java.util.Properties propCollection = convertDesignProperties( 
                dataSourceDesign.getPrivateProperties() );

        // merge public and private properties, with public values
        // taking precedence if same property key is used
        propCollection.putAll( publicProps );
        return propCollection;        
    }

    /**
     * Converts the given design properties defined in an 
     * ODA data source or data set design definition, to
     * a java.util.Properties collection.
     * @param designProps   the ODA design properties to convert from
     * @return              converted properties in a java.util.Properties collection
     */
    public static java.util.Properties convertDesignProperties( Properties designProps )
    {
        java.util.Properties utilProps = new java.util.Properties();
        if( designProps == null || designProps.isEmpty() )
            return utilProps;  // return an empty collection
        
        Iterator itr = designProps.getProperties().iterator();
        while( itr.hasNext() )
        {
            Property designProp = (Property) itr.next();

            // util collection does not allow null name or value;
            // excludes the property in such case, which would allow
            // consumer to get a null value 
            // when a property name is not found in collection
            if( designProp.getNameValue() == null ||
                designProp.getNameValue().getName() == null ||
                designProp.getNameValue().getValue() == null )
                continue;   // skip property
            
            utilProps.setProperty( designProp.getNameValue().getName(),
                                   designProp.getNameValue().getValue() );
        }
        return utilProps;
    }
    
    /**
     * Converts the given java.util.Properties collection 
     * to ODA design properties that can be applied in an 
     * ODA data source or data set design definition.
     * @param utilProps the java.util.Properties collection to convert from
     * @return          converted properties in a design properties collection
     */
    public static Properties convertToDesignProperties( 
                                java.util.Properties utilProps )
    {
        Properties designProps = 
            DesignFactory.eINSTANCE.createProperties();
        if( utilProps == null || utilProps.size() == 0 )
            return designProps;  // return an empty collection
        
        Iterator iter = utilProps.entrySet().iterator();
        while( iter.hasNext() )
        {
            Entry utilProp = (Entry) iter.next();
            designProps.setProperty( (String) utilProp.getKey(), 
                                    (String) utilProp.getValue() );
        }

        return designProps;   
    }

    /**
     * Validates the specified design session request.
     * If valid, returns the request's ODA data source element id.
     * @param requestSession
     * @return
     * @throws IllegalStateException if specified session request is invalid
     */
    public static String validateRequestSession( 
                    DesignSessionRequest requestSession )
        throws IllegalStateException
    {
        if( requestSession == null )
            throw new IllegalStateException( Messages.design_nullArgument );
    
        validateObject( requestSession );
    
        // validate the given request' data source design
        DataSourceDesign dataSourceDesign = 
                    requestSession.getDataSourceDesign();
        if( dataSourceDesign == null )
            throw new IllegalStateException( Messages.design_missingDataSourceDesign );
    
        String odaDataSourceId = dataSourceDesign.getOdaExtensionDataSourceId();
        if( odaDataSourceId == null || odaDataSourceId.length() == 0 )
            throw new IllegalStateException( Messages.design_missingId );
    
        // done validation
        return odaDataSourceId;
    }

    /**
     * Validates the specified data source design instance.
     * @param dataSourceDesign
     * @throws IllegalStateException if specified design is invalid
     */
    public static void validateDataSourceDesign( 
                        DataSourceDesign dataSourceDesign )
        throws IllegalStateException
    {
        if( dataSourceDesign == null )
            throw new IllegalStateException( Messages.design_nullArgument );
    
        validateObject( dataSourceDesign );
    }
    
    /**
     * Converts the specified string representation of a file pathname,
     * persisted in an oda design model, to its abstract representation.
     * @param filePath  the string representation of a file
     * @return  the abstract representation of a file pathname,
     *          or null if the specified argument is null, invalid or
     *          the file does not exist
     * @see #convertFileToPath(File)
     * @since 3.0.4
     */
    public static File convertPathToFile( String filePath )
    {
        if( filePath == null || filePath.length() == 0 )
            return null;

       // First try to parse the filePath argument as file name
        File file = new File( filePath );
        if( file.exists() )
            return file;

        // next try to parse the filePath argument as an url on web
        try
        {
            URL url = new URL( filePath );
            return new File( FileLocator.toFileURL( url ).getPath( ) );
        }
        catch( MalformedURLException e )
        {
            // TODO log warning
            e.printStackTrace();
        }
        catch( IOException e )
        {
            // TODO log warning
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Converts the specified file to a string representation
     * that can be persisted in an oda design model.
     * @param aFile the abstract representation of a file pathname
     * @return  the string representation of the specified file,
     *          or null if the specified argument is null
     * @see #convertPathToFile(String)
     * @since 3.0.4
     */
    public static String convertFileToPath( File aFile )
    {
        if( aFile == null )
            return null;
        return aFile.getPath();
    }
    
    private static Logger getLogger()
    {
        if( sm_logger == null )
        {
            sm_className = DesignUtil.class.getName();
            sm_logger = Logger.getLogger( sm_loggerName );
        }
        return sm_logger;
    }

}
