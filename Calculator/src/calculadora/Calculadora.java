package calculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculadora extends JFrame implements ActionListener{

    JButton b0, b00, b1, b2, b3, b4, b5, b6, b7, b8, b9, bp, bs, br, bm, bd, bi, bl;
    JTextField t1;
    JPanel pgg, pg1, pg2, p1, p2;
    JMenuBar menu;
    JMenu arquivo, ajuda;
    JMenuItem sair;
    
    private double numero = 0.0;
    private double resultado = 0.0;
    private String comp = "";
    private String calc;

    public Calculadora(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        pgg = new JPanel(new BorderLayout());
        pg1 = new JPanel(new FlowLayout());
        pg2 = new JPanel(new GridLayout(1, 2, 5, 0)); 
        p1 = new JPanel(new GridLayout(4, 3, 5, 5));  
        p2 = new JPanel(new GridLayout(3, 2, 5, 5));  

        menu = new JMenuBar();
        arquivo = new JMenu("Arquivo");
        sair = new JMenuItem("Sair");
        

        arquivo.add(sair);

        menu.add(arquivo);
        b0 = new JButton("0");
        b00 = new JButton("00");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bp = new JButton(".");
        bs = new JButton("+");
        br = new JButton("-");
        bm = new JButton("*");
        bd = new JButton("/");
        bi = new JButton("=");
        bl = new JButton("Limpar");
        t1 = new JTextField("0", 35);

        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b00);
        p1.add(b0);
        p1.add(bp);

        p2.add(bs);
        p2.add(br);
        p2.add(bm);
        p2.add(bd);
        p2.add(bi);
        p2.add(bl);

        pg1.add(t1);
        pg2.add(p1);
        pg2.add(p2);

        pgg.add(pg1, BorderLayout.NORTH);
        pgg.add(pg2, BorderLayout.CENTER);

        add(menu, BorderLayout.NORTH);
        add(pgg, BorderLayout.CENTER);

        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bs.addActionListener(this);
        br.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bi.addActionListener(this);
        b0.addActionListener(this);
        b00.addActionListener(this);
        bp.addActionListener(this);
        bl.addActionListener(this);
        sair.addActionListener(this);
        this.setVisible(true);
        this.setSize(800, 800);
        t1.setEditable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b0){
            calc = t1.getText();
            t1.setText(calc + "0");
        }

        if (ae.getSource() == b00){
            calc = t1.getText();
            t1.setText(calc + "00");
        }

        if (ae.getSource() == b1){
            calc = t1.getText();
            t1.setText(calc + "1");
        }

        if (ae.getSource() == b2){
            calc = t1.getText();
            t1.setText(calc + "2");
        }

        if (ae.getSource() == b3){
            calc = t1.getText();
            t1.setText(calc + "3");
        }

        if (ae.getSource() == b4){
            calc = t1.getText();
            t1.setText(calc + "4");
        }

        if (ae.getSource() == b5){
            calc = t1.getText();
            t1.setText(calc + "5");
        }

        if (ae.getSource() == b6){
            calc = t1.getText();
            t1.setText(calc + "6");
        }

        if (ae.getSource() == b7){
            calc = t1.getText();
            t1.setText(calc + "7");
        }

        if (ae.getSource() == b8){
            calc = t1.getText();
            t1.setText(calc + "8");
        }

        if (ae.getSource() == b9){
            calc = t1.getText();
            t1.setText(calc + "9");
        }

        if (ae.getSource() == bp){ 
            calc = t1.getText();
            t1.setText(calc + ".");
        }

        if (ae.getSource() == bs){ 
            try {
                funcSoma();
            } catch (NumberFormatException nfe) {
            	System.out.println(nfe.getMessage());
            }
        }

        if (ae.getSource() == br){ 
            try {
                funcResto();
            } catch (NumberFormatException nfe) {
            	System.out.println(nfe.getMessage());
            }
        }

        if (ae.getSource() == bm){
            try {
                funcMult();
            } catch (NumberFormatException nfe) {
               System.out.println(nfe.getMessage());
            }
        }

        if (ae.getSource() == bd){ // boton de division
            try {
                funcDiv();
            } catch (NumberFormatException nfe) {
            	System.out.println(nfe.getMessage());
            }
        }

        if (ae.getSource() == bi){ // boton de igualdad
            try {
            funcIgualdade();
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        }

        if (ae.getSource() == bl){ 
            resultado = 0.0;
            numero = 0.0;
            comp = "";
            calc = "";
            t1.setText("0");
        }

        if (ae.getSource() == sair){
            System.exit(0);
        }

    }

    public void funcSoma(){
        if(t1.getText() == ""){
            t1.setText("0");
        }

        numero = Double.parseDouble(t1.getText());

        if(comp == "-"){
            resultado = (resultado - numero);
            t1.setText("0");
        } else if(comp == "*"){
            resultado = (resultado * numero);
            t1.setText("0");
        } else if(comp == "/"){
            resultado = (resultado / numero);
            t1.setText("0");
        }

        comp = "+";
        numero = Double.parseDouble(t1.getText());
        resultado = (resultado + numero);
        t1.setText("0");
    }

    public void funcResto(){
        if(t1.getText() == ""){
            t1.setText("0");
        }

        numero = Double.parseDouble(t1.getText());

        if(comp == "+"){
            resultado = (resultado + numero);
            t1.setText("0");
        } else if(comp == "*"){
            resultado = (resultado * numero);
            t1.setText("0");
        } else if(comp == "/"){
            resultado = (resultado / numero);
            t1.setText("0");
        }

        comp = "-";
        numero = Double.parseDouble(t1.getText());
        resultado = (resultado - numero);
        t1.setText("0");
    }

    public void funcMult(){
        if(t1.getText() == ""){
            t1.setText("1");
        }

        numero = Double.parseDouble(t1.getText());

        if(comp == "+"){
            resultado = (resultado + numero);
            t1.setText("1");
        } else if(comp == "-"){
            resultado = (resultado - numero);
            t1.setText("1");
        } else if (comp == "/"){
            resultado = (resultado / numero);
            t1.setText("1");
        }

        if(resultado == 0.0){
            resultado = 1.0;
        }

        comp = "*";
        numero = Double.parseDouble(t1.getText());
        resultado = (resultado * numero);
        t1.setText("0");
    }

    public void funcDiv(){
        if(t1.getText() == ""){
            t1.setText("1");
        }

        numero = Double.parseDouble(t1.getText());

        if(comp == "+"){
            resultado = (resultado + numero);
            t1.setText("1");
        } else if(comp == "-"){
            resultado = (resultado - numero);
            t1.setText("1");
        } else if(comp == "*"){
            resultado = (resultado * numero);
            t1.setText("1");
        }

        if(resultado == 0.0){
            resultado = 1.0;
            comp = "/";
            numero = Double.parseDouble(t1.getText());
            resultado = (numero / resultado);
            t1.setText("0");
        } else {
            comp = "/";
            numero = Double.parseDouble(t1.getText());
            resultado = (resultado / numero);
            t1.setText("0");
        }
    }

    public void funcIgualdade(){
        numero = Double.parseDouble(t1.getText());

        if(comp == "+") {
            resultado = (resultado + numero);
            t1.setText("" + resultado);
        } else if (comp == "-") {
            resultado = (resultado - numero);
            t1.setText("" + resultado);
        } else if (comp == "*") {
            resultado = (resultado * numero);
            t1.setText("" + resultado);
        } else if (comp == "/") {
            resultado = (resultado / numero);
            t1.setText("" + resultado);
        }
        comp = "";
    }    
}