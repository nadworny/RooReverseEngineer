// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Advancenotice;
import ch.emineo.roo.reverse.domain.AdvancenoticeDataOnDemand;
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

privileged aspect AdvancenoticeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AdvancenoticeDataOnDemand: @Component;
    
    private Random AdvancenoticeDataOnDemand.rnd = new SecureRandom();
    
    private List<Advancenotice> AdvancenoticeDataOnDemand.data;
    
    public Advancenotice AdvancenoticeDataOnDemand.getNewTransientAdvancenotice(int index) {
        Advancenotice obj = new Advancenotice();
        setAdvancenoticeend(obj, index);
        setAdvancenoticestart(obj, index);
        setOnline(obj, index);
        setPublic1(obj, index);
        return obj;
    }
    
    public void AdvancenoticeDataOnDemand.setAdvancenoticeend(Advancenotice obj, int index) {
        Date advancenoticeend = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setAdvancenoticeend(advancenoticeend);
    }
    
    public void AdvancenoticeDataOnDemand.setAdvancenoticestart(Advancenotice obj, int index) {
        Date advancenoticestart = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setAdvancenoticestart(advancenoticestart);
    }
    
    public void AdvancenoticeDataOnDemand.setOnline(Advancenotice obj, int index) {
        Short online = new Integer(index).shortValue();
        obj.setOnline(online);
    }
    
    public void AdvancenoticeDataOnDemand.setPublic1(Advancenotice obj, int index) {
        Short public1 = new Integer(index).shortValue();
        obj.setPublic1(public1);
    }
    
    public Advancenotice AdvancenoticeDataOnDemand.getSpecificAdvancenotice(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Advancenotice obj = data.get(index);
        Integer id = obj.getAdvancenoticeid();
        return Advancenotice.findAdvancenotice(id);
    }
    
    public Advancenotice AdvancenoticeDataOnDemand.getRandomAdvancenotice() {
        init();
        Advancenotice obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getAdvancenoticeid();
        return Advancenotice.findAdvancenotice(id);
    }
    
    public boolean AdvancenoticeDataOnDemand.modifyAdvancenotice(Advancenotice obj) {
        return false;
    }
    
    public void AdvancenoticeDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Advancenotice.findAdvancenoticeEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Advancenotice' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Advancenotice>();
        for (int i = 0; i < 10; i++) {
            Advancenotice obj = getNewTransientAdvancenotice(i);
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
