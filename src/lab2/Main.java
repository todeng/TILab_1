/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author stud221
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setOut(new java.io.PrintStream(System.out, true, "Cp866"));
//        Crypto.encode(new File("F:\\Новая папка (2)\\NetBeans\\ТИ\\Lab1\\Martin George - A Game of Thrones.txt"));
//        int a = 2564;
//        int b = 432423;
//        System.out.println(a ^ b);
//        System.out.println(a ^ b^b);
        CryptoKey key = new CryptoKey(new File("Z:\\Новая папка (2)\\NetBeans\\ТИ\\Lab2\\dist\\ключ.key"));
        Crypto cry = new Crypto(key);
        cry.encode(new File("Z:\\Новая папка (2)\\NetBeans\\ТИ\\Lab2\\dist\\Martin George - A Game of Thrones.txt"));
    }

}
