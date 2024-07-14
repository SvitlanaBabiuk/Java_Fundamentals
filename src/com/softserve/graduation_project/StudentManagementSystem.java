package com.softserve.graduation_project;

import java.util.*;

import static java.util.Comparator.comparing;


public class StudentManagementSystem {
    private Map<Integer, Student> students = new LinkedHashMap<>();

    public StudentManagementSystem() {
        addStudent(new Student(1, "Teliatnyk Anastasiia", 1, 85));
        addStudent(new Student(2, "Ponomenko Anna", 2, 63));
        addStudent(new Student(3, "Kukharska Olha", 3, 90));
        addStudent(new Student(4, "Karpenko Mykola", 4, 56));
        addStudent(new Student(5, "Lazenko Tetiana", 1, 81));

    }

    public void menu() {
        out:
        while (true) {
            showMainMenu();
            int option = readOption(5);

            switch (option) {
                case 1 -> showStudents();
                case 2 -> {
                    var student = promptAddNewStudent();
                    addStudent(student);
                }
                case 3 -> editStudent();
                case 4 -> sortStudents();
                case 5 -> {
                    break out;
                }
            }
        }
        System.out.println("Bye!");
    }

    public void showMainMenu() {
        System.out.println("""
                Main menu:
                1. Show students
                2. Add a new student
                3. Edit student
                4. Sort students
                5. Exit""");
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("There is no students yet ");
        } else {
            for (var entry : students.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }


    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("The student with id: " + student.getId() + " is already exist");
        }
        students.put(student.getId(), student);
    }

    public Student promptAddNewStudent() {
        System.out.println("Let`s add a new student! ");
        int id = readIDForNewStudent();
        String name = Exceptions.readName("Enter name: ");
        int course = Exceptions.readCourse("Enter course: ");
        double grade = Exceptions.readGrade("Enter grade: ");
        return new Student(
                id,
                name,
                course,
                grade);
    }

    public void editStudent() {
        var scan = new Scanner(System.in);
        System.out.println("Enter id of the employee to edit");
        int id = Integer.parseInt(scan.nextLine());
        var student = students.get(id);
        if (student == null) {
            System.out.println("There is no employee with id: " + id);
            return;
        }
        System.out.println("The current name is: " + student.getName());
        System.out.println("Enter a new name or an empty line to keep current: ");
        String name = scan.nextLine().trim();
        if (!name.isEmpty()) {
            student.setName(name);
        }
        System.out.println("The current course is: " + student.getCourse());
        System.out.println("Enter a new course or an empty line to keep current: ");
        String courseText = scan.nextLine().trim();
        if (!courseText.isEmpty()) {
            int course = Integer.parseInt(courseText);
            student.setCourse(course);
        }
        System.out.println("The current grade is: " + student.getGrade());
        System.out.println("Enter new grade or an empty line to keep current: ");
        String gradeText = scan.nextLine().trim();
        if (!gradeText.isEmpty()) {
            double grade = Double.parseDouble(gradeText);
            student.setGrade(grade);
        }
        students.put(id, student);
    }

    public void sortStudents() {
        System.out.println("""
                Choose the sorting order:
                1. ID
                2. Name
                3. Course""");
        int option = readOption(3);
        Comparator<Student> comparator = switch (option) {
            case 1 -> comparing(Student::getId);
            case 2 -> comparing(Student::getName);
            case 3 -> comparing(Student::getCourse);
            default -> throw new IllegalStateException("Never should be here");
        };

        List<Student> studentList = new ArrayList<>(students.values());
        studentList.sort(comparator);
        students = new LinkedHashMap<>();
        for (var student : studentList) {
            students.put(student.getId(), student);
        }
        showStudents();
    }


    public int readIDForNewStudent() {
        var scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter ID for the new student:");
            int id = Integer.parseInt(scan.nextLine());
            if (!students.containsKey(id)) {
                return id;
            }
            System.out.println("The ID is already used, choose another one.");
        }
    }

    public static int readOption(int nOptions) {
        System.out.println("Enter option (1 to " + nOptions + "):");
        var scan = new Scanner(System.in);
        int result = Integer.parseInt(scan.nextLine());
        return result;
    }
}




