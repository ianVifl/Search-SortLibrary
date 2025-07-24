/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectbiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author ianvi
 */


// IAN TAILLU VILLAMIL FLORES.
// MAURICIO CLEMENTE BARRAGAN.
// EQUIPO 5


public class Prueba {
    private String info;
    ArrayList<Libro> Biblioteca = new ArrayList<>();
    Scanner leer = new Scanner(System.in);
    public boolean ListaOrdenada = false;
    
    int contBurbuja = 0;
    int contBurbujaBi = 0;
    int contInsercion = 0;
    int contSeleccion = 0;
    int contShell = 0;
    int contQuick = 0;
    int contBucket = 0;
    int contMerge = 0;
    int contRadix = 0;
    int contHeapSort = 0;
    int contCountingSort = 0;
    
    
    public void LlenarArray() {
        try{
            File archivo = new File("C:\\Users\\ianvi\\Documents\\Ordenamiento y Busqueda\\xk.txt");
            Scanner sc_reader = new Scanner(archivo);
            while (sc_reader.hasNextLine()) {
              String data = sc_reader.nextLine();
              String [] fila = data.split("\\s*,\\s*");
              Libro libro = new Libro();
              libro.setID(Integer.parseInt(fila[0]));
              libro.setISBN(Integer.parseInt(fila[1]));
              libro.setTitulo(fila[2]);
              libro.setAutor(fila[3]);
              libro.setanio(Integer.parseInt(fila[4]));
              libro.setGenero(fila[5]);
              Biblioteca.add(libro);

            }
             System.out.println("Biblioteca size: " + Biblioteca.size());
        } catch (FileNotFoundException e) {
            System.out.println("\n!! No se puede abrir el archivo .txt, revise la ubicación e intente nuevamente. !! \n");
        }
    }
    
    
   /* public void login() {
        
        
        
        LlenarArray();
        String[] usuario = {"admin"};
        String[] password = {"1234"};
        int opc = 0;
        System.out.println("_________________");
        System.out.print("Ingrese Usuario:");
        String user = leer.nextLine();
        System.out.print("Ingrese Contraseña:");
        String pass = leer.nextLine();
        boolean bandera = false;
        do {
            for (int i = 0; i < usuario.length; i++) {
                if (usuario[i].equals(user) && password[i].equals(pass)) {
                    bandera = true;
                } else {
                    bandera = false;
                }
            }
            if (bandera == true) {
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println(" ! Bienvenido a la Biblioteca ! ");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------\n");
                Menu();
            } else {
                System.out.println("\n!!Usuario incorrecto!!");
                System.out.print("Ingrese usuario: ");
                user = leer.nextLine();
                System.out.print("Ingrese contraseña: ");
                pass = leer.nextLine();
            }
        } while (bandera == false || opc != 2);
    }
    */

    public void login() {

    LlenarArray();

    // Crear el panel de login
    JFrame frame = new JFrame("Login");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    JPanel panel = new JPanel();
    frame.add(panel);

    // Agregar componentes al panel
    placeComponents(panel);

    // Hacer visible la ventana
    frame.setVisible(true);
}

private void placeComponents(JPanel panel) {
    panel.setLayout(null);

    // Crear etiqueta y campo de texto para el usuario
    JLabel userLabel = new JLabel("Usuario:");
    userLabel.setBounds(10, 20, 80, 25);
    panel.add(userLabel);

    JTextField userText = new JTextField(20);
    userText.setBounds(100, 20, 165, 25);
    panel.add(userText);

    // Crear etiqueta y campo de texto para la contraseña
    JLabel passwordLabel = new JLabel("Contraseña:");
    passwordLabel.setBounds(10, 50, 80, 25);
    panel.add(passwordLabel);

    JPasswordField passwordText = new JPasswordField(20);
    passwordText.setBounds(100, 50, 165, 25);
    panel.add(passwordText);

    // Crear botón de login
    JButton loginButton = new JButton("Iniciar Sesión");
    loginButton.setBounds(70, 110, 150, 25);
    panel.add(loginButton);

    // Añadir acción al botón de login
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = userText.getText();
            char[] password = passwordText.getPassword();

            if (authenticate(user, password)) {
                JOptionPane.showMessageDialog(panel, "Login exitoso");
                // Llamar al método Menu una vez que el usuario haya iniciado sesión
                Menu();
                //frame.dispose(); // Cerrar la ventana de login
            } else {
                JOptionPane.showMessageDialog(panel, "Usuario o contraseña incorrectos");
            }
        }
    });
}



