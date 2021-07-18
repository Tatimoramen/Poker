package poker;

import java.util.*;
import java.util.stream.Collectors;

public final class Hand implements Comparable<Hand> {
    private final List<Card> cardsProvided;
    private HandType handType = null;

    public List<Card> getCardsProvided() {
        return cardsProvided;
    }

    Hand(final String handAsString) {
        List<String> cards = Arrays.asList(handAsString.toUpperCase().split(" "));
        cardsProvided = cards.stream()
                .map(Card::new)
                .sorted()
                .collect(Collectors.toList());
        handType = identifyType();

    }

    @Override
    public String toString() {
        return getCardsProvided()
                .stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .toString();
    }

    @Override
    public int compareTo(Hand o) {
        for (int i = 0; i < getCardsProvided().size(); i++ ) {
            int value1 = cardsProvided.get(i).getValue().getValueInt();
            int value2 = o.cardsProvided.get(i).getValue().getValueInt();
            if (value1 < value2) {
                return -1;
            } else if (value1 > value2) {
                return 1;
            }
        }
        return 0;
    }

    private HandType identifyType() {
        if (valuePair() == 1) {
            return HandType.PAIR;
        }else if(fourOfaKind() ==1){
            return HandType.FOUR_OF_A_KIND;
        }else if(fullHouse() == 1){
            return HandType.FULL_HOUSE;
        } else if (three_of_a_kind() == 1) {
            return HandType.THREE_OF_A_KIND;
        }else if (valueTwoPair() == 1) {
            return HandType.TWO_PAIRS;
        }else if(straightFlush() == 1){
            return HandType.STRAIGHT_FLUSH;
        }else if (straight() == 1) {
            return HandType.STRAIGHT;
        }else if (flush() == 1) {
            return HandType.FLUSH;
        }
        return HandType.HIGH_CARD;
    }

    private int valuePair() {
        int counter = 0;
        for (int i = 1; i < cardsProvided.size(); i++) {
            if (cardsProvided.get(i - 1).getValue().equals(cardsProvided.get(i).getValue())) {
                counter++;
            }
        }
        if (counter == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int valueTwoPair() {
        int counter = 0;
        for (int i = 1; i < cardsProvided.size(); i++) {
            if (cardsProvided.get(i - 1).getValue().equals(cardsProvided.get(i).getValue())) {
                counter++;
            }
        }
        if (counter == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int three_of_a_kind() {
        if (cardsProvided.get(0).getValue().equals(cardsProvided.get(2).getValue()) ||
                cardsProvided.get(2).getValue().equals(cardsProvided.get(4).getValue())) {
            return 1;
        }
        return 0;

    }

    private int straight() {
        int counter = 0;
        for (int i = 1; i < cardsProvided.size(); i++) {
            if (cardsProvided.get(i - 1).getValue().getValueInt() == (cardsProvided.get(i).getValue().getValueInt() + 1)) {
                counter++;
            }
        }
        if (counter == 4) {
            return 1;
        }
        return 0;
    }

    private int flush() {
        int counter = 0;
        for (int i = 1; i < cardsProvided.size(); i++) {
            if (cardsProvided.get(i - 1).getSuit().equals(cardsProvided.get(i).getSuit())) {
                counter++;
            }
        }
        if (counter == 4) {
            return 1;
        }
        return 0;
    }

    public int fullHouse() {
        int comparison = 0;
        for (int i =1; i < cardsProvided.size(); i++) {
            if (cardsProvided.get(i - 1).getValue().equals(cardsProvided.get(i).getValue())) {
                comparison++;
            }
        }
        if (comparison == 3) return 1;
        return 0;
    }
    public int fourOfaKind(){
        if (cardsProvided.get(0).getValue().equals(cardsProvided.get(3).getValue()) ||
                cardsProvided.get(1).getValue().equals(cardsProvided.get(4).getValue())) {
            return 1;
        }
        return 0;
    }

    private int straightFlush() {
        int counter = 0;
        for (int i = 1; i < cardsProvided.size(); i++) {
            if (cardsProvided.get(i - 1).getValue().getValueInt() == (cardsProvided.get(i).getValue().getValueInt() + 1)) {
                if (cardsProvided.get(i - 1).getSuit().equals(cardsProvided.get(i).getSuit())) {
                    counter++;
                }
            }
        }
        if (counter == 4) {
            return 1;
        }
        return 0;
    }


    public HandType getHandType() {
        return handType;
    }
}
