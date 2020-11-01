import java.util.List;

public class Heroe extends Personaje implements Luchador {

    private static final int ATAQUE = 20;
    private static final int ENERGIA = 100;
    private static final int INCREMENTO_ENERGIA = 10;
    private static final int INCREMENTO_ATAQUE = 5;
    private Faccion faccion;


    /**
     * Crea una nueva instancia de Heroe, con el nivel de ataque y energia
     * por defecto (para Heroe)
     *
     * @param nombre  Nombre del Heroe
     * @param faccion Faccion a la cual pertenece
     */
    public Heroe(String nombre, Faccion faccion) {
        //COMPLETAR
        super(ATAQUE, ENERGIA, nombre);
        this.faccion = faccion;
    }

    /**
     * El heroe solo puede atacar a objetivos cercanos
     * ( ver método obtenerPersonajesCercanos(Personaje): List<Personaje> </> clase Mapa)
     * debe ser un villano o bien un Heroe de una faccion
     * diferente a la del heroe
     * Los danios se hacen mediante el metodo RecibirGolpe
     * con el nivel de ataque propio
     */
    @Override
    public void atacar() {
        //COMPLETAR

        List<Personaje> lista = mapa.obtenerPersonajesCercanos(this);

        //Opcion ineficiente 1
        /*
        for(Personaje personaje : lista){
            if(personaje instanceof Villano){
                Villano v = (Villano) personaje;
                v.recibirGolpe(ATAQUE);
            }else {
                Heroe h = (Heroe) personaje; //Posibilidad de un ClassCastException
                if(!h.getFaccion().equals(this.getFaccion())){
                    h.recibirGolpe(ATAQUE);
                }
            }
        }
         */

        //Opcion ineficiente 2
        for (Personaje personaje : lista) {
            try {
                Villano v = (Villano) personaje; //Posibilidad de un ClassCastException
                v.recibirGolpe(ATAQUE);
            } catch (ClassCastException e) { //Si viene aca es porque es un Heroe
                try{
                    Heroe h = (Heroe) personaje; //Posibilidad de un ClassCastException
                    if (h.getFaccion() != this.getFaccion()) {
                        h.recibirGolpe(this.getAtaque());
                    }
                }catch (ClassCastException c){
                    //Es un Neutro
                }
            }
        }
    }

    /**
     * Disminuye la vida del Heroe por el valor del danio
     */
    @Override
    public void recibirGolpe(int danio) {
        //COMPLETAR

        //Metodo heredado de Personaje
        incrementarEnergia(-danio);
    }

    /**
     * Aumenta su vida de acuerdo a la variable INCREMENTO_VIDA
     * y su ataque de acuerdo a la variable INCREMENTO_ATAQUE
     */
    @Override
    public void subirNivel() {
        //COMPLETAR
        this.incrementarEnergia(INCREMENTO_ENERGIA);
        this.incrementarAtaque(INCREMENTO_ATAQUE);
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
     * orden utilizando Direccion.values()
     * - Metodo posicionDisponible(Posicion): bool de Mapa para comprobar que el
     * movimiento sea legal
     */
    @Override
    public void mover() {
        //COMPLETAR

        for(Direccion direcc : Direccion.values()){
            if(mapa.moverPersonajeEnDireccion(this, direcc)){
                //ya lo mueve el metodo moverPersonajeEnDireccion
                return;
            }
        }
    }

    /**
     * Devuelve la faccion del Heroe
     *
     * @return
     */
    public Faccion getFaccion() {
        // COMPLETAR
        return this.faccion;
    }
}
