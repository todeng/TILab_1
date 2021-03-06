/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stud221
 */
public class Crypto {
    private CryptoKey key;
    public Crypto(CryptoKey key){
        this.key = key;
    }
    public void encode(File file) throws FileNotFoundException, IOException{


        RandomAccessFile raf = new RandomAccessFile(file, "rw");  
        long file_length = raf.length();
        System.out.println("Размер файла: " + file_length + " байт");
        System.out.print("Стутус:  ##########");
        for(long i = 0; i < file_length; i++)
        {
            
            if(i%1000 == 0) System.out.printf("\b\b\b\b\b\b\b\b\b\b\b%10.2f%%", (double)((int)i+1)/file_length*100);
            raf.seek(i);
            byte original = raf.readByte();           
            byte encoded = (byte)(original ^ key.getNextByte());
            raf.seek(i);
            raf.write(encoded);
        }
        System.out.println();
        raf.close();
    }

}
