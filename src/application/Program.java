package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		/*Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
		N funcionários. Não deve haver repetição de id.
		Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
		Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
		mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
		conforme exemplos.
		Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
		ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
		aumento por porcentagem dada.*/
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<Employee>();
		
		System.out.print("How many employees will be registered?");
		int N = sc.nextInt();
		
		for(int i = 0; i<N; i++) {
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		System.out.println("");
		System.out.print ("Enter the employee id that will have the salary increase: ");
		int  idsalary= sc.nextInt();
		Integer pos = position(list,idsalary);
		if(pos == null) {
			System.out.println("This id doesn't exist!");
			
		} else {
			
			System.out.print("Enter the percetage: ");
			double percent = sc.nextDouble();
				list.get(pos).increaseSalary(percent);	
		}
		
		System.out.println("");
		System.out.println("List of Employees");
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
		sc.close();
	}
	
	public static Integer position(List<Employee> list, int id) {
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
		
		
	}
	
	

}