private static boolean authenticate(String user, char[] password) {
    String correctUser = "admin";
    String correctPassword = "1234";

    return user.equals(correctUser) && String.valueOf(password).equals(correctPassword);
}
    
    
    
    
    
    
    
    
    
     public void Menu(){
        int opc=0;
        do{
            System.out.println("----------------------");
            System.out.println("Selecciona un número: ");
            System.out.println("""
                                    1.-Insertar.
                                    2.-Mostrar.
                                    3.-Ordenar.
                                    4.-Buscar.
                                    5.-Reportes.
                                    6.-M'sO Alfa.
                                    7.-Salir.""");
            System.out.println("----------------------");
            
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    insertar();
                    break;
                case 2:
                    mostrarInfo();
                    break;
                case 3:
                    Ordenar();
                    break;
               case 4:
                    Buscar();
                    break;
               case 5: 
                   reportes();
               case 6: 
                   msoAlfa();
                   break;
                case 7:   
                    System.exit(0);           
                    break;
            }
        } while (opc != 4);                      
    }
    
     
     
     
     
     public void insertar() {
    Libro libro = new Libro();

    System.out.print("Ingrese el ID del libro: ");
    libro.setID(leer.nextInt());
    leer.nextLine(); 

    System.out.print("Ingrese el título del libro: ");
    libro.setTitulo(leer.nextLine());

    System.out.print("Ingrese el autor del libro: ");
    libro.setAutor(leer.nextLine());

    System.out.print("Ingrese el año de publicación del libro: ");
    libro.setanio(leer.nextInt());
    leer.nextLine(); 

    System.out.print("Ingrese el ISBN del libro: ");
    libro.setISBN(leer.nextInt());
    leer.nextLine(); 

    System.out.print("Ingrese el género del libro: ");
    libro.setGenero(leer.nextLine());
    
    System.out.println("Libro agregado con exito !!");

    Biblioteca.add(libro);
}
     
     
     
     
     
     
     
     
     public void mostrarInfo() {
        
        System.out.println("Tamaño de la lista: " + Biblioteca.size());
        for (int k = 0; k < Biblioteca.size(); k++) {
            System.out.println(Biblioteca.get(k).toString());
            System.out.println("_________________________________\n");
        }
    }
     
     
     
     
     
     
     
    //metodo burbuja por ID
    public void MetodoBurbujaID() {
        System.out.println("Método de Ordenamiento seleccionado: Burbuja");
        Libro aux = new Libro();
        long inicio = System.nanoTime();
        for (int i = 0; i < (Biblioteca.size() - 1); i++) {
            for (int j = 0; j < (Biblioteca.size() - 1); j++) {
                if (Biblioteca.get(j).getID() > Biblioteca.get(j + 1).getID()) {
                    aux = Biblioteca.get(j + 1);
                    Biblioteca.set(j + 1, Biblioteca.get(j));
                    Biblioteca.set(j, aux);
                }
            }
        }
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contBurbuja++;
    }

    //metodo burbuja por ISBN
    public void MetodoBurbujaISBN() {
        System.out.println("Método de Ordenamiento seleccionado: Burbuja");
        Libro aux = new Libro();
        long inicio = System.nanoTime();
        for (int i = 0; i < (Biblioteca.size() - 1); i++) {
            for (int j = 0; j < (Biblioteca.size() - 1); j++) {
                if (Biblioteca.get(j).getISBN() > Biblioteca.get(j + 1).getISBN()) {
                    aux = Biblioteca.get(j + 1);
                    Biblioteca.set(j + 1, Biblioteca.get(j));
                    Biblioteca.set(j, aux);
                }
            }
        }
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contBurbuja++;
    }

    
    //metodo burbuja bidireccional por ID
    public void MetodoBurbujaBidireccionalID() {
        System.out.println("Método de Ordenamiento seleccionado: Burbuja bidireccional");
        int izq = 0;
        int der = Biblioteca.size() - 1;
        Libro aux = new Libro();
        int ultimo = Biblioteca.size() - 1;
        long inicio = System.nanoTime();
        do {
            for (int i = izq; i < der; i++) {
                if (Biblioteca.get(i).getID() > Biblioteca.get(i + 1).getID()) {
                    aux = Biblioteca.get(i);
                    Biblioteca.set(i, Biblioteca.get(i + 1));
                    Biblioteca.set(i + 1, aux);
                    ultimo = i;
                }
            }
            der = ultimo;
            for (int j = der; j > izq; j--) {
                if (Biblioteca.get(j - 1).getID() > Biblioteca.get(j).getID()) {
                    aux = Biblioteca.get(j);
                    Biblioteca.set(j, Biblioteca.get(j - 1));
                    Biblioteca.set(j - 1, aux);
                    ultimo = j;
                }
            }
            izq = ultimo;
        } while (izq < der);
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contBurbujaBi++;
    }

    //metodo burbuja bidireccional por ISBN
    public void MetodoBurbujaBidireccionalISBN() {
        System.out.println("Método de Ordenamiento seleccionado: Burbuja bidireccional");
        int izq = 0;
        int der = Biblioteca.size() - 1;
        Libro aux = new Libro();
        int ultimo = Biblioteca.size() - 1;
        long inicio = System.nanoTime();
        do {
            for (int i = izq; i < der; i++) {
                if (Biblioteca.get(i).getISBN() > Biblioteca.get(i + 1).getISBN()) {
                    aux = Biblioteca.get(i);
                    Biblioteca.set(i, Biblioteca.get(i + 1));
                    Biblioteca.set(i + 1, aux);
                    ultimo = i;
                }
            }
            der = ultimo;
            for (int j = der; j > izq; j--) {
                if (Biblioteca.get(j - 1).getID() > Biblioteca.get(j).getID()) {
                    aux = Biblioteca.get(j);
                    Biblioteca.set(j, Biblioteca.get(j - 1));
                    Biblioteca.set(j - 1, aux);
                    ultimo = j;
                }
            }
            izq = ultimo;
        } while (izq < der);
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contBurbujaBi++;
    }

    //metodo de seleccion por ID
    public void MetodoSeleccionID() {
        System.out.println("Método de Ordenamiento seleccionado: Seleccion");
        Libro aux = new Libro();
        long inicio = System.nanoTime();
        for (int i = 0; i < Biblioteca.size() - 1; i++) {
            for (int j = i + 1; j < Biblioteca.size(); j++) {
                if (Biblioteca.get(i).getID() > Biblioteca.get(j).getID()) {
                    aux = Biblioteca.get(i);
                    Biblioteca.set(i, Biblioteca.get(j));
                    Biblioteca.set(j, aux);
                }
            }
        }
       System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
       + (System.nanoTime()-inicio));
       contSeleccion++;

    }

    //metodo de seleccion por ISBN
    public void MetodoSeleccionISBN() {
        System.out.println("Método de Ordenamiento seleccionado: Seleccion");
        Libro aux = new Libro();
        long inicio = System.nanoTime();
        for (int i = 0; i < Biblioteca.size() - 1; i++) {
            for (int j = i + 1; j < Biblioteca.size(); j++) {
                if (Biblioteca.get(i).getISBN() > Biblioteca.get(j).getISBN()) {
                    aux = Biblioteca.get(i);
                    Biblioteca.set(i, Biblioteca.get(j));
                    Biblioteca.set(j, aux);
                }
            }
        }
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contSeleccion++;
    }

    //metodo quicksort por ID
    public void MetodoQuicksortID() {
        System.out.println("Método de Ordenamiento seleccionado: Quicksort");
        long inicio = System.nanoTime();
        MetodoQuicksortID(0, Biblioteca.size() - 1);
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contQuick++;
    }

    public void MetodoQuicksortID(int inicio, int fin) {
        int central;
        Libro aux = new Libro();
        central = (inicio + fin) / 2;

        if (inicio >= fin) {
            return;
        }
        int pivote = Biblioteca.get(central).getID();
        int i = inicio;
        int j = fin;
        do {
            while (Biblioteca.get(i).getID() < pivote) {
                i++;
            }
            while (Biblioteca.get(j).getID() > pivote) {
                j--;
            }
            if (i <= j) {
                aux = Biblioteca.get(i);
                Biblioteca.set(i, Biblioteca.get(j));
                Biblioteca.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (inicio < j) {
            MetodoQuicksortID(inicio, j);
        }
        if (i < fin) {
            MetodoQuicksortID(i, fin);
        }
    }
    
    //metodo quicksort por ISBN 
    public void MetodoQuicksortISBN() {
        System.out.println("Método de Ordenamiento seleccionado: Quicksort");
        long inicio = System.nanoTime();
        MetodoQuicksortISBN(0, Biblioteca.size() - 1);
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contQuick++;
    }
    
    public void MetodoQuicksortISBN(int inicio, int fin) {

        int central;
        Libro aux = new Libro();
        central = (inicio + fin) / 2;
        if (inicio >= fin) {
            return;
        }
        int pivote = Biblioteca.get(central).getISBN();
        int i = inicio;
        int j = fin;
        do {
            while (Biblioteca.get(i).getISBN() < pivote) {
                i++;
            }
            while (Biblioteca.get(j).getISBN() > pivote) {
                j--;
            }
            if (i <= j) {
                aux = Biblioteca.get(i);
                Biblioteca.set(i, Biblioteca.get(j));
                Biblioteca.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (inicio < j) {
            MetodoQuicksortISBN(inicio, j);
        }
        if (i < fin) {
            MetodoQuicksortISBN(i, fin);
        }
    }
    
    //Metodo de ordenacion shell por ID
    public void MetodoShellID() {
        System.out.println("Método de Ordenamiento seleccionado: Shell");
        Libro aux = new Libro();
        int intervalo, i, j, k;
        int n = Biblioteca.size() - 1;
        intervalo = n / 2;
        long inicio = System.nanoTime();
        while (intervalo > 0) {
            for (i = intervalo; i < n; i++) {
                j = i - intervalo;
                while (j >= 0) {
                    k = j + intervalo;
                    if (Biblioteca.get(j).getID() <= Biblioteca.get(k).getID()) {
                        j = -1; 
                    } else {
                        aux = Biblioteca.get(i);
                        Biblioteca.set(i, Biblioteca.get(j));
                        Biblioteca.set(j, aux);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
                + (System.nanoTime()-inicio));
        contShell++;
    }
    
    //Metodo de ordenacion shell por ISBN
    public void MetodoShellISBN() {
        System.out.println("Método de Ordenamiento seleccionado: Shell");
        Libro aux = new Libro();
        int intervalo, i, j, k;
        int n = Biblioteca.size() - 1;
        intervalo = n / 2;
        long inicio = System.nanoTime();
        while (intervalo > 0) {
            for (i = intervalo; i < n; i++) {
                j = i - intervalo;
                while (j >= 0) {
                    k = j + intervalo;
                    if (Biblioteca.get(j).getISBN() <= Biblioteca.get(k).getISBN()) {
                        j = -1; // par de elementos ordenado
                    } else {
                        aux = Biblioteca.get(i);
                        Biblioteca.set(i, Biblioteca.get(j));
                        Biblioteca.set(j, aux);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contShell++;
    }
     
    //metodo de inserccion por ID    
    public void MetodoInserccionID() {
        System.out.println("Método de Ordenamiento seleccionado: Insercion");
        int j;
        int aux;
        Libro auxiliar = new Libro();
        long inicio = System.nanoTime();
        for (int i = 1; i < Biblioteca.size(); i++) { 
            aux = Biblioteca.get(i).getID();
            auxiliar = Biblioteca.get(i);
            j = i;           
            while ((j > 0) && (aux < Biblioteca.get(j - 1).getID())) {                     
                Biblioteca.set(j, Biblioteca.get(j - 1));
                j--;
            }
            Biblioteca.set(j, auxiliar);
        }
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
                + (System.nanoTime()-inicio));
        contInsercion++;
    }

    //Metodo de insercion por ISBN  
    public void MetodoInserccionISBN() {
        System.out.println("Método de Ordenamiento seleccionado:  Insercion");
        int j;
        int aux;
        Libro auxiliar = new Libro();
        long inicio = System.nanoTime();
        for (int i = 1; i < Biblioteca.size(); i++) { 
            aux = Biblioteca.get(i).getISBN();
            auxiliar = Biblioteca.get(i);
            j = i;            
            while ((j > 0) && (aux < Biblioteca.get(j - 1).getISBN())) {                               
                Biblioteca.set(j, Biblioteca.get(j - 1));
                j--;
            }
            Biblioteca.set(j, auxiliar);
        }
        System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
        + (System.nanoTime()-inicio));
        contInsercion++;
    }

    
    
    //MERGUE SORT POR ID 
    
    public void mergeSortID() {
    System.out.println("Método de Ordenamiento seleccionado:  Merge Sort");
    long inicio = System.nanoTime();
    mergeSortID(0, Biblioteca.size() - 1);
    System.out.println("Tiempo tomado para la ejecucion del algoritmo: " + (System.nanoTime() - inicio));
    contMerge++;
}

private void mergeSortID(int ini, int fin) {
    if (ini < fin) {
        int mitad = (ini + fin) / 2;
        mergeSortID(ini, mitad);
        mergeSortID(mitad + 1, fin);
        mergeID(ini, mitad, fin);
    }
}

private void mergeID(int ini, int mitad, int fin) {
    int n1 = mitad - ini + 1;
    int n2 = fin - mitad;

    Libro[] arr1 = new Libro[n1];
    Libro[] arr2 = new Libro[n2];

    for (int i = 0; i < n1; i++) {
        arr1[i] = Biblioteca.get(ini + i);
    }
    for (int j = 0; j < n2; j++) {
        arr2[j] = Biblioteca.get(mitad + 1 + j);
    }

    int i = 0, j = 0, k = ini;

    while (i < n1 && j < n2) {
        if (arr1[i].getID() <= arr2[j].getID()) {
            Biblioteca.set(k, arr1[i]);
            i++;
        } else {
            Biblioteca.set(k, arr2[j]);
            j++;
        }
        k++;
    }

    while (i < n1) {
        Biblioteca.set(k, arr1[i]);
        i++;
        k++;
    }

    while (j < n2) {
        Biblioteca.set(k, arr2[j]);
        j++;
        k++;
    }
}
    


// MERGUE SORT POR ISBN 

public void mergeSortISBN() {
    System.out.println("Método de Ordenamiento seleccionado: Merge Sort");
    long inicio = System.nanoTime();
    mergeSortISBN(0, Biblioteca.size() - 1);
    System.out.println("Tiempo de ordenamiento: " + (System.nanoTime() - inicio )+" nanosegundos");
    contMerge++;
    
}

private void mergeSortISBN(int ini, int fin) {
    if (ini < fin) {
        int mitad = (ini + fin) / 2;
        mergeSortISBN(ini, mitad);
        mergeSortISBN(mitad + 1, fin);
        mergeISBN(ini, mitad, fin);
    }
}

private void mergeISBN(int ini, int mitad, int fin) {
    int n1 = mitad - ini + 1;
    int n2 = fin - mitad;

    Libro[] arr1 = new Libro[n1];
    Libro[] arr2 = new Libro[n2];

    for (int i = 0; i < n1; i++) {
        arr1[i] = Biblioteca.get(ini + i);
    }
    for (int j = 0; j < n2; j++) {
        arr2[j] = Biblioteca.get(mitad + 1 + j);
    }

    int i = 0, j = 0, k = ini;

    while (i < n1 && j < n2) {
        if (arr1[i].getISBN() <= arr2[j].getISBN()) {
            Biblioteca.set(k, arr1[i]);
            i++;
        } else {
            Biblioteca.set(k, arr2[j]);
            j++;
        }
        k++;
    }

    while (i < n1) {
        Biblioteca.set(k, arr1[i]);
        i++;
        k++;
    }

    while (j < n2) {
        Biblioteca.set(k, arr2[j]);
        j++;
        k++;
    }
}


//RADIX SORT POR ID 

public void radixSortID() {
    
    System.out.println("Método de Ordenamiento seleccionado:  Radix Sort");
    long inicio = System.nanoTime();
    radixSortID(Biblioteca, Biblioteca.size(), 10);
    System.out.println("Tiempo tomado para la ejecucion del algoritmo: " + (System.nanoTime() - inicio));
    contRadix++;
}

private void radixSortID(List<Libro> arr, int n, int b) {
    int max = maxValue(arr, n, b);
    int m = (int) Math.floor(Math.log(max) / Math.log(b));
    int[] count = new int[n];
    int[] aux = new int[n];
    Libro[] output = new Libro[n];

    for (int k = 1; k <= m; k++) {
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int j = (int) (arr.get(i).getID() / Math.pow(b, k)) % b;
            count[j]++;
        }

        for (int i = 1; i < b; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int j = (int) (arr.get(i).getID() / Math.pow(b, k)) % b;
            aux[count[j] - 1] = arr.get(i).getID();
            count[j]--;
        }

        for (int i = 0; i < n; i++) {
            arr.get(i).setID(aux[i]);
        }
    }
}

private int maxValue(List<Libro> arr, int n, int b) {
    int max = arr.get(0).getID();

    for (int i = 1; i < n; i++) {
        int j = (int) (arr.get(i).getID() / Math.pow(b, maxValueDigits(arr.get(i).getID(), b)));
        max = Math.max(max, j);
    }

    return max;
}

private int maxValueDigits(long n, int b) {
    int max = 0;

    while (n > 0) {
        n /= b;
        max++;
    }

    return max;
}

//RADIX POR ISBN 


public void radixSortISBN() {
    
    System.out.println("Método de Ordenamiento seleccionado:  Radix Sort");
    long inicio = System.nanoTime();
    radixSortISBN(Biblioteca, Biblioteca.size(), 10);
    System.out.println("Tiempo tomado para la ejecucion del algoritmo: " + (System.nanoTime() - inicio));
    contRadix++;
}

private void radixSortISBN(List<Libro> arr, int n, int b) {
    int max = maxValue(arr, n, b);
    int m = (int) Math.floor(Math.log(max) / Math.log(b));
    int[] count = new int[n];
    int[] aux = new int[n];
    Libro[] output = new Libro[n];

    for (int k = 1; k <= m; k++) {
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }

        for (int i= 0; i < n; i++) {
            int j = (int) (arr.get(i).getISBN() / Math.pow(b, k)) % b;
            count[j]++;
        }

        for (int i = 1; i < b; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int j = (int) (arr.get(i).getISBN() / Math.pow(b, k)) % b;
            aux[count[j] - 1] = arr.get(i).getISBN();
            count[j]--;
        }

        for (int i = 0; i < n; i++) {
            arr.get(i).setISBN(aux[i]);
        }
    }
}


//BUCKET POR ID 

public void bucketSortID() {
    System.out.println("Método de Ordenamiento seleccionado:  Bucket Sort");
    long inicio = System.nanoTime();
    bucketSortID(Biblioteca);
    System.out.println("Tiempo tomado para la ejecucion del algoritmo: " + (System.nanoTime() - inicio));
    contBucket++;
}

private void bucketSortID(List<Libro> arr) {
    int max = getMaxID(arr);
    int min = getMinID(arr);
    int range = max - min + 1;
    List<Libro>[] buckets = new List[range];

    for (int i = 0; i < range; i++) {
        buckets[i] = new ArrayList<>();
    }

    for (Libro libro : arr) {
        int idx = (libro.getID() - min) % range; // Utiliza el operador % para asegurarte de que el índice esté dentro del rango
        buckets[idx].add(libro);
    }

    int index = 0;
    for (List<Libro> bucket : buckets) {
        for (Libro libro : bucket) {
            arr.set(index, libro);
            index++;
        }
    }
}

private int getMaxID(List<Libro> arr) {
    int max = Integer.MIN_VALUE;
    for (Libro libro : arr) {
        if (libro.getID() > max) {
            max = libro.getID();
        }
    }
    return max;
}

private int getMinID(List<Libro> arr) {
    int min = Integer.MAX_VALUE;
    for (Libro libro : arr) {
        if (libro.getID() < min) {
            min = libro.getID();
        }
    }
    return min;
}

// BUCKET POR ISBN 

public void bucketSortISBN() {
    System.out.println("Método de Ordenamiento seleccionado:  Bucket Sort");
    long inicio = System.nanoTime();
    bucketSortISBN(Biblioteca);
    System.out.println("Tiempo tomado para la ejecucion del algoritmo: " + (System.nanoTime() - inicio));
    contBucket++;
}

private void bucketSortISBN(List<Libro> arr) {
    int max = getMaxISBN(arr);
    int min = getMinISBN(arr);
    int range = max - min + 1;
    List<Libro>[] buckets = new List[range];

    for (int i = 0; i < range; i++) {
        buckets[i] = new ArrayList<>();
    }

    for (Libro libro : arr) {
        int idx = (libro.getISBN() - min) % range; // Utiliza el operador % para asegurarte de que el índice esté dentro del rango
        buckets[idx].add(libro);
    }

    int index = 0;
    for (List<Libro> bucket : buckets) {
        for (Libro libro : bucket) {
            arr.set(index, libro);
            index++;
        }
    }
}

private int getMaxISBN(List<Libro> arr) {
    int max = Integer.MIN_VALUE;
    for (Libro libro : arr) {
        if (libro.getISBN() > max) {
            max = libro.getISBN();
        }
    }
    return max;
}

private int getMinISBN(List<Libro> arr) {
    int min = Integer.MAX_VALUE;
    for (Libro libro : arr) {
        if (libro.getISBN() < min) {
            min = libro.getISBN();
        }
    }
    return min;
}

public void MetodoCountingSortID() {
    System.out.println("Método de Ordenamiento seleccionado: Counting Sort");
    int maxID = getMaxID();
    int[] count = new int[maxID + 1];
    Libro[] aux = new Libro[Biblioteca.size()];

    long inicio = System.nanoTime();

    // Contar la frecuencia de cada ID
    for (int i = 0; i < Biblioteca.size(); i++) {
        count[Biblioteca.get(i).getID()]++;
    }

    // Calcular la posición acumulada de cada ID
    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
    }

    // Construir el arreglo ordenado
    for (int i = Biblioteca.size() - 1; i >= 0; i--) {
        aux[count[Biblioteca.get(i).getID()] - 1] = Biblioteca.get(i);
        count[Biblioteca.get(i).getID()]--;
    }

    // Asignar el arreglo ordenado a la biblioteca
    Biblioteca.clear();
    Biblioteca.addAll(Arrays.asList(aux));

    System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
            + (System.nanoTime() - inicio));
    contCountingSort++;
}

private int getMaxID() {
    int maxID = 0;
    for (Libro libro : Biblioteca) {
        if (libro.getID() > maxID) {
            maxID = libro.getID();
        }
    }
    return maxID;
}


public void MetodoCountingSortISBN() {
    System.out.println("Método de Ordenamiento seleccionado: Counting Sort");
    int maxISBN = getMaxISBN();
    int[] count = new int[maxISBN + 1];
    Libro[] aux = new Libro[Biblioteca.size()];

    long inicio = System.nanoTime();

    // Contar la frecuencia de cada ISBN
    for (int i = 0; i < Biblioteca.size(); i++) {
        count[Biblioteca.get(i).getISBN()]++;
    }

    // Calcular la posición acumulada de cada ISBN
    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
    }

    // Construir el arreglo ordenado
    for (int i = Biblioteca.size() - 1; i >= 0; i--) {
        aux[count[Biblioteca.get(i).getISBN()] - 1] = Biblioteca.get(i);
        count[Biblioteca.get(i).getISBN()]--;
    }

    // Asignar el arreglo ordenado a la biblioteca
    Biblioteca.clear();
    Biblioteca.addAll(Arrays.asList(aux));

    System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
            + (System.nanoTime() - inicio));
    contCountingSort++;
}

private int getMaxISBN() {
    int maxISBN = 0;
    for (Libro libro : Biblioteca) {
        if (libro.getISBN() > maxISBN) {
            maxISBN = libro.getISBN();
        }
    }
    return maxISBN;
}



public void MetodoHeapSortID() {
    System.out.println("Método de Ordenamiento seleccionado: Heap Sort");
    long inicio = System.nanoTime();

    buildHeapID();
    for (int i = Biblioteca.size() - 1; i > 0; i--) {
        Libro aux = Biblioteca.get(0);
        Biblioteca.set(0, Biblioteca.get(i));
        Biblioteca.set(i, aux);
        heapifyID(0, i);
    }

    System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
            + (System.nanoTime() - inicio));
    contHeapSort++;
}

private void buildHeapID() {
    for (int i = Biblioteca.size() / 2 - 1; i >= 0; i--) {
        heapifyID(i, Biblioteca.size());
    }
}

private void heapifyID(int i, int n) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && Biblioteca.get(left).getID() > Biblioteca.get(largest).getID()) {
        largest = left;
    }

    if (right < n && Biblioteca.get(right).getID() > Biblioteca.get(largest).getID()) {
        largest = right;
    }

    if (largest!= i) {
        Libro aux = Biblioteca.get(i);
        Biblioteca.set(i, Biblioteca.get(largest));
        Biblioteca.set(largest, aux);
        heapifyID(largest, n);
    }
}


