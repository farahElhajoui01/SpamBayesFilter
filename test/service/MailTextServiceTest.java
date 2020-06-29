/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.MailText;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author farah
 */
public class MailTextServiceTest {
    
    public MailTextServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class MailTextService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        MailText mailText = new MailText();
        MailTextService instance = new MailTextService();
        instance.create(mailText);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
