package com.mattcave.wordplay;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a group of distinct characters and their respective counts.
 */
public interface CharGroup {

    /**
     * Returns the unique characters and the respective count for each.
     *
     * @return a map where each unique character is a key to its count as the mapped value
     */
    Map<Character, Integer> charCounts();

    /**
     * Returns the total count of characters in the group.
     * \
     */
    default int totalCount() {
        return this.charCounts()
                   .entrySet()
                   .stream()
//                   .mapToInt(e -> e.getValue())
                   .mapToInt(Map.Entry::getValue)
                   .sum();
    }


    /**
     * Returns expanded version with each character represented N times for its respective count.
     */
    default char[] toCharArray() {
        List<Character> sortedChars = new ArrayList<>(charCounts().keySet());
        Collections.sort(sortedChars);

        Map<Character, Integer> charCounts = charCounts();

        List<Character> expanded =
                sortedChars.stream()
                           .flatMap(c -> Collections.nCopies(charCounts.get(c), c).stream())
                           .collect(Collectors.toList());

        // TODO: easier way to convert to an array of primitives?
        char[] expChars = new char[expanded.size()];
        int i = 0;
        for (Character c : expanded) {
            expChars[i] = c;
        }

        return expChars;
    }


    /**
     * Tests if current CharGroup is a super set of characters and counts when compared to the
     * other supplied CharGroup.
     *
     * @param other The other CharGroup tested against
     * @return true if this CharGroup contains all characters with same or greater counts as other
     */
    default boolean containsAll(CharGroup other) {
        Map<Character, Integer> myCounts = this.charCounts();

        for (Map.Entry<Character, Integer> otherEntry : other.charCounts().entrySet()) {
            if (myCounts.getOrDefault(otherEntry.getKey(), 0) <
                    otherEntry.getValue()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Creates an instance of {@link CharGroup} from a String.
     */
    static CharGroup from(String letters) {
        return CharGroupSupport.from(letters);
    }

    /**
     * Creates an instance of {@link CharGroup} from an array of chars.
     */
    static CharGroup from(char[] letters) {
        return CharGroupSupport.from(letters);
    }
}
