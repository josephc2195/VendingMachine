/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine.controller;
import com.mycompany.vendingmachine.ui.*;
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
    private VendingMachineView view;
    
    VendingMachineController(VendingMachineView view) {
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
                    chooseItem(view.chooseItem());
                    break;
                case 3:
                    io.print("Add money");
                    // Remove two with new view
                    addMoney(2);
                    break;
                case 4:
                    io.print("Return money");
                    // Replace 3 with new method from view
                    removeMoney(3);
                    break;
                case 5:
                    io.print("Add item to vending machine");
                    break;
                case 6: 
                    keepGoing = false;
                default:
                    io.print("UNKNOWN COMMAND, PLEASE TRY AGAIN");
            }
        }
        io.print("GOOD BYE");
    }

    public void listItems() {
        List<Item> items = dao.listItems();
        for (Item i : items) {
            io.print(i.getName() + " $" + i.getPrice() + " Quantity: " + i.getQuantity());
        }
    }

    public void addMoney(int m) {
        dao.addMoney(m);
    }

    public void addItem(String n, Item i) {
        dao.addItem(n, i);
    }

    public void removeMoney(double m) {
        dao.removeMoney(m);
    }

    public void chooseItem(String item) {
        String i = io.readString("Enter a item to choose: ");
        Item selection = dao.selection(i);
        if (dao.checkBalance() == selection.getPrice()) {
            if (selection.getQuantity() >= 1) {
                selection.setQuantity(selection.getQuantity() - 1);
            }
        }
    }
}
