package org.doo.rev;

import java.util.Random;
import java.util.UUID;

public class Index {

    private final byte[] data;

    private int offset;
    private int index = 1;

    public Index(byte[] data) {
        this.data = data;
    }

    public int next() {
        if (index == 256) {
            index = 1;
            offset++;
        }

        int res;

        if (offset == data.length) {
            res = -1;
        } else {
            res = data[offset] & index;
        }

        index <<= 1;
        return res;
    }

    public int next2() {
        if (offset == data.length) {
            return -1;
        }

        switch (index) {
            case 1:
                index++;
                return data[offset] & 1;
            case 2:
                index++;
                return data[offset] & 2;
            case 3:
                index++;
                return data[offset] & 4;
            case 4:
                index++;
                return data[offset] & 8;
            case 5:
                index++;
                return data[offset] & 16;
            case 6:
                index++;
                return data[offset] & 32;
            case 7:
                index++;
                return data[offset] & 64;
            default:
                index = 1;
                return data[offset++] & 128;
        }
    }

    public static void main(String[] args) {

        System.out.println(UUID.randomUUID());
//        int size = 2;
        int size = Integer.MAX_VALUE - 100000;

        System.out.println(Runtime.getRuntime().totalMemory());

        byte[] data = new byte[size];

        Random rnd = new Random(0);

        System.out.println("init");

        rnd.nextBytes(data);

        //2860c5d9-4da9-4362-a7e1-794e307491D2

//        for (byte b : data) {
//            String bin = Integer.toBinaryString(b);
//            System.out.println(bin.substring(Math.max(bin.length() - 8, 0)));
//        }

        System.out.println("start");
        long st = System.currentTimeMillis();

        Index index = new Index(data);

        long ones = 0;
        int val;

        while ((val = index.next()) != -1) {
            if (val > 0) {
                ones++;
            }
        }

        System.out.println("in " + (System.currentTimeMillis() - st));
        System.out.println(ones);
    }

}
