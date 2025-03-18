To implement a Java program that sorts a list of Employee objects (based on name, age, and salary) using lambda expressions and stream operations to demonstrate efficient data processing.

Step 1: Create the Employee Class
-Define an Employee class with the following attributes:
  name (String)
  age (int)
  salary (double)
-Create a constructor to initialize these values.
-Implement a display() method to print employee details.
  
Step 2: Create the Main Class
-Initialize an ArrayList<Employee> and add sample employee data.
-Use lambda expressions to sort the list:
  Sort by Name (Alphabetical order)
  Sort by Age (Ascending order)
  Sort by Salary (Descending order)
  
Step 3: Display the Sorted List
Use forEach() with a method reference to print the sorted employees.


Test Cases
Test Case         	Input Data                                                      	                    Expected Output
Case 1:       Sorting by Name	Alice (30, 50000), Bob (25, 60000), Charlie (35, 55000)	                    Alice, Bob, Charlie (sorted alphabetically)
Case 2:       Sorting by Age	Alice (30, 50000), Bob (25, 60000), Charlie (35, 55000)	                    Bob, Alice, Charlie (sorted by age in ascending order)
Case 3:       Sorting by Salary	Alice (30, 50000), Bob (25, 60000), Charlie (35, 55000)              	    Bob, Charlie, Alice (sorted by salary in descending order)
Case 4:       Edge Case - Same Name, Different Age	Alex (28, 45000), Alex (32, 47000), Alex (25, 46000)	Sorted by age (25 → 28 → 32)
Case 5:       Edge Case - Same Salary	David (29, 50000), Eve (31, 50000), Frank (27, 50000)	              Sorted by name if salary is the same


  Code 

  import java.util.*;

// Step 1: Create the Employee Class
class Employee {
    String name;
    int age;
    double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println(name + " (" + age + ", " + salary + ")");
    }
}

// Step 2: Main Class
public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        // Sample Employee Data
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.add(new Employee("Alex", 28, 45000));
        employees.add(new Employee("Alex", 32, 47000));
        employees.add(new Employee("Alex", 25, 46000));
        employees.add(new Employee("David", 29, 50000));
        employees.add(new Employee("Eve", 31, 50000));
        employees.add(new Employee("Frank", 27, 50000));

        // Sorting by Name (Alphabetical order)
        System.out.println("Sorting by Name:");
        employees.stream()
                 .sorted(Comparator.comparing(e -> e.name))
                 .forEach(Employee::display);
        System.out.println();

        // Sorting by Age (Ascending order)
        System.out.println("Sorting by Age:");
        employees.stream()
                 .sorted(Comparator.comparingInt(e -> e.age))
                 .forEach(Employee::display);
        System.out.println();

        // Sorting by Salary (Descending order)
        System.out.println("Sorting by Salary:");
        employees.stream()
                 .sorted(Comparator.comparingDouble(e -> -e.salary))
                 .forEach(Employee::display);
        System.out.println();

        // Edge Case - Same Name, Different Age
        System.out.println("Sorting by Name, then Age:");
        employees.stream()
                 .sorted(Comparator.comparing((Employee e) -> e.name)
                 .thenComparingInt(e -> e.age))
                 .forEach(Employee::display);
        System.out.println();

        // Edge Case - Same Salary
        System.out.println("Sorting by Salary, then Name:");
        employees.stream()
                 .sorted(Comparator.comparingDouble((Employee e) -> e.salary)
                 .thenComparing(e -> e.name))
                 .forEach(Employee::display);
    }
}
