/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Julian
 */
public class JavaApplication3 {
      
    public static double[] crearArregloReales(int n){
      double[] A= new double[n];
      return A;
    }
    
    public static boolean[] crearArregloBoolean(int n){
      boolean[] B= new boolean[n];
      return B;
    }
    
    public static void llenarArregloTrue(boolean[] A, int n){
      for(int i=0; i<n; i++){
        A[i]=true;    
      }        
    }
    
    public static double[] tomarDatosCarro(double placa, double horaEnt){
      double[] A= crearArregloReales(3);
      A[0]=placa;
      A[1]=horaEnt;
      A[2]=0;
      return A;
    }
    
    public static int buscarParqueadero(boolean[] A, int n){
      boolean bandera=false;
      for(int i=0; i<n || !bandera; i++){
        if(A[i]==true){
          bandera|=(A[i]==true);    
          return i;
        }       
      }
      return -1;
    }
    
    public static void ocuparParqueadero(boolean[] A, int numParq){
      A[numParq]=false;    
    }
    
    public static double[] gananciasPorParqueadero(int n){
      double[] A= crearArregloReales(n);
      for(int i=0; i<n; i++){
        A[i]=0;   
      }
      return A;
    }
    
    public static double cobrarCarro(double tarifa, double horaLlegada, double horaSalida){
      return (horaSalida - horaLlegada)*tarifa;      
    }
    
    public static void liberarParqueadero(boolean[] A, int numParq){
      A[numParq-1]=true;    
    }
      
    public static void asignarGananciasParqueadero(double[] A, int numParq, double valor){
      A[numParq]+=valor;      
    }
    
    public static double gananciasDia(double[] A, int n){
      if(n==1){
        return A[0];    
      }else{
        return gananciasDia(A,n-1)+A[n-1];    
      }
    }
    
    public static int parqueaderosLibres(boolean[] A, int n){
      int c=0;
      for(int i=0; i<n; i++){
        if(A[i]==true){
          c++;    
        }    
      }
      return c;
    }
    
    public static String graficaParqueaderos(boolean[] A){
      String os="";
        for(int i=0; i<23; i++){
          if(A[i]==true){
            os+=(i+1) + " ";    
          }else{
            os+= "[" + (i+1) + "]";     
          }
        }
        if(A[23]==true){
          os+=24 + "\n";    
        }else{
          os+= "[" + 24 + "]" + "\n";     
        }    
        for(int i=24; i<44; i++){
          if(A[i]==true){
            os+=(i+1) + " ";    
          }else{
            os+= "[" + (i+1) + "]";     
          }    
        }
        if(A[44]==true){
          os+=45 + "\n";    
        }else{
          os+= "[" + 45 + "]" + "\n";     
        }
        for(int i=45; i<65; i++){
          if(A[i]==true){
            os+=(i+1) + " ";    
          }else{
            os+= "[" + (i+1) + "]";     
          }    
        }
        if(A[65]==true){
          os+= 66 + "\n";    
        }else{
          os+= "[" + 66 + "]" + "\n";     
        }
        for(int i=66; i<85; i++){
          if(A[i]==true){
            os+=(i+1) + " ";    
          }else{
            os+= "[" + (i+1) + "]";     
          }
        }
      if(A[86]==true){
        os+= 87;    
      }else{
        os+= "[" + 87 + "]";     
      }
      return os;    
    }
              
    public static void main(String[] args) {
     int n=87;
     boolean[] parqueadero = crearArregloBoolean(n);
     double[] gananciasPorParqueadero= gananciasPorParqueadero(n); 
     llenarArregloTrue(parqueadero,n);
     int menu;
     do{
     System.out.println(graficaParqueaderos(parqueadero));
     java.util.Scanner lectura= new java.util.Scanner(System.in);
     System.out.println("Digite 1 para ingresar carro ");
     System.out.println("Digite 2 para sacar carro ");    
     System.out.println("Digite 3 para ganancias del dia ");
     System.out.println("Digite 4 para saber numero de puestos libres ");
     System.out.println("Digite 0 para salir");
     menu= lectura.nextInt();
     if (menu == 1){ 
       System.out.println("\n");
       System.out.println("Digite los numeros de la placa: ");
       double placa;
       placa= lectura.nextDouble();
       System.out.println("Digite la hora de entrada: ");
       double horaEnt;
       horaEnt = lectura.nextDouble();
       double[] datosCarro= tomarDatosCarro(placa,horaEnt);
       int parqueaderoLibre= buscarParqueadero(parqueadero,n);
       if(parqueaderoLibre!=-1){
         System.out.println("*****Dirijase al parqueadero numero " + (parqueaderoLibre+1) + "*****");
         ocuparParqueadero(parqueadero,parqueaderoLibre);
       }else{
         System.out.println("*****No hay parqueaderos disponibles*****");    
       }
     }
     if (menu== 2){
       System.out.println("\n");
       System.out.println("Ingrese la tarifa por hora");
       int tarifa= lectura.nextInt();
       System.out.println("Ingrese la hora de llegada del carro");
       double horaLlegada= lectura.nextInt();
       System.out.println("Ingrese la hora de salida del carro");
       double horaSalida= lectura.nextInt();
       System.out.println("Ingrese el numero de parqueadero en el que estaba ubicado el carro");
       int numParqueadero= lectura.nextInt();
       double cobrar= cobrarCarro(tarifa,horaLlegada,horaSalida);
       System.out.println("*****Valor a pagar = " + cobrar + "*****" );
       liberarParqueadero(parqueadero,numParqueadero);
       asignarGananciasParqueadero(gananciasPorParqueadero,numParqueadero,cobrar);
     }
    if(menu==3){
      System.out.println("\n");
      double ganancias= gananciasDia(gananciasPorParqueadero, n);    
      System.out.println("*****Ganancias del dia= " + ganancias + "*****");       
    }
    if(menu==4){
      System.out.println("\n");  
      int parqueaderosLibres= parqueaderosLibres(parqueadero,n);  
      System.out.println("*****Parqueaderos libres= " + parqueaderosLibres + "*****");
    }
    } 
    while(menu!=0); 
    }   
}    
      
    
    
    

