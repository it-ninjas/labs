import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import set.MySet;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {
    static final String ELEMENT_FIRST = "First";
    static final String ELEMENT_SECOND = "Second";
    static final String ELEMENT_THIRD = "Third";

    MySet<String> setEmpty;
    MySet<String> setWithThirdElements;

    @BeforeEach
    void setUp() {
        setEmpty = new MySet<>();
        setWithThirdElements = new MySet<>();
        setWithThirdElements.add(ELEMENT_FIRST);
        setWithThirdElements.add(null);
        setWithThirdElements.add(ELEMENT_THIRD);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldInitialiseListWithZeroElements() {
        assertTrue(setEmpty.isEmpty());
        assertEquals(0, setEmpty.size());
        assertFalse(setEmpty.contains(ELEMENT_FIRST));
    }

    @Test
    void shouldGetIsEmpty() {
        assertTrue(setEmpty.isEmpty());
        assertFalse(setWithThirdElements.isEmpty());
    }

    @Test
    void shouldAddElementSet() {
        assertTrue(setEmpty.add(ELEMENT_FIRST));
        assertTrue(setEmpty.add(ELEMENT_SECOND));
        assertFalse(setEmpty.add(ELEMENT_FIRST));
        assertEquals(2, setEmpty.size());
    }

    @Test
    void shouldAddNullElementSet() {
        assertTrue(setEmpty.add(null));
        assertTrue(setEmpty.add(ELEMENT_SECOND));
        assertFalse(setEmpty.add(null));
        assertEquals(2, setEmpty.size());
    }

    @Test
    void shouldRemoveFirstElement() {
        setWithThirdElements.remove(ELEMENT_FIRST);
        assertEquals(2, setWithThirdElements.size());
        assertFalse(setWithThirdElements.contains(ELEMENT_FIRST));
    }

    @Test
    void shouldRemoveLastElement() {
        assertTrue(setWithThirdElements.remove(ELEMENT_THIRD));
        assertEquals(2, setWithThirdElements.size());
        assertFalse(setWithThirdElements.contains(ELEMENT_THIRD));
    }

    @Test
    void shouldRemoveNullElement() {
        assertTrue(setWithThirdElements.remove(null));
        assertEquals(2, setWithThirdElements.size());
        assertFalse(setWithThirdElements.contains(null));
    }

    @Test
    void shouldRemoveNotExistingElement() {
        assertFalse(setWithThirdElements.remove(ELEMENT_SECOND));
        assertEquals(3, setWithThirdElements.size());
    }

    @Test
    void shouldContainsElement() {
        assertTrue(setWithThirdElements.contains(ELEMENT_FIRST));
        assertTrue(setWithThirdElements.contains(null));
        assertTrue(setWithThirdElements.contains(ELEMENT_THIRD));
        assertFalse(setWithThirdElements.contains(ELEMENT_SECOND));
        assertEquals(3, setWithThirdElements.size());
    }

    @Test
    void shouldGetSize() {
        assertEquals(0, setEmpty.size());
        assertTrue(setEmpty.add(ELEMENT_FIRST));
        assertEquals(1, setEmpty.size());

        assertEquals(3, setWithThirdElements.size());
        assertTrue(setWithThirdElements.remove(ELEMENT_FIRST));
        assertTrue(setWithThirdElements.remove(ELEMENT_THIRD));
        assertEquals(1, setWithThirdElements.size());
        assertTrue(setWithThirdElements.remove(null));
        assertEquals(0, setWithThirdElements.size());
    }

    @Test
    void shouldIsEmpty() {
        assertTrue(setEmpty.isEmpty());
        assertTrue(setEmpty.add(ELEMENT_FIRST));
        assertFalse(setEmpty.isEmpty());

        assertFalse(setWithThirdElements.isEmpty());
        assertTrue(setWithThirdElements.remove(ELEMENT_FIRST));
        assertTrue(setWithThirdElements.remove(ELEMENT_THIRD));
        assertFalse(setWithThirdElements.isEmpty());
        assertTrue(setWithThirdElements.remove(null));
        assertTrue(setWithThirdElements.isEmpty());
    }

    @Test
    void shouldClear() {
        setWithThirdElements.clear();
        assertTrue(setWithThirdElements.isEmpty());
        assertEquals(0, setWithThirdElements.size());
    }
}