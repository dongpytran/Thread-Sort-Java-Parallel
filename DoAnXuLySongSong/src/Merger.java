/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PY
 */
import java.util.Arrays;

public class Merger implements Runnable{
    private int[] unsorted, sorted;
    // number of threads
    private static final int MAX_THREADS = 8;
    public int[] sorted2;
    public long time;
    public Merger(int[] unsorted) {
        this.unsorted = unsorted;
        sorted2 = null;
    }

    public void run() {
        int middle;
        int[] left, right;
        // array is sorted
        if ( unsorted.length <= 1 ) {
            sorted = unsorted;
        } else {
            //
            middle = unsorted.length / 2;
            left = new int[middle];
            right = new int[unsorted.length - middle];
            //split array on two
            System.arraycopy(unsorted, 0, left, 0, middle);
            System.arraycopy(unsorted, middle, right, 0, unsorted.length - middle);
            SimpleMerger leftSort = new SimpleMerger(left);
            SimpleMerger rightSort = new SimpleMerger(right);
            leftSort.sort();
            rightSort.sort();
            //sort and merge
            sorted = SimpleMerger.merge(leftSort.getSorted(), rightSort.getSorted());
         }
        sorted2 = sorted;
        }
    public int[] getSorted() {
        return sorted;
    }
    public int[] getSorted2(int[] arr) {
        run();
        arr = sorted2;
        return arr;
    }
}

