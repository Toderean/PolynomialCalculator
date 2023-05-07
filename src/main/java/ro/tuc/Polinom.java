package ro.tuc;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    public TreeMap<Integer, Double> polinom1 = new TreeMap<>();
    Pattern pattern = Pattern.compile("([-+]?(\\d{0,9}[.]?\\d{0,9}))?([a-z][^ ])*(\\d{0,9})?");

    Polinom() {
         TreeMap<Integer, Double> polinom1 = new TreeMap<>();
    }
    Polinom(String polynom) {
        Matcher matcher = pattern.matcher(polynom);
        while (matcher.find()) {
            if (matcher.group(3) != null) {
                if (matcher.group(4) == null) {
                    if (matcher.group(1) == null) {
                        this.addMonom(new Monom(1.0, 1));
                    }
                    this.addMonom(new Monom(1.0, Integer.valueOf(matcher.group(4))));
                }
                if (matcher.group(4) != null) {
                    if (Objects.equals(matcher.group(1), "")) {
                        this.addMonom(new Monom(1.0, Integer.valueOf(matcher.group(4))));
                    } else
                        this.addMonom(new Monom(Double.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(4))));
                }
            }
            if (!Objects.equals(matcher.group(1), "")) {
                this.addMonom(new Monom(Double.valueOf(matcher.group(1)), 0));
            }
        }
    }

    public void addMonom(Monom m) {
        this.polinom1.put(m.getPower(), m.getCoef());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Double> it : polinom1.descendingMap().entrySet()) {
            int power = it.getKey();
            double coef = it.getValue();
            if (coef != -0.0) {
                if (coef >= 0.01) {
                    if (sb.length() > 0) {
                        sb.append(" + ");
                    }
                } else {
                    sb.append(" - ");
                    coef = -coef;
                }
                Monom temp = new Monom(coef, power);
                sb.append(temp.toString());
            }
        }

        return sb.toString();
    }

    public TreeMap<Integer, Double> getPolinom1() {
        return polinom1;
    }

    public void setPolinom1(TreeMap<Integer, Double> polinom1) {
        this.polinom1 = polinom1;
    }
    public Integer returnMax(){
        Integer grade = 0;
        for (Map.Entry<Integer, Double> it : this.polinom1.descendingMap().entrySet()){
            if(it.getValue() != 0.0 && grade < it.getKey()) {
                grade = it.getKey();
            }
        }
        return grade;
    }
}

