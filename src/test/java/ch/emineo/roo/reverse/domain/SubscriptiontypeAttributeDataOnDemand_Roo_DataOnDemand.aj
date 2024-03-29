// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.AttributeDataOnDemand;
import ch.emineo.roo.reverse.domain.Subscriptiontype;
import ch.emineo.roo.reverse.domain.SubscriptiontypeAttribute;
import ch.emineo.roo.reverse.domain.SubscriptiontypeAttributeDataOnDemand;
import ch.emineo.roo.reverse.domain.SubscriptiontypeAttributePK;
import ch.emineo.roo.reverse.domain.SubscriptiontypeDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect SubscriptiontypeAttributeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SubscriptiontypeAttributeDataOnDemand: @Component;
    
    private Random SubscriptiontypeAttributeDataOnDemand.rnd = new SecureRandom();
    
    private List<SubscriptiontypeAttribute> SubscriptiontypeAttributeDataOnDemand.data;
    
    @Autowired
    private AttributeDataOnDemand SubscriptiontypeAttributeDataOnDemand.attributeDataOnDemand;
    
    @Autowired
    private SubscriptiontypeDataOnDemand SubscriptiontypeAttributeDataOnDemand.subscriptiontypeDataOnDemand;
    
    public SubscriptiontypeAttribute SubscriptiontypeAttributeDataOnDemand.getNewTransientSubscriptiontypeAttribute(int index) {
        SubscriptiontypeAttribute obj = new SubscriptiontypeAttribute();
        setEmbeddedIdClass(obj, index);
        setAttributesAttributeid(obj, index);
        setSubscriptiontypeMonths(obj, index);
        return obj;
    }
    
    public void SubscriptiontypeAttributeDataOnDemand.setEmbeddedIdClass(SubscriptiontypeAttribute obj, int index) {
        Integer subscriptiontypeMonths = new Integer(index);
        Integer idx = new Integer(index);
        
        SubscriptiontypeAttributePK embeddedIdClass = new SubscriptiontypeAttributePK(subscriptiontypeMonths, idx);
        obj.setId(embeddedIdClass);
    }
    
    public void SubscriptiontypeAttributeDataOnDemand.setAttributesAttributeid(SubscriptiontypeAttribute obj, int index) {
        Attribute attributesAttributeid = attributeDataOnDemand.getRandomAttribute();
        obj.setAttributesAttributeid(attributesAttributeid);
    }
    
    public void SubscriptiontypeAttributeDataOnDemand.setSubscriptiontypeMonths(SubscriptiontypeAttribute obj, int index) {
        Subscriptiontype subscriptiontypeMonths = subscriptiontypeDataOnDemand.getRandomSubscriptiontype();
        obj.setSubscriptiontypeMonths(subscriptiontypeMonths);
    }
    
    public SubscriptiontypeAttribute SubscriptiontypeAttributeDataOnDemand.getSpecificSubscriptiontypeAttribute(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        SubscriptiontypeAttribute obj = data.get(index);
        SubscriptiontypeAttributePK id = obj.getId();
        return SubscriptiontypeAttribute.findSubscriptiontypeAttribute(id);
    }
    
    public SubscriptiontypeAttribute SubscriptiontypeAttributeDataOnDemand.getRandomSubscriptiontypeAttribute() {
        init();
        SubscriptiontypeAttribute obj = data.get(rnd.nextInt(data.size()));
        SubscriptiontypeAttributePK id = obj.getId();
        return SubscriptiontypeAttribute.findSubscriptiontypeAttribute(id);
    }
    
    public boolean SubscriptiontypeAttributeDataOnDemand.modifySubscriptiontypeAttribute(SubscriptiontypeAttribute obj) {
        return false;
    }
    
    public void SubscriptiontypeAttributeDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = SubscriptiontypeAttribute.findSubscriptiontypeAttributeEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'SubscriptiontypeAttribute' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<SubscriptiontypeAttribute>();
        for (int i = 0; i < 10; i++) {
            SubscriptiontypeAttribute obj = getNewTransientSubscriptiontypeAttribute(i);
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
