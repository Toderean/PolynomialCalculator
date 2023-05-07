package ro.tuc;

public class Monom {
    private Double coef;
    private Integer power;
    Monom(Double coef, Integer power){
        this.coef=coef;
        this.power= power;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString(){return this.coef + "x^" + this.power;}
}
