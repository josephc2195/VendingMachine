/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author chica
 */
public interface VendingMachineServiceLayer {
    public List<Item> listitems();
    
    public boolean chooseitem (String name);
    
    public double currentbalance();
    
    public void addmoney (double money);
    
    public boolean returnmoney();
    
    public void additem(Item added); 
    
}
