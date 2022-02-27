package ConstructorTest;
import java.util.Random;
/**
 * Ten program demonstruje techniki konstrukcji obiektów.
 * This program demonstrates techniques for constructing objects.
 * @author Tomek
 *
 */
public class ConstructorTest {
    public static void main(String[] args) {
        //Wstawianie do tablic staff trzech obiektów klasy Employee.
        //Inserting three Employee class objects into staff arrays.
        var staff = new Employee[3];

        staff[0] = new Employee("Hubert", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        //Wydruk informacji o wszystkich obiektach klasy Employee.
        //Printout of information about all objects of the Employee class.
        for (Employee e : staff)
            System.out.println("name: " + e.getName()
                    + ", id: " + e.getId()
                    + ", salary: " + e.getSalary());
    }
}

class Employee{
    private static int nextId;

    private int id;
    private String name = " ";	//Inicjalizacja zmiennej składowej obiektu.
    private double salary;

    //Statyczny blok inicjujący.
    //Static boot block.

    static {
        var generator = new Random();
        //Ustawienie zmiennej nextId na losową liczbę całkowitą z przedziału 0-9999.
        //Setting the variable nextId to a random integer between 0-9999.
        nextId = generator.nextInt(10000);
    }

    //Blok inicjujący obiektów.
    //Object initialization block.
    {
        id = nextId;
        nextId++;
    }

    //Trzy konstruktory przeciążone.
    //Three overloaded constructors.
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        //Wywołanie konstruktora Employee(String n, double s)
        //Calling the Employee (String n, double s) constructor
        this("Employee #" + nextId, s);
    }

    //Konstruktor domyślny
    //Default constructor
    public Employee() {
        //Zmienna name zainicjalizowana wartością "" - patrz niżej.
        //Name variable initialized with the value "" - see below.
        //Zmienna salary nie jest jawnie ustawiona - inicjalizacja wartością 0.
        //The salary variable is not explicitly set - initialized with 0.
        //Zmienna id jest inicjalizowana w bloku inicjującym.
        //The variable id is initialized in the initialization block.
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}