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
    public static void main(String[] args)
    {
        
        int[] arr = {1};
        
        
        
        ForkJoinPool fjpool = new ForkJoinPool();
        ForkJoinPool.commonPool().invoke(new ForkJoinTask(arr,0,arr.length));
        
        
    }
    
    
    
}
