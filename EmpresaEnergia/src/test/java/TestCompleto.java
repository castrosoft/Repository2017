import junit.framework.TestCase;



public class TestCompleto extends TestCase {

    public void test_llamada_constructor_nrosInvalidos(){

        Double [] latitudes = new Double []{-89.0, 91.0 };
        Double [] longitudes = new Double []{-179.0, 181.0 };

        try{
            for(int i=0; i < latitudes.length; i++){
                try{
                    new CoordenadaGPS(latitudes[i], longitudes[i]);
                    fail("El constructor acepto un nro invalido");
                }catch (IllegalArgumentException e){}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
