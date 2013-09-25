import java.util.Iterator;

public class PreorderIterator implements Iterator<Node> {
    protected Stack<Node> s;

    public PreorderIterator(Node tree) {
	s = new Stack<Node>();
	if (tree != null)
	    s.push(tree);
    }

    public void remove() {
	// Leave empty
    }

    public Node next() {
	// To be completed
    }

    public boolean hasNext() {
	// To be completed
    }
}
