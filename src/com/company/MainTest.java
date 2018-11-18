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
    public void testFilter(){
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
}