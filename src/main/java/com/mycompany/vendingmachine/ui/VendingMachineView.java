
package com.mycompany.vendingmachine.ui;

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
    
    /**
     * displays menu and gets user input
     * 
     * @return user selected menu option
     */
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List items");
        io.print("2. Choose an item");
        io.print("3. Add money");
        io.print("4. Return money");
        io.print("5. Add item");
        io.print("6. Save inventory");
        io.print("7. Load inventory");
        io.print("8. Exit");
        
        return io.readInt("Please select from the above choices.");
    } 
    
    /**
     * This method displays all current items in collection
     * 
     * @param dvdList list of dvds
     */
    public void displayItemList(List<Item> items) {
        for(Item i : items) { 
            displayItem(i);
            io.print("\n");
        }
    }
    
    /**
     * Displays all information for selected item
     * 
     * @param item object
     */
    public void displayItem(Item item) {
        if(item != null) {
            io.print("Item name: " + item.getName());
            io.print("Item price: $" + item.getPrice());
            io.print("Item quantity: " + item.getQuantity());
        }
    }
    
    /**
     * Displays a successful banner that amount has been added
     * @param amount - amount being added
     */
    public void addedMoneyBanner(double amount) {
        if(amount > 0 ) {
            io.print("Added $" + amount);
        }
    }
    
    public void returnMoneyBanner(double amount) {
        io.print("Returning $" + amount);
    }
    
    /**
     * This method asks the user what item they want
     * 
     * @return String the item the user selects
     */
    public String chooseItem() {
        return io.readString("Which item would you like? ");
    }
    
    /**
     * This method get the information from the user about the new item being added
     * 
     * @return Item - item object that is being added to our collection
     */
    public Item addNewItem() {
        Item addedItem = new Item();
        addedItem.setName(io.readString("Please enter the name of item: "));
        addedItem.setPrice(io.readDouble("Please enter the price of item: "));
        addedItem.setQuantity(io.readInt("Please enter the quantity of item: "));
        
        return addedItem;
    }
    
    public double moneyEntered() {
        return io.readDouble("Please enter the amount of money you are depositing: ");
    }
    
    public void change(double amount) { 
        io.print("You are getting back: " + amount);
    }
    
    public void tooLowBalance() {
        io.print("There is nothing to return");
    }
}
