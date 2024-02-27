public class Letter {
	
	private char letter;
	private int label;
	private final int UNSET = 0;
	private final int UNUSED = 1;
	private final int USED = 2;
	private final int CORRECT = 3;
	
	/**
	 * Constructor for individual letters
	 * @param c
	 */
	public Letter(char c) {
		this.label = this.UNSET;
		this.letter = c;
	}
	
	/**
	 * checks to see if one letter equals another
	 */
	public boolean equals(Object otherObject) {
		 if(otherObject instanceof Letter){
	            Letter letterObject = (Letter) otherObject;
	            if (this.letter == letterObject.letter){
	                return true;
	            }
	            return false;
	        }
	        return false;
	}
	
	/**
	 * Decorator function that sets each letter to its valid match.
	 * @return Appropriate letter symbols to a letter
	 */
	public String decorator() {
		if (this.label == this.USED) return "+";
		else if (this.label == this.UNUSED) return "-";
		else if (this.label == this.CORRECT) return "!";
		else return " ";	
		}
		
	
	/**
	 * returns letter to a string with its appropriate symbol
	 */
	public String toString() {
		return decorator() + this.letter + decorator();
	}
	/**
	 * setter method for unused letter
	 */
	public void setUnused() {
		this.label = this.UNUSED;
	}
	/**
	 * setter method for used letters
	 */
	public void setUsed() {
		this.label = this.USED;
	}
	/**
	 * setter method for correct letters
	 */
	public void setCorrect() {
		this.label = this.CORRECT;
	}
	
	/**
	 * Checks to see if a letter is unused
	 * @return true if letter is unused
	 */
	public boolean isUnused() {
		if (this.label == this.UNUSED) {
			return true;
		}else {
			return false;
		}
	}
		
	/**
	 * produces an array of letter objects from the given string
	 * @param s (string/word)
	 * @return an array of letters from word (s)
	 */
	public static Letter[] fromString(String s) {
		 Letter[] letterArray = new Letter[s.length()];
	        for(int i = 0; i < s.length(); i++){
	            letterArray[i] = new Letter(s.charAt(i));
	        }
	        return letterArray;
	    }
		
	
	
	
	}



