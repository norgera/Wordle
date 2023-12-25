
public class ExtendedLetter extends Letter {
	
	private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;

    /**
     * constructor for ExtendedLetter
     * @param s (string)
     */
    public ExtendedLetter(String s){
        super('a');
        this.content = s;
        this.related = false;
        this.family = this.SINGLETON;
    }

    /**
     * other constructor for ExtendedLeter including new parameter "fam"
     * @param s (string)
     * @param fam (family)
     */
    public ExtendedLetter(String s, int fam){
        super('a');
        this.content = s;
        this.related = false;
        this.family = fam;
    }

    /**
     * equals method to test if both family variables and content are equal
     * @return True/False depending if they are equal.
     */
    public boolean equals(Object other){
    	
        if (other instanceof ExtendedLetter){
            ExtendedLetter otherExtendedLetter = (ExtendedLetter) other;
            
            if(this.family == otherExtendedLetter.family){
                this.related = true;
            }
            if(this.content == otherExtendedLetter.content){
                return true;
            }
        }
        return false;
    }

    /**
     * toString method to display a new letter decorator in the condition that a letter is unused and related is true
     */
    public String toString(){
    	if ((this.isUnused() == true) && (this.related == true)) {
            return "." + this.content + ".";
        }
        return decorator() + this.content + decorator();
    }
    

    /**
     * fromString method that creates an array of Letter objects of the same size as param "content"
     * @param content (array)
     * @param codes (array)
     * @return letters (array of letters)
     */
    public static Letter[] fromStrings(String[] content, int[] codes){
    	
        Letter[] letters = new Letter[content.length];
        
        if(codes == null){
            for(int i = 0; i < letters.length; i++){
                letters[i] = new ExtendedLetter(content[i]);
            }
        }else{
            for(int i = 0; i  < content.length; i++){
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }


}
