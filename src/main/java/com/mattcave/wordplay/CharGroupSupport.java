package com.mattcave.wordplay;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Support functions related to CharGroup functionality.
 */
public class CharGroupSupport {

    /** Creates an instance of {@link CharGroup} from a String. */
    static CharGroup from(String letters) {
        Objects.requireNonNull(letters, "'letters' string can not be null");

        return from(letters.toCharArray());
    }

    /** Creates an instance of {@link CharGroup} from an array of chars. */
    static CharGroup from(char[] letters) {
        Objects.requireNonNull(letters, "'letters' char array can not be null");

        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : letters) {
            cnts.merge(c, 1, (prev, one) -> prev + one);
        }

        return new CharGroupImpl(cnts);
    }

    /** local implementation of {@link CharGroup} */
    private static class CharGroupImpl implements CharGroup {

        private Map<Character, Integer> charCounts;

        private CharGroupImpl(Map<Character, Integer> cnts) {
            this.charCounts = Collections.unmodifiableMap(cnts);
        }

        @Override
        public Map<Character, Integer> charCounts() {
            return charCounts;
        }

        @Override
        public String toString() {
            return new String(toCharArray());
        }

        @Override
        public int hashCode() {
            return charCounts.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CharGroupImpl)) {
                return false;
            }
            CharGroupImpl other = (CharGroupImpl) obj;

            return Objects.equals(this.charCounts, other.charCounts);
        }
    }
}
