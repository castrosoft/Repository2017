import java.util.*;

public class Mapa {

    private List<Personaje> personajes;
    private final int tamano;
    private final static int DISTANCIA_VISUALIZACION = 5;
    private static final int TAMANO_DEFAULT = 100;

    /**
     * Inicializacion de mapa. Guarda el tamanio
     * e inicializa la lista de personajes
     *
     * @param tamano Se asume un tablero cuadrado del valor recibido
     */
    public Mapa(int tamano) {
        if (tamano < 1) {
            this.tamano = TAMANO_DEFAULT;
        } else {
            this.tamano = tamano;
        }
        personajes = new ArrayList<Personaje>();
    }

    /**
     * Agrega un personaje a la lista en caso de que no se encuentre en ella.
     * Si el nombre del personaje ya se encuentra en la lista
     * arroja una excepcion
     *
     * @param p Personaje a ser agregado
     */
    public boolean agregarPersonaje(Personaje p) throws NombreDuplicadoException {
        // Implementar

        for(Personaje pers : personajes){
            if(pers.getNombre().equals(p.getNombre())){
                throw new NombreDuplicadoException("El nombre " + pers.getNombre() +  " ya en la lista");
            }
        }

        if(!posicionDisponible(p.getPosicion())){
            return false;
        }

        return personajes.add(p);
    }

    /**
     * Elimina el personaje de la lista en caso de que exista
     * si el personaje no existe en la lista devuelve False,
     * de lo contrario retorna True
     *
     * @param p Personaje a ser eliminado
     */
    public boolean eliminarPersonaje(Personaje p) {
        // Implementar

        return personajes.remove(p);
    }

    /**
     * Elimina el personaje de la lista en base a su nombre
     * si el personaje no existe en la lista devuelve False,
     * de lo contrario retorna True
     *
     * @param nombre Nombre del personaje a ser eliminado
     */
    public boolean eliminarPersonaje(String nombre) {
        // Implementar

        for(Personaje pers : personajes){
            if(pers.getNombre().equals(nombre)){
                return personajes.remove(pers);
            }
        }
        return false;
    }

    /**
     * @return Devuelve la lista de personajes
     */
    List<Personaje> getPersonajes() {
        return personajes;
    }

    /**
     * Mueve el personaje especificado en la direccion indicada.
     * Si es posible, setea una nueva posicion al personaje
     * Debe cumplirse que:
     * 1. La nueva posicion este dentro de los limites del tablero
     * 2. La nueva posicion este disponible (-> no este ocupada por otro personaje)
     * <p>
     * <p>
     * Ayuda: Utilizar metodos privados de esta misma clase (posicionDisponible (Posicion): bool, nuevaPosicion(Direccion): Posicion -> clase Posicion)
     *
     * @param p el Personaje
     * @param d la Direccion
     * @return true si se pudo efectuar el movimiento, false si no se pudo.
     */
    public boolean moverPersonajeEnDireccion(Personaje p, Direccion d) {
        // Implementar

        //Nueva Posicion
        Posicion nuevaPosicion = p.getPosicion().nuevaPosicion(d);

        //Disponibilidad de esa nueva posicion y control de limites
        if(posicionDisponible(nuevaPosicion) && (nuevaPosicion.getX() <= this.tamano && nuevaPosicion.getY() <= this.tamano)){
            p.setPosicion(nuevaPosicion);
            return true;
        }
        return false;
    }


    /**
     * @param nuevapos posicion tentativa del personaje. No debe haber ningun personaje en esa posicion
     * @return true si la posicion esta disponible, false si no lo esta
     */
    public boolean posicionDisponible(Posicion nuevapos) {
        // Implementar

        for(Personaje pers : personajes){
            if((pers.getPosicion().getX().equals(nuevapos.getX())) && (pers.getPosicion().getY().equals(nuevapos.getY()))){
                return false;
            }
        }
        return true;
    }

    /**
     * Retorna una lista con los personajes que se encuentran cercanos a un personaje
     * El personaje se considera cercano si la distancia entre los dos personajes
     * tanto en x como en y es menor a la distancia de visualizacion
     * <p>
     * AYUDA: Ningun personaje puede estar cerca de si mismo (la lista no debe incluir una referencia a si mismo)
     *
     * @param p el Personaje
     * @return una List<Personaje> con los personajes cercanos
     */
    public List<Personaje> obtenerPersonajesCercanos(Personaje p) {
        // Implementar

        List<Personaje> cercanos = new ArrayList<>();
        int posX = p.getPosicion().getX();
        int posY = p.getPosicion().getY();

        for(Personaje pers : personajes){
            int distanciaX = Math.abs(pers.getPosicion().getX() - posX);
            int distanciaY = Math.abs(pers.getPosicion().getY() - posY);
            if(distanciaX < DISTANCIA_VISUALIZACION && distanciaY < DISTANCIA_VISUALIZACION){
                if(!pers.equals(p)){
                    cercanos.add(pers);
                }
            }
        }
        return cercanos;
    }


    /**
     * Retorna la cantidad de Heroes de una faccion determinada
     *
     * @param f la faccion
     * @return el numero de heroes de esa faccion
     */
    public int obtenerNroHeroesDeFaccion(Faccion f) {
        // Implementar

        int contador = 0;
        for(Personaje pers : personajes){
            if(pers instanceof Heroe){
                Heroe h = (Heroe) pers;
                if(h.getFaccion().equals(f)){
                    contador++;
                }
            }
        }
        return contador;
    }
}
