public class Letter {

    private char letter;
    private int label;
    private final int UNSET = 0;
    private final int UNUSED = 1;
    private final int USED = 2;
    private final int CORRECT = 3;

    // Constructor for individual letters
    public Letter(char c) {
        this.label = this.UNSET;
        this.letter = c;
    }

    // Checks if one letter equals another
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            Letter letterObject = (Letter) otherObject;
            return this.letter == letterObject.letter;
        }
        return false;
    }

    // Returns a decorator symbol based on the letter's status
    public String decorator() {
        if (this.label == this.USED) return "+";
        else if (this.label == this.UNUSED) return "-";
        else if (this.label == this.CORRECT) return "!";
        else return " ";
    }

    // Returns the letter with its decorator symbols
    public String toString() {
        return decorator() + this.letter + decorator();
    }

    // Sets the letter to unused
    public void setUnused() {
        this.label = this.UNUSED;
    }

    // Sets the letter to used
    public void setUsed() {
        this.label = this.USED;
    }

    // Sets the letter to correct
    public void setCorrect() {
        this.label = this.CORRECT;
    }

    // Checks if the letter is unused
    public boolean isUnused() {
        return this.label == this.UNUSED;
    }

    // Creates an array of Letter objects from a given string
    public static Letter[] fromString(String s) {
        Letter[] letterArray = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            letterArray[i] = new Letter(s.charAt(i));
        }
        return letterArray;
    }
}
