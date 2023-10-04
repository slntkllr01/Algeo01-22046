package Method;

import Matrix.Matrix;

public class mainTemp {
    public static void main(String[] args) {
        String matrix1;
        matrix1 = MultipleLinearRegression.regression();
        // matrix1 = Matrix.ReadMatrixKeyboard();
        // Matrix.DisplayMatrix(OpMatrix.Gaussian.Gauss(matrix1));
        // System.out.println();
        // matrix1 = OpMatrix.Gaussian.GaussJordan(matrix1);
        // Matrix.DisplayMatrix(matrix1);
        System.out.println(matrix1);

        
        // Interpolation.outputInterpolasi(Interpolation.InterpolasiKeyboard());
    }
}
