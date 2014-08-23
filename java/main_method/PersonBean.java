public class PersonBean implements Comparable<PersonBean> {
	public PersonBean(int age, String name) {
		this.age = age;
		this.name = name;
	}

	private int age = 0;
	private String name = "";

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object o) {
		if (!(o instanceof PersonBean)) {
			return false;
		}
		PersonBean p = (PersonBean) o;
		return (age == p.age) && (name.equals(p.name));
	}

	public int hashCode() {
		int result = 17;
		result = 31 * result + age;
		result = 31 * result + name.hashCode();
		return result;

	}

	public String toString() {
		return (age + "{" + name + "}");
	}

	public int compareTo(PersonBean person) {
		int cop = age - person.getAge();
		if (cop != 0)
			return cop;
		else
			return name.compareTo(person.name);
	}
}