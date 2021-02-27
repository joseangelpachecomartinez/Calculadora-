/*Crear una biblioteca dinámica que contenga las operaciones matemáticas básicas 
en números enteros, dicha biblioteca deberá ser referencia a una aplicación de 
CALCULADORA, por lo que cada una de esas operaciones que ejecute CALCULADORA 
deberá realizarse desde la biblioteca.*/

package calculadora;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import operadores.Aritmetico;

public class Ventana extends JFrame{
    
    public Ventana(){ //Crear Ventana
    setTitle("Calculadora");//Titulo de la ventana
    setSize(250, 300);//Tamaño de la ventana
    setLocationRelativeTo(null);//Centrar la ventana
    
    Panel p = new Panel();//Instanciar el JPanel
    add(p);//Agregarlo a la ventana
    p.setLayout(null);//Para modificar los componentes 
}
}

class Panel extends JPanel { //Crear el panel
    public void paintComponent(Graphics g){
        //Intanciar botones
        JButton Suma = new JButton("+");
        JButton Resta = new JButton("-");
        JButton Multiplicacion = new JButton("x");
        JButton Division = new JButton("/");
        
        //crear las cajas de texto
        JTextField txtNum1 = new JTextField();
        JTextField txtNum2 = new JTextField();
        JTextField txtResultado = new JTextField();
        
        //crear etiquetas
        JLabel etNum1 = new JLabel("Numero 1");
        JLabel etNum2 = new JLabel("Numero 2");
        JLabel resultado = new JLabel("Resultado");
        
        //Dar tamaño y pocion de las etiquetas
        etNum1.setBounds(30, 25, 60, 20); 
        etNum2.setBounds(130, 25, 60, 20);
        resultado.setBounds(70, 80, 70, 20);
        
        //Dar tamaño y pocion de las cajas de textos
        txtNum1.setBounds(30, 50, 80, 20);
        txtNum2.setBounds(130, 50, 80, 20);
        txtResultado.setBounds(70, 100, 80, 20);
        
        //Dar tamaño y pocion de los botones
        Suma.setBounds(20, 150, 80, 30);
        Resta.setBounds(120, 150, 80, 30);
        Multiplicacion.setBounds(20, 200, 80, 30);
        Division.setBounds(120, 200, 80, 30);
        
        //Ponerle tipo y tamaño de letra de los botones
        Suma.setFont(new Font("arial", Font.BOLD, 30));
        Resta.setFont(new Font("arial", Font.BOLD, 30));
        Multiplicacion.setFont(new Font("arial", Font.BOLD, 30));
        Division.setFont(new Font("arial", Font.BOLD, 30));
        
        //Agregar los componentes al panel
        add(Suma);
        add(Resta);
        add(Multiplicacion);
        add(Division);
        add(txtNum1);
        add(txtNum2);
        add(txtResultado);
        add(etNum1);
        add(etNum2);
        add(resultado);
        
        ActionListener Evento = new ActionListener() {//intanciar las acciones de los botones 
            @Override
            public void actionPerformed(ActionEvent e) {
                Aritmetico A = new Aritmetico(); // instanciamos la libreria creada
                
                int num1, num2, resultado; // declarar variable
                String re;
                
                if(e.getSource()==Suma){ //condicion si presional el boton Suma
                    if(txtNum1.getText().equals("")||txtNum2.getText().equals("")){//si las cajas de texto estan vacias
                        JOptionPane.showMessageDialog(null, "Los datos no estan completos",//enunciado de error
                                "Error", JOptionPane.WARNING_MESSAGE);//nombre de la ventana emergete
                    }else{
                        
                        //convertir a entero
                        num1=Integer.parseInt(txtNum1.getText());
                        num2=Integer.parseInt(txtNum2.getText());
                        
                        //usar la libreria 
                        resultado = A.Sumar(num1, num2);
                        
                        re=String.valueOf(resultado);//convertir el resultado en String
                        txtResultado.setText(re);//agregarlo a la caja de texto
                    }
                }
                if(e.getSource()== Resta){//al presionar el boton Resta
                    if(txtNum1.getText().equals("")||txtNum2.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Los datos no estan completos",
                                "Error", JOptionPane.WARNING_MESSAGE);
                    }else{
                        num1=Integer.parseInt(txtNum1.getText());
                        num2=Integer.parseInt(txtNum2.getText());
                        
                        resultado = num1 - num2;
                        re=String.valueOf(resultado);
                        txtResultado.setText(re);
                    }
                }
                if(e.getSource()== Multiplicacion){ // al presionar el boton multiplicacion
                    if(txtNum1.getText().equals("")||txtNum2.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Los datos no estan completos",
                                "Error", JOptionPane.WARNING_MESSAGE);
                    }else{
                        num1=Integer.parseInt(txtNum1.getText());
                        num2=Integer.parseInt(txtNum2.getText());
                        
                        resultado = num1 * num2;
                        re=String.valueOf(resultado);
                        txtResultado.setText(re);
                    }
                }
                if(e.getSource()== Division){// al presionar el boton Division
                    if(txtNum1.getText().equals("")||txtNum2.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Los datos no estan completos",
                                "Error", JOptionPane.WARNING_MESSAGE);
                    }else{
                        num1=Integer.parseInt(txtNum1.getText());
                        num2=Integer.parseInt(txtNum2.getText());
                        
                        try{
                        resultado = num1 / num2;
                        re=String.valueOf(resultado);
                        txtResultado.setText(re);
                        }catch(ArithmeticException ex){
                            JOptionPane.showMessageDialog(null, "Error de Sintaxis", "Error",
                            JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        };
        
        //para darle evento al boton
        Suma.addActionListener(Evento);
        Resta.addActionListener(Evento);
        Multiplicacion.addActionListener(Evento);
        Division.addActionListener(Evento);
}
}