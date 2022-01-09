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
    @DisplayName("Test fuction changeToEur successfully")
    void changeToEurSuccessfully() {
        assertEquals("I have 500 €, you have 800 €.", tddMethods.changeToEur("Euro", "I have 500 Euro, you have 800 Euro."));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test fuction changeToEur without occurence of echange parameter")
    void changeToEurWithoutOccurence() {
        assertEquals("I have 500 Dollars, you have 800 Dollars.", tddMethods.changeToEur("Euro", "I have 500 Dollars, you have 800 Dollars."));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test fuction changeToEur with empty exhange paramter")
    void changeToEurWithEmptyStringToExchange() {
        assertEquals("I have 500 Dollars, you have 800 Dollars.", tddMethods.changeToEur("", "I have 500 Dollars, you have 800 Dollars."));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test fuction changeToEur with empty text paramter")
    void changeToEurWithEmptyText() {
        assertEquals("", tddMethods.changeToEur("Euro", ""));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test fuction changeToEur with parameter null")
    void loginException() {
        assertThrows(IllegalArgumentException.class,
                () -> tddMethods.changeToEur(null, "I have 500 Euro, you have 800 Euro."),
                "Parameters must not be null.");

        assertThrows(IllegalArgumentException.class,
                () -> tddMethods.changeToEur("Euro", null),
                "Parameters must not be null.");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test fuction countImages successfully")
    void countImagesSuccessfully() {
        assertEquals(5, tddMethods.countImages("<image> This is a headline. <image> Some content. <image><image> Some more content. <image>"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test fuction countImages when no image exists")
    void countImagesWithoutImages() {
        assertEquals(0, tddMethods.countImages("This is a headline. Some content. Some more content."));
    }
}