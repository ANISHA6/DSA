import java.util.ArrayList;

class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
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
	//Function for finding the last node of the given word
    public TrieNode findRoot(TrieNode root,String word){
        if(word.length()==0){
            return root;
        }
        int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];
        if(child==null){
            return null;
        }
        return findRoot(child,word.substring(1));
    }
	
	public void autoComplete(ArrayList<String> input, String word) {

        // Write your code here
        
        for(String  w:input){//Adding all given words in trie
            add(w);
        }
        
        TrieNode node=findRoot(root, word);//Find the last node of the given word
        
        if(node==null || node.childCount==0){
            return;
        }
        
        String output="";
        allRootToLeafPaths(node, output, word);
        
    }
    
    private void allRootToLeafPaths(TrieNode node, String output, String word){
        if(node.childCount==0){
            if(output.length()>0){
                System.out.println(word+output);
            }
            return;
        }
        if(node.isTerminating==true){//Found new word, that has formed with the help of given incomplete word
            System.out.println(word+output);
        }
        
        for(int i=0;i<node.children.length;i++){//Exploring all the children 
            if(node.children[i]!=null){
                String ans=output+node.children[i].data;
                allRootToLeafPaths(node.children[i],ans,word);
            }
        }
        
    }
 }
