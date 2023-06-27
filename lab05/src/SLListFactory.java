/** A factory object that conveniently creates LinkedLists of the specified type.
 */
public class SLListFactory<T> {

    @SafeVarargs
    public final SLList<T> of(T... items) {
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        SLList<T> head = new SLList<T>(items[0]);
        SLList<T> last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new SLList<T>(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */

    public void dFuncList(SLList<T> L, FunctionContainer<T> funcContainer) {
        while (L != null) {
            L.item = funcContainer.func(L.item);
            L = L.next;
        }
    }

    public SLList<T> funcListIterative(SLList<T> L, FunctionContainer<T> funcContainer) {
        if (L == null) {
            return null;
        }
        SLList<T> res = new SLList<T>(funcContainer.func(L.item), null);
        SLList<T> ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new SLList<T>(funcContainer.func(L.item), null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */

    public SLList<T> funcListRecursive(SLList<T> L, FunctionContainer<T> funcContainer) {
        if (L == null) {
            return null;
        }
        return new SLList<T>(funcContainer.func(L.item), funcListRecursive(L.next, funcContainer));
    }

    /**
     * Returns a new SLList<T> consisting of A followed by B,
     * destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public SLList<T> dcatenate(SLList<T> A, SLList<T> B) {
        //TODO: your code here!
        return null;
    }

    /**
     * Returns a new SLList<T> consisting of A followed by B,
     * non-destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
     public SLList<T> catenate(SLList<T> A, SLList<T> B) {
        //TODO: your code here!
         return null;
     }
}
