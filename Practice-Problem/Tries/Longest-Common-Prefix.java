//Method 1
/*
    Time Complexity: O(N*M)
    Space Complexity: O(1)
    
    where N is the number of strings in the array and M is the length of the shortest string present in the array.
*/
    
public class Solution {
    public static String longestCommonPrefix(String[] arr, int n) {
        
        // A String to store the longest common prefix
        String longestPrefix = "";

        for(int idx = 0; idx < arr[0].length(); ++idx)
        {
            // The variable ch is the character to be searched
            char ch = arr[0].charAt(idx);
            
            // A boolean value to check whether is it possible to insert ch in longest prefix or not.
            boolean matched = true;

            for(int index = 1; index < n; ++index) 
            {   
                // Check if arr[index][idx] is equal to ch
                if (arr[index].length() < idx || arr[index].charAt(idx) != ch)
                {
                    matched = false;
                    break;
                }
            }

            // If matched is true,insert the character ch into longestPrefix
            if (matched)
            {
                longestPrefix += ch;
            }
            else
            {
                break;
            }
        }

        return longestPrefix;
    }

}


//Using trie

/*
    Time Complexity: O(N*M)
    Space Complexity: O(N*M)

    where N is the number of strings in the array and M is the maximum length of the string present in the array.
*/

class TrieNode {

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

public class Solution {
	public static void add(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));

	}

	public static String longestCommonPrefix(String[] arr, int n) {

		// Declaring the Trie's root node
		TrieNode root = new TrieNode(' ');

		// Inserting each word into Trie
		for (int i = 0; i < arr.length; i++) {
			String word = arr[i];
			add(root, word);
		}

		// A string to store the longest common prefix
		String answer = "";

		// We will check if string prefix is common in all strings or not
		String prefix = arr[0];

		for (int idx = 0; idx < prefix.length(); idx++) {
			
			// Check if root has only one child.
			if (root.childCount == 1) {
				answer += prefix.charAt(idx);
				int diff = prefix.charAt(idx) - 'a';
				root = root.children[diff];
			} else {
				break;
			}

			// Check if endOfWord of root is true.
			if (root.isTerminating) {
				break;
			}
		}

		return answer;

	}

}
