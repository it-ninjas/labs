import lists.MyArrayListExtended;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListExtendedTest {

    static final String ELEMENT_FIRST = "First";
    static final String ELEMENT_SECOND = "Second";
    static final String ELEMENT_THIRD = "Third";
    static final String ELEMENT_FOURTH = "Fourth";
    static final String ELEMENT_FIFTH = "Fifth";

    MyArrayListExtended<String> listEmpty;
    MyArrayListExtended<String> listWithThirdElements;

    @BeforeEach
    void setUp() {
        listEmpty = new MyArrayListExtended<>();
        listWithThirdElements = new MyArrayListExtended<>();
        listWithThirdElements.add(ELEMENT_FIRST);
        listWithThirdElements.add(null);
        listWithThirdElements.add(ELEMENT_THIRD);
    }

    @AfterEach
    void tearDown() {
    }

    @Nested
    @DisplayName("standard methods")
    class MyListInterfaceSimpleTest {
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
            listEmpty.add(ELEMENT_FIRST);
            assertFalse(listEmpty.isEmpty());
            assertEquals(3, listEmpty.size());
            assertTrue(listEmpty.contains(null));
            assertTrue(listEmpty.contains(ELEMENT_FIRST));
            assertNull(listEmpty.get(0));
            assertNull(listEmpty.remove(0));
            assertEquals(2, listEmpty.size());
            assertNull(listEmpty.remove(0));
            assertEquals(ELEMENT_FIRST, listEmpty.remove(0));
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

    @Nested
    @DisplayName("extended methods")
    class MyListInterfaceExtendedTest {
        @Test
        void shouldAddWithIndexInOrder() {
            listEmpty.add(0, ELEMENT_FIRST);
            assertFalse(listEmpty.isEmpty());
            assertEquals(1, listEmpty.size());
            assertEquals(ELEMENT_FIRST, listEmpty.get(0));

            listEmpty.add(1, ELEMENT_SECOND);
            assertFalse(listEmpty.isEmpty());
            assertEquals(2, listEmpty.size());
            assertEquals(ELEMENT_FIRST, listEmpty.get(0));
            assertEquals(ELEMENT_SECOND, listEmpty.get(1));
        }

        @Test
        void shouldAddWithFirstIndex() {
            listWithThirdElements.add(0, ELEMENT_FOURTH);
            assertFalse(listWithThirdElements.isEmpty());
            assertEquals(4, listWithThirdElements.size());
            assertEquals(ELEMENT_FOURTH, listWithThirdElements.get(0));
            assertEquals(ELEMENT_FIRST, listWithThirdElements.get(1));
            assertNull(listWithThirdElements.get(2));
            assertEquals(ELEMENT_THIRD, listWithThirdElements.get(3));
        }

        @Test
        void shouldAddWithSecondIndex() {
            listWithThirdElements.add(1, ELEMENT_FOURTH);
            assertFalse(listWithThirdElements.isEmpty());
            assertEquals(4, listWithThirdElements.size());
            assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
            assertEquals(ELEMENT_FOURTH, listWithThirdElements.get(1));
            assertNull(listWithThirdElements.get(2));
            assertEquals(ELEMENT_THIRD, listWithThirdElements.get(3));
        }

        @Test
        void shouldAddWithLastIndex() {
            listWithThirdElements.add(3, ELEMENT_FOURTH);
            assertFalse(listWithThirdElements.isEmpty());
            assertEquals(4, listWithThirdElements.size());
            assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
            assertNull(listWithThirdElements.get(1));
            assertEquals(ELEMENT_THIRD, listWithThirdElements.get(2));
            assertEquals(ELEMENT_FOURTH, listWithThirdElements.get(3));
        }

        @Test
        void shouldAddWithToBigIndex() {
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listEmpty.add(10, ELEMENT_FIFTH)
            );
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listWithThirdElements.add(10, ELEMENT_FIFTH)
            );
        }

        @Test
        void shouldAddWithMinusIndex() {
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listWithThirdElements.add(-1, ELEMENT_FIFTH)
            );
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listEmpty.add(-1, ELEMENT_FIFTH)
            );
        }

        @Test
        void shouldContainsOrNotElements() {
            assertTrue(listWithThirdElements.contains(ELEMENT_FIRST));
            assertTrue(listWithThirdElements.contains(null));
            assertTrue(listWithThirdElements.contains(ELEMENT_THIRD));
            assertFalse(listWithThirdElements.contains(ELEMENT_FOURTH));
            assertFalse(listWithThirdElements.contains(ELEMENT_FIFTH));
        }

        @Test
        void shouldNotContainsElementsOnEmptyList() {
            assertFalse(listEmpty.contains(ELEMENT_FIRST));
            assertFalse(listEmpty.contains(ELEMENT_FOURTH));
        }

        @Test
        void shouldNotContainsNull() {
            assertFalse(listEmpty.contains(null));

            listEmpty.add(ELEMENT_FIRST);
            listEmpty.add(ELEMENT_SECOND);
            assertFalse(listEmpty.contains(null));
        }

        @Test
        void shouldGetIndexOfElement() {
            assertEquals(0, listWithThirdElements.indexOf(ELEMENT_FIRST));
            assertEquals(1, listWithThirdElements.indexOf(null));
            assertEquals(2, listWithThirdElements.indexOf(ELEMENT_THIRD));
            assertEquals(-1, listWithThirdElements.indexOf(ELEMENT_FOURTH));
            assertEquals(-1, listWithThirdElements.indexOf(ELEMENT_FIFTH));
        }

        @Test
        void shouldReplaceFirstElement() {
            assertEquals(ELEMENT_FIRST, listWithThirdElements.set(0, ELEMENT_FOURTH));
            assertEquals(3, listWithThirdElements.size());
            assertEquals(ELEMENT_FOURTH, listWithThirdElements.get(0));
            assertNull(listWithThirdElements.get(1));
            assertEquals(ELEMENT_THIRD, listWithThirdElements.get(2));
        }

        @Test
        void shouldReplaceSecondElement() {
            assertNull(listWithThirdElements.set(1, ELEMENT_FOURTH));
            assertEquals(3, listWithThirdElements.size());
            assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
            assertEquals(ELEMENT_FOURTH, listWithThirdElements.get(1));
            assertEquals(ELEMENT_THIRD, listWithThirdElements.get(2));
        }

        @Test
        void shouldReplaceLastElement() {
            assertEquals(ELEMENT_THIRD, listWithThirdElements.set(2, ELEMENT_FOURTH));
            assertEquals(3, listWithThirdElements.size());
            assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
            assertNull(listWithThirdElements.get(1));
            assertEquals(ELEMENT_FOURTH, listWithThirdElements.get(2));
        }

        @Test
        void shouldReplaceWithNull() {
            assertEquals(ELEMENT_THIRD, listWithThirdElements.set(2, null));
            assertEquals(3, listWithThirdElements.size());
            assertNull(listWithThirdElements.get(2));
        }

        @Test
        void shouldReplaceNullWithAElement() {
            listEmpty.add(null);
            listEmpty.add(ELEMENT_SECOND);
            assertEquals(2, listEmpty.size());

            assertNull(listEmpty.set(0, ELEMENT_FIRST));
            assertEquals(2, listEmpty.size());
            assertEquals(ELEMENT_FIRST, listEmpty.get(0));
        }

        @Test
        void shouldNotGetIndexOfEmptyList() {
            assertEquals(-1, listEmpty.indexOf(ELEMENT_FIRST));
            assertEquals(-1, listEmpty.indexOf(ELEMENT_FIFTH));
        }

        @Test
        void shouldNotGetIndexOfNull() {
            assertEquals(-1, listEmpty.indexOf(null));

            listEmpty.add(ELEMENT_FIRST);
            listEmpty.add(ELEMENT_SECOND);
            assertEquals(-1, listEmpty.indexOf(null));
        }

        @Test
        void shouldNotSetElementWithToBigIndex() {
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listEmpty.set(10, ELEMENT_FIFTH)
            );
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listWithThirdElements.set(10, ELEMENT_FIFTH)
            );
        }

        @Test
        void shouldNotSetElementWithMinusIndex() {
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listEmpty.set(-1, ELEMENT_FIFTH)
            );
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listWithThirdElements.set(-1, ELEMENT_FIFTH)
            );
        }

        @Test
        void shouldRemoveFirstElement() {
            assertTrue(listWithThirdElements.remove(ELEMENT_FIRST));
            assertEquals(2, listWithThirdElements.size());
            assertFalse(listWithThirdElements.contains(ELEMENT_FIRST));
            assertNull(listWithThirdElements.get(0));
            assertEquals(ELEMENT_THIRD, listWithThirdElements.get(1));
        }

        @Test
        void shouldRemoveSecondElement() {
            assertTrue(listWithThirdElements.remove(null));
            assertEquals(2, listWithThirdElements.size());
            assertFalse(listWithThirdElements.contains(ELEMENT_SECOND));
            assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
            assertEquals(ELEMENT_THIRD, listWithThirdElements.get(1));
        }

        @Test
        void shouldRemoveLastElement() {
            assertTrue(listWithThirdElements.remove(ELEMENT_THIRD));
            assertEquals(2, listWithThirdElements.size());
            assertFalse(listWithThirdElements.contains(ELEMENT_THIRD));
            assertEquals(ELEMENT_FIRST, listWithThirdElements.get(0));
            assertNull(listWithThirdElements.get(1));
        }

        @Test
        void shouldRemoveNullElement() {
            listEmpty.add(null);
            listEmpty.add(ELEMENT_SECOND);
            assertEquals(2, listEmpty.size());

            assertTrue(listEmpty.remove(null));
            assertEquals(1, listEmpty.size());
            assertFalse(listEmpty.contains(null));
            assertEquals(ELEMENT_SECOND, listEmpty.get(0));
        }

        @Test
        void shouldRemoveNotExistingElement() {
            assertThrows(IndexOutOfBoundsException.class, () ->
                    listWithThirdElements.remove(ELEMENT_FIFTH)
            );
        }
    }
}