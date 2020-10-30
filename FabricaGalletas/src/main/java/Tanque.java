public class Tanque extends Contenedor {

    private Ingrediente ingrediente;

    /**
     * Constructor con parametro
     *
     * @param capacidad la capacidad del Contenedor
     * @throws IllegalArgumentException si la la capacidad es negativa.
     */
    public Tanque(Ingrediente ingrediente, int capacidad) throws IllegalArgumentException {
        super(capacidad);
        this.ingrediente = ingrediente;

    }

    /**
     * El ingrdiente almacenado en el Contenedor.
     *
     * @return el Ingediente almacenado
     */
    @Override
    public Ingrediente getIngredienteAlmacenado() {
        return ingrediente;
    }
}
