import java.util.Hashtable;
import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		
		Hashtable<Integer, String> nombres = new Hashtable<Integer, String>();
		Hashtable<Integer, Double> precios = new Hashtable<Integer, Double>();
		Hashtable<Integer, Integer> cantidad = new Hashtable<Integer, Integer>();
		int numArticulos = 11;
		
		nombres.put(1, "Pelota");
		precios.put(1, 24.5);
		cantidad.put(1, 100);
		
		nombres.put(2, "Lápiz");
		precios.put(2, 1.2);
		cantidad.put(2, 200);
		
		nombres.put(3, "Zapatillas");
		precios.put(3, 50.0);
		cantidad.put(3, 15);
		
		nombres.put(4, "Iphone");
		precios.put(4, 700.0);
		cantidad.put(4, 10);
		
		nombres.put(5, "Camiseta");
		precios.put(5, 10.7);
		cantidad.put(5, 23);
		
		nombres.put(6, "Gorro");
		precios.put(6, 7.5);
		cantidad.put(6, 43);
		
		nombres.put(7, "Cola");
		precios.put(7, 0.6);
		cantidad.put(7, 66);
		
		nombres.put(8, "Agua");
		precios.put(8, 0.5);
		cantidad.put(8, 82);
		
		nombres.put(9, "Chips");
		precios.put(9, 1.2);
		cantidad.put(9, 21);
		
		nombres.put(10, "Cookies");
		precios.put(10, 2.5);
		cantidad.put(10, 20);
		
		String respuesta;
		Scanner sc = new Scanner(System.in);
		
		int id,addCantidad;
		
		boolean loop = true;
		
		do {
			System.out.println("\n1-Añadir Artículo");
			System.out.println("2-Añadir Cantidad");
			System.out.println("3-Consultar Stock");
			System.out.println("4-Salir\n");
			respuesta = sc.nextLine();
			
			switch(respuesta) {
				case "1":
					System.out.println("Nombre del Artículo:");
					nombres.put(numArticulos, sc.nextLine());
					
					System.out.println("Precio del Artículo:");
					precios.put(numArticulos, sc.nextDouble());
					
					System.out.println("Cantidad del Artículo:");
					cantidad.put(numArticulos, sc.nextInt());
					sc.nextLine();
					numArticulos++;
					break;
				case "2":
					System.out.println("Introduce el id del anticulo:");
					id = sc.nextInt();
					System.out.println("Introduce la cantidad a añadir:");
					addCantidad = sc.nextInt();
					sc.nextLine();
					cantidad.put(id, (cantidad.get(id)+addCantidad));
					break;
				case "3":
					for(int i=1; i<numArticulos; i++) {
						System.out.println(i + " - " + nombres.get(i) + " - " + precios.get(i) + " € - " + cantidad.get(i) + " uds");
					}
					break;
				case "4":
					loop = false;
					break;
				default:
					break;
			}
			}while(loop);
		
		sc.close();
	}

}
