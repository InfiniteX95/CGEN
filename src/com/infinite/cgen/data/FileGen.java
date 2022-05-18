package com.infinite.cgen.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.infinite.cgen.frame.MainJFrame;

public class FileGen
{
    
    public static void writetoFile(String path, String directoryPath, Long charnum, boolean num, boolean symb)
    {
        File directory = new File(directoryPath);
        
        if (! directory.exists())
        {
            System.out.println("dir created");
            directory.mkdir();
        }
        
        File file = new File(path);
        
        try
        {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            for(Long i = 1L; i <= charnum; i++)
            {
                //if there is no case checked
                if(!num && !symb)
                {
                    Random r = new Random();
                    char c = (char)(97 + r.nextInt(26));//letters lowercase
                    
                    char e = (char)(65 + r.nextInt(26));//letters uppercase
                    
                    int roll = r.nextInt(2);
                    
                    if(roll == 0)
                    writer.print(c);
                    
                    if(roll == 1)
                    writer.print(e);
                }
                
                if(num && symb)
                {
                    Random r = new Random();
                    char c = (char)(97 + r.nextInt(26));//letters lowercase
                    
                    char d = (char)(65 + r.nextInt(26)); //letters uppercase
                    
                    char e = (char)(48 + r.nextInt(9));//numbers
                    
                    char f = getSymbol();//symbols
                    
                    int roll = r.nextInt(4);
                    
                    if(roll == 0)
                    writer.print(c);
                    
                    if(roll == 1)
                    writer.print(d);
                    
                    if(roll == 2)
                    writer.print(e);
                    
                    if(roll == 3)
                    writer.print(f);

                }
                
                if(num && !symb)
                {
                    Random r = new Random();
                    char c = (char)(97 + r.nextInt(26));//letters lowercase
                    
                    char e = (char)(65 + r.nextInt(26));//letters uppercase
                    
                    char d = (char)(48 + r.nextInt(9));//numbers
                    
                    int roll = r.nextInt(3);
                    
                    if(roll == 0)
                    writer.print(c);
                    
                    if(roll == 1)
                    writer.print(d);
                    
                    if(roll == 2)
                    writer.print(e);
                }
                
                if(!num && symb)
                {
                    Random r = new Random();
                    char c = (char)(97 + r.nextInt(26));//letters lowercase
                    char d = (char)(65 + r.nextInt(26));//letters uppercase
                    char e = getSymbol();//symbols
                    
                    int roll = r.nextInt(3);
                    
                    if(roll == 0)
                    writer.print(c);
                    
                    if(roll == 1)
                    writer.print(d);
                    
                    if(roll == 2)
                    writer.print(e);
                }
                
                
            }
            writer.close();
        }
        
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.err.println("FILE NOT FOUND !");
            JOptionPane.showMessageDialog(new JFrame(), "FILE NOT FOUND", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
            System.err.println("ERROR DURING ENCODING");
            JOptionPane.showMessageDialog(new JFrame(), "ERROR DURING ENCODING", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static char getSymbol()
    {
        Random r = new Random();
        char e = (char)(33 + r.nextInt(14));//symbols1
        char f = (char)(58 + r.nextInt(6));//symbols2
        
        int roll = r.nextInt(2);
        if(roll == 0)
            return e;
        
        if(roll == 1)
            return f;
        
        return 'à';
    }
}
