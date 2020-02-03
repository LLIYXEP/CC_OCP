package builder.person;

public class Person {

	private String name;
	private String lastName;
	private int age;
	private boolean status;
	
	public static class Builder{
		private Person newPerson;
		
		public Builder() {
			newPerson = new Person();
		}
		
		public Builder withName(String name) {
			newPerson.name = name;
			return this;
		}
		public Builder withLastName(String lastName) {
			newPerson.lastName = lastName;
			return this;
		}
		public Builder withAge(int age) {
			newPerson.age = age;
			return this;
		}
		public Builder withStatus(Boolean status) {
			newPerson.status = status;
			return this;
		}
		public Person build(){
            return newPerson;
        }

	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", age=" + age + ", status=" + status + "]";
	}
	
	
	
}
