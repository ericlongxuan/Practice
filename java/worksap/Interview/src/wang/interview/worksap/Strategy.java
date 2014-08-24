
package wang.interview.worksap;

/**
 *
 * @author wang-w
 */
public interface Strategy<T extends Comparable> {
    public boolean isValid(T x, T y);   
}
