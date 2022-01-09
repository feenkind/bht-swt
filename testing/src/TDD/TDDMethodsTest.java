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
    @DisplayName("Test fuction changeToEur with exhange parameter null")
    void loginException() {
        assertThrows(IllegalArgumentException.class,
                () -> tddMethods.changeToEur(null, "I have 500 Euro, you have 800 Euro."),
                "String to exchange must not be null.");
    }
}