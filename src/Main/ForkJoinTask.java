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
    
    public Utilities util;

    public ForkJoinTask(int lo, int hi)
    {
        
        this.lo = lo;
        this.hi = hi;
        this.util = new Utilities();
    }
    
    
    protected void compute(){
        
        if (hi - lo < Main.SEQUENTIAL_CUTOFF)
        {
            //Process
            
            for (int i = lo; i < hi; i++)
            {
                if (
                        i - (Main.filterWidth-1)/2 < 0 
                        || 
                        i + (Main.filterWidth-1)/2 > Main.arr.length-1)
                {
                    
                }
                else
                {
              Main.newArr[i] = util.getMedian(i);
                }
                
                
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
