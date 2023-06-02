package Ordena;

import javax.swing.JOptionPane;

public class MetodoOrdenamientoMenu {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de números aleatorios:"));
        MetodoOrdenamiento metodoOrdenamiento = new MetodoOrdenamien(n);

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== Menú de Métodos de Ordenamiento ===\n"
                            + "1. Verificar si el arreglo está vacío\n"
                            + "2. Verificar si hay espacio en el arreglo\n"
                            + "3. Vaciar el arreglo\n"
                            + "4. Llenar el arreglo con números aleatorios\n"
                            + "5. Imprimir datos del arreglo\n"
                            + "6. Aplicar método de burbujaSeñal\n"
                            + "7. Aplicar método de dobleBurbuja\n"
                            + "8. Aplicar método de shellIncreDecre\n"
                            + "9. Aplicar método de seleDirecta\n"
                            + "10. Aplicar método de inserDirecta\n"
                            + "11. Aplicar método de búsqueda binaria\n"
                            + "12. Aplicar método de heapSort\n"
                            + "13. Aplicar método de quicksortRecursivo\n"
                            + "14. Aplicar método de radix\n"
                            + "15. Aplicar método de intercalación\n"
                            + "16. Agregar numeros al arreglo\n"
                            + "0. Salir\n\n"
                            + "Ingrese una opción:"
            ));

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "El arreglo está vacío: " + metodoOrdenamiento.arrayVacio());
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
                    metodoOrdenamiento.burbujaSeñal();
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
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número:"));
                    ((MetodoOrdenamien) metodoOrdenamiento).ingresarNumero(numero);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }
}
