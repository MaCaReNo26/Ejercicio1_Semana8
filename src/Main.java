import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Double> precios = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opc = 0;
        do{
            try {
                System.out.println("\n-----------|| PRECIOS INMOBILIARIOS ||-----------");
                System.out.println("1. Ingresar precio");
                System.out.println("2. Mostrar todos los precios");
                System.out.println("3. Mostrar precio mas alto");
                System.out.println("4. Mostrar precio mas bajo");
                System.out.println("5. Mostrar precios iguales");
                System.out.println("6. Buscar un precio especifico");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opcion: ");
                String opcion = sc.nextLine();
                opc = Integer.parseInt(opcion);
                switch (opc) {
                    case 1 -> ingresarPrecio();
                    case 2 -> mostrarPrecios();
                    case 3 -> precioMasAlto();
                    case 4 -> precioMasBajo();
                    case 5 -> precioIguales();
                    case 6 -> buscarPrecio();
                    case 7 -> System.out.println("Saliendo...");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch(NumberFormatException e){
                System.out.println("ERROR: Solo puede ingresar numeros");
            }
        }while (opc != 7);
    }

    public static void ingresarPrecio() {
        System.out.print("Ingrese un precio: ");
        double p = sc.nextDouble();
        if (p > 0) {
            precios.add(p);
            System.out.println("Precio agregado correctamente");
        } else {
            System.out.println("El precio debe ser mayor que cero");
        }
    }

    public static void mostrarPrecios() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
            return;
        }
        System.out.println("Lista de precios:");
        for (double p : precios) {
            System.out.println("$" + p);
        }
    }

    public static void precioMasAlto() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
            return;
        }
        double max = precios.get(0);
        for (double p : precios) {
            if (p > max) {
                max = p;
            }
        }
        System.out.println("El precio mas alto es: $" + max);
    }

    public static void precioMasBajo() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
            return;
        }
        double min = precios.get(0);
        for (double p : precios) {
            if (p < min) {
                min = p;
            }
        }
        System.out.println("El precio mas bajo es: $" + min);
    }

    public static void precioIguales() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
            return;
        }
        System.out.print("Ingrese el precio a buscar: ");
        double valor = sc.nextDouble();
        boolean encontrado = false;
        int contador = 0;
        for (double p : precios) {
            if (p == valor) {
                contador++;
                encontrado = true;
            }
        }
        if(encontrado){
            System.out.println("Precio: $" + valor + " se repite N" + contador);
        }else{
            System.out.println("No existen precios iguales");
        }
    }

    public static void buscarPrecio() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
            return;
        }
        System.out.print("Ingrese el precio a buscar: ");
        double buscado = sc.nextDouble();
        if (precios.contains(buscado)){
            System.out.println("El precio SI se encuentra registrado.");
        }else{
            System.out.println("El precio NO se encuentra en la lista.");
        }
    }
}
