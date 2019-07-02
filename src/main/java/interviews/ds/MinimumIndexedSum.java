/*
 * Created on Jun 30, 2019 at 4:01:31 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * TODO: Enter class-level documentation here.
 *
 */
public final class MinimumIndexedSum {

    public static String[] minimumIndexedSum(String[] left,
                                             String[] right) {

        var sumMap = new HashMap<String, Integer>();

        // Populate the map with indices
        for (int i = 0; i < left.length; i++) {
            sumMap.put(left[i], i);
        }

        var common = new ArrayList<String>();
        // Next add the other array.
        for (int i = 0; i < right.length; i++) {
            Integer index = sumMap.get(right[i]);
            if (index != null) {
                common.add(right[i]);
                sumMap.put(right[i], index + i);
            }
        }

        // Now, look for the smallest value among the common ones.
        if (common.isEmpty())
            return new String[] {};

        var best    = new ArrayList<String>();
        int bestSum = Integer.MAX_VALUE;

        for (String str : common) {
            Integer sum = sumMap.get(str);
            if (sum.equals(bestSum)) {
                best.add(str);
            } else if (sum < bestSum) {
                best.clear();
                best.add(str);
                bestSum = sum;
            }
        }

        return best.toArray(new String[best.size()]);
    }

}
