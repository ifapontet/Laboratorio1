/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Julian
 */
public class JavaApplication1 {
    public static boolean[] crearArregloBoolean(int n){
      boolean[] B= new boolean[n];
      return B;
    }
    
    public static String[] crearArregloString(int n){
      String[] A= new String[n];
      return A;
    }
    
    public static int[] crearArregloEnteros(int n){
      int[] A= new int[n];
      return A;
    }
    
    public static boolean[][] crearMatrizBoolean(int n, int m){
      boolean[][] A= new boolean[n][m];
      for(int i=0; i<n; i++){
        A[i]=crearArregloBoolean(m);    
      }
      return A;
    }
    
    public static int[][] crearMatrizEnteros(int n, int m){
      int[][] A= new int[n][m];
      for(int i=0; i<n; i++){
        A[i]=crearArregloEnteros(m);    
      }
      return A;
    }
    
    public static String[][] crearMatrizString(int n, int m){
      String[][] A= new String[n][m];
      for(int i=0; i<n; i++){
        A[i]=crearArregloString(m);    
      }
      return A;
    }
    
    public static void matrizTrue(boolean[][] A, int n, int m){
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          A[i][j]= true;
        }    
      } 
    }
   
    
    public static void ocuparPuesto(int pos, int fila, boolean[][] A){
      A[fila][pos]=false;    
    }

    public static void ocuparPuestoCedula(int pos, int fila, int[][] A, int cedula){
      A[fila][pos]=cedula;    
    }
    
    public static void ocuparPuestoNombre(int pos, int fila, String[][] A, String nombre){
      A[fila][pos]=nombre;    
    }
    
    public static int[] asignarPuestoEjec(boolean[][] A, int[][] B, String[][] C, int n, int m){
      int[] puesto= crearArregloEnteros(2);
      puesto[0]=-1;
      puesto[1]=-1;
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      System.out.println("Digite 1 para ventana o 2 para pasillo");
      int posicion= lectura.nextInt();
      System.out.println("Digite cedula");
      int cedula=lectura.nextInt();
      System.out.println("Digite nombre");
      String nombre=lectura.next();
      if(posicion==1){
        for(int i=0; i<n; i++){
          if(A[i][0]==true){
            puesto[0]= i;
            puesto[1]= 0; 
          }
          if(A[i][n-1]==true){
            puesto[0]= i;
            puesto[1]= n-1;      
          }
        }    
      }else{
       for(int i=0; i<n; i++){
          if(A[i][1]==true){
            puesto[0]= i;
            puesto[1]= 1; 
          }
          if(A[i][2]==true){
            puesto[0]= i;
            puesto[1]= 2;      
          }      
      }
    }
      ocuparPuesto(puesto[1],puesto[0],A);
      ocuparPuestoCedula(puesto[1],puesto[0],B,cedula);
      ocuparPuestoNombre(puesto[1],puesto[0],C,nombre);
      return puesto;
    }     
          
    public static int[] asignarPuestoEco(boolean[][] A, int[][] B, String[][] C, int n, int m){
      int[] puesto= crearArregloEnteros(2);
      puesto[0]=-1;
      puesto[1]=-1;
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      System.out.println("Digite 1 para ventana, 2 para centro, 3 para pasillo");
      int posicion= lectura.nextInt();
      System.out.println("Digite cedula");
      int cedula=lectura.nextInt();
      System.out.println("Digite nombre");
      String nombre=lectura.next();    
      if(posicion==1){
        for(int i=0; i<n; i++){
          if(A[i][0]==true){
            puesto[0]= i;
            puesto[1]= 0;         
          }
          if(A[i][n-1]==true){
            puesto[0]= i;
            puesto[1]= n-1;         
          }
        }
      }
      if(posicion==2){
        for(int i=0; i<n; i++){
          if(A[i][1]==true){
            puesto[0]= i;
            puesto[1]= 1; 
          }
          if(A[i][n-2]==true){
            puesto[0]= i;
            puesto[1]= n-2;                  
          }  
        }
      
      }
      if(posicion==3){
        for(int i=0; i<n ; i++){
          if(A[i][0]==true){
            puesto[0]= i;
            puesto[1]= 0;          
          }
          if(A[i][n-1]==true){
            puesto[0]= i;
            puesto[1]= n-1;                       
          }
        }
      }
      ocuparPuesto(puesto[1],puesto[0],A);
      ocuparPuestoCedula(puesto[1],puesto[0],B,cedula);
      ocuparPuestoNombre(puesto[1],puesto[0],C,nombre);           
      return puesto;
    }
    
    public static int sillasEjecutivasOcupadas(boolean[][] A, int n, int m){
      int c=0;
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(A[i][j]==false){
            c++;    
          }    
        }    
      }
      return c;  
    }
    
    public static int[] localizarSillaCedula(int[][] A, int n, int m, int cedula){
      int[] puesto= crearArregloEnteros(2);
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(A[i][j]==cedula){
            puesto[0]=i;
            puesto[1]=j;
          }    
        }    
      }
     return puesto;   
    }
    
    public static int[] sillaEconomicaDisponible(boolean[][] A, int n, int m){
      int[] puesto= crearArregloEnteros(2);
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(A[i][j]==true){
            puesto[0]=i;
            puesto[1]=j;
          }    
        }    
      }
      return puesto;  
    }
    
    public static void anularReserva(boolean[][] A, int fila, int posicion){
      A[fila][posicion]= true;      
    }
    
    public static int numeroSillasVentanaEco(boolean[][] A, int n, int m){
      int c=0;
      for(int i=0; i<n; i++){
        if((A[i][1]==true)||(A[i][n-1]==true))
          c++;    
        }    
      return c;  
    }
    
    public static boolean nombresIgualesEco(String[][] A, int n, int m){
      boolean c= false;    
      for(int i=0; i<n && !c; i++){
        for(int j=0; j<m; j++){
          for(int h=1; h<n; h++){
            for(int k=1; k<m; k++){
             c|=((A[i][j]).equals(A[h][k]));    
            }  
          }    
        }     
      }    
      return c;
    }
    
    public static String graficarAvion(boolean[][] A, boolean[][] B){
      String os= "";
      for(int i=0; i<2; i++){
        for(int j=0; j<2; j++){
          if(A[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }     
      os+= "     ";
        for(int j=2; j<4; j++){
          if(A[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }
      os+="\n";
    }
    os+= "\n" + "\n";
    for(int i=0; i<7; i++){
        for(int j=0; j<3; j++){
          if(B[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }     
      os+= " ";
        for(int j=3; j<6; j++){
          if(B[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }
      os+="\n";
    }
      return os;
    }
    
    public static void main(String[] args) {
      int nEjec=2;
      int mEjec=4;
      int nEco=7;
      int mEco=6;
      int menu;
      int opcion;
      int[] puesto;
      boolean[][] sillasEjec= crearMatrizBoolean(nEjec, mEjec);
      boolean[][] sillasEco= crearMatrizBoolean(nEco,mEco);
      int[][] sillasEjecB= crearMatrizEnteros(nEjec, mEjec);
      int[][] sillasEcoB= crearMatrizEnteros(nEco,mEco);
      String[][] sillasEjecC= crearMatrizString(nEjec, mEjec);
      String[][] sillasEcoC= crearMatrizString(nEco,mEco);
      matrizTrue(sillasEjec,nEjec,mEjec);
      matrizTrue(sillasEco,nEco,mEco);
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      do{
        System.out.println(graficarAvion(sillasEjec,sillasEco));
        System.out.println("Digite 1 para asignar sillas");
        System.out.println("Digite 2 para sistema de reportes");
        menu=lectura.nextInt();
        if(menu==1){
          System.out.println("Digite 1 para asignar sillas en clase ejecutiva");
          System.out.println("Digite 2 para asignar sillas en clase economica");
          opcion=lectura.nextInt();
          if(opcion==1){
            puesto= asignarPuestoEjec(sillasEjec,sillasEjecB,sillasEjecC,nEjec,mEjec);
            if(puesto[0]!=-1){
              System.out.println("***Su silla es la " + puesto[0] + "." + puesto[1] + " en clase ejecutiva***");    
            }else{
              System.out.println("***No hay sillas disponibles***");
            }
          }else{
            puesto= asignarPuestoEco(sillasEco,sillasEcoB,sillasEcoC,nEco,mEco);
            if(puesto[0]!=-1){
              System.out.println("***Su silla es la " + puesto[0] + puesto[1] + " en clase economica");    
            }else{
              System.out.println("***No hay sillas disponibles***");
            }
          }
        }
        if(menu==2){
          System.out.println("Digite 1 para contar sillas ejecutivas ocupadas");      
          System.out.println("Digite 2 para localizar la silla de un pasajero con numero de cedula en clase economica");
          System.out.println("Digite 3 para localizar una silla economica disponible");
          System.out.println("Digite 4 para anular reserva");
          System.out.println("Digite 5 para contar numero de puestos disponibles en ventana en clase economica");
          System.out.println("Digite 6 para identificar si hay dos personas con nombres iguales en clase economica");
          opcion= lectura.nextInt();
          if(opcion==1){
            System.out.println("***El numero de sillas ocupadas es: " + sillasEjecutivasOcupadas(sillasEjec,nEjec,mEjec)+ "***");      
          }
          if(opcion==2){
            System.out.println("Ingrese numero de cedula");  
            int cedula=lectura.nextInt();
            puesto= localizarSillaCedula(sillasEcoB,nEco, mEco, cedula);
            System.out.println("***Esta en la silla: " + puesto[0] + "." + puesto[1] + "***");      
          }
          if(opcion==3){
            puesto= sillaEconomicaDisponible(sillasEco,nEco, mEco);
            System.out.println("***Silla: " + puesto[0] + "." + puesto[1] + "***");      
          }
          if(opcion==4){
            System.out.println("ingrese 1 si su clase es ejecutiva y 2 si es economica");
            int opc=lectura.nextInt();
            if(opc==1){            
              System.out.println("ingrese la fila de su puesto para anular reserva");      
              int fila= lectura.nextInt();
              System.out.println("ingrese la posicion de su silla para anular reserva");
              int posicion= lectura.nextInt();
              anularReserva(sillasEjec, nEjec, mEjec);    
            }
            if(opc==2){            
              System.out.println("ingrese la fila de su puesto para anular reserva");      
              int fila= lectura.nextInt();
              System.out.println("ingrese la posicion de su silla para anular reserva");
              int posicion= lectura.nextInt();
              anularReserva(sillasEco, nEco, mEco);    
            }
          }
          if(opcion==5){
            System.out.println("***Puestos disponibles en ventana en clase economica: " + numeroSillasVentanaEco(sillasEco,nEco,mEco) + "***" );    
          }
          if(opcion==6){
            if(nombresIgualesEco(sillasEcoC,nEco,mEco)){  
              System.out.println("Si hay dos personas con nombres iguales en clase economica");    
            }else{ 
              System.out.println("No hay dos personas con nombres iguales en clase economica");    
            }     
          }
        } 
      }
      while(menu!=0);  
      
     
      }
    
}
