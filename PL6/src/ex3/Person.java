package ex3;

public class Person {

	public enum Sex {
		MALE, FEMALE
		}
	
		String name;
		int age;
		Sex gender;
		
		public Person(String name,Sex gender,int age) {
			this.name = name;
			this.gender = gender;
			this.age = age;
		} 
		
		
}
