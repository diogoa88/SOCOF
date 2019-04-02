package ex7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ex7 {
	
	public static void main() {
		System.out.println("Exercise 7");
		
		List<String> words = Arrays.asList("I", "love", "I", "love", "love", "SOCOF", "SOCOF");
		
		Stream<String> list = words.stream().distinct();
		
		list.forEach(w-> System.out.println(w));
	}

}
