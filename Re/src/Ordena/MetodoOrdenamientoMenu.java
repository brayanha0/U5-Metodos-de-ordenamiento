package Ordena;

import javax.swing.JOptionPane;

public class MetodoOrdenamientoMenu {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de n�meros aleatorios:"));
        MetodoOrdenamiento metodoOrdenamiento = new MetodoOrdenamien(n);

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== Men� de M�todos de Ordenamiento ===\n"
                            + "1. Verificar si el arreglo est� vac�o\n"
                            + "2. Verificar si hay espacio en el arreglo\n"
                            + "3. Vaciar el arreglo\n"
                            + "4. Llenar el arreglo con n�meros aleatorios\n"
                            + "5. Imprimir datos del arreglo\n"
                            + "6. Aplicar m�todo de burbujaSe�al\n"
                            + "7. Aplicar m�todo de dobleBurbuja\n"
                            + "8. Aplicar m�todo de shellIncreDecre\n"
                            + "9. Aplicar m�todo de seleDirecta\n"
                            + "10. Aplicar m�todo de inserDirecta\n"
                            + "11. Aplicar m�todo de b�squeda binaria\n"
                            + "12. Aplicar m�todo de heapSort\n"
                            + "13. Aplicar m�todo de quicksortRecursivo\n"
                            + "14. Aplicar m�todo de radix\n"
                            + "15. Aplicar m�todo de intercalaci�n\n"
                            + "16. Agregar numeros al arreglo\n"
                            + "0. Salir\n\n"
                            + "Ingrese una opci�n:"
            ));

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "El arreglo est� vac�o: " + metodoOrdenamiento.arrayVacio());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Hay espacio en el arreglo: " + metodoOrdenamiento.espacioArray());
                    break;
                case 3:
                    metodoOrdenamiento.vaciarArray();
                    JOptionPane.showMessageDialog(null, "Se ha vaciado el arreglo.");
                    break;
                case 4:
                    metodoOrdenamiento.almacenaAleatorios();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, metodoOrdenamiento.impresionDatos());
                    break;
                case 6:
                    metodoOrdenamiento.burbujaSe�al();
                    break;
                case 7:
                    metodoOrdenamiento.dobleBurbuja();
                    break;
                case 8:
                    metodoOrdenamiento.shellIncreDecre();
                    break;
                case 9:
                    metodoOrdenamiento.seleDirecta();
                    break;
                case 10:
                    metodoOrdenamiento.inserDirecta();
                    break;
                case 11:
                    metodoOrdenamiento.binaria();
                    break;
                case 12:
                    metodoOrdenamiento.heapSort();
                    break;
                case 13:
                    metodoOrdenamiento.quicksortRecursivo();
                    break;
                case 14:
                    metodoOrdenamiento.radix();
                    break;
                case 15:
                    metodoOrdenamiento.intercalacion();
                    break;
                case 16:
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un n�mero:"));
                    ((MetodoOrdenamien) metodoOrdenamiento).ingresarNumero(numero);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opci�n inv�lida. Por favor, ingrese una opci�n v�lida.");
                    break;
            }
        } while (opcion != 0);
    }
}
