package hello;

public class Person {
	int age;
	private String name;
	public int id;
	public static int count = 0;
	
	public Person(int age, String name) {
		this.age=age;
		this.name=name;
		id = count;
		count++;
	}
	public Person(String name, int age) {
		this.age=10;
		this.name="abc";
		id = count;
		count++;
	}
	public Person() {
		//this(0, "");
		System.out.println("hello");
		age=0;
		name="";
	}
	public Person(Person p1) { //super(otherStudent)
		this(p1.age,p1.name);
		this.age=p1.age;
		name = p1.name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setAge(double age) {//overload
		this.age=2;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return age+" "+ name;
	}
	
	public boolean equals(Person otherPerson) {
		return this.age==otherPerson.age && this.name.equals(otherPerson.name);
	}
	
	
}
