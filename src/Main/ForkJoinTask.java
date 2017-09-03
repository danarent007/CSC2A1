/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author M315T3R
 */
public class ForkJoinTask extends RecursiveAction
{
    
    int lo;
    int hi;
    


    public ForkJoinTask(int lo, int hi)
    {
        
        this.lo = lo;
        this.hi = hi;
    }
    
    
    protected void compute(){
        
        if (hi - lo < MainPar.SEQUENTIAL_CUTOFF)
        {
            //Process
            
            for (int i = lo; i < hi; i++)
            {
                if (
                        i - (MainPar.filterWidth-1)/2 < 0 
                        || 
                        i + (MainPar.filterWidth-1)/2 > MainPar.arr.length-1)
                {
                    
                }
                else
                {
              MainPar.newArr[i] = getMedian(i);
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
            
            
        public static double getMedian(int index){
        int halfWidth = (MainPar.filterWidth-1)/2;
        double[] arr1 = Arrays.copyOfRange(MainPar.arr, index-halfWidth, index+halfWidth);
        Arrays.sort(arr1);
        return arr1[(arr1.length-1)/2];
        
    }
    
}
