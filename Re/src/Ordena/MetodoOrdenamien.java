package Ordena;

import javax.swing.JOptionPane;

public class MetodoOrdenamien implements MetodoOrdenamiento {
    private int[] arreglo;
    private byte indice;

    public MetodoOrdenamien(int n) {
        arreglo = new int[n];
        indice = -1;
    }

    public boolean arrayVacio() {
        return indice == -1;
    }

    public boolean espacioArray() {
        return indice < arreglo.length - 1;
    }

    public void vaciarArray() {
        indice = -1;
    }

    public void almacenaAleatorios() {
        if (!espacioArray()) {
            JOptionPane.showMessageDialog(null, "No hay suficiente espacio en el arreglo.");
        } else {
            int dato = generaRandom(10, 99);
            indice++;
            arreglo[indice] = dato;
        }
    }

    public String impresionDatos() {
        if (arrayVacio()) {
            return "El arreglo está vacío.";
        } else {
            String datos = "Datos del arreglo: ";
            for (int i = 0; i <= indice; i++) {
                datos += arreglo[i] + " ";
            }
            return datos;
        }
    }

    public void burbujaSeñal() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            boolean intercambio;
            do {
                intercambio = false;
                for (int i = 0; i < indice; i++) {
                    if (arreglo[i] > arreglo[i + 1]) {
                        int temp = arreglo[i];
                        arreglo[i] = arreglo[i + 1];
                        arreglo[i + 1] = temp;
                        intercambio = true;
                    }
                }
            } while (intercambio);
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de burbujaSeñal.");
        }
    }

    public void dobleBurbuja() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            boolean intercambio;
            int limiteSuperior = indice;
            int limiteInferior = 0;
            do {
                intercambio = false;
                for (int i = limiteInferior; i < limiteSuperior; i++) {
                    if (arreglo[i] > arreglo[i + 1]) {
                        int temp = arreglo[i];
                        arreglo[i] = arreglo[i + 1];
                        arreglo[i + 1] = temp;
                        intercambio = true;
                    }
                }
                limiteSuperior--;
                for (int i = limiteSuperior; i > limiteInferior; i--) {
                    if (arreglo[i] < arreglo[i - 1]) {
                        int temp = arreglo[i];
                        arreglo[i] = arreglo[i - 1];
                        arreglo[i - 1] = temp;
                        intercambio = true;
                    }
                }
                limiteInferior++;
            } while (intercambio);
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de dobleBurbuja.");
        }
    }

    public void shellIncreDecre() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            int n = indice + 1;
            int brecha = n / 2;
            while (brecha > 0) {
                for (int i = brecha; i < n; i++) {
                    int temp = arreglo[i];
                    int j = i;
                    while (j >= brecha && arreglo[j - brecha] > temp) {
                        arreglo[j] = arreglo[j - brecha];
                        j -= brecha;
                    }
                    arreglo[j] = temp;
                }
                brecha /= 2;
            }
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de shellIncreDecre.");
        }
    }

    public void seleDirecta() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            for (int i = 0; i < indice; i++) {
                int minimo = i;
                for (int j = i + 1; j <= indice; j++) {
                    if (arreglo[j] < arreglo[minimo]) {
                        minimo = j;
                    }
                }
                int temp = arreglo[minimo];
                arreglo[minimo] = arreglo[i];
                arreglo[i] = temp;
            }
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de seleDirecta.");
        }
    }

    public void inserDirecta() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            for (int i = 1; i <= indice; i++) {
                int temp = arreglo[i];
                int j = i - 1;
                while (j >= 0 && arreglo[j] > temp) {
                    arreglo[j + 1] = arreglo[j];
                    j--;
                }
                arreglo[j + 1] = temp;
            }
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de inserDirecta.");
        }
    }

    public void binaria() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a buscar:"));
            int izquierda = 0;
            int derecha = indice;
            int posicion = -1;
            while (izquierda <= derecha && posicion == -1) {
                int medio = (izquierda + derecha) / 2;
                if (arreglo[medio] == valor) {
                    posicion = medio;
                } else if (arreglo[medio] < valor) {
                    izquierda = medio + 1;
                } else {
                    derecha = medio - 1;
                }
            }
            if (posicion != -1) {
                JOptionPane.showMessageDialog(null, "El valor " + valor + " fue encontrado en la posición " + posicion + ".");
            } else {
                JOptionPane.showMessageDialog(null, "El valor " + valor + " no fue encontrado en el arreglo.");
            }
        }
    }

    public void heapSort() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            int n = indice + 1;
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(n, i);
            }
            for (int i = n - 1; i >= 0; i--) {
                int temp = arreglo[0];
                arreglo[0] = arreglo[i];
                arreglo[i] = temp;
                heapify(i, 0);
            }
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de heapSort.");
        }
    }

    private void heapify(int n, int i) {
        int mayor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;
        if (izquierda < n && arreglo[izquierda] > arreglo[mayor]) {
            mayor = izquierda;
        }
        if (derecha < n && arreglo[derecha] > arreglo[mayor]) {
            mayor = derecha;
        }
        if (mayor != i) {
            int temp = arreglo[i];
            arreglo[i] = arreglo[mayor];
            arreglo[mayor] = temp;
            heapify(n, mayor);
        }
    }

    public void quicksortRecursivo() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            quicksortRecursivo(0, indice);
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de quicksortRecursivo.");
        }
    }

    private void quicksortRecursivo(int izquierda, int derecha) {
        int i = izquierda;
        int j = derecha;
        int pivote = arreglo[(izquierda + derecha) / 2];
        while (i <= j) {
            while (arreglo[i] < pivote) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
                i++;
                j--;
            }
        }
        if (izquierda < j) {
            quicksortRecursivo(izquierda, j);
        }
        if (i < derecha) {
            quicksortRecursivo(i, derecha);
        }
    }

    public void radix() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            boolean numerosNegativos = false;
            for (int i = 0; i <= indice; i++) {
                if (arreglo[i] < 0) {
                    numerosNegativos = true;
                    break;
                }
            }
            if (numerosNegativos) {
                JOptionPane.showMessageDialog(null, "No son válidos los números negativos en el método Radix.");
            } else {
                int n = indice + 1;
                int maximo = getMaximo();
                for (int exp = 1; maximo / exp > 0; exp *= 10) {
                    countingSort(exp, n);
                }
                JOptionPane.showMessageDialog(null, "Se ha aplicado el método de radix.");
            }
        }
    }


    private int getMaximo() {
        int maximo = arreglo[0];
        for (int i = 1; i <= indice; i++) {
            if (arreglo[i] > maximo) {
                maximo = arreglo[i];
            }
        }
        return maximo;
    }

    private void countingSort(int exp, int n) {
        int[] salida = new int[n];
        int[] cuenta = new int[10];
        for (int i = 0; i < n; i++) {
            cuenta[(arreglo[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            cuenta[i] += cuenta[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            salida[cuenta[(arreglo[i] / exp) % 10] - 1] = arreglo[i];
            cuenta[(arreglo[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arreglo[i] = salida[i];
        }
    }

    public void intercalacion() {
        if (arrayVacio()) {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío.");
        } else {
            int[] auxiliar = new int[indice + 1];
            intercalacion(auxiliar, 0, indice);
            JOptionPane.showMessageDialog(null, "Se ha aplicado el método de intercalación.");
        }
    }

    private void intercalacion(int[] auxiliar, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            intercalacion(auxiliar, izq, medio);
            intercalacion(auxiliar, medio + 1, der);
            mezcla(izq, medio, der, auxiliar);
        }
    }

    private void mezcla(int izq, int medio, int der, int[] auxiliar) {
        for (int i = izq; i <= der; i++) {
            auxiliar[i] = arreglo[i];
        }
        int i = izq;
        int j = medio + 1;
        int k = izq;
        while (i <= medio && j <= der) {
            if (auxiliar[i] <= auxiliar[j]) {
                arreglo[k] = auxiliar[i];
                i++;
            } else {
                arreglo[k] = auxiliar[j];
                j++;
            }
            k++;
        }
        while (i <= medio) {
            arreglo[k] = auxiliar[i];
            k++;
            i++;
        }
    }

    private int generaRandom(int min, int max) {
        return (int)((max - min + 1) * Math.random() + min);
    }

	@Override
	public void mezclaDirecta() {
		// TODO Auto-generated method stub
		
	}
	public void ingresarNumero(int numero) {
	    if (espacioArray()) {
	        indice++;
	        arreglo[indice] = numero;
	        JOptionPane.showMessageDialog(null, "Se ha ingresado el número " + numero + " al arreglo.");
	    } else {
	        JOptionPane.showMessageDialog(null, "No hay espacio disponible en el arreglo.");
	    }
	}

}


