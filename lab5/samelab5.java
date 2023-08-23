import javax.swing.*;

public class samelab5{

	public static void main(String [] args){
		
		if(args.length != 1){
			System.out.println("Invalid entries. Bye!");
			System.exit(1);	
		}
		else System.out.println("Very good, we are ready to read inputs!");

		String [] wordArray = new String[8];

		arrayFromFile(args[0], wordArray);
		
		while(true){
			String g;
			String userInput = JOptionPane.showInputDialog(null, "Please enter a word: ");
			if(userInput.equalsIgnoreCase("stop")) break;
			if(checkWord(userInput, wordArray))
			{
				g = "is";
			}
			else g = "isn't";
			JOptionPane.showMessageDialog(null, "User-input word " + g + " on the list.");
		}
	}

	public static void arrayFromFile(String filename, String [] wordArray){
		TextFileInput in = new TextFileInput(filename);
		for(int i = 0; i < wordArray.length; i++){
			String line = in.readLine();
			if(line == null)
			{
				break;
			}
			wordArray[i] = line;
		}
		in.close();		
	}

	public static boolean checkWord(String input, String [] wordArray){
		boolean s = false;
		
		for(int i = 0; i < wordArray.length; i++){
			if(input.equals(wordArray[i])) s = true;
		}
		/*
		for(String word : wordArray){
			if(word.equals(input)) s = true;
		}
		*/		
		return s;
	}
}





