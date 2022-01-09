package TDD;

import normalTest.User;
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
}