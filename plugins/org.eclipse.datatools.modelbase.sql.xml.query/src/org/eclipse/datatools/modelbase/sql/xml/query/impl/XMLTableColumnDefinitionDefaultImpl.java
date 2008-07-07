/**
 * <copyright>
 * </copyright>
 *
 * $Id: XMLTableColumnDefinitionDefaultImpl.java,v 1.3 2007/02/08 17:04:21 bpayton Exp $
 */
package org.eclipse.datatools.modelbase.sql.xml.query.impl;




import java.util.Collection;

import org.eclipse.datatools.modelbase.sql.query.GroupingExpression;
import org.eclipse.datatools.modelbase.sql.query.OrderByValueExpression;
import org.eclipse.datatools.modelbase.sql.query.PredicateBasic;
import org.eclipse.datatools.modelbase.sql.query.PredicateBetween;
import org.eclipse.datatools.modelbase.sql.query.PredicateInValueList;
import org.eclipse.datatools.modelbase.sql.query.PredicateInValueRowSelect;
import org.eclipse.datatools.modelbase.sql.query.PredicateInValueSelect;
import org.eclipse.datatools.modelbase.sql.query.PredicateIsNull;
import org.eclipse.datatools.modelbase.sql.query.PredicateLike;
import org.eclipse.datatools.modelbase.sql.query.PredicateQuantifiedRowSelect;
import org.eclipse.datatools.modelbase.sql.query.PredicateQuantifiedValueSelect;
import org.eclipse.datatools.modelbase.sql.query.QueryValueExpression;
import org.eclipse.datatools.modelbase.sql.query.ResultColumn;
import org.eclipse.datatools.modelbase.sql.query.SQLQueryModelPackage;
import org.eclipse.datatools.modelbase.sql.query.UpdateSourceExprList;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCaseElse;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCaseSearchContent;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCaseSimple;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCaseSimpleContent;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCast;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCombined;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionFunction;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionLabeledDuration;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionNested;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionUnaryOperator;
import org.eclipse.datatools.modelbase.sql.query.ValuesRow;
import org.eclipse.datatools.modelbase.sql.query.impl.QueryValueExpressionImpl;
import org.eclipse.datatools.modelbase.sql.xml.query.SQLXMLQueryModelPackage;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLTableColumnDefinitionDefault;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLTableColumnDefinitionRegular;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.datatools.modelbase.sql.datatypes.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XML Table Column Definition Default</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.datatools.modelbase.sql.xml.query.impl.XMLTableColumnDefinitionDefaultImpl#getValueExpr <em>Value Expr</em>}</li>
 *   <li>{@link org.eclipse.datatools.modelbase.sql.xml.query.impl.XMLTableColumnDefinitionDefaultImpl#getColumnDefinitionRegular <em>Column Definition Regular</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMLTableColumnDefinitionDefaultImpl extends QueryValueExpressionImpl implements XMLTableColumnDefinitionDefault {
	/**
     * The cached value of the '{@link #getValueExpr() <em>Value Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueExpr()
     * @generated
     * @ordered
     */
    protected QueryValueExpression valueExpr;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XMLTableColumnDefinitionDefaultImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SQLXMLQueryModelPackage.Literals.XML_TABLE_COLUMN_DEFINITION_DEFAULT;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QueryValueExpression getValueExpr() {
        return valueExpr;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetValueExpr(QueryValueExpression newValueExpr, NotificationChain msgs) {
        QueryValueExpression oldValueExpr = valueExpr;
        valueExpr = newValueExpr;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR, oldValueExpr, newValueExpr);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValueExpr(QueryValueExpression newValueExpr) {
        if (newValueExpr != valueExpr) {
            NotificationChain msgs = null;
            if (valueExpr != null)
                msgs = ((InternalEObject)valueExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR, null, msgs);
            if (newValueExpr != null)
                msgs = ((InternalEObject)newValueExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR, null, msgs);
            msgs = basicSetValueExpr(newValueExpr, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR, newValueExpr, newValueExpr));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XMLTableColumnDefinitionRegular getColumnDefinitionRegular() {
        if (eContainerFeatureID != SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR) return null;
        return (XMLTableColumnDefinitionRegular)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetColumnDefinitionRegular(XMLTableColumnDefinitionRegular newColumnDefinitionRegular, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newColumnDefinitionRegular, SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setColumnDefinitionRegular(XMLTableColumnDefinitionRegular newColumnDefinitionRegular) {
        if (newColumnDefinitionRegular != eInternalContainer() || (eContainerFeatureID != SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR && newColumnDefinitionRegular != null)) {
            if (EcoreUtil.isAncestor(this, newColumnDefinitionRegular))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newColumnDefinitionRegular != null)
                msgs = ((InternalEObject)newColumnDefinitionRegular).eInverseAdd(this, SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_REGULAR__COLUMN_DEFINITION_DEFAULT, XMLTableColumnDefinitionRegular.class, msgs);
            msgs = basicSetColumnDefinitionRegular(newColumnDefinitionRegular, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR, newColumnDefinitionRegular, newColumnDefinitionRegular));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetColumnDefinitionRegular((XMLTableColumnDefinitionRegular)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR:
                return basicSetValueExpr(null, msgs);
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR:
                return basicSetColumnDefinitionRegular(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID) {
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR:
                return eInternalContainer().eInverseRemove(this, SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_REGULAR__COLUMN_DEFINITION_DEFAULT, XMLTableColumnDefinitionRegular.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR:
                return getValueExpr();
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR:
                return getColumnDefinitionRegular();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR:
                setValueExpr((QueryValueExpression)newValue);
                return;
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR:
                setColumnDefinitionRegular((XMLTableColumnDefinitionRegular)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID) {
        switch (featureID) {
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR:
                setValueExpr((QueryValueExpression)null);
                return;
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR:
                setColumnDefinitionRegular((XMLTableColumnDefinitionRegular)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__VALUE_EXPR:
                return valueExpr != null;
            case SQLXMLQueryModelPackage.XML_TABLE_COLUMN_DEFINITION_DEFAULT__COLUMN_DEFINITION_REGULAR:
                return getColumnDefinitionRegular() != null;
        }
        return super.eIsSet(featureID);
    }

} //XMLTableColumnDefinitionDefaultImpl
