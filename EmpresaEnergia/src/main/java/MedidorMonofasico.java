public class MedidorMonofasico extends Medidor {

    public MedidorMonofasico(CoordenadaGPS pos) {
        super(pos);
    }

    @Override
    public TipoMedidor getTipoMedidor() {
        return TipoMedidor.MONOFASICO;
    }

    /**
     * Sobreescriba el metodo toString(), tal que agregue
     *       "_<tipoDeMedidor>" a la implementacion original de
     *       toString() en la clase padre.
     *       (ej.: "SN_12345_MONOFASICO" o "SN_343423_TRIFASICO")
     * @return
     */
    public String toString(){
        return super.toString() + "_" + getTipoMedidor();
    }
}
