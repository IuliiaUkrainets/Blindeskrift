package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainTest {

    @Test
    public void test(){
        Main main = mock(Main.class);

        // define return value for method getUniqueId()
        when(main.readInputFile("input.txt")).thenReturn("Hello");

        assertEquals(main.readInputFile("input.txt"), "Hello");
    }

}