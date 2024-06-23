public class Word {
    
    private LinearNode<Letter> firstLetter; // Instance variable
    
    // Constructor for Word class
    public Word(Letter[] letters) {
        LinearNode<Letter> prev = null;
        LinearNode<Letter> current = null;

        for (int i = 0; i < letters.length; i++) {
            current = new LinearNode<Letter>(letters[i]);

            // Setting first letter of array
            if (i == 0) {
                this.firstLetter = current;
                prev = current;
            }

            // Setting the rest of the array
            prev.setNext(current);
            prev = current;
        }
    }

    // Returns the list of letters as a string
    public String toString() {
        String finalString = "Word: ";
        LinearNode<Letter> current = this.firstLetter;
        while (current != null) {
            // If at the last letter, add letter and break
            if (current.getNext() == null) {
                finalString += current.getElement().toString();
                break;
            } else {
                // Else add letter to string and get next
                finalString += current.getElement().toString() + " ";
                current = current.getNext();
            }
        }
        finalString += " "; // End with extra space
        return finalString; // Return string
    }

    // Labels each letter in a mystery word
    private void label(Word mystery) {
        int guessCount = 0;
        LinearNode<Letter> guessCurrent = this.firstLetter;
        while (guessCurrent != null) {
            boolean correct = false;
            boolean used = false;
            boolean unused = false;
            int mysteryCount = 0;
            LinearNode<Letter> mysteryCurrent = mystery.firstLetter;

            while (mysteryCurrent != null) {
                if (guessCurrent.getElement().equals(mysteryCurrent.getElement())) {
                    if (guessCount == mysteryCount) {
                        correct = true;
                    } else {
                        used = true;
                    }
                } else {
                    unused = true;
                }
                mysteryCurrent = mysteryCurrent.getNext();
                mysteryCount++;
            }

            if (correct) {
                guessCurrent.getElement().setCorrect();
            } else if (used) {
                guessCurrent.getElement().setUsed();
            } else {
                guessCurrent.getElement().setUnused();
            }

            guessCurrent = guessCurrent.getNext();
            guessCount++;
        }
    }

    // Labels the word when compared to a mystery word
    public boolean labelWord(Word mystery) {
        this.label(mystery);

        LinearNode<Letter> current = this.firstLetter;
        while (current != null) {
            if (current.getElement().isUnused()) {
                return false; // If unused, return false
            }
            current = current.getNext();
        }
        return true; // Else return true
    }

    // Checks if all letters are in the correct positions
    public boolean isFullyCorrect(Word otherWord) {
        LinearNode<Letter> currentThis = this.firstLetter;
        LinearNode<Letter> currentOther = otherWord.firstLetter;

        while (currentThis != null && currentOther != null) {
            if (!currentThis.getElement().equals(currentOther.getElement())) {
                return false; // Found a mismatching letter
            }
            currentThis = currentThis.getNext();
            currentOther = currentOther.getNext();
        }

        // Check if both lists have reached their end, ensuring they're of the same length
        return currentThis == null && currentOther == null;
    }
}
