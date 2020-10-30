public class Heroe extends Personaje implements Luchador {

    private static final int ATAQUE = 20;
    private static final int ENERGIA = 100;
    private static final int INCREMENTO_ENERGIA = 10;
    private static final int INCREMENTO_ATAQUE = 5;
    private Faccion faccion;
    


    /**
     * Crea una nueva instancia de Heroe, con el nivel de ataque y energia
     * por defecto (para Heroe)
     * @param nombre Nombre del Heroe
     * @param faccion Faccion a la cual pertenece
     * 
     */
    Heroe(String nombre, Faccion faccion)  {
        
        //COMPLETAR
    }

    /**
     * El heroe solo puede atacar a objetivos cercanos 
     * ( ver método obtenerPersonajesCercanos clase Mapa)
     * debe ser un villano o bien un Heroe de una faccion
     * diferente a la del heroe
     * Los danios se hacen mediante el metodo RecibirGolpe 
     * con el nivel de ataque propio
     */
    @Override
    public void atacar() {
        //COMPLETAR
    }

    /**
     * Disminuye la vida del Heroe por el valor del danio
     */
    @Override
    public void recibirGolpe(int danio) {
        //COMPLETAR
    }

    /**
     * Aumenta su vida de acuerdo a la variable INCREMENTO_VIDA
     * y su ataque de acuerdo a la variable INCREMENTO_ATAQUE
     */
    @Override
    public void subirNivel() {
        //COMPLETAR
    }

    /**
     * Mueve UNA VEZ a la primera posicion disponible en el siguiente orden
     * 1. ARRIBA
     * 2. ABAJO
     * 3. DERECHA
     * 4. IZQUIERDA
     * Si ningun movimiento esta disponible el heroe se queda quieto
     * AYUDAS:
     * - Las direcciones se pueden recorrer como una lista en ese 
     * oreden utilizando Direccion.values()
     * - Metodo realizarMovimiento de Mapa para comprobar que el
     * movimiento sea legal
     */
    @Override
    public void mover() {
        //COMPLETAR
    }

    /**
     * Devuelve la faccion del Heroe
     * @return
     */
    public Faccion getFaccion(){
        // COMPLETAR
        return null;
    }
}
