package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		List <TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char r = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double income = sc.nextDouble();
			if (r == 'i') {
				System.out.print("Health expenditures: ");
				double health = sc.nextDouble();
				list.add(new Individual(name, income, health));
			}
			else {
				System.out.print("Number of employees: ");
				int emp = sc.nextInt();
				list.add(new Company(name, income, emp));
			}
			System.out.println();
		}
		System.out.println("TAXES PAID:");
		double sum = 0.0;
		for (TaxPayer t : list) {
			System.out.println(t.getName() + ": $ " + String.format("%.2f", t.tax()));
			sum += t.tax();
		}
		System.out.println();
		
		System.out.printf("TOTAL TAX: $ %.2f%n", sum);
		
	}

}
