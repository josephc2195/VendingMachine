/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine.ui;

import com.mycompany.classroster.ui.UserIO;
import com.mycompany.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author chica
 */
public class VendingMachineView {
    private UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List items");
        io.print("2. Choose an item");
        io.print("3. Add money");
        io.print("4. Return money");
        io.print("5. Add item");
        io.print("6. Exit");
        
        return io.readInt("Please select from the above choices.", 1, 6);
    } 
    
    public void displayItemList(List<Item> items) {
        for(Item i : items) { 
            displayItem(i);
            io.print("\n");
        }
    }
    
    public void displayItem(Item item) {
        if(item != null) {
            io.print("Item name: " + item.getName());
            io.print("Item price: $" + item.getPrice());
            io.print("Item quantity: " + item.getQuantity());
        }
    }
    
    public void addedMoneyBanner(double amount) {
        io.print("Added $" + amount);
    }
    
    
    
}
