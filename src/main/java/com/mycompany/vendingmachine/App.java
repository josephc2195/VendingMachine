/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.vendingmachine;

import com.mycompany.vendingmachine.controller.VendingMachineController;


/**
 *
 * @author chica
 */
public class App {

    public static void main(String[] args) {
        VendingMachineController controller = new VendingMachineController();
        controller.run();
    }
}
