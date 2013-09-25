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
	Node temp = s.pop();

	if (temp.left != null) {
	    s.push(temp.left);
	}
	if (temp.right != null) {
	    s.push(temp.right);
	}

	return temp;
    }

    public boolean hasNext() {
	return next() != null;
    }
}
