package hangmangame.game;

import java.util.HashSet;
import java.util.Set;

import hangmangame.UI.UI;
import hangmangame.core.Config;
import hangmangame.core.Dictionary;
import hangmangame.core.InvalidCharacterException;
import hangmangame.core.Word;

public class Game {

	public void start () {
	UI.print("Welcome to Hangman Game!");	
	
	UI.printNewLine();
	
	Dictionary dictionary = Dictionary.getInstance();
	UI.print("Dictionary used: " + dictionary.getName());
	
	Word word = dictionary.nextWord();
	
	UI.print("The word has " + word.size() + " letters");
	
	Set <Character> usedChar = new HashSet<>();
	int errorCount = 0;
	int maxErrors = Integer.parseInt(Config.get("maxErrors"));
	UI.printNewLine();
	UI.print("you can get it wrong at most " + maxErrors + " times");
	
	
	while(true) {
		UI.print(word);
		UI.printNewLine();
		
		char c;
		try{
			c = UI.readChar("Type one letter: ");
			
			if(usedChar.contains(c)) {
				throw new InvalidCharacterException("This letter has already been used");
			}
			
			usedChar.add(c);
			
			if(word.hasChar(c)) {
				UI.print("You got a letter right!");
			}else {
				errorCount ++;			}
			
			if(errorCount < maxErrors) {
				UI.print("You missed! you can still get it wrong " + 
			    (maxErrors - errorCount)+ " time(s)");
			}
			
			UI.printNewLine();
			
			if(word.discovered()) {
				UI.print("Congratulations! you got the correct word " +
			word.getOriginalWord());
				UI.print("End game!");
				break;
			} 
			
			if (errorCount == maxErrors) {
				UI.print("You lost the game! The correct word is " +
			word.getOriginalWord());
				UI.print("End game!");
				break;
			}
			
			
			
		} catch (InvalidCharacterException e) {
			UI.print("Error: " + e.getMessage());
			UI.printNewLine();
		}
		
	}
	}
	

}
