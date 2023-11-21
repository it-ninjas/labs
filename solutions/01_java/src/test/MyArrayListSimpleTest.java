import lists.MyArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListSimpleTest {

    static final String ELEMENT_FIRST = "First";
    static final String ELEMENT_SECOND = "Second";
    static final String ELEMENT_THIRD = "Third";

    MyArrayList<String> listEmpty;
    MyArrayList<String> listWithThirdElements;

    @BeforeEach
    void setUp() {
        listEmpty = new MyArrayList<>();
        listWithThirdElements = new MyArrayList<>();
        listWithThirdElements.add(ELEMENT_FIRST);
        listWithThirdElements.add(null);
        listWithThirdElements.add(ELEMENT_THIRD);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldInitialiseListWithZeroElements() {
        assertTrue(listEmpty.isEmpty());
        assertEquals(0, listEmpty.size());
    }

    @Test
    void shouldGetIsEmpty() {
        assertTrue(listEmpty.isEmpty());
        assertFalse(listWithThirdElements.isEmpty());
    }

    @Test
    void shouldGetSize() {
        assertEquals(0, listEmpty.size());
        assertEquals(3, listWithThirdElements.size());
    }

    @Test
    void shouldAddTwoElementToEmptyList() {
        listEmpty.add(ELEMENT_FIRST);
        assertFalse(listEmpty.isEmpty());
        assertEquals(1, listEmpty.size());
        assertEquals(ELEMENT_FIRST, listEmpty.get(0));

        listEmpty.add(ELEMENT_SECOND);
        assertFalse(listEmpty.isEmpty());
        assertEquals(2, listEmpty.size());
        assertEquals(ELEMENT_FIRST, listEmpty.get(0));
        assertEquals(ELEMENT_SECOND, listEmpty.get(1));
    }

    @Test
    void shouldAddTwoSameElementToEmptyList() {
        listEmpty.add(ELEMENT_FIRST);
        assertFalse(listEmpty.isEmpty());
        assertEquals(1, listEmpty.size());
        assertEquals(ELEMENT_FIRST, listEmpty.get(0));

        listEmpty.add(ELEMENT_FIRST);
        assertFalse(listEmpty.isEmpty());
        assertEquals(2, listEmpty.size());
        assertEquals(ELEMENT_FIRST, listEmpty.get(0));
        assertEquals(ELEMENT_FIRST, listEmpty.get(1));
    }

    @Test
    void shouldAddNullElement() {
        listEmpty.add(null);
        listEmpty.add(null);
        assertFalse(listEmpty.isEmpty());
        assertEquals(2, listEmpty.size());
        assertNull(listEmpty.get(0));
        assertNull(listEmpty.remove(0));
        assertEquals(1, listEmpty.size());
        assertNull(listEmpty.remove(0));
        assertEquals(0, listEmpty.size());
        assertTrue(listEmpty.isEmpty());
    }

    @Test
    void shouldGetWithIndex() {
        assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
        assertNull(listWithThirdElements.get(1));
        assertEquals(ELEMENT_THIRD, listWithThirdElements.get(2));
    }

    @Test
    void shouldNotGetWithToBigIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listWithThirdElements.get(4)
        );
    }

    @Test
    void shouldNotGetWithMinusIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listWithThirdElements.get(-1)
        );
    }

    @Test
    void shouldRemoveFirstElement() {
        assertEquals(ELEMENT_FIRST, listWithThirdElements.remove(0));
        assertFalse(listWithThirdElements.isEmpty());
        assertEquals(2, listWithThirdElements.size());
        assertNull(listWithThirdElements.get(0));
        assertEquals(ELEMENT_THIRD, listWithThirdElements.get(1));
    }

    @Test
    void shouldRemoveMiddleElement() {
        assertNull(listWithThirdElements.remove(1));
        assertFalse(listWithThirdElements.isEmpty());
        assertEquals(2, listWithThirdElements.size());
        assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
        assertEquals(ELEMENT_THIRD, listWithThirdElements.get(1));

        assertEquals(ELEMENT_FIRST, listWithThirdElements.remove(0));
        assertFalse(listWithThirdElements.isEmpty());
        assertEquals(ELEMENT_THIRD, listWithThirdElements.get(0));
    }

    @Test
    void shouldRemoveLastElement() {
        assertEquals(ELEMENT_THIRD, listWithThirdElements.remove(2));
        assertFalse(listWithThirdElements.isEmpty());
        assertEquals(2, listWithThirdElements.size());
        assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
        assertNull(listWithThirdElements.get(1));
    }

    @Test
    void shouldNotRemoveWithToBigIndex() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                listWithThirdElements.remove(4)
        );
    }

    @Test
    void shouldNotRemoveWithMinusIndex() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                listWithThirdElements.remove(-1)
        );
    }

    @Test
    void shouldClearAllElements() {
        listWithThirdElements.clear();
        assertTrue(listEmpty.isEmpty());
        assertEquals(0, listEmpty.size());
    }

    @Test
    void shouldClearAlsoEmptyList() {
        listEmpty.clear();
        assertTrue(listEmpty.isEmpty());
        assertEquals(0, listEmpty.size());
    }
}