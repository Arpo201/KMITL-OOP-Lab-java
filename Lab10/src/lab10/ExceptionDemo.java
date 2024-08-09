/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

/**
 *
 * @author Asus
 */
import java.lang.Math;

public class ExceptionDemo {
    public static void main(String[] args) {
            try{
                double numA = Double.parseDouble(args[0]);
                double numB = Double.parseDouble(args[1]);
                double numC = Double.parseDouble(args[2]);
                double x1 = (-numB + Math.sqrt(Math.pow(numB, 2) - (4 * numA * numC)))/(2*numA);
                double x2 = (-numB - Math.sqrt(Math.pow(numB, 2) - (4 * numA * numC)))/(2*numA);
                System.out.println("x1: " + x1);
                System.out.println("x2: " + x2);
            }catch(NumberFormatException ex){
                System.out.println("Please input data in number format only.");
            }catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Please enter 3 numbers as a, b, and c respectively.");
            }
            
    }
    
}
