package ro.tuc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class View extends JFrame {
    private JTextField mInsetP1 = new JTextField();
    private JTextField mInsetP2 = new JTextField();
    private JTextField mResult = new JTextField();
    private JButton mMultiply = new JButton("Multiply");
    private JButton mDivide = new JButton("Divide");
    private JButton mAdd = new JButton("Add");
    private JButton mSubstraction = new JButton("Substraction");
    private JButton mIntegration = new JButton("Integration");
    private JButton mDerivation = new JButton("Derivation");
    private JButton mClear = new JButton("Clear");

    View() {
        mResult.setEditable(false);
        JPanel firstContent = new JPanel();
        JPanel secondContent = new JPanel();
        firstContent.add(new JLabel("First Polynom"));
        firstContent.add(mInsetP1).setPreferredSize(new Dimension(480, 30));
        firstContent.add(new JLabel("Second Polynom"));
        firstContent.add(mInsetP2).setPreferredSize(new Dimension(480, 30));
        firstContent.add(new JLabel("Result"));
        firstContent.add(mResult).setPreferredSize(new Dimension(480, 30));
        secondContent.add(mAdd).setPreferredSize(new Dimension(150, 75));
        secondContent.add(mSubstraction).setPreferredSize(new Dimension(150, 75));
        secondContent.add(mMultiply).setPreferredSize(new Dimension(150, 75));
        secondContent.add(mDivide).setPreferredSize(new Dimension(150, 75));
        secondContent.add(mDerivation).setPreferredSize(new Dimension(150, 75));
        secondContent.add(mIntegration).setPreferredSize(new Dimension(150, 75));
        secondContent.add(mClear).setPreferredSize(new Dimension(150, 75));
        this.setSize(500, 500);
        JPanel grid = new JPanel(new GridLayout(2, 1));
        grid.add(firstContent);
        grid.add(secondContent);
        this.add(grid);
        this.setResizable(false);
        this.setTitle("Caculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void clear() {
        mInsetP1.setText("");
        mInsetP2.setText("");
        mResult.setText("");
    }

    String getUserInputP1() {
        return mInsetP1.getText();
    }

    String getUserInputP2() {
        return mInsetP2.getText();
    }

    void mul(ActionListener e) {
        mMultiply.addActionListener(e);
    }

    void add(ActionListener e) {
        mAdd.addActionListener(e);
    }

    void sub(ActionListener e) {
        mSubstraction.addActionListener(e);
    }

    void deriv(ActionListener e) {
        mDerivation.addActionListener(e);
    }

    void integration(ActionListener e) {
        mIntegration.addActionListener(e);
    }

    void div(ActionListener e) {
        mDivide.addActionListener(e);
    }
    void clear(ActionListener e){
        mClear.addActionListener(e);
    }

    void SetValue(Polinom p) {
        mResult.setText(p.toString());
    }

    void setValueSpecial(String s) {
        mResult.setText(s);
    }

    void showError(String error){JOptionPane.showMessageDialog(this,error);}
}
