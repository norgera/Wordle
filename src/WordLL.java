public class WordLL {

    private Word mysteryWord;
    private LinearNode<Word> history;

    // Constructor for WordLL
    public WordLL(Word mystery) {
        this.history = null;
        this.mysteryWord = mystery;
    }

    // Labels guess word in comparison to the mystery word and adds guess word to history list
    public boolean tryWord(Word guess) {
        guess.labelWord(this.mysteryWord); // Labels each letter in guess word

        LinearNode<Word> guessNode = new LinearNode<>(guess);
        guessNode.setNext(this.history);    // Points to the node that history points to
        this.history = guessNode;           // Points to the new node

        return guess.isFullyCorrect(this.mysteryWord); // Returns true if all letters are correct and in the right spot
    }

    // Outputs a list of word objects as a string
    public String toString() {
        LinearNode<Word> current = this.history;
        String finalString = "";
        
        // Adding each word to a string with a newline separating each word
        while (current != null) {
            finalString += current.getElement().toString() + "\n";
            current = current.getNext();
        }
        return finalString;
    }
}
