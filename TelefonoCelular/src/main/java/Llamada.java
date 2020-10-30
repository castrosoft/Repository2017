
public class Llamada {
    protected TipoDeLlamada saliente;
    protected int duracionEnSegundos;
    protected String numero ;
    protected Fecha fecha;
    
    /**
     * Constructor sin parametros
     */
    public Llamada (){
    }
    
    /**
     * Constructor con parametros.
     * @param numero - Numero de destino/origen. Numero valido debe tener 10 digitos (elimina espacios inicial/final)
     * @param fecha - Fecha de la llamada. No puede ser null
     * @param duracion - Duración de la llamada, en segundos. Una duraci�n negativa es invalida
     * @param tipo - Tipo de llamada (saliente/entrante). No puede ser null
     * 
     * @throws IllegalArgumentException cuando alguno de os parametros es invalid
     */
    public Llamada (String numero, Fecha fecha, int duracion, TipoDeLlamada tipo){
        
        //TODO Implementar
    }

    public TipoDeLlamada getTipoDeLlamada() {
        return saliente;
    }

    public int getDuracionEnSegundos() {
        return duracionEnSegundos;
    }

    public String getNumero() {
        return numero;
    }

    public Fecha getFecha() {
        return fecha;
    }
    
    
    /**
     * Retorna la duración en un string con formato <mm:ss>
     * Ejemplos: "03:15", "12:03", "110:45"
     * 
     * @return
     */
    public String getDuracion() {
        //TODO Implementar
        return null;
    }
    
    /**
     * Retorna un String con el siguiente formato:
     * 
     * <aaaa/mm/dd> <hh:mm>, <numero>, <SALIENTE|ENTRANTE>, <duracion>
     *       
     * Ej. "2013/05/06 21:44, 3514801234, ENTRANTE, 05:12"
     * "2013/01/30 01:14, 1161293091, SALIENTE, 12:00"
     * 
     */
        
    public String toString(){
        //TODO Implementar
        return null;
    }
}