public void MetodoHeapSortISBN() {
    System.out.println("Método de Ordenamiento seleccionado: Heap Sort");
    long inicio = System.nanoTime();

    buildHeapISBN();
    for (int i = Biblioteca.size() - 1; i > 0; i--) {
        Libro aux = Biblioteca.get(0);
        Biblioteca.set(0, Biblioteca.get(i));
        Biblioteca.set(i, aux);
        heapifyISBN(0, i);
    }

    System.out.println("Tiempo tomado para la ejecucion del algoritmo: "
            + (System.nanoTime() - inicio));
    contHeapSort++;
}

private void buildHeapISBN() {
    for (int i = Biblioteca.size() / 2 - 1; i >= 0; i--) {
        heapifyISBN(i, Biblioteca.size());
    }
}

private void heapifyISBN(int i, int n) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && Biblioteca.get(left).getISBN() > Biblioteca.get(largest).getISBN()) {
        largest = left;
    }

    if (right < n && Biblioteca.get(right).getISBN() > Biblioteca.get(largest).getISBN()) {
        largest = right;
    }

    if (largest!= i) {
        Libro aux = Biblioteca.get(i);
        Biblioteca.set(i, Biblioteca.get(largest));
        Biblioteca.set(largest, aux);
        heapifyISBN(largest, n);
    }
}

    
    //==========================================================BUSQUEDAS=========================================================//
    
    
    

