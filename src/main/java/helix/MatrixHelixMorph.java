package helix;


public class MatrixHelixMorph {

    public static int[][] helix(int[][] inMatrix) {
        int outRow = 0;
        int outCol = 0;
        int inRow = 0;
        int inCol = 0;
        if (inMatrix == null || inMatrix.length == 0)
            return null;
        int matrixCol = 0;
        int matrixRow = inMatrix.length;
        if (matrixRow > 0) {
            matrixCol = inMatrix[0].length;
            for (int i = 1; i < inMatrix.length; i++) {
                if (matrixCol != inMatrix[i].length) {
                    return null;
                }
            }
        }
        int[][] outMatrix = new int[matrixRow][matrixCol];
        while (outRow < matrixRow && outCol < matrixCol) {
            for (int i = outCol; i < matrixCol; ++i) {
                outMatrix[outRow][i] = inMatrix[inRow][inCol];
                if (inCol == inMatrix[0].length - 1) {
                    inRow++;
                    inCol = 0;
                } else {
                    inCol++;
                }
            }
            outRow++;
            for (int i = outRow; i < matrixRow; ++i) {
                outMatrix[i][matrixCol - 1] = inMatrix[inRow][inCol];

                if (inCol == inMatrix[0].length - 1) {
                    inRow++;
                    inCol = 0;
                } else {
                    inCol++;
                }
            }
            matrixCol--;

            if (outRow < matrixRow) {
                for (int i = matrixCol - 1; i >= outCol; --i) {
                    outMatrix[matrixRow - 1][i] = inMatrix[inRow][inCol];

                    if (inCol == inMatrix[0].length - 1) {
                        inRow++;
                        inCol = 0;
                    } else {
                        inCol++;
                    }
                }
                matrixRow--;
            }
            if (outCol < matrixCol) {
                for (int i = matrixRow - 1; i >= outRow; --i) {
                    outMatrix[i][outCol] = inMatrix[inRow][inCol];
                    if (inCol == inMatrix[0].length - 1) {
                        inRow++;
                        inCol = 0;
                    } else {
                        inCol++;
                    }
                }
                outCol++;
            }
        }

        for (int i = 0; i < outMatrix.length; i++)
        {
            for (int j = 0; j < outMatrix[0].length; j++)
            {
                System.out.print(outMatrix[i][j]+ "\t");
            }

            System.out.print("\n");
        }
        return outMatrix;
    }
}