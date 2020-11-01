public class Main {
    public static void main(String[] args) {

        //Heroe h1 = new Heroe("Pedro", Faccion.EQUIPO_AZUL);
        //h1.atacar();

        Mapa mapa = new Mapa(5);

        //Heroes
        Personaje h1 = new Heroe("heroeUno", Faccion.EQUIPO_AZUL);
        Personaje h2 = new Heroe("heroeDos", Faccion.EQUIPO_ROJO);
        Personaje h3 = new Heroe("heroeTres", Faccion.EQUIPO_AZUL);
        Personaje h4 = new Heroe("heroeCuatro", Faccion.EQUIPO_ROJO);

        //Villanos
        Personaje v1 = new Villano("villanoUno");
        Personaje v2 = new Villano("villanoDos");
        Personaje v3 = new Villano("villanoTres");

        //Neutros
        Personaje n1 = new Neutro("NeutroUno");
        Personaje n2 = new Neutro("NeutroUDos");

        //Posiciones
        h1.setPosicion(new Posicion(0,0));
        h2.setPosicion(new Posicion(0,1));
        h3.setPosicion(new Posicion(1,0));
        h4.setPosicion(new Posicion(1,1));
        v1.setPosicion(new Posicion(0,2));
        v2.setPosicion(new Posicion(1,2));
        v3.setPosicion(new Posicion(2,2));
        n1.setPosicion(new Posicion(3,2));
        n2.setPosicion(new Posicion(4,2));


        //Realizo la agregacion de Personajes
        try {
            mapa.agregarPersonaje(h1);
            //mapa.agregarPersonaje(h1);
            mapa.agregarPersonaje(h2);
            mapa.agregarPersonaje(h3);
            mapa.agregarPersonaje(h4);
            mapa.agregarPersonaje(v1);
            //mapa.agregarPersonaje(v1);
            mapa.agregarPersonaje(v2);
            mapa.agregarPersonaje(v3);
            mapa.agregarPersonaje(n1);
            mapa.agregarPersonaje(n2);
        } catch (NombreDuplicadoException e) {
            e.printStackTrace();
        }

        //for(Personaje p : mapa.getPersonajes()){
        //    System.out.println(p.getNombre());
        //}




    }
}
