package Algoritmos;
import java.util.ArrayList;

public class SortedArrayListExample {
    private ArrayList<String> sortedList;

    public SortedArrayListExample() {
        sortedList = new ArrayList<>();
    }

    public void insertSorted(String element) {
        int insertIndex = binarySearch(element);
        sortedList.add(insertIndex, element);
    }

    private int binarySearch(String element) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = element.compareTo(sortedList.get(mid));

            if (comparisonResult == 0) {
                return mid;  // Element already exists, insert at this position
            } else if (comparisonResult < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;  // Element does not exist, return the position for insertion
    }

    public ArrayList<String> getSortedList() {
        return sortedList;
    }

    public static void main(String[] args) {
        SortedArrayListExample sortedArrayListExample = new SortedArrayListExample();

        // Insertar elementos en orden
        sortedArrayListExample.insertSorted("Apple");
        sortedArrayListExample.insertSorted("Orange");
        sortedArrayListExample.insertSorted("Banana");
        

        // Obtener la lista ordenada
        ArrayList<String> sortedList = sortedArrayListExample.getSortedList();

        // Imprimir la lista ordenada
        System.out.println("Lista ordenada: " + sortedList);
    }
}
