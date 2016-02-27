/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

import java.util.Arrays;

/**
 *
 * @author 
 */
public class Laboratorio1 {

    /**
     * @param 
     */
    //PRODUCTOS//
  public static int[] CodProducto(int numProductos){
    java.util.Scanner lectura= new java.util.Scanner(System.in);     
    int[] C;
      C = new int[numProductos];
    for(int i=0;i<numProductos;i++){
      System.out.println("Ingrese el codigo del producto "+ (i+1) +": ");
      int codigo= lectura.nextInt();
      C[i] = codigo;
    }
    return C;
  }
  public static String[] DescripcionProducto(int numProductos){
    java.util.Scanner lectura= new java.util.Scanner(System.in);    
    String[] D = new String[numProductos];
    for(int i=0;i<numProductos;i++){      
      System.out.println("Ingrese la descripcion del producto en una palabra "+ (i+1) +": ");
      String descripcion=lectura.next();
      D[i] = descripcion;
    }
    return D;
  }
  public static double[] precioProducto(int numProductos){
    java.util.Scanner lectura= new java.util.Scanner(System.in);
    double[] P = new double[numProductos];
    for(int i=0;i<numProductos;i++){
      System.out.println("Ingrese el precio del producto "+ (i+1) +": ");
      double precio=lectura.nextDouble();
      P[i] = precio;
    }
    return P;
  }
  //*Registro Ventas*//
  
  public static int[]VendedoresCero(int n){
    int[] A= new int[n];
    for(int i=0; i<n; i++){
      A[i]=0;
    }
    return A;
  }
  public static int[]numeroVentas(int[]A,int numEmpleados){
    A[numEmpleados] += 1;
    return A;
  }

  public static double total(double[] A, int n,double precio){
    double s=0;
    A=new double[n];
    for(int i=0; i<n; i++){
      s +=A[i];  
    }
    return s;
  }
  
  
  
    
  public static void main(String[] args) {
    java.util.Scanner lectura= new java.util.Scanner(System.in);
    
    System.out.println("Ingrese la cantidad de productos en venta: ");
    int numProductos = lectura.nextInt();
    

    //Fecha//
    int dd,mm,aa,hh,min;
    System.out.println("Fecha dd/mm/aa hh:mm: ");
    dd = lectura.nextInt();
    mm = lectura.nextInt();
    aa = lectura.nextInt();
    hh = lectura.nextInt();
    min = lectura.nextInt();
    //Datos de Venta//
    
    System.out.println("ID del Vendedor:");
    int ID = lectura.nextInt();
    System.out.println("Vendedor Nombre:");
    String Nombre = lectura.next();
    System.out.println("Vendedor Apellido:");
    String Apellido = lectura.next();
    
    System.out.println("Codigo del producto");
    int codigo = lectura.nextInt();
    System.out.println("Cantidad de producto: ");
    int cantidadProducto=lectura.nextInt();
    System.out.println();
    //Modo de Pago//
    System.out.println("Digite 1 para pagar con Efectivo");
    System.out.println("Digite 2 para pagar con Débito");
    System.out.println("Digite 3 para pagar por Crédito");
 
    int menu=lectura.nextInt();
    if(menu==1){
       System.out.println("El pago se efectuó por Efectivo");
    }
    if(menu==2){
      System.out.println("El pago se efectuó por Débito");
    }
    if(menu==3){
      System.out.println("El pago se efectuó por Tarjeta");
    }
    //*FACTURA//
    System.out.println("   ");
    System.out.println("****FACTURA****");
    System.out.println("   ");
    System.out.println("Fecha: " + dd+"/"+mm+"/"+aa+" "+hh+":"+min);
    System.out.println("Vendedor: "+ "ID " + ID+"    " + Nombre + " " + Apellido);
    System.out.println("Codigo del producto: " + codigo);
    System.out.println("Cantidad: "+ cantidadProducto);
    System.out.println(menu);
    System.out.println("_____________________________________________");
  }
}
