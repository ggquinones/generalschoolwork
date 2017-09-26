import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This is a program which will take as input a sentence and will then output the sentence translated to Pig Latin
 * @author Gabriel Quinones
 *
 */
public class PigLatin {
	
	public static void main (String []args)
	{
		translate();
	}
	
	/**
	 * Method will take input sentence from console, tokenize the sentence, put the StringBuffer tokens into
	 * an ArrayList, translate the sentence, and output the product to the console.
	 * Input: none
	 * Output: Translated sentence to console
	 */
	public static void translate()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Input a sentence");
		String input=kb.nextLine();
		ArrayList<StringBuffer> sentTokens=toTokens(input);
		System.out.print(translateSentence(sentTokens));
		
	}
	/**
	 * Determines what type of word the token being looked at is.
	 * Whether the word begins with:
	 *  a vowel followed by a consonant
	 *  a single consonant followed by a vowel
	 *  a group of consonants
	 *  Input: StringBuffer
	 *  Output: returns 1 if words starts with a vowel, 2 if word starts with a single consonant, and 3 if the word starts 
	 *  with multiple consonants
	 * @param word
	 * @return
	 */
	public static int whatIsFirstLetter(StringBuffer word)
	{
		char charOne = word.charAt(0);
		char charTwo = word.charAt(1);
		// Case 1: First character is a vowel
		if(charOne=='a' || charOne=='e' || charOne=='i' || charOne=='o' || charOne=='u' || charOne=='y')
		{
			return 1;
		}
		// Case 2: Starts with single consonant
		else if(charTwo=='a' || charTwo=='e' || charTwo=='i' || charTwo=='o' || charTwo=='u' || charTwo=='y')
		{
			return 2;
		}
		
		// Case 3: Starts with multiple 
		else
		{
			return 3;
		}
	}
	/**
	 * Will take words that begin with a vowel and add "yay" to the end of it
	 * Input: StringBuffer
	 * Output: returns StringBuffer with "yay" appended
	 * @param word
	 * @return
	 */
	public static StringBuffer changeFirstVowel(StringBuffer word)
	{
		return word.append("yay");
	}
	
	/**
	 * Will take words that start with one consonant moves the consonant to the back and adds "ay"
	 * to it
	 * Input: StringBuffer
	 * Output: returns new StringBuffer with the consonant of the original in the back and "ay" appended 
	 * @param word
	 * @return
	 */
	public static StringBuffer changeFirstCons(StringBuffer word)
	{
		char firstConsonant = word.charAt(0);
		word.append(firstConsonant+"ay");
		word.deleteCharAt(0);
		return word;
		
	}
	/**
	 * Checks if the word is comprised of one letter
	 * @param word
	 * @return
	 */
	public static boolean isOneLetter(StringBuffer word)
	{
		char charOne=word.charAt(0);
		if(charOne=='a' || charOne=='e' || charOne=='i' || charOne=='o' || charOne=='u' || charOne=='y' || charOne=='A' || charOne=='E' || charOne=='I' || charOne=='O' || charOne=='U' || charOne=='Y')
		{
			return true;
		}
		return false;
	}
	/**
	 * Takes words that start with multiple consonants and takes that bit of consonants
	 * moves it to the back of the word and then adds ay to the word
	 * Input: StringBuffer
	 * Output: returns new StringBuffer with the consonant group of the original in the back and "ay" appended
	 * 
	 * @param word
	 * @return
	 */
	public static StringBuffer changeMultCons(StringBuffer word)
	{
		int end =findIndexOfLastCons(word);
		String cons = word.substring(0,end);
		word.delete(0,end);
		word.append(cons+"ay");
		return word;
	}
	
	/**
	 * Finds index of last consonant
	 * @param word
	 * @return
	 */
	public static int findIndexOfLastCons(StringBuffer word)
	{
		
		int i = 1;
		while(!(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u' || word.charAt(i)=='y'))
		{
			i++;
		}
		return i;
	}
	/**
	 * Decides which translating method the input word needs to be sent to.
	 * @param word
	 * @return
	 */
	public static StringBuffer toPigLatin(StringBuffer word)
	{
		if(isOneLetter(word))
		{
			return changeFirstVowel(word);
		}
		int firstLetter = whatIsFirstLetter(word);
		switch(firstLetter)
		{
			case 1: firstLetter=1;
			{
				return changeFirstVowel(word);
				
			}
			case 2: firstLetter=2;
			{
				return changeFirstCons(word);
			}
			default:
			{
				return changeMultCons(word);
			}
		}
	}
	/**
	 * Takes a sentence and tokenizes it
	 */
	public static ArrayList<StringBuffer> toTokens(String sentence)
	{
		ArrayList<StringBuffer> arrOfWords = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(sentence);
		while(st.hasMoreTokens())
		{
			arrOfWords.add(new StringBuffer(st.nextToken()));
		}
		return arrOfWords;
	}
	/**
	 * Takes a normal sentence and translates the words to Pig Latin adding the products to a new StringBuffer
	 * which it returns.
	 * @param sentence
	 * @return
	 */
	public static StringBuffer translateSentence(ArrayList<StringBuffer> sentence)
	{
		StringBuffer translatedSentence=new StringBuffer("");
		for(int i=0;i<sentence.size();i++)
		{
			translatedSentence.append(toPigLatin(sentence.get(i))+" ");
		}
		return translatedSentence;
	}
	
}
