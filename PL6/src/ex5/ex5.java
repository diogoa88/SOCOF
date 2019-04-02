package ex5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ex5 {
	
	public static void main() {
		System.out.println("Exercise 5");
		
		  List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe","Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");
		  
		  Optional<String> res = names.stream().map(n->n.toUpperCase()).reduce((String first, String second)-> first + " " + second);
		  
		  if(res.isPresent()) {
			  System.out.println(res.get());
		  }else {
			  System.out.println("ERROR");
		  }
	}

}
