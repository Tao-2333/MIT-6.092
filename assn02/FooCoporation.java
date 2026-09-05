public class FooCoporation {
    public static void main(String[] args) {
        Employee employee1 = new Employee(7.5,35);
        Employee employee2 = new Employee(8.2,47);
        Employee employee3 = new Employee(10,73);
        calculateSalary(employee1.getSalaryPerHour(),employee1.getWorkTime());
        calculateSalary(employee2.getSalaryPerHour(),employee2.getWorkTime());
        calculateSalary(employee3.getSalaryPerHour(),employee3.getWorkTime());
    }

    public static void calculateSalary(double salaryPerHour,int workTime){
        double totalSalary;
        if (workTime > 60 || salaryPerHour < 8 || workTime < 0){
            System.out.println("Error,WorkTime or SalaryPerHour is incorrect");
        }
        else if (workTime <= 40){
            totalSalary = salaryPerHour*workTime;
            System.out.println("this employee gets "+totalSalary);
        }
        else {
            totalSalary = 40*salaryPerHour + (workTime-40)*(1.5*salaryPerHour);
            System.out.println("this employee gets "+totalSalary);
        }
    }
}

class Employee {
    private double salaryPerHour;
    private int workTime;

    public Employee(double salaryPerHour, int workTime) {
        this.salaryPerHour = salaryPerHour;
        this.workTime = workTime;
    }

    public void setSalary(double SalaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public void setWorkTime(int WorkTime) {
        this.workTime = workTime;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public int getWorkTime() {
        return workTime;
    }
}