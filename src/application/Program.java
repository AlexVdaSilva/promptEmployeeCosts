package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Employee> list = new ArrayList<>();
		
		String name = null;
		int hours = 0;
		double valuePerHour = 0.00;
		char employeeContract = '0';
		
		System.out.print("Favor entrar com a quantidade de funcionários: ");
		int fN = sc.nextInt();
		
		for (int i=1; i<=fN; i++) {
			System.out.println("Dados do Funcionário #" + i);
			System.out.print("O funcionário é terceirizado? (y/n): ");
			employeeContract = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Horas trabalhadas: ");
			hours = sc.nextInt();
			System.out.print("Valor por horas: ");
			valuePerHour = sc.nextDouble();
			if (employeeContract == 'y') {
				System.out.print("Despesa adicional: ");
				double additionalCharge = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(emp);
			}
			else {
				Employee emp = new Employee(name, hours, valuePerHour);
				list.add(emp);
			}
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS:");
		
		for (Employee emp: list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();

	}

}
