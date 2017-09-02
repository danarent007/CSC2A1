/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author M315T3R
 */
public class Main
{
    public static double[] arr;
    public static int filterWidth;
    public static int SEQUENTIAL_CUTOFF = 5;
    
    public static void main(String[] args)
    {
        
        //double[] arr = {1,2,3,4,5,6,7,8,9};
        
        int filterWidth = 5;

        
        ForkJoinPool fjpool = new ForkJoinPool();
        fjpool.commonPool().invoke(new ForkJoinTask(0,arr.length));
        System.out.println("Done");
        
    }
    
    static final ForkJoinPool fjPool = new ForkJoinPool();
    void doTask(){
    fjPool.commonPool().invoke(new ForkJoinTask(0,arr.length));
    }
    
    
    
}
