package poker;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {
    private final List<Hand> hands;

    public Poker(final List<String> hands) {
        //Convert strings to Hand objects
        this.hands = hands.stream()
                .map(Hand::new)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getBestHands() {
        //Check if list of hands is empty
        if (hands.isEmpty()) {
            return Collections.emptyList();
        }
        
        //Get first hand to compare against the others  List hands -> Position: 0 = highest8, Position: 1 = highest10,  Position: 2 = highestJ
        Hand bestHand = hands.get(hands.size() - 1);
        return hands.stream()
                .filter(hand -> hand.compareTo(bestHand) == 0)
                .map(Hand::toString)
                .collect(Collectors.toList());
    }

    public List<Hand> getHands() {
        return hands;
    }
}
