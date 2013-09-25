public class BST {
    /* Root of BST */
    private Node root;
    /* Number of nodes in BST */
    private int size;

    public BST() {
	this.root = null;
	this.size = 0;
    }

    /**
     * Is the BST empty?
     */
    public boolean isEmpty() {
	return size() == 0;
    }

    /**
     * Return root of BST
     */
    public Node getRoot() {
	return root;
    }

    /**
     * Return number of key-value pairs in BST
     */
    public int size() {
	return size;
    }

    /**
     * Does there exist a key-value pair with given key?
     */
    public boolean contains(int key) {
	return find(key) != null;
    }

    /**
     * Return value associated with the given key, or null if no such key exists
     */
    public String find(int key) {
	return find(root, key);
    }

    /**
     * Return value associated with the given key, or null if no such key exists
     * in subtree rooted at x
     */
    private String find(Node x, int key) {
	if (x == null) {
	    return null;
	}
	if (key < x.key) {
	    return find(x.left, key);
	} else if (key > x.key) {
	    return find(x.right, key);
	} else {
	    return x.val;
	}
    }

    /**
     * Insert key-value pair into BST. If key already exists, update with new
     * value
     */
    public void insert(int key, String val) {
	if (val == null) {
	    remove(key);
	    return;
	}
	root = insert(root, key, val);
    }

    /**
     * Insert key-value pair into subtree rooted at x. If key already exists,
     * update with new value.
     */
    private Node insert(Node x, int key, String val) {
	if (x == null) {
	    size++;
	    return new Node(key, val);
	}
	if (key < x.key) {
	    x.left = insert(x.left, key, val);
	} else if (key > x.key) {
	    x.right = insert(x.right, key, val);
	} else {
	    x.val = val;
	}

	return x;
    }

    /**
     * Remove node with given key from BST
     */
    public void remove(int key) {
	return;
    } // dummy code

    public PreorderIterator preorder() {
	return new PreorderIterator(root);
    }

    public LevelorderIterator levelorder() {
	return new LevelorderIterator(root);
    }
}
