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
	root = findNode(root, key);
    } // dummy code

    public Node findNode(Node x, int key) {
        // Is the node to the left of x?
	if (key < x.key) {
	    findNode(x.left, key);
	}
	// Is the node to the right of x?
	else if (key > x.key) {
	    findNode(x.right, key);
	}
	// Is the current node the node to be removed?
	else if (key == x.key) {
	    x = removeNode(x);
	}
	return x;
    }

    public Node removeNode(Node x) {
	if (x.left != null) {
	    Node temp = leftMax(x);

	    remove(leftMax(x).key);

	    temp.left = x.left;
	    if (x.right != null) {
		temp.right = x.right;
	    }
	    x = temp;
	}
	else if (x.right != null) {
	    x = x.right;
	} else {
	    // Just remove x if it is a leaf
	    x = null;
	}
	return x;
    }

    /**
     * Returns the rightmost node of the left sub-tree
     */
    public Node leftMax(Node x) {
	Node temp = x.left;
	while (temp.right != null) {
	    temp = temp.right;
	}
	return temp;
    }

    public PreorderIterator preorder() {
	return new PreorderIterator(root);
    }

    public LevelorderIterator levelorder() {
	return new LevelorderIterator(root);
    }
}
