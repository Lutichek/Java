package lr2;

public class Example4 {
    public static class Person {
        private String name;
        private int age;
        private char gender;

        public Person(String name, int age, char gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public char getGender() {
            return gender;
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Zaripov Marat", 23, 'M');

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());
    }
}
