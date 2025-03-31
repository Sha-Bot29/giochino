package lezione6;

import java.util.Scanner;
import java.util.Random;

public class Menu {
	public static void stampaMenu() {
//		corpo del metodo
		System.out.println("----MENU----");
		System.out.println("1. Gioca Tombola (g)");
		System.out.println("2. Calcola (c)");
		System.out.println("3. Gioca con i dadi(d)");
		System.out.println("4. Esci (q)");
		System.out.println("------------");		
	}
	
	public static void gioca() {
		
	}
	
// CALCOLATRICE
	
	public static void calcola(double num1, double num2, char operazione) {
		double risultato;
		switch(operazione) {
		case '+':
			risultato = num1 + num2;
			System.out.println("la somma è: " + risultato);
			break;
		case '-':
			risultato = num1 - num2;
			System.out.println("la sottrazione è: " + risultato);
			break;
		case '*':
			risultato = num1 * num2;
			System.out.println("la moltiplicazione è : " + risultato);
			break;
		case '/':
			if(num2 != 0) {
				risultato = num1 / num2;
				System.out.println("la divisione è: " + risultato);
			}else {
				System.out.println("Errore, stai dividento per 0!!");
			}
			break;
			default:
				System.out.println("Operazione non valida");	
		}
	}
	
	
	
	// GENERA NUMERI CASUALI 
	public static void generaCasuali(int quanti, Random random) {
		for(int i = 0; i < quanti; i++) {
			int NumCasuali = random.nextInt(100);
			System.out.println(NumCasuali);
		}
	}

	// DADI 
	public static void dadi(Scanner input, Random random){
		System.out.println("Quante facce?");
		int facce = input.nextInt();
		
		while(true) {
			int dado1 = random.nextInt(facce) + 1;
			int dado2 = random.nextInt(facce) + 1;
			System.out.println("Dado1 = " + dado1 + " Dado2 = " + dado2);
			
			if (dado1 == dado2) {
				System.out.println("HAI VINTO!!");
				break;
			}else {
				System.out.println("perdente, se non vuoi piu giocare scrivi 'no' per uscire, oppure inserisci numero facce ");
				String risposta = input.next().toLowerCase();
				if(risposta.equals("no")) {
					System.out.println("Hai scelto di uscire.");
					break;
				}
			}	
		}		
	}
	
	
	public static void main(String[] args) {
		
//		System.out.println(numero); //Qui non posso risalire alla variabile numero
		
		Scanner input = new Scanner(System.in);
		Scanner numeri = new Scanner (System.in);
		Random random = new Random(); 
		
		
		char scelta;
		
		
		do {
			
//			richiamo il metodo per stampare il menu
			stampaMenu();
			scelta = input.next().toLowerCase().charAt(0); //Raccolgo una stringa con next() ed estraggo la lettera  nella posizione 0 della stringa
			
			
			switch(scelta) {
				case 'g':
				case '1':
					System.out.print("Quanti numeri vuoi? ");
					int n = numeri.nextInt();
					System.out.println("Hai scelto di giocare alla tombola. Abbiamo estratto per te i seguenti numeri...");
					generaCasuali(n, random);
				break;
				
				case 'c':
				case '2':
					System.out.print("Inserisci 1° numero: ");
					double num1 = input.nextDouble();
					System.out.println("Inserisci 2° numero: ");
					double num2 = input.nextDouble();
					System.out.println("Inserisci l'operazione +, -, *, /");
					char operazione = input.next().charAt(0);
					calcola(num1, num2, operazione);
				break;
				
				case 'd':
				case '3':
					System.out.println("Hai scelto di giocare con i dadi: ");
					dadi(input,random);
				break;
				
				case 'q':
					System.out.println("Stai uscendo dal programma..");
				break;
				
				default:
					System.out.println("Scelta non valida. Riprova.");
			}
			
			System.out.println();
		
		}while(scelta != 'q' && scelta != 'Q'); //quit
		
		System.out.println("Hai chiuso il programma");
	
	
	
	
}
}
