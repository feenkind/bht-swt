package TDD;

public class TDDMethods {
    /**
     * Method to replace any string with €.
     *
     * @param stringToExchange string that should be replaced with €
     * @param text text that should be searched
     * @return the text with replaced strings
     * @throws IllegalArgumentException if any parameter is null
     */
    public String changeToEur(String stringToExchange, String text) throws IllegalArgumentException {
        if (stringToExchange == null || text == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }

        if (stringToExchange.equals("")) {
            return text;
        }

        return text.replaceAll(stringToExchange, "€");
    }

    public int countImages(String text) {
        int lengthImage = "<image>".length();
        int count = 0;
        int imageIndex = text.indexOf("<image>");

        while(imageIndex != -1) {
            text = text.substring(imageIndex + lengthImage);
            count ++;
            imageIndex = text.indexOf("<image>");
        }

        return count;
    }
}
