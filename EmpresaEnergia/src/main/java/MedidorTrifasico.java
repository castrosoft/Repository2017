public class MedidorTrifasico extends Medidor{

    public MedidorTrifasico(CoordenadaGPS coordenadaGPS){
        super(coordenadaGPS);
    }

    @Override
    public TipoMedidor getTipoMedidor() {
        return TipoMedidor.TRIFASICO;
    }

    public String toString(){
        return super.toString() + "_" + getTipoMedidor();
    }
}
