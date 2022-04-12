/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author chica
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private double currentMoney;
    HashMap<String, Item> items = new HashMap<>();
    
    
    public void addinventory(String name)
    {
        Item tempitem = items.get(name);
        
        tempitem.setQuantity(tempitem.getQuantity()+1);
        
        items.put(name, tempitem);
        
    }  
    
    public void removeinventory(String name)
    {
        Item tempitem = items.get(name);
        
        tempitem.setQuantity(tempitem.getQuantity()-1);
        
        items.put(name, tempitem);
        
    }        
    
    
    
    @Override
    public double addMoney(double amount) {
        currentMoney += amount;
        return currentMoney;
    }

    @Override
    public double checkBalance() {
        return currentMoney;
    }

    @Override
    public double removeMoney(double amount) {
        currentMoney -= amount;
        //make sure current money doesn't go under 0
        return currentMoney;
    }

    @Override
    public Item selection(String item) {
        return items.get(item);
        //check for availability, and remaining funds
    }

    @Override
    public void addItem(String name, Item item) {
        items.put(name, item);
    }

    @Override
    public void removeItem(String name) {
        items.remove(name);
    }
    
    @Override
    public List<Item> listItems() {
        //creates set from items "keys"
        Set<String> itemNames = items.keySet();
        
        //list that holds the items
        List<Item> itemList = new ArrayList();
        
        //looping to add items
        for(String name : itemNames) {
            itemList.add(items.get(name));//adding item to list by name
        }
        return itemList;
    }

    @Override
    public void saveLibrary() {

        try {//to create file
            File myObj = new File("Library.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {//to write to file
            FileWriter myWriter = new FileWriter("collection.txt");
            for (Map.Entry<String, Item> entry : items.entrySet()) { // iterates through keys in hashmap
                Item tempItem = entry.getValue();
                myWriter.write(tempItem.getName() + "::"
                        + tempItem.getQuantity() + "::"
                        + tempItem.getPrice() + "::"
                        + tempItem.getMoneyInMachine());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void loadLibrary() {
        try {
            File f = new File("Library.txt");
            if (!f.exists()) {
                System.out.println("File doesn't exist");
                throw new Exception();
            }
            Scanner sc = new Scanner(new BufferedReader(new FileReader("Library.txt")));//to read from file
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] storeState = currentLine.split("::", 0);
               
                // Revert any empty strings which may have been stored as spaces
                for (String value : storeState) {
                    value = revertEmptyValue(value);
                }
                
                Item tempItem = new Item();
                tempItem.setName(storeState[0]);
                tempItem.setPrice(Double.parseDouble(storeState[1]));
                tempItem.setQuantity(Integer.parseInt(storeState[2]));
              
                items.put(storeState[0], tempItem);
            }
        } catch (Exception e) {
            System.out.println("You got an error " + e.getMessage());
        }
    }
    
    public String revertEmptyValue(String checkString) {
        if (checkString.equals(" ")) {
            return "";
        }
        return checkString;
    }
}
