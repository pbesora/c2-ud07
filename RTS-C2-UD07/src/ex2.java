import java.util.ArrayList;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		
		ArrayList<String[]> productos = new ArrayList<>();
		Double iva, pago;
		String respuesta;
		Scanner sc = new Scanner(System.in);
		String[] producto = new String[3];
		
		System.out.println("IVA aplicado: 1-21% 2-4%");
		respuesta = sc.nextLine();
		if(respuesta=="1") 
			iva = 0.04;
		else
			iva = 0.21;
		
		do {
			producto = leerArticulo(sc); 
			productos.add(producto);
		}while(producto!=null);
		//mostrar precio antes de pago y coger e imprimir datos correctamente
		
		System.out.println("Cantidad Pagada: ");
		pago = sc.nextDouble();
		
		
		
		
		
		mostrarFactura(productos, iva, pago);
		
		
		sc.close();
		
	}

	public static String lineaPrecio(Double precioBruto, Double iva) {
		
		String linea;
		
		linea = (iva*100) + "% IVA - Precio bruto: " + precioBruto + " - Precio Total: " + (precioBruto+precioBruto*iva);
		
		return linea;
	}
	
	public static String lineaArticulo(String[] articulo) {
		
		Double precio = Double.parseDouble(articulo[1]);
		int cantidad = Integer.parseInt(articulo[2]);
		String linea = "";
		
		linea = articulo[0] + " - " + precio + "€ x" + cantidad + " " + (precio*cantidad);
		
		return linea;
	}
	
	public static String[] leerArticulo(Scanner sc) {
		
		String[] articulo = new String[3];	//0-nombre 1-precio 2-cantidad
		String nombre, precio, cantidad;
		
		
		
		System.out.println("Nombre del artículo(2 para salir): ");
		nombre = sc.nextLine();
		if(!nombre.equals("2")) {
			System.out.println("Precio de artículo: ");
			precio = sc.nextLine();
		
			System.out.println("Cantidad: ");
			cantidad = sc.nextLine();
		
			articulo[0] = nombre;
			articulo[1] = precio;
			articulo[2] = cantidad;
		
			return articulo;
		}else {
			return null;
		}
	}
	
	public static void mostrarFactura(ArrayList<String[]> articulos, Double iva, Double pago) {
		/*
		 * iva aplicado 21 4
		 * precio bruto y precio + iva
		 * numero de articulos
		 * cantidad pagada
		 * cambio a devolver
		 */
		Double precioBruto = 0.0;
		String resultado = "";
		Double cambio = 0.0;
		
		for(String[] a:articulos) {
			if(a!=null) {
				precioBruto += Double.parseDouble(a[1])*Integer.parseInt(a[2]);
				resultado += "\n" + lineaArticulo(a);
			}
		}
		
		resultado += "\n" + lineaPrecio(precioBruto, iva);
		
		resultado += "\nCantidad Pagada: " + pago;
		
		cambio = pago-(precioBruto+precioBruto*iva);
		
		if(cambio>=0) {
			resultado += "\nCambio: " + cambio;
		}else {
			resultado += "\nCambio: Pago insuficiente(" + cambio + ")";
		}
		
		System.out.println(resultado);
	}
}
