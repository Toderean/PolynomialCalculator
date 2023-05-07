package ro.tuc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control{
    View tempView = new View();
    Operation tempOp = new Operation();
    Control(){
        tempView.mul(new MultiplyListener());
        tempView.div(new DivisionListener());
        tempView.add(new AdittionListener());
        tempView.sub(new SubstractionListener());
        tempView.deriv(new DerivationListener());
        tempView.integration(new IntegrationListener());
        tempView.clear(new ClearListener());
    }


    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
              Polinom userInput = new Polinom(tempView.getUserInputP1());
              Polinom userInput2 = new Polinom(tempView.getUserInputP2());
              Polinom res = tempOp.multiplication(userInput, userInput2);
              tempView.SetValue(res);
        }
    }
    class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom userInput = new Polinom(tempView.getUserInputP1());
            Polinom userInput2 = new Polinom(tempView.getUserInputP2());
            String res = "";
            try {
                res = tempOp.division(userInput, userInput2);
            } catch (IncorrectPolynomException ex) {
                tempView.showError("Wrong input");
            }
            tempView.setValueSpecial(res);
        }
    }

    class AdittionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom userInput = new Polinom(tempView.getUserInputP1());
            Polinom userInput2 = new Polinom(tempView.getUserInputP2());
            Polinom res = tempOp.addition(userInput,userInput2);
            tempView.SetValue(res);
        }
    }

    class SubstractionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom userInput = new Polinom(tempView.getUserInputP1());
            Polinom userInput2 = new Polinom(tempView.getUserInputP2());
            Polinom res = tempOp.substraction(userInput,userInput2);
            tempView.SetValue(res);
        }
    }
    class DerivationListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom userInput = new Polinom(tempView.getUserInputP1());
            Polinom res = tempOp.derivation(userInput);
            tempView.SetValue(res);
        }
    }
    class IntegrationListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom userInput = new Polinom(tempView.getUserInputP1());
            Polinom res = tempOp.integration(userInput);
            tempView.SetValue(res);
        }
    }
    class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            tempView.clear();
        }
    }

}
