package poker;


public final class Card implements Comparable<Card> {
    private final CardSuit suit;
    private final CardValue value;

    Card(final String cardAsString) {
        String[] arr = cardAsString.split("");
        if (cardAsString.length() == 3) {
            value = CardValue.getCardValueByValue(arr[0] + arr[1]);
            String lastLetter = arr[2];
            suit = CardSuit.getCardSuitBySuit(lastLetter.charAt(0));
        }else{
            value = CardValue.getCardValueByValue(arr[0]);
            String lastLetter = arr[1];
            suit = CardSuit.getCardSuitBySuit(lastLetter.charAt(0));
        }
    }

    CardSuit getSuit() {
        return suit;
    }

    CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getValueString() + "" + suit.getSuitChar();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value.getValueInt() == card.value.getValueInt();
    }

    @Override
    public int compareTo(Card o) {
        return o.value.compareTo(this.value);
    }
}
