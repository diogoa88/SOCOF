package ex4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ex4 {
	
	public static void main() {
		System.out.println("Exercise 4");
		
		List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe","Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");
		
		Optional<String> first = names.stream().filter(word-> word.length()==3).findFirst();
		
		if(first.isPresent()) {
			System.out.println(first.get());
		}else {
			System.out.println("Don't have a name with 3 letters");
		}
	}

}
