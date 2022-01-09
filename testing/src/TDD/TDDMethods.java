package TDD;

public class TDDMethods {
    public String changeToEur(String stringToExchange, String text) {
        if (stringToExchange.equals("")) {
            return text;
        }

        return text.replaceAll(stringToExchange, "€");
    }
}
