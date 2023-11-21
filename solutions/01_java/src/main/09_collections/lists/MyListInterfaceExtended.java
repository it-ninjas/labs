package lists;

public interface MyListInterfaceExtended<E> {

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

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the add operation is not supported by this list
     */
    void add(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    boolean contains(Object o);

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    int indexOf(Object o);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E set(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Compares the specified object with this list for equality.
     * Returns true if and only if the specified object is also a list, both lists have the same size,
     * and all corresponding pairs of elements in the two lists are equal.
     *
     * @param o the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    boolean equals(Object o);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    boolean remove(Object o);
}
