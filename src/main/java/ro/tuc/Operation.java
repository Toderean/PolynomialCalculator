package ro.tuc;

import java.util.Map;
import java.util.Objects;

public class Operation {
    Operation() {
    }

    public Polinom emptyFieldSubstraction(Polinom p, Polinom p2) {
        Polinom temp = new Polinom();
        if (p.polinom1.isEmpty()) {
            for (Map.Entry<Integer, Double> it : p2.polinom1.entrySet()) {
                temp.addMonom(new Monom(-it.getValue(), it.getKey()));
            }
            return temp;
        } else if (p2.polinom1.isEmpty()) {
            for (Map.Entry<Integer, Double> it : p.polinom1.entrySet()) {
                temp.addMonom(new Monom(it.getValue(), it.getKey()));
            }
            return temp;
        }
        return temp;
    }

    public Polinom emptyFieldAddition(Polinom p, Polinom p2) {
        Polinom temp = new Polinom();
        if (p.polinom1.isEmpty()) {
            for (Map.Entry<Integer, Double> it : p2.polinom1.entrySet()) {
                temp.addMonom(new Monom(it.getValue(), it.getKey()));
            }
            return temp;
        } else if (p2.polinom1.isEmpty()) {
            for (Map.Entry<Integer, Double> it : p.polinom1.entrySet()) {
                temp.addMonom(new Monom(it.getValue(), it.getKey()));
            }
            return temp;
        }
        return temp;
    }

    public Polinom addition(Polinom p1, Polinom p2) {
        Polinom temp = new Polinom();
        if (!p1.polinom1.isEmpty() && !p2.polinom1.isEmpty()) {
            for (Map.Entry<Integer, Double> it1 : p1.polinom1.entrySet()) {
                for (Map.Entry<Integer, Double> it2 : p2.polinom1.entrySet()) {
                    if (it1.getKey().equals(it2.getKey())) {
                        temp.addMonom(new Monom(it1.getValue() + it2.getValue(), it1.getKey()));
                    }
                 else{
                     temp.polinom1.putIfAbsent(it1.getKey(), it1.getValue());
                     temp.polinom1.putIfAbsent(it2.getKey(), it2.getValue());
                    }
                }
            }
        } else {
            temp = emptyFieldAddition(p1, p2);
        }
        return temp;
    }


    public Polinom substraction(Polinom p1, Polinom p2) {
        Polinom temp = new Polinom();
        if (!p1.polinom1.isEmpty() && !p2.polinom1.isEmpty()) {
            for (Map.Entry<Integer, Double> it1 : p1.polinom1.entrySet()) {
                for (Map.Entry<Integer, Double> it2 : p2.polinom1.entrySet()) {
                    if (Objects.equals(it1.getKey(), it2.getKey())) {
                        temp.addMonom(new Monom(it1.getValue() - it2.getValue(), it1.getKey()));
                    } else {
                        temp.polinom1.putIfAbsent(it1.getKey(), it1.getValue());
                        temp.polinom1.putIfAbsent(it2.getKey(), -it2.getValue());
                    }
                }
            }
        }else{
                temp = emptyFieldSubstraction(p1, p2);
            }
            return temp;
        }

        public Polinom multiplication (Polinom p1, Polinom p2){
            Polinom temp = new Polinom();
            for (Map.Entry<Integer, Double> it1 : p1.polinom1.entrySet()) {
                for (Map.Entry<Integer, Double> it2 : p2.polinom1.entrySet()) {
                    temp.addMonom(new Monom(it1.getValue() * it2.getValue(), it1.getKey() + it2.getKey()));
                }
            }
            return temp;
        }


        public String division (Polinom p1, Polinom p2) throws IncorrectPolynomException {
            Polinom q = new Polinom();
            if (p1.polinom1.isEmpty() || p2.polinom1.isEmpty()) {
                throw new IncorrectPolynomException("Error Input");
            }
            if (p2.returnMax() > p1.returnMax()) {
                throw new IncorrectPolynomException("Error Input");
            }
            Polinom aux = p1;
            while (!aux.polinom1.isEmpty() & aux.returnMax() >= p2.returnMax()) {
                Polinom t = new Polinom();
                double c = aux.polinom1.get(aux.returnMax()) / p2.polinom1.get(p2.returnMax());
                int pow = aux.returnMax() - p2.returnMax();
                q.addMonom(new Monom(c, pow));
                for (int key : p2.getPolinom1().keySet()) {
                    t.addMonom(new Monom(c * p2.polinom1.get(key), key + pow));
                }
                aux = substraction(aux, t);
            }
            return q + "  rest: " + aux;
        }

        public Polinom derivation (Polinom p1){
            Polinom temp = new Polinom();
            for (Map.Entry<Integer, Double> it1 : p1.polinom1.entrySet()) {
                temp.addMonom(new Monom(it1.getValue() * it1.getKey(), it1.getKey() - 1));
            }
            return temp;
        }

        public Polinom integration (Polinom p1){
            Polinom temp = new Polinom();
            for (Map.Entry<Integer, Double> it1 : p1.polinom1.entrySet()) {
                if (it1.getKey() != 0) {
                    temp.addMonom(new Monom(it1.getValue() * (1.0 / (it1.getKey() + 1)), it1.getKey() + 1));
                }
            }
            return temp;
        }
    }
