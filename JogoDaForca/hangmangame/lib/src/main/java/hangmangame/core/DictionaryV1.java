package hangmangame.core;

import java.util.ArrayList;
import java.util.Scanner;

import hangmangame.game.GameException;
import hangmangame.utils.RandomUtils;

import java.util.List;


public class DictionaryV1 {
	
	private static final String FILE_NAME = "dicionario.txt";
	private static DictionaryV1 instance;
	private List<String> words = new ArrayList<>();
	
	private DictionaryV1( ){
		load();
	}
	
	
	public static DictionaryV1 getInstance() {
		if(instance == null) {
			instance = new DictionaryV1();
		}
		return instance;
		
	}
	
	private void load() throws GameException{
		
		
	try(Scanner scanner = 
			new Scanner(getClass().getResourceAsStream("/"+FILE_NAME))) {
		
		while (scanner.hasNextLine()) {
			String word = scanner.nextLine().trim();
			words.add(word);
		}
		
		if(words.size() ==0) {
			
			throw new GameException("A lista de palavra não pode ser vazia");
			}
		}
	}
	
	public Word nextWord() {
		int pos = RandomUtils.newRandomNumber(0, words.size());
		return new Word(words.get(pos));
	}
	
	
}
