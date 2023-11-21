package lists;

public interface MyListInterfaceSimple<E> {

    /**
     * Appends the specified element to the end of this list .
     *
     * @param element element to be appended to this list
     */
    void add(E element);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index) throws IndexOutOfBoundsException;

    /**
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list.
     * soll IndexOutOfBoundsException werfen
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    E remove(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the number of elements in this list.
     * If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Removes all the elements from this list. The list will be empty after this call returns.
     */
    void clear();
}
