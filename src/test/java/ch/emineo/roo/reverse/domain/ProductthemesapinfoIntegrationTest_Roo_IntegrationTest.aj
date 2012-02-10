// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productthemesapinfo;
import ch.emineo.roo.reverse.domain.ProductthemesapinfoDataOnDemand;
import ch.emineo.roo.reverse.domain.ProductthemesapinfoIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProductthemesapinfoIntegrationTest_Roo_IntegrationTest {
    
    declare @type: ProductthemesapinfoIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: ProductthemesapinfoIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: ProductthemesapinfoIntegrationTest: @Transactional;
    
    @Autowired
    private ProductthemesapinfoDataOnDemand ProductthemesapinfoIntegrationTest.dod;
    
    @Test
    public void ProductthemesapinfoIntegrationTest.testCountProductthemesapinfoes() {
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to initialize correctly", dod.getRandomProductthemesapinfo());
        long count = Productthemesapinfo.countProductthemesapinfoes();
        Assert.assertTrue("Counter for 'Productthemesapinfo' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void ProductthemesapinfoIntegrationTest.testFindProductthemesapinfo() {
        Productthemesapinfo obj = dod.getRandomProductthemesapinfo();
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to initialize correctly", obj);
        Integer id = obj.getProductthemesapinfoid();
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to provide an identifier", id);
        obj = Productthemesapinfo.findProductthemesapinfo(id);
        Assert.assertNotNull("Find method for 'Productthemesapinfo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Productthemesapinfo' returned the incorrect identifier", id, obj.getProductthemesapinfoid());
    }
    
    @Test
    public void ProductthemesapinfoIntegrationTest.testFindAllProductthemesapinfoes() {
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to initialize correctly", dod.getRandomProductthemesapinfo());
        long count = Productthemesapinfo.countProductthemesapinfoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Productthemesapinfo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Productthemesapinfo> result = Productthemesapinfo.findAllProductthemesapinfoes();
        Assert.assertNotNull("Find all method for 'Productthemesapinfo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Productthemesapinfo' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void ProductthemesapinfoIntegrationTest.testFindProductthemesapinfoEntries() {
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to initialize correctly", dod.getRandomProductthemesapinfo());
        long count = Productthemesapinfo.countProductthemesapinfoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Productthemesapinfo> result = Productthemesapinfo.findProductthemesapinfoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Productthemesapinfo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Productthemesapinfo' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void ProductthemesapinfoIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to initialize correctly", dod.getRandomProductthemesapinfo());
        Productthemesapinfo obj = dod.getNewTransientProductthemesapinfo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Productthemesapinfo' identifier to be null", obj.getProductthemesapinfoid());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Productthemesapinfo' identifier to no longer be null", obj.getProductthemesapinfoid());
    }
    
    @Test
    public void ProductthemesapinfoIntegrationTest.testRemove() {
        Productthemesapinfo obj = dod.getRandomProductthemesapinfo();
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to initialize correctly", obj);
        Integer id = obj.getProductthemesapinfoid();
        Assert.assertNotNull("Data on demand for 'Productthemesapinfo' failed to provide an identifier", id);
        obj = Productthemesapinfo.findProductthemesapinfo(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Productthemesapinfo' with identifier '" + id + "'", Productthemesapinfo.findProductthemesapinfo(id));
    }
    
}