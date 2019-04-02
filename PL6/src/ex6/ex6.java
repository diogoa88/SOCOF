package ex6;

import java.util.Optional;
import java.util.stream.Stream;

public class ex6 {
	
	public static void main() {
		System.out.println("Exercise 6");
		
		Stream<Integer> strm = Stream.of(5,1,3,2);
		
		Optional<Integer> res = strm.reduce((Integer one, Integer two) -> one * two);
		
		if(res.isPresent()) {
			System.out.println("Res:" + res.get());
		}else {
			System.out.println("ERROR");
		}
	}

}
