package com.mattcave.wordplay;


import java.util.Map;
import java.util.Objects;

public class Rack implements CharGroup {

    private CharGroup charGroup;

    public Rack(CharGroup charGroup) {
        Objects.requireNonNull(charGroup);
        this.charGroup = charGroup;
    }

    public static Rack from(String letters) {
        return new Rack(
                CharGroup.from(letters)
        );
    }

    @Override
    public Map<Character, Integer> charCounts() {
        return charGroup.charCounts();
    }

    @Override
    public String toString() {
        return new String(toCharArray());
    }


    @Override
    public int hashCode() {
        return charGroup.charCounts().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rack)) {
            return false;
        }
        Rack other = (Rack) obj;

        return Objects.equals(this.charGroup.charCounts(),
                              other.charGroup.charCounts());
    }
}
