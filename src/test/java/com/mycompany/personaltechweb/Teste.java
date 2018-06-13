/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
//import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author marcos
 */
public class Teste {

    protected static EJBContainer container;
    protected final Logger logger = Logger.getGlobal();

    @BeforeClass
    public static void setUpClass() {
        container = EJBContainer.createEJBContainer();
        DbUnitUtil.inserirDados();
    }

    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
}
