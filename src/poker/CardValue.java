package poker;

import java.util.HashMap;
import java.util.Map;

public enum CardValue {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5",5),
    SIX("6", 6),
    SEVEN("7",7),
    EIGHT("8",8),
    NINE("9",9),
    TEN("10", 10),
    JACK("J",11),
    QUEEN("Q",12),
    KING("K",13),
    ACE("A",14);

    private final String valueString;
    private final int valueInt;
    private static final Map<String, CardValue> MAP = new HashMap<>();


    private CardValue(final String valueString, final int valueInt) {
        this.valueString = valueString;
        this.valueInt = valueInt;
    }

    public static CardValue getCardValueByValue(String value) {
        return MAP.get(value);
    }

    static {
        for (CardValue cardValue : values()) {
            MAP.put(cardValue.getValueString(), cardValue);
        }
    }

    String getValueString() {
        return valueString;
    }

    int getValueInt() {
        return valueInt;
    }
}
