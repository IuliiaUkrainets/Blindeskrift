package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class MainTest {

    @Test
    public void test(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("Hello");

        assertEquals(main.readInputFile("input.txt"), "Hello");
    }

    @Test
    public void testFilter(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("the end!");

        String text = main.readInputFile("input.txt");
        String filtered = Main.filter(text);
        for (String value : Main.map.keySet()) {
            assertFalse(filtered.contains(value));
        }
    }
}