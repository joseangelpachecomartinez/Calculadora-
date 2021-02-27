

package operadores;
public class Aritmetico {
    public int Sumar(int num1, int num2){ // metodo sumar
        return(num1+num2);
    }
    public int Restar(int num1, int num2){//metodo restar
           return(num1-num2);
    }
    public int Multiplicar(int num1, int num2){//metodo multiplicar
        return(num1*num2);
    }
    public int Dividir(int num1, int num2){//metodo multiplicar
        if(num2 !=0){
        return(num1/num2);
        }else{
                System.err.println("No se puede dividir entre cero");
                }
    
        return 0;
    }
}