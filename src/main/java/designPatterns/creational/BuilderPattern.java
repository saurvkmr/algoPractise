package designPatterns.creational;

public class BuilderPattern {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .setfName("Saurav")
                .setlName("Kumar")
                .setAge(30)
                .setHairColor("Black").build();
        System.out.println(person.toString());
    }
}

class Person {
    String fName;
    String lName;
    int age;
    String hairColor;

    public Person(String fName, String lName, int age, String hairColor) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.hairColor = hairColor;
    }

    public Person(PersonBuilder personBuilder) {
        this.fName = personBuilder.fName;
        this.lName = personBuilder.lName;
        this.age = personBuilder.age;
        this.hairColor = personBuilder.hairColor;
    }

    public static class PersonBuilder {
        String fName;
        String lName;
        int age;
        String hairColor;
        public PersonBuilder() {}

        public PersonBuilder setfName(String fName) {
            this.fName = fName;
            return this;
        }

        public PersonBuilder setlName(String lName) {
            this.lName = lName;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setHairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person - First Name: " + fName
                + ", Last Name: " + lName
                + ", Age: " + age
                + ", Hair Color: " + hairColor;
    }
}
