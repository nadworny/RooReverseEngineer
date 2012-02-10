// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Deliveryinfo;
import ch.emineo.roo.reverse.domain.DeliveryinfoDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect DeliveryinfoDataOnDemand_Roo_DataOnDemand {
    
    declare @type: DeliveryinfoDataOnDemand: @Component;
    
    private Random DeliveryinfoDataOnDemand.rnd = new SecureRandom();
    
    private List<Deliveryinfo> DeliveryinfoDataOnDemand.data;
    
    public Deliveryinfo DeliveryinfoDataOnDemand.getNewTransientDeliveryinfo(int index) {
        Deliveryinfo obj = new Deliveryinfo();
        setDeliveryinterval(obj, index);
        setDeliveryreferencetype(obj, index);
        setDeliverytimestamp(obj, index);
        setElapsetimespan(obj, index);
        setSeasonend(obj, index);
        setSeasonstart(obj, index);
        setValidtimespan(obj, index);
        return obj;
    }
    
    public void DeliveryinfoDataOnDemand.setDeliveryinterval(Deliveryinfo obj, int index) {
        Integer deliveryinterval = new Integer(index);
        obj.setDeliveryinterval(deliveryinterval);
    }
    
    public void DeliveryinfoDataOnDemand.setDeliveryreferencetype(Deliveryinfo obj, int index) {
        Integer deliveryreferencetype = new Integer(index);
        obj.setDeliveryreferencetype(deliveryreferencetype);
    }
    
    public void DeliveryinfoDataOnDemand.setDeliverytimestamp(Deliveryinfo obj, int index) {
        Date deliverytimestamp = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setDeliverytimestamp(deliverytimestamp);
    }
    
    public void DeliveryinfoDataOnDemand.setElapsetimespan(Deliveryinfo obj, int index) {
        Integer elapsetimespan = new Integer(index);
        obj.setElapsetimespan(elapsetimespan);
    }
    
    public void DeliveryinfoDataOnDemand.setSeasonend(Deliveryinfo obj, int index) {
        Date seasonend = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setSeasonend(seasonend);
    }
    
    public void DeliveryinfoDataOnDemand.setSeasonstart(Deliveryinfo obj, int index) {
        Date seasonstart = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setSeasonstart(seasonstart);
    }
    
    public void DeliveryinfoDataOnDemand.setValidtimespan(Deliveryinfo obj, int index) {
        Integer validtimespan = new Integer(index);
        obj.setValidtimespan(validtimespan);
    }
    
    public Deliveryinfo DeliveryinfoDataOnDemand.getSpecificDeliveryinfo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Deliveryinfo obj = data.get(index);
        Integer id = obj.getDeliveryinfoid();
        return Deliveryinfo.findDeliveryinfo(id);
    }
    
    public Deliveryinfo DeliveryinfoDataOnDemand.getRandomDeliveryinfo() {
        init();
        Deliveryinfo obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getDeliveryinfoid();
        return Deliveryinfo.findDeliveryinfo(id);
    }
    
    public boolean DeliveryinfoDataOnDemand.modifyDeliveryinfo(Deliveryinfo obj) {
        return false;
    }
    
    public void DeliveryinfoDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Deliveryinfo.findDeliveryinfoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Deliveryinfo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Deliveryinfo>();
        for (int i = 0; i < 10; i++) {
            Deliveryinfo obj = getNewTransientDeliveryinfo(i);
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
