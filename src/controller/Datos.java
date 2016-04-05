package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javafx.scene.chart.Chart;
import view.Interfaz;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import view.MensajeErr;

/**
 *
 * @author pablo
 */
public class Datos {

    
    MensajeErr me=new MensajeErr();
    int pA = 0, pC = 0;
    String operator = "";
    String todo = "";
    Boolean state = true;
    Interfaz i;
    Stack<String> stk = new Stack<>();

    public Datos() {
        i = new Interfaz();

        for (Button bt : i.getNumerics()) {
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        Integer.parseInt(i.getDisplay().getText());
                    } catch (NumberFormatException e) {
                        stk.add(i.getDisplay().getText());
                    }
                    i.getDisplay().setText(i.getDisplay().getText() + arg0.getActionCommand());//va poniendo los numeros
                    i.requestFocus();
                }
            });
        }

        i.getParAButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pA=pA+1;
                String s = i.getDisplay().getText();
                i.getDisplay().setText(meterCaracter(s, ae.getActionCommand()));
                i.requestFocus();
            }
        });

        i.getParCButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pC=pC+1;
                String s = i.getDisplay().getText();
                i.getDisplay().setText(meterCaracter(s, ae.getActionCommand()));
                i.requestFocus();
            }
        });

        i.getPlusButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = i.getDisplay().getText();
                i.getDisplay().setText(meterCaracter(s, ae.getActionCommand()));
                i.requestFocus();

            }
        });

        i.getMinusButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = i.getDisplay().getText();
                i.getDisplay().setText(meterCaracter(s, ae.getActionCommand()));
                i.requestFocus();
            }
        });

        i.getMulButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = i.getDisplay().getText();
                i.getDisplay().setText(meterCaracter(s, ae.getActionCommand()));
                i.requestFocus();
            }
        });

        i.getDivButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = i.getDisplay().getText();
                i.getDisplay().setText(meterCaracter(s, ae.getActionCommand()));
                i.requestFocus();
            }
        });

        i.getClearButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                i.getDisplay().setText("");
                i.requestFocus();
            }
        });

        i.getEqualsButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pA!=pC){
                    pA=0;
                    pC=0;
                    me.visibleON();
                    i.getDisplay().setText("");
                    i.requestFocus();
                    
                }else{
                todo = i.getDisplay().getText();
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                try {
                    String expression = todo;
                    Object result = engine.eval(expression);
                    i.getDisplay().setText(result + "");
                } catch (ScriptException se) {
                    System.out.println(se);
                }

                i.requestFocus();
                }
            }
        });

        i.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                i.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    todo = i.getDisplay().getText();
                    ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine engine = manager.getEngineByName("js");
                    try {
                        String expression = todo;
                        Object result = engine.eval(expression);
                        i.getDisplay().setText(result + "");
                    } catch (ScriptException se) {
                        System.out.println(se);
                    }

                    i.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                i.requestFocus();
            }
        });

        i.getDisplay().addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                i.requestFocus();
            }

            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
    }

    private String meterCaracter(String s, String ae) {

        String salida = "";
        if (s.length() == 0) {
            switch (ae) {
                case "(":
                    salida = ae;
                    break;
                case "-":
                    salida = ae;
                    break;
                default:
                    salida = "";

            }
        } else {
            if (!Character.isDigit(s.charAt(s.length() - 1))) {//si es un caracter

                switch (s.charAt(s.length() - 1)) {
                    case '(':
                        if (ae == "-" || ae == "(") {
                            salida = s + ae;
                        } else {
                            salida = s;
                        }
                        break;
                    case ')':
                        if (ae != "(") {
                            salida = s + ae;
                        } else {
                            salida = s;
                        }
                        break;

                    default:
                        switch (ae) {

                            case "(":
                                salida = s + ae;
                                break;
                            default:
                                salida = s.substring(0, s.length() - 1) + ae;
                        }

                }
            } else {
                if (ae == "(") {
                    salida = s;
                } else {
                    salida = s + ae;
                }
            }
        }
        return salida;

    }

}
