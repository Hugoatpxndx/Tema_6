import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejemploBasico();
        ejercicioHashtable();
        demoBusquedaYEliminacion();
        sc.close();
    }

    public static void ejemploBasico() {
        System.out.println("=== EJEMPLO BÁSICO ===");
        Hashtable<Integer> numeros = new Hashtable<>();

        numeros.put("uno", 1);
        numeros.put("dos", 2);
        numeros.put("tres", 3);

        numeros.display();

        System.out.println("Valor de 'dos': " + numeros.get("dos"));
        System.out.println("¿Contiene 'cuatro'? " + numeros.containsKey("cuatro"));

        System.out.println("Eliminando 'dos': " + numeros.remove("dos"));
        numeros.display();
    }

    public static void ejercicioHashtable() {
        System.out.println("\n=== EJERCICIO TABLA HASH ===");
        Hashtable<Integer> tabla = new Hashtable<>();
        int[] elementos = {
                15, 8, 42, 23, 7, 99, 56, 31, 4, 67,
                12, 88, 53, 21, 39, 75, 60, 2, 18, 27
        };

        for (int i = 0; i < elementos.length; i++) {
            String clave = "num" + elementos[i];
            tabla.put(clave, elementos[i]);
        }

        tabla.display();

        System.out.println("Buscando algunos elementos:");
        System.out.println("num42: " + tabla.get("num42"));
        System.out.println("num99: " + tabla.get("num99"));
        System.out.println("num100: " + tabla.get("num100")); // No existe
    }

    public static void demoBusquedaYEliminacion() {
        System.out.println("\n=== DEMOSTRACIÓN DE BÚSQUEDA Y ELIMINACIÓN ===");
        Hashtable<String> agenda = new Hashtable<>();

        agenda.put("Juan", "555-1234");
        agenda.put("María", "555-5678");
        agenda.put("Pedro", "555-9012");
        agenda.put("Ana", "555-3456");

        agenda.display();
        String telefonoJuan = agenda.get("Juan");
        System.out.println("\nEl teléfono de Juan es: " + telefonoJuan);
        System.out.println("\nEliminando a María...");
        agenda.remove("María");

        agenda.display();
    }
}