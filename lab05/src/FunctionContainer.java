/** A general container for a function that returns an object of a generic type, given an object of that same type.
 */
public interface FunctionContainer<T> {
    public T func(T item);
}
