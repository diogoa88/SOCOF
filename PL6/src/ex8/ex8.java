package ex8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ex8 {
	
	public static void main() {
		System.out.println("Exercise 8");
		
		 List<Integer> numberList = Arrays.asList(1, 2, 3, 4 , 5);
		 
		 Optional<Integer> res = numberList.stream().reduce((Integer one, Integer two) -> one * (two*two));
		 
		 if(res.isPresent()) {
			 System.out.println(res.get());
		 }else {
			 System.out.println("ERROR");
		 }
	}

}
