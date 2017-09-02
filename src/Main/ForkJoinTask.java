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
    
    int lo;
    int hi;
    public static int SEQUENTIAL_CUTOFF = 5;
    public Utilities util;

    public ForkJoinTask(int lo, int hi)
    {
        
        this.lo = lo;
        this.hi = hi;
        this.util = new Utilities();
    }
    
    
    protected void compute(){
        if (hi - lo < SEQUENTIAL_CUTOFF)
        {
            //Process
            for (int i = lo; i < hi+1; i++)
            {
              //  Main.arr[] 
                
            }
            
            
            
        }
        else
        {
            ForkJoinTask left = new ForkJoinTask(lo, (hi+lo)/2);
            ForkJoinTask right = new ForkJoinTask((hi+lo)/2,hi);
            left.fork();
            right.compute();
            left.join();
            
        }
    }
            
            
    
    
}
