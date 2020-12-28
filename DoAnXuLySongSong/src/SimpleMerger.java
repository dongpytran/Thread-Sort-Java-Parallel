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

public class SimpleMerger {

    private int[] unsorted, sorted;

    public SimpleMerger( int[] unsorted ) {
        this.unsorted = unsorted;
    }

    // split array on two part to sort
    public void sort() {
        int middle;
        int[] left, right;

        if ( unsorted.length <= 1 ) {
            sorted = unsorted;
        } else {
            middle = unsorted.length / 2;
            left = new int[middle];
            // array length may be odd
            right = new int[unsorted.length - middle];
            System.arraycopy( unsorted, 0, left, 0, middle );
            System.arraycopy( unsorted, middle, right, 0, unsorted.length - middle );
            // array sort
            Arrays.sort(left);
            Arrays.sort(right);
            sorted = merge(left, right);
        }
    }
    // function to merge two arrays in one
    public static int[] merge( int[] leftPart, int[] rightPart ) {
        int cursorLeft = 0, cursorRight = 0, counter = 0;
        int[] merged = new int[leftPart.length + rightPart.length];
        while ( cursorLeft < leftPart.length && cursorRight < rightPart.length ) {
            if (leftPart[cursorLeft]-(rightPart[cursorRight] ) < 0 ) {
                merged[counter] = leftPart[cursorLeft];
                cursorLeft++;
            } else {
                merged[counter] = rightPart[cursorRight];
                cursorRight++;
            }
            counter++;
        }
        if ( cursorLeft < leftPart.length ) {
            System.arraycopy( leftPart, cursorLeft, merged, counter, merged.length - counter );
        }
        if ( cursorRight < rightPart.length ) {
            System.arraycopy( rightPart, cursorRight, merged, counter, merged.length - counter );
        }
        return merged;
    }
    public int[] getSorted() {
        return sorted;
    }
    
}

