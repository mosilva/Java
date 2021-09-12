package hangmangame.core;

import java.util.List;

public class StaticDictionary extends Dictionary{

	private List<String> words = List.of("house","computer","pen","car");
	private int currentIndex = -1; //pra come�ar pelo 0 na fila circular
	
	@Override
	public Word nextWord() {
		
		currentIndex = (currentIndex += 1) % words.size();
		return new Word(words.get(currentIndex));
		
	}

	@Override
	public String getName() {
		return "Static"; // s� pra dizer que � um dicion�rio est�tico
	}
	
	

}
