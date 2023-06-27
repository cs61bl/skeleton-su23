public class DLListFactory<T> {
    /** Returns an DLList consisting of the given values. */
    @SafeVarargs
    public final DLList<T> of(T... values) {
        DLList<T> list = new DLList<>();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;
    }
}
