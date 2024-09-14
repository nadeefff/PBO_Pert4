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
public class Throw {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        int[] array = {0, 1, 2, 3}; // Fixed array initialization

        Scanner userInput = new Scanner(System.in);

        System.out.print("nilai array ke: ");

        int index = userInput.nextInt(); // Fixed syntax for assigning user input

        // No try-catch block, instead the method declares it can throw the exception
        System.out.printf("index ke-%d, adalah %d\n", index, array[index]);

        // Program end message
        System.out.println("Akhir dari program.");
    }
}