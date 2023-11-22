package application;

import entities.Account;
import entities.BusinessAcount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAcount bacc = new BusinessAcount(1002, "Maria", 0.0, 500.00);
		
		//UPCASTING - ATRIBUI UMA VARIÁVEL DE CLASSE INFERIOR A UMA SUPER CLASSE
		
		Account acc1 = bacc;// NÃO DÁ ERRO PQ A CLASSE FILHA É CLASSE MÃE TBM
		
		Account acc2 = new BusinessAcount(1002, "Bob", 0.0, 200.00);
		
		Account acc3 = new SavingsAccount(1002, "Ana", 0.0, 0.1);
		
		//	 DOWNCASTING - COVERTE DA SUPERCLASSE PARA A CLASSE FILHA
		//desse jeito dá imcompatibilidade de tipo - faz o casting
		BusinessAcount acc4 = (BusinessAcount)acc2;
		//problema escondido -- só aparecera na execução devido a mesma hierarquia, evito com teste.
		if (acc3 instanceof	 BusinessAcount) {
			BusinessAcount acc5 = (BusinessAcount)acc3;
			System.out.println("deu certo BusinessAcount");
			
		}
		if (acc3 instanceof	 SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			//System.out.println("deu certo SavingsAccount");
			
		}
		//sobreposição
		Account accT1 = new Account(1001, "Alex", 1000.50);
		accT1.withdraw(200);
		System.out.println(accT1.getBalance());
		
		Account accT2 = new SavingsAccount (1001, "Alex", 1000.50, 0.01);
		accT2.withdraw(200);
		System.out.println(accT2.getBalance());
		
		Account accT3 = new BusinessAcount (1001, "Alex", 1000.50, 500.0);
		accT3.withdraw(200);
		System.out.println(accT3.getBalance());
	}

}
