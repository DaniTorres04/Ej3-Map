import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        Ubicacion obj1 = new Ubicacion(0, "Estás sentado en la clase de programación");
        Ubicacion obj2 = new Ubicacion(1, "Estás en la cima de una montaña");
        Ubicacion obj3 = new Ubicacion(2, "Estás bañándote en la playa");
        Ubicacion obj4 = new Ubicacion(3, "Estás dentro de un edificio muy alto");
        Ubicacion obj5 = new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion obj6 = new Ubicacion(5, "Estás en un bosque");

        ubicaciones.put(1, obj2);
        ubicaciones.put(2, obj3);
        ubicaciones.put(3, obj4);
        ubicaciones.put(4, obj5);
        ubicaciones.put(5, obj6);

        obj2.addExit("O", 2);
        obj2.addExit("N", 5);
        obj2.addExit("E", 3);
        obj2.addExit("S", 4);
        obj2.addExit("Q", 0);

        obj3.addExit("N", 5);
        obj3.addExit("Q", 0);

        obj4.addExit("O", 1);
        obj4.addExit("Q", 0);

        obj5.addExit("O", 2);
        obj5.addExit("Q", 0);

        obj6.addExit("O", 2);
        obj6.addExit("S", 1);
        obj6.addExit("Q", 0);

        System.out.println("Ubicación 1: " + obj2.descripcion);
        int ubicacion = 1;

        do {
            Ubicacion ubi = ubicaciones.get(ubicacion);
            System.out.println("Las salidas válidas de esta ubicación son (Q es para salir del programa): ");
            for (String key : ubi.getExits().keySet()) {
                System.out.println(key);
            }
                do {
                    System.out.println("¿A donde te diriges?");
                    opcion = sc.next().toUpperCase();
                    if (ubi.getExits().containsKey(opcion)){
                        ubicacion = ubi.getExits().get(opcion);
                        System.out.println(ubi.getDescripcion());
                    }else {
                        System.out.println("ERROR: Esa dirección no es válida.");
                    }
                }while (!ubi.getExits().containsKey(opcion));
        } while (!opcion.equalsIgnoreCase("Q"));
    }
}
