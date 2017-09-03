/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author M315T3R
 */
public class MainSeq
{
    
    public static int filterWidth = 3;
    public static int iterations = 50;
    public static int items = 10;
    public static double[] arr = new double[items];
    public static double[] newArr = new double[items];
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        
       //Read file
        BufferedReader br = new BufferedReader(new FileReader ("sampleinputfile.txt"));
        String tmp = br.readLine();
        tmp = br.readLine();
        int count = 0;
        
        while (tmp != null && count<items){
            arr[count] = Double.parseDouble(tmp.split(" ")[1]);
            count++;
            tmp = br.readLine();
        }
        
        //Set first & last values (unchanged vals)
        System.gc();
        
        
        
     
        
        
        
        //Time
        double time1 = System.currentTimeMillis();
            //Process
        for (int a = 0; a < iterations; a++)
        {
            
        
            int halfWidth = (filterWidth-1)/2;
            
            for (int i = halfWidth; i < arr.length-2*halfWidth; i++)
        {
               newArr[i] = getMedian(i);
            }
        }
        //Time end
        System.out.println((System.currentTimeMillis()-time1)/iterations);
        
      
        
        PrintWriter pw = new PrintWriter(new FileWriter("seqOut.txt"));
        
        
        pw.println("" + items);
        
        for (int i = 0; i < newArr.length; i++)
        {
            pw.println(newArr[i] + "");
            
        }
        pw.close();
        
        
    }
    
    
    public static double getMedian(int index){
        int halfWidth = (MainSeq.filterWidth-1)/2;
        double[] arr1 = Arrays.copyOfRange(MainSeq.arr, index-halfWidth, index+halfWidth);
        Arrays.sort(arr1);
        return arr1[(arr1.length-1)/2];
        
    }
    
    
    
    
    
}
