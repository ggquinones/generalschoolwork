/*
 * Simple node class for making linked lists.
 */
public class Node {

	protected Integer data;
	protected Node link;

	public Node() {

	}

	public Node(Integer data, Node link) {
		this.data = data;
		this.link = link;
	}
	public Node addNodeAfter(Integer element) {
		return link = new Node(element, link);
	}

	
	public String toString(int i) {
		if (i > 0) {
			if (link == null)
				return "" + data + " null in tail";
			else
				return "" + data + " " + link.toString(i - 1);
		} else
			return "";
	}

	public String toString() {
		String msg = "";
		try {
			if (link == null) {
				msg = data + " null in tail";
			} else {
				msg = data + ", " + link.toString();
			}
		} catch (StackOverflowError e) {
		}
		return msg;
	}

	
	public Integer getData() {
		return data;
	}

	public Node getLink() {
		return link;
	}

}