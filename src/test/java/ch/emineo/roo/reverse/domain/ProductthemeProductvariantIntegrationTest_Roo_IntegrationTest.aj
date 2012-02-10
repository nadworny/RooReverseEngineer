// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductthemeProductvariant;
import ch.emineo.roo.reverse.domain.ProductthemeProductvariantDataOnDemand;
import ch.emineo.roo.reverse.domain.ProductthemeProductvariantIntegrationTest;
import ch.emineo.roo.reverse.domain.ProductthemeProductvariantPK;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProductthemeProductvariantIntegrationTest_Roo_IntegrationTest {
    
    declare @type: ProductthemeProductvariantIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: ProductthemeProductvariantIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: ProductthemeProductvariantIntegrationTest: @Transactional;
    
    @Autowired
    private ProductthemeProductvariantDataOnDemand ProductthemeProductvariantIntegrationTest.dod;
    
    @Test
    public void ProductthemeProductvariantIntegrationTest.testCountProductthemeProductvariants() {
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to initialize correctly", dod.getRandomProductthemeProductvariant());
        long count = ProductthemeProductvariant.countProductthemeProductvariants();
        Assert.assertTrue("Counter for 'ProductthemeProductvariant' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void ProductthemeProductvariantIntegrationTest.testFindProductthemeProductvariant() {
        ProductthemeProductvariant obj = dod.getRandomProductthemeProductvariant();
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to initialize correctly", obj);
        ProductthemeProductvariantPK id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to provide an identifier", id);
        obj = ProductthemeProductvariant.findProductthemeProductvariant(id);
        Assert.assertNotNull("Find method for 'ProductthemeProductvariant' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'ProductthemeProductvariant' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void ProductthemeProductvariantIntegrationTest.testFindAllProductthemeProductvariants() {
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to initialize correctly", dod.getRandomProductthemeProductvariant());
        long count = ProductthemeProductvariant.countProductthemeProductvariants();
        Assert.assertTrue("Too expensive to perform a find all test for 'ProductthemeProductvariant', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<ProductthemeProductvariant> result = ProductthemeProductvariant.findAllProductthemeProductvariants();
        Assert.assertNotNull("Find all method for 'ProductthemeProductvariant' illegally returned null", result);
        Assert.assertTrue("Find all method for 'ProductthemeProductvariant' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void ProductthemeProductvariantIntegrationTest.testFindProductthemeProductvariantEntries() {
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to initialize correctly", dod.getRandomProductthemeProductvariant());
        long count = ProductthemeProductvariant.countProductthemeProductvariants();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<ProductthemeProductvariant> result = ProductthemeProductvariant.findProductthemeProductvariantEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'ProductthemeProductvariant' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'ProductthemeProductvariant' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void ProductthemeProductvariantIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to initialize correctly", dod.getRandomProductthemeProductvariant());
        ProductthemeProductvariant obj = dod.getNewTransientProductthemeProductvariant(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to provide a new transient entity", obj);
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'ProductthemeProductvariant' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void ProductthemeProductvariantIntegrationTest.testRemove() {
        ProductthemeProductvariant obj = dod.getRandomProductthemeProductvariant();
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to initialize correctly", obj);
        ProductthemeProductvariantPK id = obj.getId();
        Assert.assertNotNull("Data on demand for 'ProductthemeProductvariant' failed to provide an identifier", id);
        obj = ProductthemeProductvariant.findProductthemeProductvariant(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'ProductthemeProductvariant' with identifier '" + id + "'", ProductthemeProductvariant.findProductthemeProductvariant(id));
    }
    
}