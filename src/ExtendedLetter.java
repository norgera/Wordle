public class ExtendedLetter extends Letter {

    private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;

    // Constructor for ExtendedLetter with string parameter
    public ExtendedLetter(String s) {
        super('a');
        this.content = s;
        this.related = false;
        this.family = this.SINGLETON;
    }

    // Constructor for ExtendedLetter with string and family parameters
    public ExtendedLetter(String s, int fam) {
        super('a');
        this.content = s;
        this.related = false;
        this.family = fam;
    }

    // Checks if both family variables and content are equal
    public boolean equals(Object other) {
        if (other instanceof ExtendedLetter) {
            ExtendedLetter otherExtendedLetter = (ExtendedLetter) other;
            if (this.family == otherExtendedLetter.family) {
                this.related = true;
            }
            return this.content.equals(otherExtendedLetter.content);
        }
        return false;
    }

    // Displays a new letter decorator if unused and related is true
    public String toString() {
        if (this.isUnused() && this.related) {
            return "." + this.content + ".";
        }
        return decorator() + this.content + decorator();
    }

    // Creates an array of Letter objects from given arrays of content and codes
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        if (codes == null) {
            for (int i = 0; i < letters.length; i++) {
                letters[i] = new ExtendedLetter(content[i]);
            }
        } else {
            for (int i = 0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }
}
