
public class WordLL {
	
	 private Word mysteryWord;
	 private LinearNode<Word> history;

	 
	 /**
	  * constructor for WordLL
	  * @param mystery word
	  */
	    public WordLL(Word mystery){
	        this.history = null;
	        this.mysteryWord = mystery;
	    }

	  /**
	   * labels guess word in comparison to the mystery word and adds guess word to history list
	   * @param guess word
	   * @return true/false
	   */
	    public boolean tryWord(Word guess){
	        guess.labelWord(this.mysteryWord); // labels each letter in guess word

	        LinearNode<Word> guessNode = new LinearNode(guess);
	        guessNode.setNext(this.history);    // points to the node that history points to
	        this.history = guessNode;           // point to the new node

	        return guess.isFullyCorrect(this.mysteryWord); // returns true if all letters are correct and in the right spot
	    }


	    
	    /**
	     * toString method that outputs a list of word objects.
	     */
	    public String toString(){
	        LinearNode<Word> current = this.history;
	        String finalString = "";
	        
	        // adding each word to a string with a newline separating each word
	        while(current != null){
	            finalString += current.getElement().toString() + "\n";
	            current = current.getNext();
	        }
	        return finalString;
	    }     
}