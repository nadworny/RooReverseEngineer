// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Product;
import ch.emineo.roo.reverse.domain.ProductDataOnDemand;
import ch.emineo.roo.reverse.domain.Productbuild;
import ch.emineo.roo.reverse.domain.ProductbuildDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ProductDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ProductDataOnDemand: @Component;
    
    private Random ProductDataOnDemand.rnd = new SecureRandom();
    
    private List<Product> ProductDataOnDemand.data;
    
    @Autowired
    private ProductbuildDataOnDemand ProductDataOnDemand.productbuildDataOnDemand;
    
    public Product ProductDataOnDemand.getNewTransientProduct(int index) {
        Product obj = new Product();
        setOnline(obj, index);
        setPicturepath(obj, index);
        setProductbuildFk(obj, index);
        setPublic1(obj, index);
        setSample(obj, index);
        return obj;
    }
    
    public void ProductDataOnDemand.setOnline(Product obj, int index) {
        Boolean online = true;
        obj.setOnline(online);
    }
    
    public void ProductDataOnDemand.setPicturepath(Product obj, int index) {
        String picturepath = "picturepath_" + index;
        if (picturepath.length() > 255) {
            picturepath = picturepath.substring(0, 255);
        }
        obj.setPicturepath(picturepath);
    }
    
    public void ProductDataOnDemand.setProductbuildFk(Product obj, int index) {
        Productbuild productbuildFk = productbuildDataOnDemand.getRandomProductbuild();
        obj.setProductbuildFk(productbuildFk);
    }
    
    public void ProductDataOnDemand.setPublic1(Product obj, int index) {
        Boolean public1 = true;
        obj.setPublic1(public1);
    }
    
    public void ProductDataOnDemand.setSample(Product obj, int index) {
        Boolean sample = true;
        obj.setSample(sample);
    }
    
    public Product ProductDataOnDemand.getSpecificProduct(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Product obj = data.get(index);
        Integer id = obj.getProductid();
        return Product.findProduct(id);
    }
    
    public Product ProductDataOnDemand.getRandomProduct() {
        init();
        Product obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getProductid();
        return Product.findProduct(id);
    }
    
    public boolean ProductDataOnDemand.modifyProduct(Product obj) {
        return false;
    }
    
    public void ProductDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Product.findProductEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Product' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Product>();
        for (int i = 0; i < 10; i++) {
            Product obj = getNewTransientProduct(i);
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
