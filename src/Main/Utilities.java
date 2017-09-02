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
   

    public Utilities()
    {
        
    }
    
    
    public double getMedian(int index){
        int halfWidth = (Main.filterWidth-1)/2;
        
        
        
        double[] arr1 = Arrays.copyOfRange(Main.arr, index-halfWidth, index+halfWidth);
        Arrays.sort(arr1);
        return arr1[(arr1.length-1)/2];
        
    }
    
    
    
    
    
    
}