//BUSQUEDA BINARIA ISBN

public int busquedaBinariaISBN(int isbn) {
    int inferior = 0;
    int superior = Biblioteca.size() - 1;
    while (inferior <= superior) {
        int medio = (inferior + superior) / 2;
        if (Biblioteca.get(medio).getISBN() == isbn) {
            return medio;
        } else if (Biblioteca.get(medio).getISBN() < isbn) {
            inferior = medio + 1;
        } else {
            superior = medio - 1;
        }
    }
    return -1;
}


//BUSQUEDA SECUENCIAL ISBN

public int busquedaSecuencialISBN(int isbn) {
for (int i = 0; i < Biblioteca.size(); i++) {
        if (Biblioteca.get(i).getISBN() == isbn) {
            return i;
        }
    }
    return -1;
}

            public int busquedaSecuencialID(int id ){
            for (int i=0; i<Biblioteca.size(); i++){
                if (Biblioteca.get(i).getID()==id ){
            return i;
            }
            }
        return -1;
        }

    

            
          public int búsquedaBinariaID(int id){
        int inferior = 0;
            int superior =Biblioteca.size ()-1;
            while (inferior <= superior){
            int medio = (inferior+ superior)/2;
            if (Biblioteca.get(medio).getID() == id){
                return medio;
                }else if (Biblioteca.get(medio).getID()<id){
            inferior=medio + 1;
        } else{
        superior =medio -1;
            }
        }
        return -1;
    }
  
       
    
    
    
    // Método para verificar si los datos están ordenados
    public boolean datosOrdenadosPorID() {
        for (int i = 0; i < Biblioteca.size() - 1; i++) {
            if (Biblioteca.get(i).getID() > Biblioteca.get(i + 1).getID()) {
                return false;
            }
        }
        return true;
    }
    
    // Método para verificar si los datos están ordenados
    public boolean datosOrdenadosPorISBN() {
        for (int i = 0; i < Biblioteca.size() - 1; i++) {
            if (Biblioteca.get(i).getISBN() > Biblioteca.get(i + 1).getISBN()) {
                return false;
            }
        }
        return true;
    }
    
    
       
    
    
    
    
    public void Ordenar() {
        System.out.println("¿Como desea ordenar los datos? \n1.-ID. \n2.-ISBN. \n3.-Salir al menu.");
        switch (leer.nextInt()) {
            case 1:
                SelecionDeMetodosID();
                ListaOrdenada = true;
            break;
            case 2:         
                SelecionDeMetodosISBN();
                ListaOrdenada = true;
            break;
            case 3:    
                Menu();
            break;
        }
    }
    
    
    
    public void Buscar(){
        System.out.println("Como desea buscar el libro \n1.-ID \n2.-ISBN \n3.-Salir al menu");
        switch (leer.nextInt()) {
            case 1: 
                busquedaPorID();
                break;
            case 2:
                BusquedaPorISBN();
                break;
            case 3:
                Menu();
            break;
        }
    }
        
    
    
    
    
    public void reportes(){
    System.out.println("Elija una opcion para realizar los reportes:");
    System.out.println("1.- Ordenamiento.");
    System.out.println("2.- BUsqueda.");
    System.out.println("Elija una opción:");
    int opc=leer.nextInt();
    
    switch (opc) {
        case 1:
            reportesOrdenamiento();
        case 2:
            reportesBusqueda();
        }
    
    }
    
    
    
    
    public void msoAlfa(){
        System.out.println("Elija un número: ");
        System.out.println("1.- Alfa.");
        System.out.println("2.- Todos.");
        System.out.println("3.- Salir.");
        int opc =leer.nextInt();
        if (opc== 1){
            alfa();
        }else if (opc == 2){
            contadores();
        }else if (opc == 3){
            Menu();
        }else {
            System.out.println("Elija una opción válida.");
            msoAlfa();
        }
    }
    
    
    
    
    
    public void reportesOrdenamiento(){
    long inicio = System.nanoTime();
    String resultadoBusqueda = "";

    if (ListaOrdenada) { // Agrega una condición para verificar si los datos están ordenados
        resultadoBusqueda += "\t\t\t==========NUEVO REPORTE GENERADO==========\t\t\t\n";

        // Write data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ianvi\\Documents\\REPORTES\\Reporte_Ordenamiento.txt"))) {
            writer.write("ID\tISBN\tTitulo\t\t\tTema\t\tAutor\t\tAño\n" );
            for (Libro libro : Biblioteca) {
                
                writer.write(libro.getID()+"\t"+libro.getISBN() +"\t\t" + libro.getTitulo() +"\t\t"+libro.getGenero()+ "\t" + libro.getAutor() +libro.getanio()+ "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("====NUEVO REPORTE GENERADO====\n");
    } else {
        resultadoBusqueda = "No se pueden generar reportes porque la biblioteca no está ordenada.";
        System.out.println(resultadoBusqueda);
    }
    Menu();
}
    
    
    
    
    
    public void reportesBusqueda(){
        
        leer.nextLine();  

        long inicio = System.nanoTime();
        String resultadoBusqueda = "";
        
        System.out.println("Elija una opcion para relizar los reportes de busqueda:");
        System.out.println("1.- Por año");
        System.out.println("2.- Por autor");
        System.out.println("3.- Salir.");
        int opc = leer.nextInt();
        
            leer.nextLine(); // consume the newline character left over from the previous input
        
        switch(opc){
            case 1:
                
            System.out.println("Ingrese el año para el reporte.");
            int anio = leer.nextInt();
            leer.nextLine(); 
            resultadoBusqueda += "\t\t\t==========NUEVO REPORTE GENERADO==========\t\t\t\n";
            resultadoBusqueda += "Reporte de libros del año " + anio + "\n";
            generarReportePorAño(anio);
            Menu();
            break;
             
            case 2: 
                
                System.out.println("Ingrese el autor para el reporte.");
                String autor = leer.nextLine();
                resultadoBusqueda += "\t\t\t==========NUEVO REPORTE GENERADO==========\t\t\t\n";
                resultadoBusqueda += "Reporte de libros del autor " + autor + "\n";
                generarReportePorAutor(autor);
                Menu();
                break;
            case 3:
                Menu();
                break;

        }
    }
    
    
    
    public void busquedaPorID(){
            System.out.println("Teclee el ID: ");
            int id=leer.nextInt();
            leer.nextLine ();
            long inicio = System.nanoTime();
            int posicion= -1;
            String metodo_de_busqueda="";
            int opc =(int)(Math.random() *2);
            if (opc == 0){
                if (ListaOrdenada){
                    posicion =búsquedaBinariaID(id);
                    metodo_de_busqueda="Binaria";
                }else {
                    System.out.println("La lista no está ordenada, no se puede realizar la búsqueda binaria.");
                    Menu();
                }
            }else {
                posicion = busquedaSecuencialID(id);
                metodo_de_busqueda="Secuencial";
            }
            if (posicion >= 0){
                System.out.println("Libro encontrado en la posicion : "+posicion);
                System.out.println("Metodo de busqueda: "+metodo_de_busqueda);
                System.out.println("Tiempo de Busqueda: "+(System.nanoTime()-inicio));
                System.out.println("\nContenido:");
                System.out.println(Biblioteca.get(posicion));
                Menu();
            }else {
                System.out.println("No se encontró el ID especificado.");
                Menu();
            }
            
}
    
    
    
    
    public void BusquedaPorISBN() {
        System.out.println("Teclee el ISBN: ");
    int isbn = leer.nextInt();
    leer.nextLine();
    long inicio = System.nanoTime();
    int posicion = -1;
    String metodo_de_busqueda = "";
    int opc = (int) (Math.random() * 2);
    if (opc == 0) {
        if (ListaOrdenada) {
            posicion = busquedaBinariaISBN(isbn);
            metodo_de_busqueda = "Binaria";
        } else {
            System.out.println("La lista no está ordenada, no se puede realizar la búsqueda binaria.");
            Menu();
        }
    } else {
        posicion = busquedaSecuencialISBN(isbn);
        metodo_de_busqueda = "Secuencial";
    }
    if (posicion >= 0) {
        System.out.println("Libro encontrado en la posición: " + posicion);
        System.out.println("Método de búsqueda: " + metodo_de_busqueda);
        System.out.println("Tiempo de búsqueda: " + (System.nanoTime() - inicio));
        System.out.println("\nContenido: ");
        System.out.println(Biblioteca.get(posicion));
        Menu();
    } else {
        System.out.println("No se encontró ningún libro con el ISBN especificado.");
    }
    Menu();
}
    
    
    
    
    public void SelecionDeMetodosID() {
        int opc =  new Random().nextInt(11);

        switch (opc) {
            case 1:
                //Algoritmo de burbuja 
                MetodoBurbujaID();
                break;
            case 2:
                //Algoritmo de Burbuja Bidireccional
                MetodoBurbujaBidireccionalID();
                break;
            case 3:
                //Algoritmo de Seleccion
                MetodoSeleccionID();
                break;
            case 4:
                //Algoritmo de Inserccion
                MetodoInserccionID();
                break;
            case 5:
                //Algoritmo de Shell
                MetodoShellID();
                break;
            case 6:
                //Algoritmo de Quicksort
                MetodoQuicksortID();
                break;
            case 7:
                mergeSortID();
                break;
            case 8:
                radixSortID();
                break;
            case 9:
                bucketSortID();
                break;
            case 10:
                MetodoCountingSortID();
                break;
            case 11:
                MetodoHeapSortID();
                break;
                   
                
        }
    }

    //Metodo que elige un metodo de ordenacion por ISBN

    public void SelecionDeMetodosISBN() {
        int opc =  new Random().nextInt(11);

        switch (opc) {
            case 1:
                //Algoritmo de burbuja 
                MetodoBurbujaISBN();
            break;
            case 2:
                //Algoritmo de Burbuja Bidireccional
                MetodoBurbujaBidireccionalISBN();
            break;
            case 3:
                //Algoritmo de Seleccion
                MetodoSeleccionISBN();
            break;    
             case 4:
                //Algoritmo de Inserccion
                MetodoInserccionISBN();
                break;
            case 5:
                //Algoritmo de Shell
                MetodoShellISBN();
                break;
            case 6:
                //Algoritmo de Quicksort
                MetodoQuicksortISBN();
            break;
            case 7:
                mergeSortISBN();
                break;
            case 8:
                //Algoritmo de Bucket
                radixSortISBN();
                break;
            case 9:
                bucketSortISBN();
                break;
            case 10:
                MetodoCountingSortISBN();
                break;
            case 11:
                MetodoHeapSortISBN();
                break;
        }
    }

    private int minValue(List<Libro> arr, int n, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public class GeneradorReportes {
    public static void generarReporte(String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ianvi\\Documents\\REPORTES\\resultados_busqueda.txt", true))) {
            writer.write(contenido);
            writer.newLine(); // Agrega una nueva linea después de cada contenido
            writer.write("---------------------------------\n");
        } catch (IOException e) {
            System.err.println("Error al guardar resultados en el archivo.");
            e.printStackTrace();
        }
    }
}
    
    
    
    
     public void generarReportePorAño(int anio) {
    ArrayList<Libro> librosFiltrados = new ArrayList<>();
    for (Libro libro : Biblioteca) {
        if (libro.getanio() == anio) {
            librosFiltrados.add(libro);
        }
    }

    try (FileWriter writer = new FileWriter("C:\\Users\\ianvi\\Documents\\REPORTES\\Reporte_Por_Año_"+anio+".txt")) {
        writer.write("Año\tID\tISBN\tTitulo\t\t\tTema\tAutor\n ");
        for (Libro libro : librosFiltrados) {
            writer.write("_____________________________________________________________________________\n");
            writer.write(anio + libro.getID()+"\t"+libro.getISBN() +"\t\t" + libro.getTitulo() +"\t\t"+libro.getGenero()+ "\t" + libro.getAutor() + "\n");
        }
        System.out.println("Reporte generado con éxito");
    } catch (IOException e) {
        System.out.println("Error al generar el reporte: " + e.getMessage());
    }
    System.out.println("Libros Encontrados: " + librosFiltrados.size());
}

     
     
     
     
    public void generarReportePorAutor(String autor) {
    ArrayList<Libro> librosFiltrados = new ArrayList<>();
    String inputAuthor = autor.toLowerCase().replaceAll("[^a-z0-9 ]", "");

    for (Libro libro : Biblioteca) {
        String bookAuthor = libro.getAutor().toLowerCase().replaceAll("[^a-z0-9 ]", "");
        if (bookAuthor.equals(inputAuthor)) {
            librosFiltrados.add(libro);
        }
    }

    try (FileWriter writer = new FileWriter("C:\\Users\\ianvi\\Documents\\REPORTES\\Reporte_Por_Autor_" + inputAuthor + ".txt")) {
        writer.write("Autor\t\t\tAño\tID\tISBN\tTitulo\t\t\tTema\t\t\n\n");
        for (Libro libro : librosFiltrados) {
            writer.write(libro.getAutor() + "\t" + libro.getanio() + "\t" + libro.getID() + "\t" + libro.getISBN() + "\t" + libro.getTitulo() + "\t" + libro.getGenero() + "\n");
        }
        System.out.println("Reporte generado con éxito");
    } catch (IOException e) {
        System.out.println("Error al generar el reporte: " + e.getMessage());
    }
    System.out.println("Libros Encontrados: " + librosFiltrados.size());
}
    
    
    
    public void alfa (){
        
    String[] nombres = {"Burbuja", "Burbuja Bidireccional", "Inserción", "Selección", "Shell", "Quicksort", "Radix", "Merge", "Bucket", "Couting","Heap"};
    int[] arr = {contBurbuja, contBurbujaBi, contInsercion, contSeleccion, contShell, contQuick, contRadix, contMerge, contBucket,contCountingSort,contHeapSort};
    int max = Arrays.stream(arr).max().getAsInt();
    int indiceMax = IntStream.range(0, arr.length).reduce((i, j) -> arr[i] > arr[j] ? i : j).getAsInt();
    System.out.println("El método de Ordenamiento Alfa es: " + nombres[indiceMax] + " con un conteo de " + max);
    }
    
    public void contadores (){
        System.out.println("Algoritmo de Burbuja ejectutado:               "+ contBurbuja + " veces.");
        System.out.println("Algoritmo de Burbuja Bidireccional ejectutado: "+ contBurbujaBi + " veces.");
        System.out.println("Algoritmo de Insercion ejectutado:             "+ contInsercion+ " veces.");
        System.out.println("Algoritmo de Seleccion ejectutado:             "+ contSeleccion+ " veces.");
        System.out.println("Algoritmo de Shell ejectutado:                 "+ contShell+ " veces.");
        System.out.println("Algoritmo de Quick ejectutado:                 "+ contQuick + " veces.");
        System.out.println("Algoritmo de Radix ejectutado:                 "+ contRadix+ " veces.");
        System.out.println("Algoritmo de Merge ejectutado:                 "+ contMerge + " veces.");
        System.out.println("Algoritmo de Bucket ejectutado:                "+ contBucket + " veces.");
        System.out.println("Algoritmo de Counting ejecutado:               "+ contCountingSort +" veces.");
        System.out.println("Algoritmo de Heap ejecutado:                   "+ contHeapSort +" veces.");
        
    }
}