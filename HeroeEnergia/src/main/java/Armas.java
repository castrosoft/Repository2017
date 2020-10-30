/** Modela cualquier tipo de arma. */

public abstract class Armas extends Objetos {
    private Integer alcance;
    private Integer danio;

    /**
     * El uso de un arma puede desgastarla o consumir municiones,
     * por eso la implementación depende del arma
     */
    public abstract void Atacar ();

    public Integer getAlcance() {
        return alcance;
    }

    public void setAlcance(Integer alcance) {
        this.alcance = alcance;
    }

    public Integer getDanio() {
        return danio;
    }

    public void setDanio(Integer danio) {
        this.danio = danio;
    }

}
