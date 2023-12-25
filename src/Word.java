public class Word {
	
	private LinearNode<Letter> firstLetter; // Instance variable
	
	/**
	 * Constructor for Word class
	 * @param list of letters
	 */
    public Word(Letter[] letters){
    	
    	//constructing 2 nodes
        LinearNode<Letter> prev = null;
        LinearNode<Letter> current = null;
        
        
        for(int i = 0; i<letters.length; i++){
            current = new LinearNode<Letter>(letters[i]);
            
            // setting first letter of array
            if(i == 0){
                this.firstLetter = current;
                prev = current;
            }
            
            //setting the rest of the array array
            prev.setNext(current);
            prev = current;
        }
    }
    
    /**
     * toString of the list of letters.
     */
    public String toString(){
        String finalString = "Word: ";
        LinearNode<Letter> current = this.firstLetter; // accessing first letter of word
        while(current != null){  // loops over every letter
        	
        	// if at the last letter, add letter and break
            if(current.getNext() == null){
                finalString += current.getElement().toString();
                break;
                
                
            //else add letter to string and get next 
            }else {
            	finalString += current.getElement().toString() + " ";
            	current = current.getNext();
            }
        }
        finalString +=  " "; // end with extra space
        return finalString; // return string
    }
    
    
    
    
/**
 * Labeling tool to label each letter in a mystery array.
 * @param mystery word
 */
    private void label(Word mystery){
    	int guessCount = 0;
		LinearNode<Letter> guessCurrent = this.firstLetter; // front of guess LL
		while (guessCurrent != null) {		// until end of guess LL
			
			
			// manipulating boolean values for each element in mystery word to determine its use.
			boolean correct = false;
			boolean used = false;
			boolean unused = false;
			int mysteryCount = 0; 	// need to reset mystery's index every loop
			LinearNode<Letter> mysteryCurrent = mystery.firstLetter;	// front of mystery LL
			
			while (mysteryCurrent != null) { 	// until end of mystery LL
				
				if (guessCurrent.getElement().equals(mysteryCurrent.getElement())) { 	// letter == letter
					if (guessCount == mysteryCount) { 	// comparing indexes
						correct = true;
					} else {
						used = true;
					}
				} else {
					unused = true;
				}
				
				// continuing loop for each letter.
				mysteryCurrent = mysteryCurrent.getNext();
				mysteryCount++;
			}
			
			//Setters being applied to mystery word letters using boolean values.
			if (correct == true) {
				guessCurrent.getElement().setCorrect();
			} else if (used == true) {
				guessCurrent.getElement().setUsed();
			} else {
				guessCurrent.getElement().setUnused();
			}
			
			//looping each letter in mystery word
			guessCurrent = guessCurrent.getNext();
			guessCount++;
		}
    }
    
    /**
     * Labels every word with their respective inputs when compared to mystery word
     * @param mystery word
     * @return True or False
     */
    public boolean labelWord(Word mystery) {
   
    	this.label(mystery); // uses helper method to label letters
		
		LinearNode<Letter> current = this.firstLetter;
		while (current != null) { // while first letter is valid
			if ((current.getElement().isUnused() == true)){ // if unused, return false
				return false;
			}
			current = current.getNext();
		}
		return true; // else return true
	}
    
    /**
     * Compares this word with another word to check if all letters are in the correct positions.
     * @param otherWord The word to compare with.
     * @return true if all letters are in the correct position, false otherwise.
     */
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
    	



