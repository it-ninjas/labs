import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testing.Dictionary;
import testing.DictionaryRepository;
import testing.DictionaryStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DictionaryTest {

    private DictionaryRepository repository;
    private Dictionary dictionary;

    @BeforeEach
    public void setUp() {
        repository = mock(DictionaryRepository.class);
        dictionary = new Dictionary(repository);
    }

    @Test
    public void givenNonExistingWord_whenAddOrUpdateWord_thenAdded() {
        String word = "apple";
        String definition = "A fruit.";
        when(repository.getDefinition(word)).thenReturn(null);

        DictionaryStatus result = dictionary.addOrUpdateWord(word, definition);

        verify(repository).add(word, definition);
        verify(repository, times(0)).update(any(), any());
        assertEquals(DictionaryStatus.ADDED, result);
    }

    @Test
    public void givenExistingWord_whenAddOrUpdateWord_thenUpdated() {
        String word = "apple";
        String definition = "A sweet fruit.";
        when(repository.getDefinition(word)).thenReturn("A fruit.");

        DictionaryStatus result = dictionary.addOrUpdateWord(word, definition);

        verify(repository, times(0)).add(any(), any());
        verify(repository).update(word, definition);
        assertEquals(DictionaryStatus.UPDATED, result);
    }

    @Test
    public void givenEmptyWord_whenAddOrUpdateWord_thenInvalid() {
        String word = "";
        String definition = "Invalid word.";

        DictionaryStatus result = dictionary.addOrUpdateWord(word, definition);

        verify(repository, times(0)).add(any(), any());
        verify(repository, times(0)).update(any(), any());
        assertEquals(DictionaryStatus.INVALID, result);
    }

    @Test
    public void givenWordWithNumbers_whenAddOrUpdateWord_thenInvalid() {
        String word = "apple123";
        String definition = "Invalid word with numbers.";

        DictionaryStatus result = dictionary.addOrUpdateWord(word, definition);

        verify(repository, times(0)).add(any(), any());
        verify(repository, times(0)).update(any(), any());
        assertEquals(DictionaryStatus.INVALID, result);
    }

    @Test
    public void givenExistingWord_whenGetDefinition_thenDefinitionReturned() {
        String word = "apple";
        String expectedDefinition = "A fruit.";
        when(repository.getDefinition(word)).thenReturn(expectedDefinition);

        String result = dictionary.getDefinition(word);

        verify(repository).getDefinition(word);
        assertEquals(expectedDefinition, result);
    }

    @Test
    public void givenNonExistingWord_whenGetDefinition_thenNotFoundMessage() {
        String word = "banana";
        when(repository.getDefinition(word)).thenReturn(null);

        String result = dictionary.getDefinition(word);

        verify(repository).getDefinition(word);
        assertEquals("Das Wort " + word + " konnte im Wörterbuch nicht gefunden werden", result);
    }

}
