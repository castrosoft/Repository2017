import java.util.ArrayList;
import java.util.List;

public class Cliente {

	protected String nombre;
	protected Medidor medidor;
	protected List<Lectura> lecturas;
	
	/**
	 * Constructor.1: Inicializa la variable "nombre" del cliente,
	 * crea la lista de lecturas e inicializa la variable
	 * "lecturas"
	 * 
	 * @param nom Nombre del cliente. El nombre debe persistir en
	 *        minusculas y sin espacios al principio o fin de la cadena.
	 */
	public Cliente (String nom){
	}
	
	/**
	 * Retorna el nombre del cliente
	 * @return
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * 
	 * @return el Medidor asociado al cliente (null si no tiene)
	 */
	public Medidor getMedidorAsociado(){
		return medidor;
	}
	
	/**
	 * 
	 * @return La lista de Lecturas realizadas sobre el medidor
	 * del cliente
	 */
	public List<Lectura> getLecturas(){
		return lecturas;
	}
	

	
	/**
	 * Este metodo:
	 * 1. Crea una nueva lectura con la fecha indicada y el
	 *    consumo del medidor asociado.
	 * 2. Si la nueva lectura es valida, la agrega a la lista de
	 *    lecturas del cliente.
	 *
	 * (Puede utilizar los metodos de la clase Utils para validar la lectura)
	 * 
	 * @param f Fecha de la lectura a agregar
	 * @throws IllegalStateException Cuando el cliente no tiene
	 *         medidor asociado.
	 * @throws LecturaInconsistenteException Cuando la lectura es
	 *         anterior a la ultima lectura de la lista o cuando el
	 *         valor leido es inferior al valor de la ultima lectura
	 */
	public void registrarNuevaLectura (Fecha f) throws LecturaInconsistenteException{

	}
	
	
	/**
	 * Asocia un medidor a este cliente, si es que no tiene ningun
	 * medidor asociado.  Si el cliente ya tiene un medidor
	 * asociado, ignora esta nueva asociacion.
	 *
	 * @param m El Medidor a asociar
	 * @return true si se pudo asociar el medidor, false si el
	 *         cliente ya tiene un medidor asociado.
	 */
	public boolean asociarMedidor(Medidor m){
		//TODO Implementar metodo
		return true;
	}
	
	/**
	 *  Remueve el medidor asociado a este cliente, y limpia la
	 *  lista de lecturas asociadas
	 */
	public void removerMedidor(){
		//TODO Implementar metodo	
	}
	
	/**
	 * Retorna un string con el siguiente formato:
	 * 1) cuando tiene un medidor asociado
	 *   "Cliente: <nombre_del_cliente> - Medidor: SN_<Medidor_SerialNumber>"
	 * 2) cuando no tienen un medidor asociado
	 *   "Cliente: <nombre_del_cliente> - Medidor: N/A"
	 * 
	 * ej. "Cliente: juan perez - Medidor: N/A" o
	 *     "Cliente: juan perez - Medidor: SN_12"
	 *
	 */
	public String toString() {
		//TODO Implementar metodo
		return null;
	}

}
