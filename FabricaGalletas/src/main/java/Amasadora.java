import java.util.*;


public class Amasadora implements Maquina {

    private List<Contenedor> contenedores;
    private Estado estado = Estado.APAGADO;
    private final String id;
    private Receta receta;
    public static int count = 0;

    /**
     * Constructor sin parametros
     * <p>
     * Inicializa las variables internas
     * setea el id de la amasadora con el formato "am_"+<count>
     * incrementea la cuenta total de count
     */
    public Amasadora() {
        contenedores = new ArrayList<>();
        this.id = "am_" + count;
        count++;

    }

    /**
     * Obtiene un contenedor del ingrediente solicitado conectado a esta Amasadora
     *
     * @param ingrediente el Ingrediente requerido
     * @return el Contenedor que contiene el ingrediente
     * @throws ContenedorNoDisponibleException cuando no existe un contenedor del ingrediente solicitado
     *                                         conectado a la amasadora
     */
    public Contenedor getContenedorPara(Ingrediente ingrediente) throws ContenedorNoDisponibleException {

        Contenedor c = null;

        for (Contenedor cont : contenedores) {
            if (cont.getIngredienteAlmacenado() == ingrediente) {
                c = cont;
            }
        }

        if (c == null) {
            throw new ContenedorNoDisponibleException("El ingrediente no esta conectado a la amasadora");
        }

        return c;
    }


    /**
     * Extrae una cantidad solicitada del Ingrediente de un contenedor asociado a la Amasadora
     *
     * @param ingrediente el Ingrediente a extraer
     * @param cantidad    la cantidad de ingrediente a extraer
     * @throws IllegalArgumentException cuando la cantidad es invalida (numero negativo), o cuando no existe
     *                                  un contenedor del ingrediente especificado asociado a la amasadora
     */
    public void extraerIngrediente(Ingrediente ingrediente, int cantidad) {

        if (cantidad < 0) {
            throw new IllegalArgumentException();
        }

        try {
            Contenedor c1 = getContenedorPara(ingrediente);
            c1.extraerIngrediente(cantidad);
        } catch (ContenedorNoDisponibleException e) {
            throw new IllegalArgumentException();
        }

    }

    /**
     * Carga una receta en la amasadora. Es posible setear un valor null.
     *
     * @param receta la Receta a cargar
     * @throws IllegalArgumentException cuando la amasadora no posee contenedor conectado
     *                                  para alguno de los componentes de la receta
     */
    public void setReceta(Receta receta) {

        int contador = contenedores.size();
        int flag = 0;
        for (Ingrediente ingr : receta.getListaDeIngredientes()) { //por cada ingrediente de la receta...
            flag = 0;
            for (Contenedor cont : contenedores) {  //recorro los contenedores
                if (cont.getIngredienteAlmacenado() == ingr) {
                    break;
                }
                flag++;
                if (cont.getIngredienteAlmacenado() != ingr && contador == flag) {
                    throw new IllegalArgumentException();
                }
            }
        }

        this.receta = receta;
    }

    @Override
    /**
     * Enciende la amasadora, seteando su estado apropiadamente
     */
    public void encender() {
        setEstado(Estado.ENCENDIDO);

    }

    /**
     * Apaga la amasadora, seteando su estado apropiadamente
     *
     * @throws IllegalStateException cuando se quiere apagar una maquina que estada OCUPADA
     */
    @Override
    public void apagar() {
        if (getEstado() == Estado.OCUPADO) {
            throw new IllegalStateException();
        }

        setEstado(Estado.APAGADO);

    }

    /**
     * Inicia el proces de amasado de la receta asociada
     * <p>
     * - Extrae los ingredientes necesarios para la receta
     * - Cambia estado de la amasadora a OCUPADO
     *
     * @throws IllegalStateException cuando
     *                               . el Estado de la amasadora no es correcto (apagado u ocupado),
     *                               . no hay receta cargada en la amasadora
     */
    public void iniciarProceso() {

        if (getEstado() == Estado.APAGADO || getEstado() == Estado.OCUPADO || getReceta() == null) {
            throw new IllegalArgumentException();
        }
        //extraerIngrediente(i);
        setEstado(Estado.OCUPADO);

    }

