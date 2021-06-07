import java.util.Random;

public class Persona{
    private String nombre;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;
    private String nss;

    private final char SEXO = 'H';

    public Persona(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(){}

    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public char getSexo(){
        return this.sexo;
    }

    public double getPeso(){
        return this.peso;
    }

    public double getAltura(){
        return this.altura;
    }

    public String getNSS(){
        return this.nss;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setSexo(char sexo){
        this.sexo = (sexo == ' ' ? SEXO:sexo);
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setAltura(float altura){
        this.altura = altura;
    }

    public int calcularIMC(){
        double result = this.peso/Math.pow(this.altura, 2);
        final int bajo = -1;
        final int ideal = 0;
        final int arriba = 1;
        int imc = 0;
        switch (this.sexo == ' ' ? SEXO:this.sexo){
            case 'H':
                if(result < 20){
                    imc = bajo;
                }else if(result >= 20 && result <= 25){
                    imc = ideal;
                }else{
                    imc = arriba;
                }
            break;
            case 'M':
                if(result < 19){
                    imc = bajo;
                }else if(result >= 19 && result <= 24){
                    imc = ideal;
                }else{
                    imc = arriba;
                }
            break;
        }
        return imc;
    }

    public boolean esMayorDeEdad(){
        return (this.edad >= 18)?true:false;
    }

    public boolean comprobarSexo(char sexo){
        return sexo == SEXO || sexo == 'M' ? true:false;
    }

    public void generarNSS(){
        String caracteres = this.nombre.replace(" ", "");
        String numbers = "0123456789";
        Random rnd = new Random();
        char[] result = new char[8];
        for(int i = 0; 8 > i; i++){
            result[i] = caracteres.charAt(rnd.nextInt(caracteres.length()));
            i++;
            result[i] = numbers.charAt(rnd.nextInt(numbers.length()));
        }
        this.nss = String.valueOf(result).toUpperCase();
    }

    public String toString(){
        return "Persona\nNombre: "+this.nombre+"\nEdad: "+this.edad+"\nSexo: "+
        (this.sexo == ' ' ? SEXO:this.sexo)+"\nPeso: "+this.peso+"\nAltura: "+this.altura+"\nNSS: "
        +this.nss;
    }
}