package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    void shouldAdd2Numbers() {
        int firstNumber = 2;
        int secondNumber = 4;
        int actualResult = 6;

        Book book = new Book();
        int expectedResult = book.title(firstNumber, secondNumber);

        assertEquals(expectedResult, actualResult);
    }
}