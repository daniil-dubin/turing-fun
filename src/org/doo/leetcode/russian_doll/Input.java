package org.doo.leetcode.russian_doll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static final int[][] data() throws IOException {
        List<int[]> in1 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(Input.class.getResourceAsStream("/org/doo/leetcode/russian_doll/in.txt")));
        String line;

        while ((line = br.readLine()) != null) {
            in1.add(new int[]{Integer.valueOf(line.substring(0, line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",") + 1))});
        }


        int[][] res = new int[in1.size()][2];

        for (int i = 0; i < res.length; i++) {
            res[i] = in1.get(i);
        }

        return res;
    }

}
