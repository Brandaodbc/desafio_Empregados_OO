package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int paymentDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phoneNumber = sc.next();
		
		Department dept = new Department(departmentName, paymentDay, new Address(email, phoneNumber));
		
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Dados do funcionário " + (i+1) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
						
			Employee employees = new Employee(name, salary);
			dept.addEmployee(employees);
			
		}
		
		System.out.println();
		showReport(dept);
		
		sc.close();
	}
	
	private static void showReport(Department dept) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.println("Departamento " + dept.getName() + ": R$" + String.format("%.2f", dept.payrooll()));
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários: ");
		for (Employee dpt : dept.getEmployee()) {
			System.out.println(dpt.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}

}
