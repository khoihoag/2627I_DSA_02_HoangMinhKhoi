import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Checker implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() < s2.getCgpa()) {
            return 1;
        }

        if (s1.getCgpa() > s2.getCgpa()) {
            return -1;
        }

        int nameCompare = s1.getName().compareTo(s2.getName());

        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(s1.getId(), s2.getId());
    }
}

public class JavaSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, new Checker());

        for (Student student : students) {
            System.out.println(
                    student.getName()
            );
        }

        sc.close();
    }
}

