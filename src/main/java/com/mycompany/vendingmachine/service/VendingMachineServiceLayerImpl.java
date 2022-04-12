
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mycompany.vendingmachine.dto.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

enum coin
{
    cent,
    nickel,
    dime,
    quarter,
    dollar
    
}

public class VendingMachineServiceLayerImpl {
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public List<Item> listitems()
    {
    
   
    
    List<Item> items = dao.listItems();
    
        
        //list that holds the items
        List<Item> tempitems = new ArrayList();
        
        //looping to add items
        for(Item name : items) 
        {
            
            if (name.getQuantity()==0)
            {
                System.out.println("Looks like we are out of "+name.getName());
            }
            
            else
            {
               tempitems.add(name);
           
            }
        }
        
        return tempitems;


   } 
    
    
    public boolean chooseitem (String name)
            
    {
        Item selection = dao.selection(name);
        
        if (dao.checkBalance() >= selection.getPrice()) 
        {
           dao.removeMoney(selection.getPrice());
           dao.removeinventory(name);
           
           return true;
        } 
        
        else
        {
            return false;
        }    
        
    }
    
    
    public double currentbalance()
    {
        return dao.checkBalance();
        
    }
    
    public void addmoney (double money)
    {
        dao.addMoney(money);
    }
    
    public boolean returnmoney()
    {
        if (dao.checkBalance()==0)
        {
            return false;
        }
        
        else
        {
        double tempmoney = dao.checkBalance();
        dao.removeMoney(tempmoney);
        return true;
        }
    }
    
    
    
    
    
}






