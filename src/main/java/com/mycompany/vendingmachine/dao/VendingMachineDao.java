/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author chica
 */
public interface VendingMachineDao {
    
    double addMoney(double amount);
    
    double removeMoney(double amount);
    
    Item selection(String item);
    
    List<Item> listItems();
    
    void loadLibrary();
    
    void saveLibrary();
    
    void addItem(String name, Item item);
    
    void removeItem(String name);
    
    
}
