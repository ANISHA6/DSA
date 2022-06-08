// Method 1

/*

	Time complexity: O(N ^ 3)
	Space complexity: O(N ^ 2) 

	Where N represents the length of word.

*/


import java.util.HashSet;

public class Solution {

	public static int distinctSubstring(String word) {

		HashSet<String> ans = new HashSet<String>();

		// Iterate over each character of word.
		for (int i = 0; i < word.length(); i++) {

			String tempStr = "";
			
			for (int j = i; j < word.length(); j++) {
				
				tempStr += word.charAt(j);

				// Add this substring into the HashSet.
				ans.add(tempStr);
			}
		}

		// Return the size of the HashSet.
		return ans.size();

	}
}


// Method 2, trie
TC:O(N^2)

class Node {
  Node links[] = new Node[26];

  boolean containsKey(char ch) {
    return (links[ch - 'a'] != null);
  }

  Node get(char ch) {
    return links[ch - 'a'];
  }

  void put(char ch, Node node) {
    links[ch - 'a'] = node;
  }
}

public class Solution {
    public static int distinctSubstring(String s) {
        // Write your code here.
        Node root = new Node();
    int n = s.length();
    int count = 0;

    for (int i = 0; i < n; i++) {
      Node node = root;

      for (int j = i; j < n; j++) {
        if (!node.containsKey(s.charAt(j))) {
          node.put(s.charAt(j), new Node());
          count++;
        }
        node = node.get(s.charAt(j));
      }
    }
    return count ;
    }
}

