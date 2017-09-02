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
public class Main
{
    public static double[] arr = new double[1000000];
    public static double[] newArr = new double[1000000];
    public static int filterWidth = 3;
    public static int SEQUENTIAL_CUTOFF = 10;
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        
       //Read file
        BufferedReader br = new BufferedReader(new FileReader ("sampleinputfile.txt"));
        String tmp = br.readLine();
        tmp = br.readLine();
        int count = 0;
        
        while (tmp != null){
            arr[count] = Double.parseDouble(tmp.split(" ")[1]);
            count++;
            tmp = br.readLine();
        }
        
        
       
        

        
        ForkJoinPool fjpool = new ForkJoinPool();
        fjpool.commonPool().invoke(new ForkJoinTask(0,arr.length));
        System.out.println("Done");
        
        PrintWriter pw = new PrintWriter(new FileWriter("file.txt"));
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
