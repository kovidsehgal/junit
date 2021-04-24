package helix;

import org.junit.Test;

import java.rmi.MarshalException;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public  void nullMatrixTest(){
        int[][] inMatrix = null;
        int[][] expOutput = null;
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testMatrix0x0(){
        int[][] inMatrix = {};
        int[][] expOutput = {};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test6x4() {
        int[][] inMatrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}, {17,18,19,20}, {21,22,23,24}};
        int[][] expOutput = {{1,2,3,4}, {16,17,18,5}, {15,24,19,6}, {14,23,20,7}, {13,22,21,8}, {12,11,10,9}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test3x5() {
        int[][] inMatrix = {{1, 2, 3, 4, 5},{ 6, 7, 8, 9, 10},{ 11, 12, 13, 14, 15}};
        int[][] expOutput = {{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void invalidMatrix() {
        int[][] inMatrix = {{1, 2}, {3, 4, 5, 6}, {7 , 8 , 9 , 10}};
        int[][] expOutput = null;
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x2() {
        int[][] inMatrix = {{1, 5}};
        int[][] expOutput = {{1, 5}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test2x1() {
        int[][] inMatrix = {{6}, {7}};
        int[][] expOutput = {{6}, {7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void matrix3x3(){
        int[][] inMatrix  = { {1, 2, 3 }, {4, 5, 6}, {7, 8, 9 } };
        int[][] expOutput = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void matrix5x3() {
        int[][] inMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        int[][] expOutput = {{1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void matrix4x6() {
        int[][] inMatrix = {{1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}, {19,20,21,22,23,24}};
        int[][] expOutput = {{1,2,3,4,5,6}, {16,17,18,19,20,7}, {15,24,23,22,21,8}, {14,13,12,11,10,9}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void matrix4x5(){
        int[][] inMatrix = { { 25,24,23,22,21 }, { 20,19,18,17,16 }, { 15,14,13,12,11 }, { 10,9,8,7,6 } };
        int[][] expOutput = { { 25,24,23,22,21 }, { 12,11,10,9,20 }, { 13,6,7,8,19 }, { 14,15,16,17,18 } };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
}
