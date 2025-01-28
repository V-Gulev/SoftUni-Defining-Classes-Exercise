package SoftUni.CompanyRoster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Employee>> employeeMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] elements = sc.nextLine().split("\\s+");
            String name = elements[0];
            double salary = Double.parseDouble(elements[1]);
            String position = elements[2];
            String department = elements[3];
            Employee currentEmployee;

            if (elements.length == 6) {
                String email = elements[4];
                int age = Integer.parseInt(elements[5]);
                currentEmployee = new Employee(name, salary, position, department, email, age);
            } else if (elements.length == 4) {
                currentEmployee = new Employee(name, salary, position, department);
            } else {
                String element5 = elements[4];
                if (element5.contains("@")) {
                    currentEmployee = new Employee(name, salary, position, department, element5);
                } else {
                    int age = Integer.parseInt(element5);
                    currentEmployee = new Employee(name, salary, position, department, age);
                }
            }

            if (!employeeMap.containsKey(department)) {
                List<Employee> currentEmployeesList = new ArrayList<>();
                currentEmployeesList.add(currentEmployee);
                employeeMap.put(department, currentEmployeesList);
            } else {
                employeeMap.get(department).add(currentEmployee);
            }

        }

        String departmentNameWithHighestAvgSalary = employeeMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", departmentNameWithHighestAvgSalary);
        List<Employee> employeesWithHighestSalary = employeeMap.get(departmentNameWithHighestAvgSalary);
        employeesWithHighestSalary.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(employeesWithHighestSalary);

        for (Employee employee : employeesWithHighestSalary) {
            String result = employee.getName() + " " + String.format("%.2f ", employee.getSalary()) + employee.getEmail() + " " + employee.getAge();
            System.out.println(result);
        }
    }

    private static double getAverageSalary(List<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
