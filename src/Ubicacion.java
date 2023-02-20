import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    int id;
    String descripcion;
    Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
        exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void addExit(String direccion, int idUbicacion){
        exits.put(direccion, idUbicacion);
    }
}
