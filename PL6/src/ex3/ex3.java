package ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ex3 {

	public static void main() {
		System.out.println("Exercise 3");

		Person p1 = new Person("andre", Person.Sex.MALE, 31);
		Person p2 = new Person("joao", Person.Sex.MALE, 21);
		Person p3 = new Person("joana", Person.Sex.FEMALE, 23);
		Person p4 = new Person("margarida", Person.Sex.FEMALE, 35);

		ArrayList<Person> ap = new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4));
		ArrayList<Person> olderThan30 = (ArrayList<Person>) ap.stream().filter(p -> p.age > 30)
				.collect(Collectors.toList());

		for (Person p : olderThan30) {
			System.out.println(p.name + " - " + p.age);
		}

		double average = ap.stream().mapToDouble(p -> p.age).average().getAsDouble();

		System.out.println("Average:" + average);
	}
}
