// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Subscriptiontype;
import ch.emineo.roo.reverse.domain.SubscriptiontypeDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect SubscriptiontypeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SubscriptiontypeDataOnDemand: @Component;
    
    private Random SubscriptiontypeDataOnDemand.rnd = new SecureRandom();
    
    private List<Subscriptiontype> SubscriptiontypeDataOnDemand.data;
    
    public Subscriptiontype SubscriptiontypeDataOnDemand.getNewTransientSubscriptiontype(int index) {
        Subscriptiontype obj = new Subscriptiontype();
        setOnline(obj, index);
        setPublish(obj, index);
        return obj;
    }
    
    public void SubscriptiontypeDataOnDemand.setOnline(Subscriptiontype obj, int index) {
        Boolean online = true;
        obj.setOnline(online);
    }
    
    public void SubscriptiontypeDataOnDemand.setPublish(Subscriptiontype obj, int index) {
        Boolean publish = true;
        obj.setPublish(publish);
    }
    
    public Subscriptiontype SubscriptiontypeDataOnDemand.getSpecificSubscriptiontype(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Subscriptiontype obj = data.get(index);
        Integer id = obj.getMonths();
        return Subscriptiontype.findSubscriptiontype(id);
    }
    
    public Subscriptiontype SubscriptiontypeDataOnDemand.getRandomSubscriptiontype() {
        init();
        Subscriptiontype obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getMonths();
        return Subscriptiontype.findSubscriptiontype(id);
    }
    
    public boolean SubscriptiontypeDataOnDemand.modifySubscriptiontype(Subscriptiontype obj) {
        return false;
    }
    
    public void SubscriptiontypeDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Subscriptiontype.findSubscriptiontypeEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Subscriptiontype' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Subscriptiontype>();
        for (int i = 0; i < 10; i++) {
            Subscriptiontype obj = getNewTransientSubscriptiontype(i);
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
