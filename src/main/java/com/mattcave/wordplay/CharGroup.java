package com.mattcave.wordplay;

import java.util.Map;

/**
 * Represents a group of distinct characters and their respective counts.
 */
public interface CharGroup {

    /**
     * Returns the unique characters and the respective count for each.
     * @return a map where each unique character is a key to its count as the mapped value
     */
    Map<Character, Integer> charCounts();

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
}
