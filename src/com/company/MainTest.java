package com.company;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainTest {

    @Test
    public void test(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn(new String[]{"Hello"});

        assertEquals(main.readInputFile("input.txt")[0], "Hello");
    }

    @Test
    public void testWordFilter(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn(new String[]{"the", "end!"});

        String[] text = main.readInputFile("input.txt");
        String[] filtered = Main.filter(text);
        for (String value : Main.map.keySet()) {
            for (String word : filtered) {
                assertNotEquals(word, value);
            }
        }
    }

    @Test
    public void testPunctuationsFilter(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn(new String[]{"the", "?end!"});

        String[] text = main.readInputFile("input.txt");
        String[] filtered = Main.filter(text);
        for (String value : Main.punctuations) {
            for (String word : filtered) {
                assertFalse(word.contains(value));
            }
        }
    }
}