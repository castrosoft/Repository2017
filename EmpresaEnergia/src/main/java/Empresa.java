import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Empresa {
	protected List<Cliente> clientes;
	protected List<Medidor> medidores;
	protected Map<String, String> mapaClientes;
	
	/**
	 * Constructor. Inicializa la lista de clientes y medidores
	 * administrados por la Empresa. Inicializa el mapa de
	 * medidores asociados a clientes
	 */
	public Empresa(){
		clientes = new ArrayList<Cliente>();
		medidores = new ArrayList<Medidor>();
		mapaClientes = new HashMap<String,String>();
	}
		
	/**
	 * 
	 * @return La lista de Clientes de la empresa
	 */
	public List<Cliente> getClientes(){

		return clientes;
	}
	
	/**
	 * 
	 * @return La lista de medidores administrados por la empresa
	 */
	public List<Medidor> getMedidoresAdministrados(){

		return medidores;
	}
	
	/**
	 * Obtiene el mapa de asociaciones cliente-medidor
	 * 
	 * @return El mapa de asociaciones cliente-medidor
	 */
	public Map<String,String> getMapaAsociaciones(){

		return mapaClientes;
	}
	
	/**
	 * Crea un nuevo cliente con el nombre especificado y lo
	 * agrega a la lista de clientes de la empresa. Si en la lista
	 * de clientes de la empresa existe un cliente con ese nombre,
	 * lanza una exception.
	 *
	 * @param nombre El nombre del nuevo cliente a crear
	 * @return El Cliente creado
	 * @throws IllegalStateException Si ya existe un cliente con
	 *         ese nombre en la empresa
	 */
	public Cliente nuevoCliente (String nombre){
		//TODO Implementar metodo
		return null;
	}

	/**
	 * Devuelve el cliente de la empresa con el nombre especificado.
	 *
	 * No se distingue mayusculas o minusculas, es indistinto
	 * especificar "JUAN PEREZ" o "juan Perez" como
	 * argumento. Ademas, deben eliminarse los espacios prefijos o
	 * sufijos.
	 *
	 * @param nombre El nombre del cliente a buscar
	 * @return El cliente encontrado, o null en caso de no existir
	 *         el cliente entre los clientes de la empresa 
	 */
	public Cliente getCliente(String nombre) {
		//TODO Implementar metodo
		throw new IllegalStateException();
	}
	
	/**
	 * Remueve de la lista de clientes administrados al cliente
	 * cuyo nombre es el que se especifica como parametro.
	 * 
	 * @param nombreCliente El cliente a remover
	 * @return true Si se pudo dar de baja, false si no existe
	 *         cliente con el nombre especificado
	 */
	public boolean bajaCliente(String nombreCliente){
		//TODO Implementar metodo
		throw new IllegalStateException();
	}

	
	/**
	 * Crea un nuevo Medidor del tipo indicado y con la
	 * ubicacion especificada. Lo agrega a la lista de
	 * medidores administrados por la Empresa.
	 * 
	 * @param tipo El TipoMedidor (MONOFASICO/TRIFASICO)
	 * @param pos Las coordenadas donde se ubica el nuevo medidor
	 * @return El medidor creado
	 * @throws IllegalArgumentException si no puede crearlo
	 */


	public Medidor nuevoMedidor(TipoMedidor tipo, CoordenadaGPS pos){
		Medidor m;
		if (TipoMedidor.MONOFASICO.equals(tipo))
			m = new MedidorMonofasico(pos);
		else
			throw new IllegalArgumentException();
		medidores.add(m);
		return m;
	}


	
	/**
	 * Remueve de la lista de medidores administrados al medidor
	 * cuyo serial number es el que se especifica como parametro.
	 * 
	 * @param serialNumber El serialNumber del medidor a remover
	 * @return true si se pudo dar de baja, false si no existe
	 *         medidor con el serialNumber especificado
	 */
	public boolean bajaMedidor(int serialNumber){
		for (Medidor m: medidores){
			if (serialNumber == m.getSerialNumber()) {
				medidores.remove(m);
				return true;
			}
		}
		return false;		
	}
	
	/**
	 * Asocia el medidor al cliente.
	 * Registra en el mapa de clientes la relacion
	 * (<nombre_del_cliente>,<descripcion_medidor>)
	 * (cliente.getNombre(), medidor.toString())
	 * 
	 * ej. ("juan perez", "SN_123")
	 * 
	 * Si el cliente ya tiene un medidor asociado, lanza excepcion
	 * 
	 * @param c El cliente al cual asociar el medidor
	 * @param m El medidor 
	 * @throws IllegalStateException Si el medidor no puede
	 *         asociarse al cliente (por ejemplo, si ya tiene un
	 *         medidor asociado)
	 */
	public void asociarMedidorACliente(Cliente c, Medidor m){
		//TODO Implementar metodo
	}
	
	/**
	 * Remueve el medidor del cliente.  Elimina del mapa de
	 * clientes la relacion
	 * (<nombre_del_cliente>,<descripcion_medidor>)
	 * 
	 * @param c El cliente a desvincular
	 */
	public void disociarMedidorDeCliente (Cliente c){
		//TODO Implementar metodo
	}
	
}
