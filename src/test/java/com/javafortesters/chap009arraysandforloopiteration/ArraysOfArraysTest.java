package com.javafortesters.chap009arraysandforloopiteration;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArraysOfArraysTest {

    public void print2DIntArray(int [][]array2d) {
        for (int[] outer : array2d) {
            if (outer == null) {
                System.out.println("null");
            } else {
                for (int inner : outer) {
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void createMultiArray() {
        int[][] multi2d =   {
                                {1, 2, 3},
                                {4, 5, 6}
                            };
        int[][] multi2dExpected =   {
                                        {1, 2, 3},
                                        {4, 5, 6}
                                    };
        print2DIntArray(multi2d);

        assertArrayEquals(multi2dExpected, multi2d);

    }

    @Test
    public void createTriangle2dArray() {


        int[][] triangle2d = new int[16][];

        for (int i=0; i<triangle2d.length; i++) {
            triangle2d[i] = new int[i+1];
            for (int j=0; j<triangle2d[i].length; j++) {
                triangle2d[i][j] = j;
            }
        }

        print2DIntArray(triangle2d);

    }

    @Test
    public void createTriangle2dArray1() {

        int dim = 16;

        int[][] triangle2d = new int[dim][];

        for (int i = 0; i<dim; i++) {
            triangle2d[i] = new int[i + 1];
            for (int j = 0; j<i+1; j++) {
                triangle2d[i][j] = j;
            }
        }

        print2DIntArray(triangle2d);

    }


}
