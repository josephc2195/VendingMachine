/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author chica
 */
public class VendingMachineDaoFileImplTest {
    
    VendingMachineDao testDao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoFileImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testVendingMachine.txt";
        
        new FileWriter(testFile);
        testDao = new VendingMachineDaoFileImpl(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddItem() throws Exception {
        //create item
        Item candy = new Item();
        String name = "Candycane";
        candy.setName(name);
        candy.setPrice(1.25);
        candy.setQuantity(10);
        
        //add item to dao
        testDao.addItem(name, candy);
        
        
    }
}
