// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.AttributeDataOnDemand;
import ch.emineo.roo.reverse.domain.Productcategory;
import ch.emineo.roo.reverse.domain.ProductcategoryAttribute;
import ch.emineo.roo.reverse.domain.ProductcategoryAttributeDataOnDemand;
import ch.emineo.roo.reverse.domain.ProductcategoryAttributePK;
import ch.emineo.roo.reverse.domain.ProductcategoryDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ProductcategoryAttributeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ProductcategoryAttributeDataOnDemand: @Component;
    
    private Random ProductcategoryAttributeDataOnDemand.rnd = new SecureRandom();
    
    private List<ProductcategoryAttribute> ProductcategoryAttributeDataOnDemand.data;
    
    @Autowired
    private AttributeDataOnDemand ProductcategoryAttributeDataOnDemand.attributeDataOnDemand;
    
    @Autowired
    private ProductcategoryDataOnDemand ProductcategoryAttributeDataOnDemand.productcategoryDataOnDemand;
    
    public ProductcategoryAttribute ProductcategoryAttributeDataOnDemand.getNewTransientProductcategoryAttribute(int index) {
        ProductcategoryAttribute obj = new ProductcategoryAttribute();
        setEmbeddedIdClass(obj, index);
        setAttributesAttributeid(obj, index);
        setProductcategoryProductcategoryid(obj, index);
        return obj;
    }
    
    public void ProductcategoryAttributeDataOnDemand.setEmbeddedIdClass(ProductcategoryAttribute obj, int index) {
        Integer productcategoryProductcategoryid = new Integer(index);
        Integer idx = new Integer(index);
        
        ProductcategoryAttributePK embeddedIdClass = new ProductcategoryAttributePK(productcategoryProductcategoryid, idx);
        obj.setId(embeddedIdClass);
    }
    
    public void ProductcategoryAttributeDataOnDemand.setAttributesAttributeid(ProductcategoryAttribute obj, int index) {
        Attribute attributesAttributeid = attributeDataOnDemand.getRandomAttribute();
        obj.setAttributesAttributeid(attributesAttributeid);
    }
    
    public void ProductcategoryAttributeDataOnDemand.setProductcategoryProductcategoryid(ProductcategoryAttribute obj, int index) {
        Productcategory productcategoryProductcategoryid = productcategoryDataOnDemand.getRandomProductcategory();
        obj.setProductcategoryProductcategoryid(productcategoryProductcategoryid);
    }
    
    public ProductcategoryAttribute ProductcategoryAttributeDataOnDemand.getSpecificProductcategoryAttribute(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ProductcategoryAttribute obj = data.get(index);
        ProductcategoryAttributePK id = obj.getId();
        return ProductcategoryAttribute.findProductcategoryAttribute(id);
    }
    
    public ProductcategoryAttribute ProductcategoryAttributeDataOnDemand.getRandomProductcategoryAttribute() {
        init();
        ProductcategoryAttribute obj = data.get(rnd.nextInt(data.size()));
        ProductcategoryAttributePK id = obj.getId();
        return ProductcategoryAttribute.findProductcategoryAttribute(id);
    }
    
    public boolean ProductcategoryAttributeDataOnDemand.modifyProductcategoryAttribute(ProductcategoryAttribute obj) {
        return false;
    }
    
    public void ProductcategoryAttributeDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = ProductcategoryAttribute.findProductcategoryAttributeEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ProductcategoryAttribute' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ProductcategoryAttribute>();
        for (int i = 0; i < 10; i++) {
            ProductcategoryAttribute obj = getNewTransientProductcategoryAttribute(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
