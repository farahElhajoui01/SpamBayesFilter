/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public class MailTextFacadeTest {
    
    public MailTextFacadeTest() {
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
     * Test of Insérermot method, of class MailTextFacade.
     */
//    @Test
//    public void testInsérermot() {
//        System.out.println("Ins\u00e9rermot");
//        MailTextFacade instance = new MailTextFacade();
//        instance.Insérermot();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of Probamot method, of class MailTextFacade.
     */
//    @Test
//    public void testProbamot() {
//        System.out.println("Probamot");
//        String word = "";
//        String categorie = "";
//        MailTextFacade instance = new MailTextFacade();
//        double expResult = 0.0;
//        double result = instance.Probamot(word, categorie);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of Prob method, of class MailTextFacade.
     */
//    @Test
//    public void testProb() {
//        System.out.println("Prob");
//        String text = "";
//        String categorie = "";
//        MailTextFacade instance = new MailTextFacade();
//        double expResult = 0.0;
//        double result = instance.Prob(text, categorie);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of PseudoProbaEmail method, of class MailTextFacade.
     */
//    @Test
//    public void testPseudoProbaEmail() {
//        System.out.println("PseudoProbaEmail");
//        String text = "";
//        String categorie = "";
//        MailTextFacade instance = new MailTextFacade();
//        double expResult = 0.0;
//        double result = instance.PseudoProbaEmail(text, categorie);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of ClassifieurBayes method, of class MailTextFacade.
     */
    @Test
    public void testClassifieurBayes() {
        System.out.println("ClassifieurBayes");
        String text = "test life";
        MailTextFacade instance = new MailTextFacade();
        String expResult = "";
        String result = instance.ClassifieurBayes(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
