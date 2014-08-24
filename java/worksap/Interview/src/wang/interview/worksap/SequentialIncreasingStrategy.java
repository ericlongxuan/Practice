
package wang.interview.worksap;

/**
 *
 * @author wang-w
 */
public class SequentialIncreasingStrategy<T extends Comparable> implements Strategy<T>{
    @Override
    public boolean isValid(T x, T y){
        return y.compareTo(x) > 0;
    }
}
