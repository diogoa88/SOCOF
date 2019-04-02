package ex2;

import java.util.Arrays;
import java.util.stream.Stream;

public class ex2 {

	public static void main() {
		System.out.println("Exercise 2 a");
		String strs[] = { "nas", "aulas", "pl", "de", "socof", "aprendo", "programação", "funcional", "em", "java","8" };
		Arrays.sort(strs, (String first, String second) -> Integer.compare(first.length(), second.length()));
		Arrays.stream(strs).forEach(word -> System.out.println(word));
		
		System.out.println("#######################################");
		System.out.println("Exercise 2 b");
		String strs2[] = { "nas", "aulas", "pl", "de", "socof", "aprendo", "programação", "funcional", "em", "java","8" };
		Arrays.sort(strs2, String::compareToIgnoreCase);
		Arrays.stream(strs2).forEach(word -> System.out.println(word));

		System.out.println("#######################################");
		System.out.print("Exercise 2 c/d:");
		String strs3[] = { "nas", "aulas", "pl", "de", "socof", "aprendo", "programação", "funcional", "em", "java","8" };
		Stream<String> strm = Stream.of(strs3);
		Long res = strm.filter(w -> w.length() > 3).count();
		System.out.println(res);

		System.out.println("#######################################");
		System.out.println("Exercise 2 e");
		Stream<String> strm2 = Stream.of(strs3);
		String[] strm3 = strm2.map(String::toUpperCase).toArray(String[]::new);
		
		for(String s : strm3) {
			System.out.println(s);
		}
	}
}
