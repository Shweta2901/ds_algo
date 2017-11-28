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
	
	/*
	 * 1) Key may not be there in trie. Delete operation should not modify trie.
	 * 2) Key present as unique key (no part of key contains another key (prefix), 
	 * nor the key itself is prefix of another key in trie). Delete all the nodes.
	 * 3) Key is prefix key of another long key in trie. Unmark the leaf node.
	 * 4) Key present in trie, having atleast one other key as prefix key. 
	 * Delete nodes from end of key until first leaf node of longest prefix key.
	 * */
	static void delete(String key) {
		if(key == null)
			return;
		
	}
	static void printAllWords() {
		TrieNode cursor=root;
	}
	
}
