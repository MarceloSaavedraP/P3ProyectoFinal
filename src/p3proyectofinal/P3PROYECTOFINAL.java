/*
 Author: Marcelo Esteban Saavedra Peña
 Date: 30-11-2019
 Description: The company "Boyacá ancestral food" is a request to create and program what
 and allows to have salary information (random number between SMLV and SML
 V*4) of each of its N employees for each quarter of the year
 */
package p3proyectofinal;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class P3PROYECTOFINAL {

    static int[][] Vector;
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
// This function is Menu
        try {
            int opt = 6;
            
            while (opt != 0) {
                show_menu();
                opt = keyboard.nextInt();

                switch (opt) {
                    case 1:
                        generate_Vector();
                        break;
                    case 2:
                        show_Vector(Vector);
                        break;
                    case 3:
                        show_max_20000000(Vector);
                        break;
                    case 4:
                        show_average(Vector);
                        show_average2(Vector);
                        show_average3(Vector);
                        show_average4(Vector);
                        break;
                    case 5:
                        salary_max(Vector);
                        break;
                    case 6:
                        salary_min(Vector);
                        create_file(Vector);
                        System.out.println("File save in D");
                        break;

                }

            }

        } catch (Exception e) {
            System.err.println("opción no encontrada, seleccione disponibles");
            System.err.println("Aborted system" + e.toString());
        }
    }

    public static void show_menu() {
        // Function show menu
        try {
            System.out.println("___Software de nomina para empresa Boyacá Ancestral Food___ \n"
                    + "Creado por: Marcelo Saavedra\n"
                    + "Menú principal:\n"
                    + " (1) Generar base de datos\n"
                    + " (2) Visualizar base de datos\n"
                    + " (3) Empleados que ganaron más de $20.000.000\n"
                    + " (4) Promedio de sueldos por trimestre\n"
                    + " (5) Empleado con mayor ganancia de sueldos en el año\n"
                    + " (6) Empleado con menor ganancia de sueldos en el año\n"
                    + " (0) Salir del software");
        } catch (Exception e) {
            System.out.println("Aborted system.MENU"+ e.toString());
        }

    }

    public static int[][] generate_Vector() {
        //The fuction is create the vector 
        try {
            System.out.println("Ingrese numero de trabajadores");
            
            int N = keyboard.nextInt();

            Vector = new int[N][4];

            for (int i = 0; i < N; i++) {
                for (int n = 0; n < 4; n++) {
                    Vector[i][n] = (int) Math.round(Math.random() * (3312464 - 828116 + 1) + 828116);
                }

            }

            return Vector;
        } catch (Exception e) {
            System.err.println("Aborted system.VECTOR " + e.toString());
            return null;
        }

    }

    public static void show_Vector(int[][] Vector) {
        //Function show vector 
        try {
            for (int i = 0; i < Vector.length; i++) {
                System.out.println("Numero: " + (1 + i)
                        + " El pago es: " + Vector[i][0]  
                        + " El pago es: " + Vector[i][1]
                        + " El pago es: " + Vector[i][2] 
                        + " El pago es: " + Vector[i][3]);
            }
        } catch (Exception e) {
            System.err.println("Aborted system.SHOWVECTOR " + e.toString());
        }

    }

    public static int show_max_20000000(int[][] vector) {
        // This function show salari max of 5000000 
        try {
            int total = 0;
            int employer = 0;
            for (int[] vector1 : vector) {
                total = vector1[1] + vector1[2] + vector1[3];
                if (total >= 5000000) {
                    employer += 1;
                }
            }
            System.out.println("Mas de 20000000: " + employer);
            return employer;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double show_average(int[][] vector) {
        // This function show average 
        try {
            int suma = 0;
            for (int i = 0; i < vector.length; i++) {
                suma += vector[i][0];

            }
            double average = suma / vector.length;
            System.out.println("Cifra 1: " + average);
            return suma;

        } catch (Exception e) {
            System.out.println("Aborted system.AVERAGE"+ e.toString());

            return 0;
        }
    }

    public static double show_average2(int[][] vector) {
      
        try {
            int suma = 0;
            for (int i = 0; i < vector.length; i++) {
                suma += vector[i][1];

            }
            double average = suma / vector.length;
            System.out.println("Cifra 2: " + average);
            return suma;

        } catch (Exception e) {
            System.out.println("Aborted system.AVERAGE2" + e.toString());

            return 0;
        }
    }

    public static double show_average3(int[][] vector) {
     
        try {
            int suma = 0;
            for (int i = 0; i < vector.length; i++) {
                suma += vector[i][2];

            }
            double average = suma / vector.length;
            System.out.println("Cifra 3: " + average);
            return suma;

        } catch (Exception e) {
            System.out.println("Aborted system.AVERAGE3 " + e.toString());

            return 0;
        }
    }

    public static double show_average4(int[][] vector) {
       
        try {
            int suma = 0;
            for (int i = 0; i < vector.length; i++) {
                suma += vector[i][3];

            }
            double average = suma / vector.length;
            System.out.println("Cifra 4: " + average);
            return suma;

        } catch (Exception e) {
            System.out.println("Aborted system.AVERAGE4"+ e.toString());

            return 0;
        }
    }

    public static int salary_max(int[][] vector) {

        try {
            int max = 0;
            int employer = 0;
            for (int i = 0; i < vector.length; i++) {
                int total = vector[i][0] + vector[i][1] + vector[i][2] + vector[i][3];
                if (i == 0) {
                    max = total;
                } else if (total > max) {
                    max = total;
                    employer = i;
                }
            }
            System.out.println("Salario mayor: " + max);
            return employer + 1;
        } catch (Exception e) {
            System.err.println("Aborted system.SALARYMAX" + e.toString());
            return 0;
        }
    }

    public static int salary_min(int[][] vector) {
      
        try {
            int min = 0;
            int employer = 0;
            for (int i = 0; i < vector.length; i++) {
                int total = vector[i][0] + vector[i][1] + vector[i][2] + vector[i][3];
                if (i == 0) {
                    min = total;
                } else if (total < min) {
                    min = total;
                    employer = i;
                }
            }
            System.out.println("Salario minimo: " + min);
            return employer + 1;
        } catch (Exception e) {
            System.err.println("Aborted system.SALARYMIN" + e.toString());
            return 0;
        }
    }

    public static void create_file(int[][] vector) {
        // This function create file t1he program
        try {
            PrintWriter archivo = new PrintWriter("d:/software de nomina para empresa Boyacá Ancestral Food.txt", "UTF-8");
            archivo.println("This file is automatically by java");
            for (int i = 0; i < vector.length; i++) {
                archivo.println("Numero: " + (1 + i) 
                        + " El pago es: " + Vector[i][0] 
                        + " El pago es: " + Vector[i][1]
                        + " El pago es: " + Vector[i][2] 
                        + " El pago es: " + Vector[i][3]);
            }
            for (int[] vector1 : vector) {
                archivo.println("___Total___");
                archivo.println("Salario minimo: " + salary_max(vector));
                archivo.println("Salario maximo: " + salary_min(vector));
                archivo.println("Promedio 1:   " + show_average(vector) 
                        + " Promedio 2:   " + show_average2(vector)
                        + " Promedio 3:   " + show_average3(vector) 
                        + " Promedio 4:   " + show_average4(vector));
                archivo.println("Mayor de 5000000: " + show_max_20000000(vector));
                archivo.println("It is developed by: Marcelo Esteban Saavedra Peña ");
                
                archivo.close();
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.err.println("Aborted system.FILE" + e.toString());
        }
    }
}
