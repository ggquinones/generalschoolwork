
public class Letter {
	 private String sender;
	    private boolean printedMatter;
	    public Letter(String send, boolean print) {
	        sender = send;
	        printedMatter = print;
	    }
	    public Letter(Letter other) {
	        sender = new String(other.sender);
	        printedMatter = other.printedMatter;
	    }
	    public String toString() {
	        return sender + "\t" + printedMatter;
	    }
	    public boolean equals(Letter other) {
	        if(printedMatter == other.printedMatter && sender.equals(other.sender)) {
	            return true;
	        }
	        return false;
	    }
}
