class RecordExample {

    public record Point(int x, int y) { }

    public record Student(String name, int age) {

        public Student {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        }

        public String greeting() {
            return "Hi, I'm " + name + " and I'm " + age + " years old.";
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(3, 5);

        System.out.println("=== Point Record ===");
        System.out.println("p1: " + p1);
        System.out.println("p1.x(): " + p1.x());
        System.out.println("p1.y(): " + p1.y());
        System.out.println("p1.equals(p2): " + p1.equals(p2));

        System.out.println("\n=== Student Record ===");
        Student s = new Student("Matan", 22);
        System.out.println(s);
        System.out.println(s.greeting());
    }
}
