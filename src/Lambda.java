import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lambda {

    Faker faker;

    public Lambda() {

        faker = new Faker();
    }

    class Student {

        String firstName;
        String lastName;
        double GPA;
        int amountOfClasses;

        public Student(String newFirst, String newLast, double newGPA, int classCount) {

            firstName = newFirst;
            lastName = newLast;
            GPA = newGPA;
            amountOfClasses = classCount;
        }

        public Student(String newFirst, String newLast, double[] newGrades, double[] newWeights, int classCount) {

            firstName = newFirst;
            lastName = newLast;

            GPA = 0;
            for (int g = 0; g < newGrades.length; g++) {

                newGrades[g] -= 60;
                newGrades[g] = (newGrades[g] < 0) ? (0) : (newGrades[g]);
                newGrades[g] /= 10;
                GPA += newGrades[g] * newWeights[g];
            }

            GPA /= classCount;
            amountOfClasses = classCount;
        }

        public String getFirstName() {

            return firstName;
        }

        public String getLastName() {

            return lastName;
        }

        public double getGPA() {

            return GPA;
        }

        public int getAmountOfClasses() {

            return amountOfClasses;
        }

        public String toString() {

            return firstName + " " + lastName + ": " + GPA;
        }
    }

    public List<Student> honorRoll(List<Student> studentList, Predicate<Student> tester) {

        List<Student> honorRoll = new ArrayList<Student>();

        for (Student s: studentList) {

            if (tester.test(s)) {

                honorRoll.add(s);
            }
        }

        return honorRoll;
    }

    public void honorRollTester() {

        int studentCount = 50;
        ArrayList<Student> population = new ArrayList<Student>();

        for (int s = 0; s < studentCount; s++) {

            double[] weights = {2, 1.5, 0.5, 0.5, 0.5, 1};
            double[] grades = {
                    (Math.random() * 40) + 60,
                    (Math.random() * 40) + 60,
                    (Math.random() * 40) + 60,
                    (Math.random() * 40) + 60,
                    (Math.random() * 40) + 60,
                    (Math.random() * 40) + 60
            };

            population.add(new Student(faker.name().firstName(), faker.name().lastName(), grades, weights, 6));
        }

        List<Student> honorRollStudents = honorRoll(population, (s -> s.getGPA() > 3));



        System.out.println("Honor Roll Students: " + honorRollStudents);
        System.out.println("Count: " + honorRollStudents.size());
    }

    public static void main(String[] args) {

        Lambda l = new Lambda();
        l.honorRollTester();
    }
}
