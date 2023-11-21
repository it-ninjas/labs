package set;

public interface MySetInterfaceSimple<E> {

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param element element to be appended to this list
     * @return true if this set did not already contain the specified element
     */
    boolean add(E element);


    /**
     * Removes the specified element from this set if it is present.
     *
     * @param object object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    boolean remove(Object object);

    /**
     * Returns true if this set contains the specified element.
     *
     * @param object element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    public boolean contains(Object object);

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    int size();

    /**
     * Returns true if this set contains no elements.
     *
     * @return true if this set contains no elements
     */
    boolean isEmpty();

    /**
     * Removes all the elements from this set. The set will be empty after this call returns.
     */
    void clear();
}