#include <iostream>
using std::cout;
using std::endl;
using std::swap;

template <typename T>
void printArray(T a[], int len) {
    for (int i = 1; i <= len; i++) {
        cout << a[i] << ' ';
    }
    cout << endl;
}

template <typename T>
void siftDown(T a[], int i, int len) {
    while (i <= len/2) {
        int j = i;
        if (i * 2 <= len && a[j] < a[i * 2]) {
            j = i * 2;
        }
        if (i * 2 + 1 <= len && a[j] < a[i * 2 + 1]) {
            j = i * 2 + 1;
        }
        if (i != j) {
            swap(a[i], a[j]);
            i = j;
        } else {
            break;
        }
    }
}

template <typename T>
void heapSort(T a[], int len) {
    /* build heap */
    for (int i = len/2; i >= 1; i--) {
        siftDown(a, i, len);
    }

    /* loop */
    while (len > 1) {
        swap(a[1], a[len]);
        len--;
        siftDown(a, 1, len);
    }
}

int main() {
    int a[] = {0,
               4, 2, 9, 2, 1, 0, 8, 5, 2};
    int lenA = 9;
    printArray<int>(a, lenA);
    heapSort<int>(a, lenA);
    printArray<int>(a, lenA);
    cout << endl;

    float b[] = {0.0,
                4.2, .3, .1, 34.2, -9.003, 8, 3.4};
    int lenB = 7;
    printArray<float>(b, lenB);
    heapSort<float>(b, lenB);
    printArray<float>(b, lenB);
    cout << endl;

    return 0;
}