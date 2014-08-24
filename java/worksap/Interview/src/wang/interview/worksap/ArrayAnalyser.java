
package wang.interview.worksap;

import java.util.Arrays;

/**
 *
 * @author wang-w
 */
public class ArrayAnalyser<T extends Comparable> {

    private Strategy strategy;
    
    public ArrayAnalyser(Strategy strategy){
        this.strategy = strategy;
    }
    
    
    
    public T[] analyse(T[] arr){
        if(arr.length <=1)
            return arr;
        
        int start = 0, end = 0;
        int temp_start = 0, temp_end = 0;
        
        for(int i=1; i<arr.length; i++){
            if(strategy.isValid(arr[i-1], arr[i])){
                temp_end ++;
            }
            else{
                if(temp_end - temp_start > end - start){
                    start = temp_start;
                    end = temp_end;
                }   
                temp_start = i;
                temp_end = i;
            }     
        }
        
        if(temp_end == arr.length -1 && temp_end - temp_start > end - start){
            start = temp_start;
            end = temp_end;
        }
            
        return Arrays.copyOfRange(arr, start, end + 1);      
    }
    
}
