public class Main {

    public static void main(String[] args) {

        //Medidor MONOFASICO
        //Medidor m1 = new MedidorMonofasico(new CoordenadaGPS(0, 10));
        //m1.incrementarConsumo(2000);

        //Asocio medidor MONO al Cliente
        //Cliente c1 = new Cliente("Pedro");
        //c1.asociarMedidor(m1);

        //Lecturas
        //Lectura l1 = new Lectura(100, new Fecha(10, 2000));
        //Lectura l2 = new Lectura(100, new Fecha(11, 2000));
        //Lectura l3 = new Lectura(100, new Fecha(12, 2000));

        /*
        try {
            c1.registrarNuevaLectura(new Fecha(10, 2000));
            c1.registrarNuevaLectura(new Fecha(11, 2000));
            c1.registrarNuevaLectura(new Fecha(12, 2000));
        } catch (LecturaInconsistenteException e) {
            e.printStackTrace();
        }

         */

        //Empresa
        Empresa epec = new Empresa();

        //Cliente
        Cliente c1 = epec.nuevoCliente("Pedro");
        //epec.nuevoCliente("Pedro");

        //Recupera Cliente
        System.out.println(epec.getCliente("PedrO"));

        //Baja Cliente
        System.out.println(epec.bajaCliente("Pedro"));

        //Medidores
        Medidor m1 = epec.nuevoMedidor(TipoMedidor.MONOFASICO, new CoordenadaGPS(0,0));
        Medidor m2 = epec.nuevoMedidor(TipoMedidor.TRIFASICO, new CoordenadaGPS(0,1));

        //Baja medidor
        //System.out.println(epec.bajaMedidor(0));

        System.out.println(c1.getMedidorAsociado());

        //Asocio medidor a cliente
        epec.asociarMedidorACliente(c1, m1);
        //epec.asociarMedidorACliente(c1, m2);

        System.out.println(c1.getMedidorAsociado());

        //Disocio medidor del cliente
        epec.disociarMedidorDeCliente(c1);

        System.out.println(c1.getMedidorAsociado());
        //epec.asociarMedidorACliente(c1, m1);

    }


}
