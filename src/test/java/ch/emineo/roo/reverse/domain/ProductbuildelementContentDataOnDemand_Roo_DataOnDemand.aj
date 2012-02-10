// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Content;
import ch.emineo.roo.reverse.domain.ContentDataOnDemand;
import ch.emineo.roo.reverse.domain.Productbuildelement;
import ch.emineo.roo.reverse.domain.ProductbuildelementContent;
import ch.emineo.roo.reverse.domain.ProductbuildelementContentDataOnDemand;
import ch.emineo.roo.reverse.domain.ProductbuildelementContentPK;
import ch.emineo.roo.reverse.domain.ProductbuildelementDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ProductbuildelementContentDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ProductbuildelementContentDataOnDemand: @Component;
    
    private Random ProductbuildelementContentDataOnDemand.rnd = new SecureRandom();
    
    private List<ProductbuildelementContent> ProductbuildelementContentDataOnDemand.data;
    
    @Autowired
    private ContentDataOnDemand ProductbuildelementContentDataOnDemand.contentDataOnDemand;
    
    @Autowired
    private ProductbuildelementDataOnDemand ProductbuildelementContentDataOnDemand.productbuildelementDataOnDemand;
    
    public ProductbuildelementContent ProductbuildelementContentDataOnDemand.getNewTransientProductbuildelementContent(int index) {
        ProductbuildelementContent obj = new ProductbuildelementContent();
        setEmbeddedIdClass(obj, index);
        setContentsContentid(obj, index);
        setProductbuildelementProductbuildelementid(obj, index);
        return obj;
    }
    
    public void ProductbuildelementContentDataOnDemand.setEmbeddedIdClass(ProductbuildelementContent obj, int index) {
        Integer productbuildelementProductbuildelementid = new Integer(index);
        Integer idx = new Integer(index);
        
        ProductbuildelementContentPK embeddedIdClass = new ProductbuildelementContentPK(productbuildelementProductbuildelementid, idx);
        obj.setId(embeddedIdClass);
    }
    
    public void ProductbuildelementContentDataOnDemand.setContentsContentid(ProductbuildelementContent obj, int index) {
        Content contentsContentid = contentDataOnDemand.getRandomContent();
        obj.setContentsContentid(contentsContentid);
    }
    
    public void ProductbuildelementContentDataOnDemand.setProductbuildelementProductbuildelementid(ProductbuildelementContent obj, int index) {
        Productbuildelement productbuildelementProductbuildelementid = productbuildelementDataOnDemand.getRandomProductbuildelement();
        obj.setProductbuildelementProductbuildelementid(productbuildelementProductbuildelementid);
    }
    
    public ProductbuildelementContent ProductbuildelementContentDataOnDemand.getSpecificProductbuildelementContent(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ProductbuildelementContent obj = data.get(index);
        ProductbuildelementContentPK id = obj.getId();
        return ProductbuildelementContent.findProductbuildelementContent(id);
    }
    
    public ProductbuildelementContent ProductbuildelementContentDataOnDemand.getRandomProductbuildelementContent() {
        init();
        ProductbuildelementContent obj = data.get(rnd.nextInt(data.size()));
        ProductbuildelementContentPK id = obj.getId();
        return ProductbuildelementContent.findProductbuildelementContent(id);
    }
    
    public boolean ProductbuildelementContentDataOnDemand.modifyProductbuildelementContent(ProductbuildelementContent obj) {
        return false;
    }
    
    public void ProductbuildelementContentDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = ProductbuildelementContent.findProductbuildelementContentEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ProductbuildelementContent' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ProductbuildelementContent>();
        for (int i = 0; i < 10; i++) {
            ProductbuildelementContent obj = getNewTransientProductbuildelementContent(i);
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
