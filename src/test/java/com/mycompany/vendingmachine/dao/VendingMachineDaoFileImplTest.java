/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        Item retrievedItem = testDao.selection(name);

        //checking data
        assertEquals(candy.getName(), retrievedItem.getName(), "Checking added item name");
        assertEquals(candy.getPrice(), retrievedItem.getPrice(), "Checking added item price");
        assertEquals(candy.getQuantity(), retrievedItem.getQuantity(), "Checking added item quantity");
    }

    @Test
    public void testRemoveItem() throws Exception {
        //creating 2 new items
        Item chips = new Item();
        Item honeybun = new Item();

        chips.setName("Lays");
        chips.setPrice(1.75);
        chips.setQuantity(10);
        honeybun.setName("HoneyBun");
        honeybun.setPrice(1.50);
        honeybun.setQuantity(12);

        //add both to the dao
        testDao.addItem("Lays", chips);
        testDao.addItem("HoneyBun", honeybun);

        //remove first item
        testDao.removeItem(chips.getName());

        //get list of items
        List<Item> allItems = testDao.listItems();

        assertNotNull(allItems, "Item list should not be null");

        assertEquals(1, allItems.size(), "Item list should only have 1 item at this point");

        assertFalse(allItems.contains(chips));

        assertTrue(allItems.contains(honeybun));

        //remove second item
        testDao.removeItem(honeybun.getName());

        allItems = testDao.listItems();

        assertTrue(allItems.isEmpty(), "Item list should be empty");
    }
}
