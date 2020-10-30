public class Main {

    public static void main(String [] args){

        //Contenedor con1 = new Tanque(Ingrediente.AGUA, 100);
        //System.out.println(con1.getIngredienteAlmacenado());

        /*************************************************************/

        //Creacion de recetas
        Receta rec1 = new Receta("Pastafrola");
        Receta rec2 = new Receta("Macucas");

        //Agrego ingredientes a las recetas
        rec1.agreagarIngrediente(Ingrediente.AGUA, 200);
        rec1.agreagarIngrediente(Ingrediente.AZUCAR, 50);
        rec1.agreagarIngrediente(Ingrediente.HARINA, 500);
        //rec1.agreagarIngrediente(Ingrediente.VAINILLA, 5);
        rec1.setTiempoDeAmasado(50);

        rec2.agreagarIngrediente(Ingrediente.CACAO, 50);
        rec2.agreagarIngrediente(Ingrediente.VAINILLA, 5);

        //Muestro lista de ingredientes de receta
        System.out.println(rec1.getListaDeIngredientes());

        //rec1.cambiarOrden(Ingrediente.HARINA, 1);
        //System.out.println(rec1.getListaDeIngredientes());

        /********************************************************************/

        //Nueva amasadora
        Amasadora a = new Amasadora();

        //Creo 5 contenedores con cierta capacidad
        Contenedor con1 = new Tanque(Ingrediente.AGUA, 100);
        Contenedor con2 = new Tanque(Ingrediente.AZUCAR, 200);
        Contenedor con3 = new Tanque(Ingrediente.HARINA, 300);
        Contenedor con4 = new Tanque(Ingrediente.CACAO, 400);
        Contenedor con5 = new Tanque(Ingrediente.VAINILLA, 500);

        //Lleno cada contenedor con una cantidad
        con1.reprovisionarIngrediente(90);
        con2.reprovisionarIngrediente(190);
        con3.reprovisionarIngrediente(290);
        con4.reprovisionarIngrediente(390);
        con5.reprovisionarIngrediente(490);

        //Conecto cada contenedor (agrego a la lista)
        a.conectarContenedor(con1);
        a.conectarContenedor(con2);
        a.conectarContenedor(con3);
        a.conectarContenedor(con4);
        //a.conectarContenedor(con5);

        //Extrae del contenedor la cantidad que se indica por parametro
        a.extraerIngrediente(Ingrediente.VAINILLA, 20);

        //Muestra el contenido del ingrediente anterior para verificar si extrajo correctamente
        try {
            System.out.println(a.getContenedorPara(Ingrediente.AGUA).getContenidoActual());
        } catch (ContenedorNoDisponibleException e) {
            e.printStackTrace();
        }

        //Carga una receta a la amasadora. (Solamente puedo cargar una receta_? dado que es un metodo setter)
        a.setReceta(rec1);
        //a.setReceta(rec2);

        //Muestra los ingrediente de la receta. (Ejecuta el toString() de la clase Receta)
        System.out.println(a.getReceta());


        //Verifica disponibilidad de la cantidad que se pasa por parametro del ingrediente indicado
        System.out.println(a.verificarDisponibilidadDeIngrediente(Ingrediente.AGUA, 70));

        System.out.println(a.getIngredientesFaltantesParaReceta()); //agua y harina





    }
}
