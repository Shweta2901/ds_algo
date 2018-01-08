package ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time.
 * Each intermediate word must exist in the dictionary For example, Given: start = “hit” end = “cog” dict = ["hot","dot","dog","lot","log"] As one shortest transformation is “hit” -> “hot” -> “dot” -> “dog” -> “cog”, return its length 5.
 * Note: Return 0 if there is no such transformation sequence. All words have the same length. All words contain only lowercase alphabetic characters.
 * 
 * Solution:
 * We can use BFS to solve this problem. It’s a breadth first search. Put the first word in a queue.
 * Then, while the queue is not empty, check all possible combinations of the word changing one letter.
 * If the word exists in the dictionary, check if it is the word you’re looking for, if its not, put it in the queue with the count of the word you’re checking right now plus 1.
 * If it was the word you’re looking for, return the current word’s count.
 * 
 **/
public class WordLadder {
	
	public static String replaceChar(String temp,char ch,int index) {
		char[] charArray=temp.toCharArray();
		charArray[index]=ch;
		return new String(charArray);
	}
	
	public static int countMinTransformation(String startWord,String endWord,Set<String> dict) {
		if(startWord==null || endWord==null || dict == null || startWord.isEmpty() || endWord.isEmpty())
			return 0;
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(startWord);
		int length=1;
		
		while(!queue.isEmpty()) {
			//for each word in the queue at this level
			int count = queue.size();
			for(int i=0;i<count;i++) {
				String current = queue.poll();
				//try replacing each character in this word with all the characters in the set and check if we have that word in the dictionary
				//this is to add all the word with difference of one character to the queue (going to next level)
				for(int j=0;j<current.length();j++) {
					for(char k='a';k<='z';k++) {
						if(current.charAt(j)==k) 
							continue;
						//check if the new word after replacing the jth character with 
						//k is present in the directory
						//if yes add it to the queue
						String temp = replaceChar(current,k,j);
						
						if(temp.equals(endWord))
							return length+1;
						
						if(dict.contains(temp)) {
							queue.offer(temp);
							dict.remove(temp);
						}
						
					}
				}
			}
			length++;
		}
		return 0;
	}
	

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("lot");
		dict.add("not");
		dict.add("dog");
		dict.add("log");
		dict.add("hut");
		
		System.out.println(WordLadder.countMinTransformation("hit", "hut", dict));
	}
}
