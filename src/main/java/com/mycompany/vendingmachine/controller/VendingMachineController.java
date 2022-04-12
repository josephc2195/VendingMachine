/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine.controller;

import com.mycompany.classroster.ui.UserIO;
import com.mycompany.classroster.ui.UserIOConsoleImpl;
import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mycompany.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author chica
 */
public class VendingMachineController {

    private UserIO io = new UserIOConsoleImpl();
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. List items");
            io.print("2. Choose an item");
            io.print("3. Add money");
            io.print("4. Return money");
            io.print("5. Add item");
            io.print("6. Exit");
            

            menuSelection = io.readInt("Please select from the above choices.");

            switch (menuSelection) {
                case 1:
                    io.print("List of items:");
                    listItems();
                    break;
                case 2:
                    io.print("Choose item");
                    break;
                case 3:
                    io.print("Add money");
                    break;
                case 4:
                    io.print("Return money");
                    break;
                case 5:
                    io.print("Add item to vending machine");
                    break;
                case 6: 
                    keepGoing = false;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("GOOD BYE");
    }
    
    public void listItems() {
        List<Item> items = dao.listItems();
        for(Item i : items) {
            io.print(i.getName() + " $" + i.getPrice() + " Quantity: " + i.getQuantity());
        }
    }
}
