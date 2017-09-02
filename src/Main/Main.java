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
    
    
    public static void main(String[] args)
    {
        
        double[] arr = {1,2,3,4,5,6,7,8,9};

        
        //ForkJoinPool fjpool = new ForkJoinPool();
        ForkJoinPool.commonPool().invoke(new ForkJoinTask(0,arr.length));
        System.out.println("Done");
        
    }
    
    
    
}
