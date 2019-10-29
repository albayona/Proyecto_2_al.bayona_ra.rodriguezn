package model.data_structures;

import java.util.Comparator;

public class MergeSort {
    private  static Object[] aux;

    private  static Comparator comparator;

    public static void mergeSort(Object[] a, Comparator comp)
    {
        comparator = comp;
        aux = new Object[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    public  static void merge(Object[] a, int inf, int med, int sup)
    {
        int i = inf, j = med+1;

        for (int k = inf; k <= sup; k++) aux[k] = a[k];

        for (int k = inf; k <= sup; k++) {

            if (i > med) a[k] = aux[j++];

            else if (j > sup) a[k] = aux[i++];

            else if (less(aux[j], aux[i])) a[k] = aux[j++];

            else a[k] = aux[i++];
        }
    }

    private static  boolean less(Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    private static void mergeSort(Object[] a, int inf, int sup)
    {
        if (sup <= inf) return;
        int mid = inf + (sup - inf)/2;
        mergeSort(a, inf, mid);
        mergeSort(a, mid+1, sup);
        merge(a, inf, mid, sup);
    }
}
