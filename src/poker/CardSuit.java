package poker;

import java.util.HashMap;
import java.util.Map;

public enum CardSuit {
    CLUBS('C'),
    DIAMONDS('D'),
    HEARTS('H'),
    SPADES('S');

    private final char suitChar;
    private static final Map<Character, CardSuit> MAP = new HashMap<>();

    CardSuit(final char suitChar) {
        this.suitChar = suitChar;
    }

    public static CardSuit getCardSuitBySuit(char suit) {
        return MAP.get(suit);
    }

    static {
        for (CardSuit cardSuit : values()) {
            MAP.put(cardSuit.getSuitChar(), cardSuit);
        }
    }
    char getSuitChar() {
        return suitChar;
    }
}
