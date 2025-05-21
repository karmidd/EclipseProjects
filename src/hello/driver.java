package hello;

public class driver {

	public static void main(String[] args) {
		Person tala = new Person(18, "tala");
		Person tala2 = new Person("tala", 18);
		System.out.println(tala.getName());
		System.out.println(tala);
		System.out.println(tala2);
		tala2.setAge(18);
		System.out.println(tala.equals(tala2));
		tala2.setName("tala");
		tala2.setAge(18);
		System.out.println(tala.equals(tala2));
		tala2.setAge(18);
		System.out.println(Person.count);
		System.out.println(tala.id);
		System.out.println(tala2.id);
		
		
	}

}
