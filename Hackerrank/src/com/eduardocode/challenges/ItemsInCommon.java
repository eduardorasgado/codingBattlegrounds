package com.eduardocode.challenges;

import java.util.Hashtable;

public class ItemsInCommon {

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};
        int[] array3 = {2, 4, 6};

        System.out.println(hasItemInCommon(array1, array2));
        System.out.println(hasItemInCommon(array1, array3));
    }

    private static boolean hasItemInCommon(int[] array1, int[] array2) {
        Hashtable<Integer, Boolean> ht = new Hashtable<>();

        for (int i = 0; i < array1.length; i++) {
            ht.put(array1[i], true);
        }

        for (int i = 0; i < array2.length; i++) {
            if(ht.get(array2[i]) != null) {
                return true;
            }
        }

        return false;
    }
}
