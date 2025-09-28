import java.util.Arrays;

public class MergeSort {

    // сортировка слиянием (делим массив на части и соединяем обратно)
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    // рекурсивная часть
    private static void mergeSort(int[] arr, int left, int right) {
        // если только один элемент - сортировать не нужно
        if (left >= right) return;

        int middle = (left + right) / 2;

        // сортируем левую часть
        mergeSort(arr, left, middle);
        // сортируем правую часть
        mergeSort(arr, middle + 1, right);

        // объединяем две части
        merge(arr, left, middle, right);
    }

    // метод слияния двух отсортированных частей
    private static void merge(int[] arr, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        // создаем временные массивы
        int[] leftArr = new int[size1];
        int[] rightArr = new int[size2];

        for (int i = 0; i < size1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < size2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // слияние обратно в основной массив
        int i = 0, j = 0, k = left;
        while (i < size1 && j < size2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // добавляем оставшиеся элементы
        while (i < size1) {
            arr[k++] = leftArr[i++];
        }
        while (j < size2) {
            arr[k++] = rightArr[j++];
        }
    }

    // проверка работы
    public static void main(String[] args) {
        int[] nums = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("До сортировки: " + Arrays.toString(nums));
        mergeSort(nums);
        System.out.println("После сортировки: " + Arrays.toString(nums));
    }
}
