package TDD;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class TDDMethodsTest {
    TDDMethods tddMethods;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.tddMethods = new TDDMethods();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function changeToEur successfully")
    void changeToEurSuccessfully() {
        assertEquals("I have 500 €, you have 800 €.", tddMethods.changeToEur("Euro", "I have 500 Euro, you have 800 Euro."));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function changeToEur without occurence of exchange parameter")
    void changeToEurWithoutOccurence() {
        assertEquals("I have 500 Dollars, you have 800 Dollars.", tddMethods.changeToEur("Euro", "I have 500 Dollars, you have 800 Dollars."));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function changeToEur with empty exhange parameter")
    void changeToEurWithEmptyStringToExchange() {
        assertEquals("I have 500 Dollars, you have 800 Dollars.", tddMethods.changeToEur("", "I have 500 Dollars, you have 800 Dollars."));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function changeToEur with empty text parameter")
    void changeToEurWithEmptyText() {
        assertEquals("", tddMethods.changeToEur("Euro", ""));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function changeToEur with parameter null")
    void loginException() {
        assertThrows(IllegalArgumentException.class,
                () -> tddMethods.changeToEur(null, "I have 500 Euro, you have 800 Euro."),
                "Parameters must not be null.");

        assertThrows(IllegalArgumentException.class,
                () -> tddMethods.changeToEur("Euro", null),
                "Parameters must not be null.");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function countImages successfully")
    void countImagesSuccessfully() {
        assertEquals(5, tddMethods.countImages("<image> This is a headline. <image> Some content. <image><image> Some more content. <image>"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function countImages when no image exists")
    void countImagesWithoutImages() {
        assertEquals(0, tddMethods.countImages("This is a headline. Some content. Some more content."));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function countImages with empty text")
    void countImagesWithEmptyText() {
        assertEquals(0, tddMethods.countImages(""));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test function countImages with null text")
    void countImagesWithNulText() {
        assertThrows(IllegalArgumentException.class, () -> tddMethods.countImages(null), "Text must not be null.");
    }
}