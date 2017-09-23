

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Miscellineous {
	
	public void getSequence(int n) {
		
	}
	
	public String sequence(int current,int n,String s) {
		if(current==n) {
			return s;
		}
		if(current>n) {
			return "not possible";
		}
		String seq5=sequence(current+5,n,s+"+5");
		String seq3=sequence(current*3,n,s+"*3");
		
		if(seq5.equals("not possible") && seq3.equals("not possible")) {
			return "not possible";
		}
		if(seq5.equals("not possible")) {
			return seq3;
		}
		return seq5;
	}
	//This method prompts the user for the name of a file and then counts the
	//occurrences of words in the file (ignoring case).  It then reports the
	//frequencies using a cutoff supplied by the user that limits the output
	//to just those words with a certain minimum frequency.
	public void getWordCountInFile() throws FileNotFoundException {
		// open the file
	     Scanner console = new Scanner(System.in);
	     System.out.print("What is the name of the text file? ");
	     String fileName = console.nextLine();
	     Scanner input = new Scanner(new File(fileName));

	     // count occurrences
	     Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
	     while (input.hasNext()) {
	         String next = input.next().toLowerCase();
	         if (!wordCounts.containsKey(next)) {
	             wordCounts.put(next, 1);
	         } else {
	             wordCounts.put(next, wordCounts.get(next) + 1);
	         }
	     }

	     // get cutoff and report frequencies
	     System.out.println("Total words = " + wordCounts.size());
	     System.out.print("Minimum number of occurrences for printing? ");
	     int min = console.nextInt();
	     for (String word : wordCounts.keySet()) {
	         int count = wordCounts.get(word);
	         if (count >= min)
	             System.out.println(count + "\t" + word);
	     }
	}
	
	public static void main(String args[]){
		Miscellineous obj = new Miscellineous();
		
		System.out.println(obj.sequence(1,15,"1"));
	}

}