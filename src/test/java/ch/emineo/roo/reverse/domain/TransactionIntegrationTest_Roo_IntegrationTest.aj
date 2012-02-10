// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Transaction;
import ch.emineo.roo.reverse.domain.TransactionDataOnDemand;
import ch.emineo.roo.reverse.domain.TransactionIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TransactionIntegrationTest_Roo_IntegrationTest {
    
    declare @type: TransactionIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: TransactionIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: TransactionIntegrationTest: @Transactional;
    
    @Autowired
    private TransactionDataOnDemand TransactionIntegrationTest.dod;
    
    @Test
    public void TransactionIntegrationTest.testCountTransactions() {
        Assert.assertNotNull("Data on demand for 'Transaction' failed to initialize correctly", dod.getRandomTransaction());
        long count = Transaction.countTransactions();
        Assert.assertTrue("Counter for 'Transaction' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void TransactionIntegrationTest.testFindTransaction() {
        Transaction obj = dod.getRandomTransaction();
        Assert.assertNotNull("Data on demand for 'Transaction' failed to initialize correctly", obj);
        Integer id = obj.getTransactionid();
        Assert.assertNotNull("Data on demand for 'Transaction' failed to provide an identifier", id);
        obj = Transaction.findTransaction(id);
        Assert.assertNotNull("Find method for 'Transaction' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Transaction' returned the incorrect identifier", id, obj.getTransactionid());
    }
    
    @Test
    public void TransactionIntegrationTest.testFindAllTransactions() {
        Assert.assertNotNull("Data on demand for 'Transaction' failed to initialize correctly", dod.getRandomTransaction());
        long count = Transaction.countTransactions();
        Assert.assertTrue("Too expensive to perform a find all test for 'Transaction', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Transaction> result = Transaction.findAllTransactions();
        Assert.assertNotNull("Find all method for 'Transaction' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Transaction' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void TransactionIntegrationTest.testFindTransactionEntries() {
        Assert.assertNotNull("Data on demand for 'Transaction' failed to initialize correctly", dod.getRandomTransaction());
        long count = Transaction.countTransactions();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Transaction> result = Transaction.findTransactionEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Transaction' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Transaction' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void TransactionIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Transaction' failed to initialize correctly", dod.getRandomTransaction());
        Transaction obj = dod.getNewTransientTransaction(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Transaction' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Transaction' identifier to be null", obj.getTransactionid());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Transaction' identifier to no longer be null", obj.getTransactionid());
    }
    
    @Test
    public void TransactionIntegrationTest.testRemove() {
        Transaction obj = dod.getRandomTransaction();
        Assert.assertNotNull("Data on demand for 'Transaction' failed to initialize correctly", obj);
        Integer id = obj.getTransactionid();
        Assert.assertNotNull("Data on demand for 'Transaction' failed to provide an identifier", id);
        obj = Transaction.findTransaction(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Transaction' with identifier '" + id + "'", Transaction.findTransaction(id));
    }
    
}