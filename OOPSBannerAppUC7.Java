/**
 * OOPSBannerApp UC7 – Store Character Pattern in a Class
 *
 * This use case extends UC6 by implementing a CharacterPatternMap class
 * to encapsulate character-to-pattern mappings.
 *
 * @author Developer
 * @version 7.0
 */

public class OOPSBannerApp {

    /**
     * Inner static class to store character and its ASCII pattern
     */
    static class CharacterPatternMap {

        private Character character;
        private String[] pattern;

        /**
         * Constructor
         * @param character character to map
         * @param pattern ASCII pattern (7 lines)
         */
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        /**
         * Getter for character
         * @return mapped character
         */
        public Character getCharacter() {
            return character;
        }

        /**
         * Getter for pattern
         * @return ASCII pattern
         */
        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Create and initialize character pattern mappings
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        CharacterPatternMap[] maps = new CharacterPatternMap[4];

        String[] O = {
                " *** ",
                "*   *",
                "*   *",
                "*   *",
                "*   *",
                "*   *",
                " *** "
        };

        String[] P = {
                "**** ",
                "*   *",
                "*   *",
                "**** ",
                "*    ",
                "*    ",
                "*    "
        };

        String[] S = {
                " ****",
                "*    ",
                "*    ",
                " *** ",
                "    *",
                "    *",
                "**** "
        };

        String[] SPACE = {
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        };

        maps[0] = new CharacterPatternMap('O', O);
        maps[1] = new CharacterPatternMap('P', P);
        maps[2] = new CharacterPatternMap('S', S);
        maps[3] = new CharacterPatternMap(' ', SPACE);

        return maps;
    }

    /**
     * Get ASCII pattern for a given character
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {

        for (CharacterPatternMap map : maps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }

        return maps[3].getPattern(); // return space if not found
    }

    /**
     * Print banner message
     */
    public static void printMessage(String message, CharacterPatternMap[] maps) {

        for (int i = 0; i < 7; i++) {

            StringBuilder line = new StringBuilder();

            for (int j = 0; j < message.length(); j++) {
                String[] pattern = getCharacterPattern(message.charAt(j), maps);
                line.append(pattern[i]).append("  ");
            }

            System.out.println(line);
        }
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        CharacterPatternMap[] maps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, maps);
    }
}