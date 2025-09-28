import java.util.Random;

public class QuickSort {

    // Главная функция сортировки
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Рекурсивный алгоритм
    private static void quickSort(int[] arr, int left, int right) {
        while (left < right) {
            int pivotIndex = partition(arr, left, right);

            // 🔁 Сначала рекурсия на меньшей части (для глубины O(log n))
            if (pivotIndex - left < right - pivotIndex) {
                quickSort(arr, left, pivotIndex - 1);
                left = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, right);
                right = pivotIndex - 1;
            }
        }
    }

    // Разделение массива вокруг pivot
    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    //  Обмен элементов
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Проверим работу
    public static void main(String[] args) {
        int[] arr = {9, 4, 6, 2, 7, 1, 5};
        quickSort(arr);
        System.out.print("Отсортированный массив: ");
        for (int n : arr) System.out.print(n + " ");
    }
}
