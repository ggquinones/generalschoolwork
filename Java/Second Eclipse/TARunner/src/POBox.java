
public class POBox {
	private int POBNumber;
    private Letter[] letters;
    public POBox() {
    }
    public POBox(Letter letters[], int bn) {
        POBNumber = bn;
        this.letters = letters;
    }
    public POBox(POBox other) {
        this.POBNumber = other.POBNumber;
        this.letters = other.getLetters();
    }
    public int getBoxNumber() {
        return POBNumber;
    }
    public Letter[] getLetters() {
        Letter[] copy = new Letter[letters.length];
        for(int i = 0; i< letters.length; i++) {
            copy[i] = new Letter(letters[i]);
        }
        return copy;
    }
    public String toString() {
        String temp = "";
        temp += String.format("POBNumber: %d\n\n", POBNumber);
        temp += "senders\t\tprintedMatter Values\n\n";
        for(Letter let : letters) {
            temp += let.toString() + "\n";
        }
        return temp;
    }
}
