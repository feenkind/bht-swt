package TDD;

public class TDDMethods {
    public String changeToEur(String stringToExchange, String text) {
        String replacedText = text.replaceAll("Euro", "€");
        return replacedText;
    }
}
