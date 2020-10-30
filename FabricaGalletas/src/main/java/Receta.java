import java.util.*;


public class Receta extends Constantes {

    private HashMap<Ingrediente,Integer> mapa;
    private ArrayList<Ingrediente> listaDeIngredientes;
    private int tiempoDeAmasado;
    private final String nombre;
    
    /**
     * Constructor
     * @param nombre el nombre de la receta
     */

    public Receta(String nombreReceta){
        
       nombre = nombreReceta;
       mapa = new HashMap<Ingrediente,Integer>();
       listaDeIngredientes = new ArrayList<Ingrediente>();
    }
    
    /**
     * Agreaga un ingrediente a la receta
     * @param ingrediente el Ingrediente a incorporar
     * @param cantidad la cantidad de Ingrediente a incorporar
     * @throws IllegalArgumentException cuando la cantidad es negativa, el ingrediente es null o 
     * cuando ya existe el ingrediente en la receta 
     */

    public void agreagarIngrediente(Ingrediente ingrediente, int cantidad){
        if( cantidad < 0 || ingrediente == null || listaDeIngredientes.contains(ingrediente)){
            throw new IllegalArgumentException();
        }


        listaDeIngredientes.add(ingrediente);
        mapa.put(ingrediente, cantidad);
    }
    
    
    /**
     * Retorna la cantidad necesaria para esta receta del Ingrediente especificado
     * @param ingrediente el Ingrediente 
     * @return la cantidad del ingrediente especificado
     * @throws IllegalArgumentException cuando la receta no contiene el ingrediente especificado
     */
    public int getCantidadDeIngrediente(Ingrediente ingrediente) {
        if(!mapa.containsKey(ingrediente)){
            throw new IllegalArgumentException();
        }

        return mapa.get(ingrediente);
    }
    
    /**
     * setea el tiempo de Amasado de la receta
     * @param tiempo el tiempo de amasado 
     * @throws IllegalArgumentException si el tiempo especificado es negativo
     */
    public void setTiempoDeAmasado (int tiempo){
        this.tiempoDeAmasado = tiempo;
    }
    
    /**
     * 
     *Formato: 
     
     RECETA<NL><nombre_receta><NL><nroDeOrden><SEPARADOR><Ingrediente><SEPARADOR><cantidad><NL><...>TIEMPO/<tiempoDeAmasado><NL>
     
     Sugerencia: utilice las constantes "NL" y "SEPARADOR" para lograr el formato.
     Nota: El string termina con "NL" 
     *     
     *Ejemplo:
     RECETA
     macucas
     0/HARINA/60
     1/CACAO/30
     2/AGUA/70
     3/AZUCAR/15
     TIEMPO/15
     *
     */
    public String toString(){

        String str = "";
        int cuenta = 0;
        str += "RECETA" + NL + getNombre() + NL;
        for(Map.Entry<Ingrediente, Integer> mapa : mapa.entrySet()){
            str +=  cuenta + SEPARADOR +
                    mapa.getKey() + SEPARADOR +
                    mapa.getValue() + NL;
            cuenta++;
        }
        str += "TIEMPO" + SEPARADOR + getTiempoDeAmasado() + NL;

        return str;
        }

    
    /**
     * Reordena los ingredientes de la receta, ubicando el ingrediente en el orden indicado, 
         * manteniendo los demas ingredientes el orden relativo
     * @param ingrediente
     * @param nroDeOrden
     * @throws IllegalArgumentException cuando el nroDeOrden esta fuera de rango o si
         * el ingrediente no existe en la receta
     */
    public void cambiarOrden(Ingrediente ingrediente, int nroDeOrden)
    {
        int indice = 0;
        Ingrediente temp = null;
        while(indice < listaDeIngredientes.size()){
            Ingrediente ingr = listaDeIngredientes.get(indice);
            if(ingr == ingrediente){
                temp = ingr;
                listaDeIngredientes.remove(ingr); //elimino elemento
                listaDeIngredientes.add(nroDeOrden, temp); //Agrega el elemento. Desplaza los elementos a la derecha (si es que hay)
            }
            indice++;
        }
    }

     ////////////////////////////////////////////////////////////////////
    
    /**
     * retorna la lista de ingredientes de la receta (sin las cantidades de cada uno)
     * @return List<Ingredinte> la lista de ingredintes
     */
    public List<Ingrediente> getListaDeIngredientes(){
        return listaDeIngredientes;
      
    }
    
    /**
     * Retorna el tiempo de amasado de la receta
     * @return el tiempo de amasado
     */
    public int getTiempoDeAmasado (){
        return tiempoDeAmasado;
        
    }
    
    /**
     * getter
     * @return
     */
    public String getNombre() {
        return nombre;
      
    }

    /*Argegado por Pedro Castro*/

    public Map<Ingrediente, Integer> getMapa(){
        return mapa;
    }

}