    /**
     * finaliza el proceso de la maquina
     * - Cambia el estado a ENCENDIDO
     *
     * @throws IllegalStateException cuando el estado de la maquina est� en estado APAGADO o ENCENDIDO
     *                               (no hay ning�n proceso corriendo)
     */
    public void finalizarProceso() {
        if (getEstado() == Estado.APAGADO || getEstado() == Estado.ENCENDIDO) {
            throw new IllegalArgumentException();
        }

        setEstado(Estado.ENCENDIDO);

    }

    /**
     * Verifica si es posible obtener la cantidad especificada de un Ingrediente en particular
     *
     * @param ingrediente el Ingrediente necesario
     * @param cantidad    la cantidad necesaria del Ingrediente especificado
     * @return true si hay alg�n contenedor con suficiente cantidad de Ingrediente
     * false si no hay ning�n conenedor con sufciente cantidad de Ingrediente
     * @throws IllegalArgumentException cuando la cantidad es invalida (numero negativo), o cuando no existe
     *                                  un contenedor del ingrediente especificado asociado a la amasadora
     */
    public boolean verificarDisponibilidadDeIngrediente(Ingrediente ingrediente, int cantidad) {

        if (cantidad < 0) {
            throw new IllegalArgumentException();
        }

        for (Contenedor cont : contenedores) {
            if (cont.getIngredienteAlmacenado() == ingrediente && cont.getContenidoActual() >= cantidad) {
                return true;
            }
        }

        return false;
    }

    /**
     * Obtiene un listado de ingredientes faltantes para poder ejecutar la Receta asociada a la Amasadora
     * <p>
     * Ej. La receta requiere HARINA 50, AGUA 50 y AZUCAR 20. En los contenedores conectados a la Amasadora
     * hay HARINA 30, AGUA 100, AZUCAR 10, entonces retorna una lista con [HARINA,AZUCAR]
     *
     * @return una lista de Ingrediente faltantes para poder ejecutar la receta
     * @throws IllegalStateException cuando no existe receta asociada a la amasadora
     */
    public List getIngredientesFaltantesParaReceta() {
        List lista = new ArrayList();

        for (Map.Entry<Ingrediente, Integer> mapa : receta.getMapa().entrySet()) {
            try {
                Contenedor cont = getContenedorPara(mapa.getKey());
                if (cont.getContenidoActual() < mapa.getValue()) {
                    lista.add(mapa.getKey());
                }
            } catch (ContenedorNoDisponibleException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Conecta un contenedor a esta amasadora
     *
     * @param contenedor el contenedor a conectar
     */
    public void conectarContenedor(Contenedor contenedor) {

        contenedores.add(contenedor);

    }

    /**
     * Desconecta un contenedor de esta amasadora
     *
     * @param contenedor el contenedor a desconectar
     */
    public void desconectarContenedor(Contenedor contenedor) {

        contenedores.remove(contenedor);

    }

    /**
     * Retorna la lista de contenedores conectados a esta amasadora
     *
     * @return la lista de contenederes
     */
    public List<Contenedor> getContenedores() {
        return contenedores;
    }

    /**
     * getter
     *
     * @return el estado de esta amasadora
     */
    public Estado getEstado() {
        return estado;

    }


    /**
     * setter
     *
     * @param estado el estado de la amasadora
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * getter
     *
     * @return el id de esta amassadora
     */
    public String getId() {

        return id;

    }

    /**
     * getter
     *
     * @return la receta asociada a la amasadora
     */
    public Receta getReceta() {

        return receta;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Amasadora) {
        }
        return false;
    }

    public Date getHoraFinAmasado() {
        return null;

    }
}

