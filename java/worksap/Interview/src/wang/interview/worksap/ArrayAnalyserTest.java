
package wang.interview.worksap;

import java.util.Arrays;

/**
 *
 * @author wang-w
 */
public class ArrayAnalyserTest {
    
    public static void main(String[] arg){
        
        Integer a1[] = {1,2,3,5,6,7,9,3,5,1,6,7,1,3,7,9,1};
        Integer a2[] = {1,1,3,3,3,7,9,1,5};
        Integer a3[] = {9,6,3,3,3,4,6,1,2,2,4,5,6,7};
        Integer a4[] = {1,2};
        Integer a5[] = {1,1};
        Integer a6[] = {1};
        Integer a7[] = {};
        
        Integer b1[] = {1,1,1,1,1,0,1,0,0,0,0,0,0,0};
        Integer b2[] = {1,1};
        Integer b3[] = {1};
        Integer b4[] = {};
        
        Character c1[] = {'a','a','A','b','c','c','a','A','A','A','A'};
        Character c2[] = {'a','b','A','b','c','c','v','v','v','A','A'};
        Character c3[] = {'a'};
        Character c4[] = {};
        
        // Question 1.1
        ArrayAnalyser<Integer> magicTube1 = new ArrayAnalyser<Integer>(new SequentialIncreasingStrategy());
        System.out.println(Arrays.toString(magicTube1.analyse(a1)));
        System.out.println(Arrays.toString(magicTube1.analyse(a2)));
        System.out.println(Arrays.toString(magicTube1.analyse(a3)));
        System.out.println(Arrays.toString(magicTube1.analyse(a4)));
        System.out.println(Arrays.toString(magicTube1.analyse(a5)));
        System.out.println(Arrays.toString(magicTube1.analyse(a6)));
        System.out.println(Arrays.toString(magicTube1.analyse(a7)));
        
        // Question 1.2
        ArrayAnalyser<Integer> magicTube2 = new ArrayAnalyser<Integer>(new SequentialEquivalentStrategy());
        System.out.println(Arrays.toString(magicTube2.analyse(b1)));
        System.out.println(Arrays.toString(magicTube2.analyse(b2)));
        System.out.println(Arrays.toString(magicTube2.analyse(b3)));
        System.out.println(Arrays.toString(magicTube2.analyse(b4)));
        
        // Question 1.3
        ArrayAnalyser<Character> magicTube3 = new ArrayAnalyser<Character>(new SequentialEquivalentStrategy());
        System.out.println(Arrays.toString(magicTube3.analyse(c1)));
        System.out.println(Arrays.toString(magicTube3.analyse(c2)));
        System.out.println(Arrays.toString(magicTube3.analyse(c3)));
        System.out.println(Arrays.toString(magicTube3.analyse(c4)));
        
    }
       
}
