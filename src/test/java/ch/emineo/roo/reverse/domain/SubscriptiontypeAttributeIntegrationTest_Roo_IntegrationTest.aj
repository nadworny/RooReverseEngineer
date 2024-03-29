// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.SubscriptiontypeAttribute;
import ch.emineo.roo.reverse.domain.SubscriptiontypeAttributeDataOnDemand;
import ch.emineo.roo.reverse.domain.SubscriptiontypeAttributeIntegrationTest;
import ch.emineo.roo.reverse.domain.SubscriptiontypeAttributePK;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SubscriptiontypeAttributeIntegrationTest_Roo_IntegrationTest {
    
    declare @type: SubscriptiontypeAttributeIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: SubscriptiontypeAttributeIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: SubscriptiontypeAttributeIntegrationTest: @Transactional;
    
    @Autowired
    private SubscriptiontypeAttributeDataOnDemand SubscriptiontypeAttributeIntegrationTest.dod;
    
    @Test
    public void SubscriptiontypeAttributeIntegrationTest.testCountSubscriptiontypeAttributes() {
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to initialize correctly", dod.getRandomSubscriptiontypeAttribute());
        long count = SubscriptiontypeAttribute.countSubscriptiontypeAttributes();
        Assert.assertTrue("Counter for 'SubscriptiontypeAttribute' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void SubscriptiontypeAttributeIntegrationTest.testFindSubscriptiontypeAttribute() {
        SubscriptiontypeAttribute obj = dod.getRandomSubscriptiontypeAttribute();
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to initialize correctly", obj);
        SubscriptiontypeAttributePK id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to provide an identifier", id);
        obj = SubscriptiontypeAttribute.findSubscriptiontypeAttribute(id);
        Assert.assertNotNull("Find method for 'SubscriptiontypeAttribute' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'SubscriptiontypeAttribute' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void SubscriptiontypeAttributeIntegrationTest.testFindAllSubscriptiontypeAttributes() {
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to initialize correctly", dod.getRandomSubscriptiontypeAttribute());
        long count = SubscriptiontypeAttribute.countSubscriptiontypeAttributes();
        Assert.assertTrue("Too expensive to perform a find all test for 'SubscriptiontypeAttribute', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<SubscriptiontypeAttribute> result = SubscriptiontypeAttribute.findAllSubscriptiontypeAttributes();
        Assert.assertNotNull("Find all method for 'SubscriptiontypeAttribute' illegally returned null", result);
        Assert.assertTrue("Find all method for 'SubscriptiontypeAttribute' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void SubscriptiontypeAttributeIntegrationTest.testFindSubscriptiontypeAttributeEntries() {
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to initialize correctly", dod.getRandomSubscriptiontypeAttribute());
        long count = SubscriptiontypeAttribute.countSubscriptiontypeAttributes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<SubscriptiontypeAttribute> result = SubscriptiontypeAttribute.findSubscriptiontypeAttributeEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'SubscriptiontypeAttribute' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'SubscriptiontypeAttribute' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void SubscriptiontypeAttributeIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to initialize correctly", dod.getRandomSubscriptiontypeAttribute());
        SubscriptiontypeAttribute obj = dod.getNewTransientSubscriptiontypeAttribute(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to provide a new transient entity", obj);
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'SubscriptiontypeAttribute' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void SubscriptiontypeAttributeIntegrationTest.testRemove() {
        SubscriptiontypeAttribute obj = dod.getRandomSubscriptiontypeAttribute();
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to initialize correctly", obj);
        SubscriptiontypeAttributePK id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SubscriptiontypeAttribute' failed to provide an identifier", id);
        obj = SubscriptiontypeAttribute.findSubscriptiontypeAttribute(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'SubscriptiontypeAttribute' with identifier '" + id + "'", SubscriptiontypeAttribute.findSubscriptiontypeAttribute(id));
    }
    
}
