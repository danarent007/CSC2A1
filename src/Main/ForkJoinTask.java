/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author M315T3R
 */
public class ForkJoinTask extends RecursiveAction
{
    int[] arr;
    int lo;
    int hi;

    public ForkJoinTask(int[] arr, int lo, int hi)
    {
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
    }
    
    
    
    
    protected void compute(){
        
    }
            
            
    
    
}
