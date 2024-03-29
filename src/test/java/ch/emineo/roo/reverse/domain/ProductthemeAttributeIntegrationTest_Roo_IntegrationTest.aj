// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductthemeAttribute;
import ch.emineo.roo.reverse.domain.ProductthemeAttributeDataOnDemand;
import ch.emineo.roo.reverse.domain.ProductthemeAttributeIntegrationTest;
import ch.emineo.roo.reverse.domain.ProductthemeAttributePK;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProductthemeAttributeIntegrationTest_Roo_IntegrationTest {
    
    declare @type: ProductthemeAttributeIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: ProductthemeAttributeIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: ProductthemeAttributeIntegrationTest: @Transactional;
    
    @Autowired
    private ProductthemeAttributeDataOnDemand ProductthemeAttributeIntegrationTest.dod;
    
    @Test
    public void ProductthemeAttributeIntegrationTest.testCountProductthemeAttributes() {
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to initialize correctly", dod.getRandomProductthemeAttribute());
        long count = ProductthemeAttribute.countProductthemeAttributes();
        Assert.assertTrue("Counter for 'ProductthemeAttribute' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void ProductthemeAttributeIntegrationTest.testFindProductthemeAttribute() {
        ProductthemeAttribute obj = dod.getRandomProductthemeAttribute();
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to initialize correctly", obj);
        ProductthemeAttributePK id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to provide an identifier", id);
        obj = ProductthemeAttribute.findProductthemeAttribute(id);
        Assert.assertNotNull("Find method for 'ProductthemeAttribute' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'ProductthemeAttribute' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void ProductthemeAttributeIntegrationTest.testFindAllProductthemeAttributes() {
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to initialize correctly", dod.getRandomProductthemeAttribute());
        long count = ProductthemeAttribute.countProductthemeAttributes();
        Assert.assertTrue("Too expensive to perform a find all test for 'ProductthemeAttribute', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<ProductthemeAttribute> result = ProductthemeAttribute.findAllProductthemeAttributes();
        Assert.assertNotNull("Find all method for 'ProductthemeAttribute' illegally returned null", result);
        Assert.assertTrue("Find all method for 'ProductthemeAttribute' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void ProductthemeAttributeIntegrationTest.testFindProductthemeAttributeEntries() {
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to initialize correctly", dod.getRandomProductthemeAttribute());
        long count = ProductthemeAttribute.countProductthemeAttributes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<ProductthemeAttribute> result = ProductthemeAttribute.findProductthemeAttributeEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'ProductthemeAttribute' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'ProductthemeAttribute' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void ProductthemeAttributeIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to initialize correctly", dod.getRandomProductthemeAttribute());
        ProductthemeAttribute obj = dod.getNewTransientProductthemeAttribute(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to provide a new transient entity", obj);
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'ProductthemeAttribute' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void ProductthemeAttributeIntegrationTest.testRemove() {
        ProductthemeAttribute obj = dod.getRandomProductthemeAttribute();
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to initialize correctly", obj);
        ProductthemeAttributePK id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ProductthemeAttribute' failed to provide an identifier", id);
        obj = ProductthemeAttribute.findProductthemeAttribute(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'ProductthemeAttribute' with identifier '" + id + "'", ProductthemeAttribute.findProductthemeAttribute(id));
    }
    
}
