/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.util.HashMap;

/**
 *
 * @author chica
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {
    private double currentMoney;
    HashMap<String, Item> items = new HashMap<>();

    @Override
    public double addMoney(double amount) {
        currentMoney += amount;
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
    public void saveLibrary() {
    /*
        try {//to create file
            File myObj = new File("collection.txt");
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
            for (Map.Entry<String, DVDObj> entry : dvdCollection.entrySet()) { // iterates through keys in hashmap
                DVDObj tempdvd = entry.getValue();
                myWriter.write(tempdvd.getTitle() + "::"
                        + correctEmptyString(tempdvd.getReleaseDate()) + "::"
                        + correctEmptyString(tempdvd.getRating()) + "::"
                        + correctEmptyString(tempdvd.getDirectors()) + "::"
                        + correctEmptyString(tempdvd.getStudio()) + "::"
                        + correctEmptyString(tempdvd.getNote()) + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    */
    }

    @Override
    public void loadLibrary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
