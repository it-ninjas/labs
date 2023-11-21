import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import set.MyHashSet;

public class MyHashSetTest {
    static final String ELEMENT_FIRST = "First";
    static final String ELEMENT_SECOND = "Second";
    static final String ELEMENT_THIRD = "Third";

    MyHashSet<String> setEmpty;
    MyHashSet<String> setWithThirdElements;

    @BeforeEach
    void setUp() {
        setEmpty = new MyHashSet<>();
        setWithThirdElements = new MyHashSet<>();
        setWithThirdElements.add(ELEMENT_FIRST);
        setWithThirdElements.add(null);
        setWithThirdElements.add(ELEMENT_THIRD);
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void shouldInitialiseListWithZeroElements() {
        Assertions.assertTrue(setEmpty.isEmpty());
        Assertions.assertEquals(0, setEmpty.size());
        Assertions.assertFalse(setEmpty.contains(ELEMENT_FIRST));
    }

    @org.junit.jupiter.api.Test
    void shouldGetIsEmpty() {
        Assertions.assertTrue(setEmpty.isEmpty());
        Assertions.assertFalse(setWithThirdElements.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void shouldAddElementSet() {
        Assertions.assertTrue(setEmpty.add(ELEMENT_FIRST));
        Assertions.assertTrue(setEmpty.add(ELEMENT_SECOND));
        Assertions.assertFalse(setEmpty.add(ELEMENT_FIRST));
        Assertions.assertEquals(2, setEmpty.size());
    }

    @org.junit.jupiter.api.Test
    void shouldAddNullElementSet() {
        Assertions.assertTrue(setEmpty.add(null));
        Assertions.assertTrue(setEmpty.add(ELEMENT_SECOND));
        Assertions.assertFalse(setEmpty.add(null));
        Assertions.assertEquals(2, setEmpty.size());
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveFirstElement() {
        setWithThirdElements.remove(ELEMENT_FIRST);
        Assertions.assertEquals(2, setWithThirdElements.size());
        Assertions.assertFalse(setWithThirdElements.contains(ELEMENT_FIRST));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveLastElement() {
        Assertions.assertTrue(setWithThirdElements.remove(ELEMENT_THIRD));
        Assertions.assertEquals(2, setWithThirdElements.size());
        Assertions.assertFalse(setWithThirdElements.contains(ELEMENT_THIRD));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveNullElement() {
        Assertions.assertTrue(setWithThirdElements.remove(null));
        Assertions.assertEquals(2, setWithThirdElements.size());
        Assertions.assertFalse(setWithThirdElements.contains(null));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveNotExistingElement() {
        Assertions.assertFalse(setWithThirdElements.remove(ELEMENT_SECOND));
        Assertions.assertEquals(3, setWithThirdElements.size());
    }

    @org.junit.jupiter.api.Test
    void shouldContainsElement() {
        Assertions.assertTrue(setWithThirdElements.contains(ELEMENT_FIRST));
        Assertions.assertTrue(setWithThirdElements.contains(null));
        Assertions.assertTrue(setWithThirdElements.contains(ELEMENT_THIRD));
        Assertions.assertFalse(setWithThirdElements.contains(ELEMENT_SECOND));
        Assertions.assertEquals(3, setWithThirdElements.size());
    }

    @org.junit.jupiter.api.Test
    void shouldGetSize() {
        Assertions.assertEquals(0, setEmpty.size());
        Assertions.assertTrue(setEmpty.add(ELEMENT_FIRST));
        Assertions.assertEquals(1, setEmpty.size());

        Assertions.assertEquals(3, setWithThirdElements.size());
        Assertions.assertTrue(setWithThirdElements.remove(ELEMENT_FIRST));
        Assertions.assertTrue(setWithThirdElements.remove(ELEMENT_THIRD));
        Assertions.assertEquals(1, setWithThirdElements.size());
        Assertions.assertTrue(setWithThirdElements.remove(null));
        Assertions.assertEquals(0, setWithThirdElements.size());
    }

    @org.junit.jupiter.api.Test
    void shouldIsEmpty() {
        Assertions.assertTrue(setEmpty.isEmpty());
        Assertions.assertTrue(setEmpty.add(ELEMENT_FIRST));
        Assertions.assertFalse(setEmpty.isEmpty());

        Assertions.assertFalse(setWithThirdElements.isEmpty());
        Assertions.assertTrue(setWithThirdElements.remove(ELEMENT_FIRST));
        Assertions.assertTrue(setWithThirdElements.remove(ELEMENT_THIRD));
        Assertions.assertFalse(setWithThirdElements.isEmpty());
        Assertions.assertTrue(setWithThirdElements.remove(null));
        Assertions.assertTrue(setWithThirdElements.isEmpty());
    }

    @Test
    void shouldClear() {
        setWithThirdElements.clear();
        Assertions.assertTrue(setWithThirdElements.isEmpty());
        Assertions.assertEquals(0, setWithThirdElements.size());
    }
}
