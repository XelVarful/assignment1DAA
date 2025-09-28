public class MergeSort {

    // Главная функция — запускаем сортировку
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    // Рекурсивный алгоритм делит массив и сортирует
    private static void mergeSort(int[] arr, int left, int right, int[] buffer) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        // Сортируем левую и правую половину
        mergeSort(arr, left, mid, buffer);
        mergeSort(arr, mid + 1, right, buffer);

        // Сливаем две отсортированные части
        merge(arr, left, mid, right, buffer);
    }

    //  Слияние отсортированных частей
    private static void merge(int[] arr, int left, int mid, int right, int[] buffer) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                buffer[k++] = arr[i++];
            } else {
                buffer[k++] = arr[j++];
            }
        }

        while (i <= mid) buffer[k++] = arr[i++];
        while (j <= right) buffer[k++] = arr[j++];

        for (int p = left; p <= right; p++) {
            arr[p] = buffer[p];
        }
    }

    // Проверка работы
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        mergeSort(arr);

        System.out.print("Отсортированный массив: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
