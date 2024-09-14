/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert4;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class TryCatch {
    public static void main(String[] args) {

        int[] array = {0, 1, 2, 3}; 

        Scanner userInput = new Scanner(System.in);
        System.out.print("nilai array ke: ");

        int index = userInput.nextInt(); 

        // Exception handling (try, catch)
        try {
            System.out.printf("index ke-%d, adalah %d\n", index, array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
            System.out.println("Index tidak tersedia di array.");
        }
        System.out.println("Akhir dari program.");
    }
}