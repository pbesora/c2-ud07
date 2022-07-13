import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		
		Hashtable<String, Double> notas = new Hashtable<String, Double>();
		Hashtable<String, String> nombres = new Hashtable<String, String>();
		
		String nombre="";
		int cont=1;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Nombre del alumno(0 para salir): ");
			nombre = sc.nextLine();
			
			if(!nombre.contentEquals("0")) {
				
				nombres.put(String.valueOf(cont), nombre);
			
				notas.put(String.valueOf(cont), calcularNotaMedia(leerNotas(sc)));
				cont++;
			}
		}while(!nombre.contentEquals("0"));
		sc.close();
		
		mostrarResultado(notas, nombres);
		
	}
	
	
	public static ArrayList<Integer> leerNotas(Scanner sc){
		
		ArrayList<Integer> notas = new ArrayList<Integer>();
		int nota;
		
		do {
			System.out.println("Nota(Más de 10 para salir): ");
			nota = sc.nextInt();
			
			if(nota<10 && nota>=0)
				notas.add(nota);
				sc.nextLine();
		}while(nota>=0 && nota<=10);
		
		
		return notas;
		
	}
	
	public static double calcularNotaMedia(ArrayList<Integer> notas) {
		
		double suma=0;
		double numNotas=0;
		
		for(int nota:notas) {
			suma += nota;
			numNotas++;
		}
		
		return suma/numNotas;
	}
	
	public static void mostrarResultado(Hashtable<String, Double> notas, Hashtable<String, String> nombres) {
		int size = nombres.size()+1;
		
		for(int i=1; i<size; i++) {
			System.out.println("\n-Nombre: " + nombres.get(String.valueOf(i)) + "\n\t-Nota: " + String.format("%.2f", notas.get(String.valueOf(i))));
		}
		
	}

}
