package hangmangame.UI;

import java.util.Scanner;

import hangmangame.core.InvalidCharacterException;

public class UI {

	public static void print(Object object) {
		System.out.println(object);
		
	}
	
	public static void printNewLine() {
		System.out.println();
	}
	
	
	@SuppressWarnings("resource")
	public static char readChar(String text) throws InvalidCharacterException {
		System.out.println(text + " ");
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		if(line.trim().isEmpty())//espaço em branca em da Enter
		{
			throw new InvalidCharacterException("No letters were typed");
			
		}
		
		if(line.length()>1) //se ele digitou mais de uma letra
		{
			throw new InvalidCharacterException("Only one letter must be entered.");		
		}
		
		char c = line.charAt(0);
		
		if(!Character.isLetter(c)) //Não é uma letra
		{
			throw new InvalidCharacterException("Only letters must be typed");
		}
		
		return c;
	}
	
}
