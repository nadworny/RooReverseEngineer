// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Product;
import ch.emineo.roo.reverse.domain.ProductDataOnDemand;
import ch.emineo.roo.reverse.domain.Producttheme;
import ch.emineo.roo.reverse.domain.ProductthemeDataOnDemand;
import ch.emineo.roo.reverse.domain.Productvariant;
import ch.emineo.roo.reverse.domain.ProductvariantDataOnDemand;
import ch.emineo.roo.reverse.domain.Promotion;
import ch.emineo.roo.reverse.domain.PromotionDataOnDemand;
import ch.emineo.roo.reverse.domain.Purchaseditem;
import ch.emineo.roo.reverse.domain.PurchaseditemDataOnDemand;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect PurchaseditemDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PurchaseditemDataOnDemand: @Component;
    
    private Random PurchaseditemDataOnDemand.rnd = new SecureRandom();
    
    private List<Purchaseditem> PurchaseditemDataOnDemand.data;
    
    @Autowired
    private ProductDataOnDemand PurchaseditemDataOnDemand.productDataOnDemand;
    
    @Autowired
    private ProductthemeDataOnDemand PurchaseditemDataOnDemand.productthemeDataOnDemand;
    
    @Autowired
    private ProductvariantDataOnDemand PurchaseditemDataOnDemand.productvariantDataOnDemand;
    
    @Autowired
    private PromotionDataOnDemand PurchaseditemDataOnDemand.promotionDataOnDemand;
    
    public Purchaseditem PurchaseditemDataOnDemand.getNewTransientPurchaseditem(int index) {
        Purchaseditem obj = new Purchaseditem();
        setAcquisitiondate(obj, index);
        setOnline(obj, index);
        setProductProductid(obj, index);
        setProductthemeProductthemeid(obj, index);
        setProductvariantProductvariantid(obj, index);
        setPromotion(obj, index);
        setPromotionreferencePromotionid(obj, index);
        setPublic1(obj, index);
        setRemindersent(obj, index);
        setType(obj, index);
        return obj;
    }
    
    public void PurchaseditemDataOnDemand.setAcquisitiondate(Purchaseditem obj, int index) {
        Date acquisitiondate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setAcquisitiondate(acquisitiondate);
    }
    
    public void PurchaseditemDataOnDemand.setOnline(Purchaseditem obj, int index) {
        Boolean online = true;
        obj.setOnline(online);
    }
    
    public void PurchaseditemDataOnDemand.setProductProductid(Purchaseditem obj, int index) {
        Product productProductid = productDataOnDemand.getRandomProduct();
        obj.setProductProductid(productProductid);
    }
    
    public void PurchaseditemDataOnDemand.setProductthemeProductthemeid(Purchaseditem obj, int index) {
        Producttheme productthemeProductthemeid = productthemeDataOnDemand.getRandomProducttheme();
        obj.setProductthemeProductthemeid(productthemeProductthemeid);
    }
    
    public void PurchaseditemDataOnDemand.setProductvariantProductvariantid(Purchaseditem obj, int index) {
        Productvariant productvariantProductvariantid = productvariantDataOnDemand.getRandomProductvariant();
        obj.setProductvariantProductvariantid(productvariantProductvariantid);
    }
    
    public void PurchaseditemDataOnDemand.setPromotion(Purchaseditem obj, int index) {
        Boolean promotion = true;
        obj.setPromotion(promotion);
    }
    
    public void PurchaseditemDataOnDemand.setPromotionreferencePromotionid(Purchaseditem obj, int index) {
        Promotion promotionreferencePromotionid = promotionDataOnDemand.getRandomPromotion();
        obj.setPromotionreferencePromotionid(promotionreferencePromotionid);
    }
    
    public void PurchaseditemDataOnDemand.setPublic1(Purchaseditem obj, int index) {
        Boolean public1 = true;
        obj.setPublic1(public1);
    }
    
    public void PurchaseditemDataOnDemand.setRemindersent(Purchaseditem obj, int index) {
        Boolean remindersent = true;
        obj.setRemindersent(remindersent);
    }
    
    public void PurchaseditemDataOnDemand.setType(Purchaseditem obj, int index) {
        String type = "type_" + index;
        if (type.length() > 255) {
            type = type.substring(0, 255);
        }
        obj.setType(type);
    }
    
    public Purchaseditem PurchaseditemDataOnDemand.getSpecificPurchaseditem(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Purchaseditem obj = data.get(index);
        Integer id = obj.getPurchaseditemid();
        return Purchaseditem.findPurchaseditem(id);
    }
    
    public Purchaseditem PurchaseditemDataOnDemand.getRandomPurchaseditem() {
        init();
        Purchaseditem obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getPurchaseditemid();
        return Purchaseditem.findPurchaseditem(id);
    }
    
    public boolean PurchaseditemDataOnDemand.modifyPurchaseditem(Purchaseditem obj) {
        return false;
    }
    
    public void PurchaseditemDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Purchaseditem.findPurchaseditemEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Purchaseditem' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Purchaseditem>();
        for (int i = 0; i < 10; i++) {
            Purchaseditem obj = getNewTransientPurchaseditem(i);
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