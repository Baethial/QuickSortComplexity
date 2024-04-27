public class Logic {

    private int count = 0;          // Counter of Elemental Operations for Binary Search
    private int quickSortEO = 0;    // Counter of Elemental Operation for Quick Sort
    private int mergeSortOE = 0;    // Counter of Elemental Operation for Quick Sort

    public Logic() {
    }

    public int[] generateArray(int arraySize) {

        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) ((Math.random() * 100) + 1);
        }

        quickSort(0, array.length - 1, array);

        return array;

    }

    public void sort(int arr[], int left, int right){
        mergeSortOE += 1;
        if(left < right){
            mergeSortOE += 3;
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            //Une las mitades.
            merge(arr, left, middle, right);
        }
    }

    public void merge(int arr[], int left, int middle, int right) {
        mergeSortOE += 5;
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        mergeSortOE += 2;
        //Vectores temporales.
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //Copia los datos a los arrays temporales.
        mergeSortOE += 1;
        for (int i=0; i < n1; i++) {
            mergeSortOE += 2;
            mergeSortOE += 4;
            leftArray[i] = arr[left+i];
        }
        mergeSortOE += 1;

        mergeSortOE += 1;
        for (int j=0; j < n2; j++) {
            mergeSortOE += 2;
            mergeSortOE += 5;
            rightArray[j] = arr[middle + j + 1];
        }
        mergeSortOE += 1;
        /* Une los vectorestemporales. */

        mergeSortOE += 2;
        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        mergeSortOE += 1;
        //Índice inicial del sub-vector arr[].
        int k = left;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            mergeSortOE += 2;
            mergeSortOE += 3;
            if (leftArray[i] <= rightArray[j]) {
                mergeSortOE += 4;
                arr[k] = leftArray[i];
                i++;
            } else {
                mergeSortOE += 4;
                arr[k] = rightArray[j];
                j++;
            }
            mergeSortOE += 1;
            k++;
        }//Fin del while.
        mergeSortOE += 2;

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            mergeSortOE += 1;
            mergeSortOE += 5;
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        mergeSortOE += 1;

        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            mergeSortOE += 1;
            mergeSortOE += 5;
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void quickSort(int i,int j,int[] array) {
        //quickSortEO += 2;
        int tempi = i;
        int tempj = j;
        quickSortEO += 2;
        int center = array[ (i+j) / 2 ];
        do {
            while (array[i] < center) {
                quickSortEO += 2;
                quickSortEO +=1;
                i++;
            }
            quickSortEO += 1;

            while (center < array[j]) {
                quickSortEO += 2;
                quickSortEO += 1;
                j--;
            }
            quickSortEO += 1;

            quickSortEO += 1;
            if (i < j) {
                swap (array,i,j);
                quickSortEO += 1;
                i = i + 1;
                quickSortEO += 1;
                j = j - 1;
            }

            quickSortEO += 1;
        } while ( i < j);

        quickSortEO += 1;
        if (i == j) {
            quickSortEO += 2;
            if (center < array[i]){
                quickSortEO += 1;
                j = j - 1;
            } else {
                quickSortEO += 1;
                i = i + 1;
            }
        }

        quickSortEO += 1;
        if (j-1 == tempi) {
            quickSortEO += 3;
            if (array[tempi] > array[j]) {
                swap (array, tempi,j);
            }
        }
        else {
            quickSortEO += 1;
            if (j > tempi) {
                quickSort (tempi,j,array);
            }
        }
        quickSortEO += 1;
        if (i+1 == tempj) {
            quickSortEO += 3;
            if (array[i] > array[tempj]) {
                swap (array,i,tempj);
            }
        }
        else {
            quickSortEO += 1;
            if (i < tempj) {
                quickSort (i,tempj,array);
            }
        }

    }
    
    void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean binarySearch(int[] array, int left, int right, int number) {
        count += 1;
        if (left > right) {
            //System.out.println("Element not found");
            return false;
        } else {
            count += 3;
            int center = (int) ((left + right) / 2);
            count += 2;
            if (number == array[center]) {
                //System.out.println("Element found at position: " + center);
                return true;
            } else {
                count += 2;
                if (number < array[center]) {
                    return binarySearch(array, left, (center - 1), number);
                } else {
                    return binarySearch(array, (center + 1), right, number);
                }
            }
        }

        /*        count += 1;
        if (right>=left){
            count += 3;
            int center = left + (right - left)/2;
            count += 2;
            if (array[center] == number){
                System.out.println("Number " + number + "found in position " + center);
                return true;
            }
            count += 2;
            if (array[center] > number){
                count += 1;
                return binarySearch(array, left, center-1, number);//search in left subarray
            }else{
                count += 1;
                return binarySearch(array, center+1, right, number);//search in right subarray
            }
        }
        System.out.println("Number not found");
        return false;

        count += 3;
        int center = (left + right) / 2;
        count += 1;
        while (left <= right) {
            count += 1;
            count += 2;
            if (array[center] < number) {
                count += 2;
                left = center + 1;
            } else if (array[center] == number) {
                count += 2;
                System.out.println("Element is found at index: " + center);
                return true;
            } else {
                count += 2;
                right = center - 1;
            }
            count += 3;
            center = (left + right) / 2;
        }

        System.out.println("Element is not found!");
        return false;*/

    }

    public int[][] generateMergeSortCoordinates(int n) {

        int[][] coordinatesXY = new int[2][n];

        for (int i = 0; i < n; i++) {

            int arraySize = (i + 1) * 5;

            coordinatesXY[0][i] = arraySize;    // Number of the independent variable-arraySize

            int[] array = generateArray(arraySize);

            sort(array, 0, arraySize - 1);
            coordinatesXY[1][i] = mergeSortOE;
            if (i == n - 1) {
                //System.out.println("Numero de OE: " + coordinatesXY[1][i]);
            }
            
            mergeSortOE = 0;

        }

        return coordinatesXY;

    }

    public int[][] generateQuickSortCoordinates(int n) {

        int[][] coordinatesXY = new int[2][n];

        for (int i = 0; i < n; i++) {

            int arraySize = (i + 1) * 5;

            coordinatesXY[0][i] = arraySize;    // Number of the independent variable-arraySize

            int[] array = generateArray(50);

            quickSort(0, 50 - 1, array);
            coordinatesXY[1][i] = 500 - quickSortEO / 50;
            if (i == n - 1) {
                System.out.println("Numero de OE: " + coordinatesXY[1][i]);
            }
            quickSortEO = 0;

        }

        return coordinatesXY;

    }

    public int[][] generateCoordinates(int n) {

        int[][] coordinatesXY = new int[2][n];

        for (int i = 0; i < n; i++) {

            int arraySize = (i + 1) * 5;

            coordinatesXY[0][i] = arraySize;    // Number of the independent variable-arraySize

            int[] array = generateArray(arraySize);
            //printArray(array);
            int posNumberToFind = (int) (Math.random() * array.length);
            //System.out.println("Pos: " + posNumberToFind);
            int numberToFind = array[posNumberToFind];
            //System.out.println("The number in pos " + posNumberToFind + " is " + numberToFind);
            count = 0;
            binarySearch(array, 0, (arraySize - 1), numberToFind);
            coordinatesXY[1][i] = 500 - count * 5;

        }

        return coordinatesXY;

    }

    public int[][] generateCoordinatesLogBaseTwo(int n) {

        int[][] coordinatesLogarithmBaseTwo = new int[2][n];

        for (int i = 0; i < n; i++) {

            coordinatesLogarithmBaseTwo[0][i] = (i + 1) * 5;
            coordinatesLogarithmBaseTwo[1][i] = 500 - (int) ((Math.log(i + 1) / Math.log(2)) * 5) -30;

        }

        return coordinatesLogarithmBaseTwo;

    }

    public int[][] generateCoordinatesByFormula(int n) {

        int[][] coordinatesByFormula = new int[2][n];

        for (int i = 0; i < n; i++) {

            coordinatesByFormula[0][i] = (i + 1) * 5;
            coordinatesByFormula[1][i] = 500 - (int) (7 + 10 * Math.log(i + 1) / Math.log(2)) * 5;

        }

        return coordinatesByFormula;

    }

    /*public void printArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.println("Pos: " + i + " value: " + array[i]);
        }
    }*/

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getQuickSortEO() {
        return quickSortEO;
    }

    public void setQuickSortEO(int quickSortEO) {
        this.quickSortEO = quickSortEO;
    }

    public int getMergeSortOE() {
        return mergeSortOE;
    }

    public void setMergeSortOE(int mergeSortOE) {
        this.mergeSortOE = mergeSortOE;
    }
}