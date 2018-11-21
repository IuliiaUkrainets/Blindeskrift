package com.company;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainTest {

    @Test
    public void test(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("Hello");

        assertEquals(main.readInputFile("input.txt"), "Hello");
    }

    @Test
    public void testWordFilter(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("the end!");

        String[] text = main.readInputFile("input.txt").split(" ");
        String[] filtered = Main.translate(text);
        for (String value : Main.wordToBraile.keySet()) {
            for (String word : filtered) {
                assertNotEquals(word, value);
            }
        }
    }

    @Test
    public void testPunctuationsFilter(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("the ?end!");

        String[] text = main.readInputFile("input.txt").split(" ");
        String[] filtered = Main.translate(text);
        for (String value : Main.punctuationsToBraile.keySet()) {
            for (String word : filtered) {
                assertFalse(word.contains(value));
            }
        }
    }

    @Test
    public void testNumbersFilter(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("the end 7");

        String[] text = main.readInputFile("input.txt").split(" ");
        String[] filtered = Main.translate(text);
        String value = String.join(" ", filtered);
        for (char c : value.toCharArray()) {
            if (Character.isDigit(c)) {
                fail();
            }
        }
    }

    @Test
    public void testBigLetterFilter(){
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("The end 7");

        String[] text = main.readInputFile("input.txt").split(" ");
        String[] filtered = Main.translate(text);
        String value = String.join(" ", filtered);
        for (char c : value.toCharArray()) {
            if (Main.isBigLetter(c)) {
                fail();
            }
        }
    }

    @Test
    public void testTranslation() {
        Main main = mock(Main.class);

        when(main.readInputFile("input.txt")).thenReturn("Hello all.");

        String[] text = main.readInputFile("input.txt").split(" ");
        String[] filtered = Main.translate(text);
        String value = String.join(" ", filtered);
        assertEquals("⠠⠓⠑⠇⠇⠕ ⠁⠇⠇⠲", value);

    }


}