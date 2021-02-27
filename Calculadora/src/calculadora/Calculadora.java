
package calculadora;

import javax.swing.JFrame;


public class Calculadora {

    public static void main(String[] args) {
        Ventana v = new Ventana();//instanciar ventana
        v.setVisible(true);//hacerla visible
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//se termina de ejecutar al cerrarse
    }
    
}
