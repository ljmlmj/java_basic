package class01;

public class Employee {
	private String name = null;
	private int age = 0;
	private int salary = 0;
	private String local = null;
	private int terms = 0;
	private String gubun = null;
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, int salary, String local, int terms, String gubun) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.local = local;
		this.terms = terms;
		this.gubun = gubun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getTerms() {
		return terms;
	}

	public void setTerms(int terms) {
		this.terms = terms;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
}
