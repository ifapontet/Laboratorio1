/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecciones;

/**
 *
 * @author Julian
 */
public class Elecciones {
    
    public static int[] crearArregloEnteros(int n){
      int[] A= new int[n];
      return A;
    }
     
    public static double[] crearArregloReales(int n){
      double[] A= new double[n];
      return A;
    }
    
    public static String[] crearArregloString(int n){
      String[] A= new String[n];
      return A;
    }
    
    public static int[][] crearMatrizEnteros(int n, int m){
      int[][] A= new int[n][m];
      for(int i=0; i<n; i++){
        A[i]= crearArregloEnteros(m);      
      }
      return A;   
    }
    
    public static int[][] votosMatrizEnteros(int n, int m, String[] C){
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      int[][] A= crearMatrizEnteros(n,m);
      for(int i=0; i<n; i++){ 
        for(int j=0; j<m; j++){
          System.out.print("Ingrese los votos en el municipio " + (i+1) + " del candidato " + C[j] + ": ");  
          A[i][j]=lectura.nextInt();       
        }
      }    
      return A;
    }        
    
    public static String[] nombresCandidatos(int n){
      String[] A= crearArregloString(n);
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      for(int i=0; i<n; i++){
        System.out.print("Ingrese el nombre del candidato " + (i+1) + ": ");
        A[i]=lectura.next();
      }
      return A;
    }
    
    public static int[] votos(int n, String[] B){
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      int[] A= crearArregloEnteros(n);
      for(int i=0; i<n; i++){
        System.out.print("Ingrese los votos del candidato " + B[i] + " en el municipio " + (i+1) + ": ");
        A[i]=lectura.nextInt();
      }
      return A;  
    }
    
    public static String escribirTablaVotos(int[][] A, int n, int m){
      String os= "Candidatos:  " + 1;
      for(int h=1; h<m-1; h++){
        os+= " " + (h+1) + " ";    
      }
      os+= n + "\n";
      for(int i=0; i<n; i++){
        os+= "Municipio " + (i+1) + "  ";    
        for(int j=0; j<m-1; j++){
          os+= A[i][j] + " ";        
        }
        os+= A[i][m-1] + "\n";
      }
      return os;
    }
    
    public static int[] ordenarArregloEnteros(int[] A, int n){
      int aux;
      for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
          if(A[j]<A[i]){
            aux=A[i];
            A[i]=A[j];
            A[j]=aux;
          }        
        }        
      }
      return A;    
    }
    
    public static int totalVotos(int[][] A, int n, int m){
      int c=0;
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          c+=A[i][j];    
        }        
      }
      return c;  
    }
    
    public static int[] votosPorCandidato(int[][] A, int n, int m){
      int[] votosPorCandidato= crearArregloEnteros(m);
      for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){    
          votosPorCandidato[i]+=A[j][i];    
        }             
      }
      return votosPorCandidato;  
    }  
    
    public static double[] porcentajesVotos(int[] A, int n, int m, int totalVotos){
      double[] porcentajes= crearArregloReales(m);
      for(int i=0; i<m; i++){
        porcentajes[i]=(A[i]*100)/totalVotos;    
      }
      return porcentajes;
    }
          
    public static int buscarSubIndice(int[] A, int n, int h){
      int[] B= crearArregloEnteros(n);
      B=ordenarArregloEnteros(A,n);
      for(int i=0; i<n; i++){
        if(A[h]==B[i]){
          return i;    
        }      
      }
      return -1;
     }
    
    public static int ganadorMitadVotos(double A[], int m){
      int ganador=0;
      for(int i=0; i<m; i++){
        if(A[i]>50){
          return ganador=i;     
        }    
      }
      return ganador=-1;
    }
    
    public static String[] ordenarNombresCandidatos(int[] A, int n, String[] B){
      String[] C= crearArregloString(n);
      for(int i=0; i<n; i++){
        C[buscarSubIndice(A,n,i)]=B[i];        
      }
      return C;
    }
    
    public static String escribirCandidatosOrdenados(String[] A, int n, int[] B){
      String os;
      os = "****Candidatos****" + "\n"; 
      for(int i=0; i<n; i++){
        os+= (i+1) + "." + A[i] + "  " + B[i] + "\n";   
      }
      return os;
    }
    
    public static String segundaVuelta(String[] A, int n){      
      String os;
      os = "Candidatos segunda vuelta" + "\n";
      os+= "1." + A[n-1] + "\n";
      os+= "2." + A[n-2] + "\n";
      return os;
    }
    
    public static void main(String[] args) {
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      System.out.print("Ingrese el numero de municipios: ");
      int n= lectura.nextInt();
      System.out.print("Ingrese el numero de candidatos: ");
      int m= lectura.nextInt();
      String[] nombres= nombresCandidatos(m);
      int[][] votos= votosMatrizEnteros(n,m,nombres);
      String escribir= escribirTablaVotos(votos,n,m);
      System.out.print(escribir);
      int totalVotos= totalVotos(votos,n,m);
      int[] votosPorCandidato= votosPorCandidato(votos,n,m);
      int[] votosOrdenados= ordenarArregloEnteros(votosPorCandidato,n);
      double[] porcentajes= porcentajesVotos(votosPorCandidato,n,m,totalVotos);
      int ganadorMitadVotos= ganadorMitadVotos(porcentajes,m);
      String[] nombresOrdenados= ordenarNombresCandidatos(votosPorCandidato,n,nombres);
      if(ganadorMitadVotos!=-1){ 
        String escribirCandidatosOrdenados= escribirCandidatosOrdenados(nombresOrdenados,n,votosOrdenados);
        System.out.print(escribirCandidatosOrdenados);
        System.out.println("Ganador: " + nombres[ganadorMitadVotos]);    
      }else{
        System.out.print("\n");
        String escribirCandidatosOrdenados= escribirCandidatosOrdenados(nombresOrdenados,n,votosOrdenados);
        System.out.print(escribirCandidatosOrdenados);
        String segundaVuelta=segundaVuelta(nombresOrdenados,n);  
        System.out.println(segundaVuelta); 
      } 
    }
    
}
