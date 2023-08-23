import javax.swing.*;

public class lab5 {

	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Invalid number, bye!");
			System.exit(1);
		}	

		System.out.println("no errors!");
		
		String [] wordArray = new String [8];
		
		arrayFromFile(args[0], wordArray);
		
		for( String s : wordArray){
			System.out.println(s);
		}
		//String[] wordArray = {"hello", "goodbye", "cat", "dog", "red", "green", "sun", "moon" };
		//System.out.print(wordArray.length);
		String isOrIsNot, inputWord;
			
		// This line asks the user for input by popping out a single window
		// with text input
		
		while(true){
		inputWord = JOptionPane.showInputDialog(null, "Enter a word in ALL LOWER CASE:");
		if(inputWord.equalsIgnoreCase("STOP")) break;		

		// if the inputWord is contained within wordArray return true
		if (wordIsThere(inputWord, wordArray)) 
			isOrIsNot = "is"; // set to is if the word is on the list
		else
			isOrIsNot = "is not"; // set to is not if the word is not on the list
		
		// Output to a JOptionPane window whether the word is on the list or not
		JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list.");
		
		}
		
	}
	
	public static void arrayFromFile(String filename, String [] words){
		TextFileInput in = new TextFileInput(filename);
		for(int i = 0; i < words.length; i++){
			String line = in.readLine();
			if(line == null) break;
			words[i] = line;
		}
		in.close();
	}
	
	public static boolean wordIsThere(String findMe, String[] theList) {
		for(String word : theList){
			if(word.equals(findMe)) return true;//we can also use equalsIgnoreCase(findMe)
		}
		return false;
	} // wordIsThere
} // class Lab4Program1
