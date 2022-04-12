/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine.controller;
import com.mycompany.vendingmachine.ui.*;
import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mycompany.vendingmachine.dto.Item;
import com.mycompany.vendingmachine.service.VendingMachineServiceLayerImpl;

import java.util.List;

/**
 *
 * @author chica
 */
public class VendingMachineController {

    private UserIO io = new UserIOConsoleImpl();
    // Replace with implementation
    private VendingMachineServiceLayerImpl serviceLayer = new VendingMachineServiceLayerImpl();
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    private VendingMachineView view;
    
    public VendingMachineController(VendingMachineView view) {
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    io.print("List of items:");
                    listItems();
                    break;
                case 2:
                    io.print("Choose item");
                    chooseItem();
                    break;
                case 3:
                    io.print("Add money");
                    addMoney();
                    break;
                case 4:
                    io.print("Return money");
                    returnMoney();
                    break;
                case 5:
                    io.print("Add item to vending machine");
                    addItem();
                    break;
                case 6: 
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND, PLEASE TRY AGAIN");
            }
        }
        io.print("GOOD BYE");
    }

    public void listItems() {
        List<Item> items = serviceLayer.listitems();
        view.displayItemList(items);
    }

    public void addMoney() {
        double m = view.moneyEntered();
        serviceLayer.addmoney(m);
    }

    public void addItem() {
        Item i = view.addNewItem();
        serviceLayer.additem(i);
    }

    public void returnMoney() {
        double current = serviceLayer.currentbalance();
        if(serviceLayer.returnmoney()) {
            view.change(current);
        } else {
            view.tooLowBalance();
        }
    }

    public void chooseItem() {
        String item = view.chooseItem();
        if(serviceLayer.chooseitem(item)) {
            System.out.println("Enjoy your item!");
        } else {
            System.out.println("Not enough money!");
        }
    }
}
