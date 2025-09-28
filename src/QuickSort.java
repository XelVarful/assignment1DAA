import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    // основная функция сортировки
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    // рекурсивная часть
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        // выбираем случайный опорный элемент
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = arr[pivotIndex];

        // делим массив на части
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // сортируем части рекурсивно
        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }

    // метод обмена элементов
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // проверка
    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("До сортировки: " + Arrays.toString(data));
        quickSort(data);
        System.out.println("После сортировки: " + Arrays.toString(data));
    }
}
