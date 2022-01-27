class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];//Creating children for every node
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	public boolean searchHelper(TrieNode root,String word){
		// Write your code here
        if(word.length() == 0){
			
			return root.isTerminating;
		}		
		int childIndex = word.charAt(0) - 'a';//Getting index of each characters of word
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return searchHelper(child, word.substring(1));
        
	}
    public boolean search(String word){
        
        return searchHelper(root, word);
    }


	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));

	}

	public void add(String word){
		add(root, word);
	}
}
