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
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author M315T3R
 */
public class MainPar
{
    
    public static int filterWidth = 3;
    public static int SEQUENTIAL_CUTOFF = 10000;
    public static int items = 1000000;
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
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < ((filterWidth-1)/2); i++)
        {
            newArr[i] = arr[i];
            newArr[newArr.length-1-i] = arr[arr.length-1-i];
        }
        
       
        

        
        ForkJoinPool fjpool = new ForkJoinPool();
        fjpool.commonPool().invoke(new ForkJoinTask(0,arr.length));
        
        System.out.println(System.currentTimeMillis()-time1);
        
        
       
        
        
        PrintWriter pw = new PrintWriter(new FileWriter("parOut.txt"));
        
        pw.println("" + items);
        for (int i = 0; i < arr.length; i++)
        {
            pw.println(newArr[i] + " ");
        }
        pw.close();
        
        
    }
    
    static final ForkJoinPool fjPool = new ForkJoinPool();
    void doTask(){
    fjPool.commonPool().invoke(new ForkJoinTask(0,arr.length));
    }
    
    
    
}
