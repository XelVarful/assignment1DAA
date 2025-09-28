import java.util.*;

public class DeterministicSelect {

    // Главная функция поиска k-го элемента
    public static int select(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k - 1);
    }

    // Рекурсивный алгоритм Median of Medians
    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivotIndex = getPivotIndex(arr, left, right);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return select(arr, left, pivotIndex - 1, k);
        } else {
            return select(arr, pivotIndex + 1, right, k);
        }
    }

    // Разделение массива
    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    // Поиск медианы медиан (ключевой шаг!)
    private static int getPivotIndex(int[] arr, int left, int right) {
        if (right - left < 5) {
            Arrays.sort(arr, left, right + 1);
            return (left + right) / 2;
        }

        int subRight = left;
        for (int i = left; i <= right; i += 5) {
            int subEnd = Math.min(i + 4, right);
            Arrays.sort(arr, i, subEnd + 1);
            int medianIndex = (i + subEnd) / 2;
            swap(arr, medianIndex, subRight);
            subRight++;
        }
        return getPivotIndex(arr, left, subRight - 1);
    }

    // Обмен
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Проверка
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 3; // ищем 3-й по величине элемент
        int result = select(arr, k);
        System.out.println(k + "-й наименьший элемент: " + result);
    }
}
