
package wang.interview.worksap;

/**
 *
 * @author wang-w
 */
public class SequentialEquivalentStrategy<T extends Comparable> implements Strategy<T>{
    @Override
    public boolean isValid(T x, T y){
        return y.equals(x);
    }
}
