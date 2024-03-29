// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Subscriptiontype;
import ch.emineo.roo.reverse.domain.SubscriptiontypeDataOnDemand;
import ch.emineo.roo.reverse.domain.SubscriptiontypeIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SubscriptiontypeIntegrationTest_Roo_IntegrationTest {
    
    declare @type: SubscriptiontypeIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: SubscriptiontypeIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: SubscriptiontypeIntegrationTest: @Transactional;
    
    @Autowired
    private SubscriptiontypeDataOnDemand SubscriptiontypeIntegrationTest.dod;
    
    @Test
    public void SubscriptiontypeIntegrationTest.testCountSubscriptiontypes() {
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to initialize correctly", dod.getRandomSubscriptiontype());
        long count = Subscriptiontype.countSubscriptiontypes();
        Assert.assertTrue("Counter for 'Subscriptiontype' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void SubscriptiontypeIntegrationTest.testFindSubscriptiontype() {
        Subscriptiontype obj = dod.getRandomSubscriptiontype();
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to initialize correctly", obj);
        Integer id = obj.getMonths();
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to provide an identifier", id);
        obj = Subscriptiontype.findSubscriptiontype(id);
        Assert.assertNotNull("Find method for 'Subscriptiontype' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Subscriptiontype' returned the incorrect identifier", id, obj.getMonths());
    }
    
    @Test
    public void SubscriptiontypeIntegrationTest.testFindAllSubscriptiontypes() {
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to initialize correctly", dod.getRandomSubscriptiontype());
        long count = Subscriptiontype.countSubscriptiontypes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Subscriptiontype', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Subscriptiontype> result = Subscriptiontype.findAllSubscriptiontypes();
        Assert.assertNotNull("Find all method for 'Subscriptiontype' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Subscriptiontype' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void SubscriptiontypeIntegrationTest.testFindSubscriptiontypeEntries() {
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to initialize correctly", dod.getRandomSubscriptiontype());
        long count = Subscriptiontype.countSubscriptiontypes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Subscriptiontype> result = Subscriptiontype.findSubscriptiontypeEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Subscriptiontype' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Subscriptiontype' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void SubscriptiontypeIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to initialize correctly", dod.getRandomSubscriptiontype());
        Subscriptiontype obj = dod.getNewTransientSubscriptiontype(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Subscriptiontype' identifier to be null", obj.getMonths());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Subscriptiontype' identifier to no longer be null", obj.getMonths());
    }
    
    @Test
    public void SubscriptiontypeIntegrationTest.testRemove() {
        Subscriptiontype obj = dod.getRandomSubscriptiontype();
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to initialize correctly", obj);
        Integer id = obj.getMonths();
        Assert.assertNotNull("Data on demand for 'Subscriptiontype' failed to provide an identifier", id);
        obj = Subscriptiontype.findSubscriptiontype(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Subscriptiontype' with identifier '" + id + "'", Subscriptiontype.findSubscriptiontype(id));
    }
    
}
