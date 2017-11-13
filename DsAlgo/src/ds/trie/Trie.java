package ds.trie;

public class Trie {
	//#of symbols in a trie
	static int ALPHABETS=26;
	
	static class TrieNode {
		TrieNode children[] = new TrieNode[ALPHABETS];
		boolean endOfKey;
		TrieNode() {
			this.endOfKey=false;
			for(int i=0;i<children.length;i++)
				children[i]=null;
		}
	};

	static TrieNode root;
	
	Trie() {
		this.root = new TrieNode();
	}
	/**
	 * If not present, inserts key into trie
	 * If the key is prefix of trie node, 
	 * just marks leaf node
	 * 
	 * @param key
	 */
	static void insert(String key) {
		TrieNode cursor=root;
		int index;
		for(int i=0;i<key.length();i++) {
			index=key.charAt(i) - 'a';
			if(cursor.children[index]==null) {
				cursor.children[index] = new TrieNode();
			}
			cursor=cursor.children[index];
		}
		cursor.endOfKey=true;
	}
	
	/**
	 * Returns true if key presents in trie, else false
	 * @param key
	 * @return
	 */
	static boolean search(String key) {
		TrieNode cursor = root;
		if(key==null || key.isEmpty())
			return true;
		int index;
		for(int i=0;i<key.length();i++) {
		   index=key.charAt(i)-'a';
		   if(cursor.children[index]==null)
			   return false;
		}
		return (cursor != null && cursor.endOfKey);
	}
	
	static void printAllWords() {
		TrieNode cursor=root;
	}
	
}
