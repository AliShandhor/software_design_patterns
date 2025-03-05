package creationalpatterns.factorymethod;
// This program calculates the salary of different types of employees
// in an organization: General Employee, Team Lead, and Team Manager.
// Each employee type has a different daily salary rate. The monthly
// salary is calculated as the number of days worked multiplied by
// the daily rate.

// Instead of repeating the salary calculation logic in each employee
// type class, we use a Factory Method pattern to encapsulate the
// object creation and ensure that each employee type computes its
// salary within its own module/class.

// Example: 2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// superclass: Salary
// subclasses: employee, team lead, team manager
abstract class Salary{
    protected double dailyRate;
    abstract void setDailyRate();

    // we do not want to have the salary calculation method in all subclasses
    public double calculateMonthlySalary(int days){
        double salary;
        salary = dailyRate *  days;
        return salary;
    }
}

class EmployeeSalary extends Salary{

    @Override
    void setDailyRate() {
        this.dailyRate = 300.0;
    }
}

class TeamLeadSalary extends Salary {

    @Override
    void setDailyRate(){
        this.dailyRate = 500.0;
    }
}

class TeamManagerSalary extends Salary{
    @Override
    void setDailyRate() {
        this.dailyRate = 700.0;
    }
}

class GenerateSalaryFactory {
    // getClass method (factory method)
    public Salary getEmployeeType(String employeeType){
        if (employeeType == null){
            return null;
        }

        else if(employeeType.equalsIgnoreCase("EMPLOYEE")){
            return new EmployeeSalary();
        }

        else if (employeeType.equalsIgnoreCase("LEAD")){
            return new TeamLeadSalary();
        }

        else if (employeeType.equalsIgnoreCase("MANAGER")){
            return new TeamManagerSalary();
        }
        else{
            return null;
        }
    }

}

public class GenerateSalary {
    public static void main(String[] args) throws IOException {
        // Using the factory
        // Initialize the factory
        GenerateSalaryFactory generateSalaryFactory = new GenerateSalaryFactory();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter type of employee (or type 'exit' to quit): ");
            String employeeType = bufferedReader.readLine().trim();

            if (employeeType.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program...");
                break;
            }

            try {
                // get instances of Salary from (subclasses)
                Salary salary = generateSalaryFactory.getEmployeeType(employeeType);
                if (salary == null) {
                    System.out.println("Invalid employee type. Please try again.");
                    continue;
                }

                salary.setDailyRate();

                // Ask the employee for the number of days worked
                System.out.println("Enter number of days worked: ");
                int days = Integer.parseInt(bufferedReader.readLine());

                double monthlySalary = salary.calculateMonthlySalary(days);
                System.out.println("Monthly Salary: " + monthlySalary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid integer for days worked.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}