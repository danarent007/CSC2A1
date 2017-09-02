/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author M315T3R
 */
public class Utilities
{
    double[] arr;

    public Utilities(double[] arr)
    {
        this.arr = arr;
    }
    
    
    public double getMedian(int index, int filterWidth){
        int halfWidth = (filterWidth-1)/2;
        
        double[] arr1 = Arrays.copyOfRange(arr, index-halfWidth, index+halfWidth);
        Arrays.sort(arr1);
        return arr1[(arr1.length-1)/2];
        
        
        
    }
    
    
    
    
    
    
}
