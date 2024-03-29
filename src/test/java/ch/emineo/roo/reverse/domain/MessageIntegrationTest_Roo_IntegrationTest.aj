// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Message;
import ch.emineo.roo.reverse.domain.MessageDataOnDemand;
import ch.emineo.roo.reverse.domain.MessageIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect MessageIntegrationTest_Roo_IntegrationTest {
    
    declare @type: MessageIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: MessageIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: MessageIntegrationTest: @Transactional;
    
    @Autowired
    private MessageDataOnDemand MessageIntegrationTest.dod;
    
    @Test
    public void MessageIntegrationTest.testCountMessages() {
        Assert.assertNotNull("Data on demand for 'Message' failed to initialize correctly", dod.getRandomMessage());
        long count = Message.countMessages();
        Assert.assertTrue("Counter for 'Message' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void MessageIntegrationTest.testFindMessage() {
        Message obj = dod.getRandomMessage();
        Assert.assertNotNull("Data on demand for 'Message' failed to initialize correctly", obj);
        Integer id = obj.getMessageid();
        Assert.assertNotNull("Data on demand for 'Message' failed to provide an identifier", id);
        obj = Message.findMessage(id);
        Assert.assertNotNull("Find method for 'Message' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Message' returned the incorrect identifier", id, obj.getMessageid());
    }
    
    @Test
    public void MessageIntegrationTest.testFindAllMessages() {
        Assert.assertNotNull("Data on demand for 'Message' failed to initialize correctly", dod.getRandomMessage());
        long count = Message.countMessages();
        Assert.assertTrue("Too expensive to perform a find all test for 'Message', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Message> result = Message.findAllMessages();
        Assert.assertNotNull("Find all method for 'Message' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Message' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void MessageIntegrationTest.testFindMessageEntries() {
        Assert.assertNotNull("Data on demand for 'Message' failed to initialize correctly", dod.getRandomMessage());
        long count = Message.countMessages();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Message> result = Message.findMessageEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Message' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Message' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void MessageIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Message' failed to initialize correctly", dod.getRandomMessage());
        Message obj = dod.getNewTransientMessage(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Message' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Message' identifier to be null", obj.getMessageid());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Message' identifier to no longer be null", obj.getMessageid());
    }
    
    @Test
    public void MessageIntegrationTest.testRemove() {
        Message obj = dod.getRandomMessage();
        Assert.assertNotNull("Data on demand for 'Message' failed to initialize correctly", obj);
        Integer id = obj.getMessageid();
        Assert.assertNotNull("Data on demand for 'Message' failed to provide an identifier", id);
        obj = Message.findMessage(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Message' with identifier '" + id + "'", Message.findMessage(id));
    }
    
}
