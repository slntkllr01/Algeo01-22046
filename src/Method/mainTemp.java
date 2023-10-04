package Method;

import Matrix.InputOutput;
import Matrix.Matrix;

public class mainTemp {
    public static void main(String[] args) {
        double[][] matrix1 = new double[100][100];
        // matrix1 = MultipleLinearRegression.regression();
        matrix1 = InputOutput.readMatrixFile(matrix1, "1_d10.txt");
        Matrix.DisplayMatrix(OpMatrix.Gaussian.GaussJordan(matrix1));
        // System.out.println();
        // matrix1 = OpMatrix.Gaussian.GaussJordan(matrix1);
        // Matrix.DisplayMatrix(matrix1);
        // System.out.println(matrix1);

        
        // Interpolation.outputInterpolasi(Interpolation.InterpolasiKeyboard());
    }
}
