// import java.util.Arrays;

// import OpMatrix.Gaussian;
// nyoba akses method dari Matrix.java
public class MainTemp {
    public static void main(String[] args) {
        // double[][] Matrix1, Matrix2, Matrix3;
        // double det;
        // Matrix1 = Matrix.ReadMatrixKeyboard();
        // det = OpMatrix.detGauss(matrix1);
        // System.out.println(det);
        // // Matrix2 = OpMatrix.Gaussian.Gauss(Matrix1);
        // // Matrix.DisplayMatrix(Matrix2);
        // // System.out.println();
        // // Matrix3 = OpMatrix.Gaussian.GaussJordan(Matrix1);
        // // Matrix.DisplayMatrix(Matrix.sliceMatrix(Matrix3));
        
        // System.out.println();
        // Matrix2 = Matrix.ReadMatrixKeyboard();
        // Matrix.DisplayMatrix(Matrix2);
        
        // int baris = Matrix.getRow(Matrix1);
        // int kolom = Matrix.getCol(Matrix1);
        // System.out.println("baris: " + baris);
        // System.out.println("kolom: " + kolom + "\n");

        // Matrix3 = Matrix.AddMatrix(Matrix1, Matrix2);
        // Matrix.DisplayMatrix(Matrix3); System.out.println();
        
        // Matrix3 = Matrix.MultiplyMatrix(Matrix1, Matrix2);
        // Matrix.DisplayMatrix(Matrix3);

        // // tes kofaktor
        // Matrix3 = Matrix.cofactor(Matrix1);
        // Matrix.DisplayMatrix(Matrix3);System.out.println();

        // // tes adjoin
        // Matrix3 = Matrix.adjoint(Matrix1);
        // Matrix.DisplayMatrix(Matrix3);System.out.println();
        
        // tes determinan
        // double det = Matrix.detCofactor(Matrix1);
        // System.out.println("det: " +det);
        
        // // tes inverseAdjoint
        // System.out.println("\ninverse: ");
        // Matrix2 = Matrix.inverseAdjoint(Matrix1);
        // Matrix.DisplayMatrix(Matrix2);System.out.println();
        
        // tes Cramer
        // double[] result = SPL.solveCramer(Matrix1);
        // for (double value : result) {
            // System.out.println(value);
        // }
        

    //     // Matrix2 = Matrix.slice_b(Matrix1);
    //     // Matrix.DisplayMatrix(Matrix2);System.out.println();

    //     Matrix2 = Matrix.slice_a(Matrix1);
    //     Matrix.DisplayMatrix(Matrix2);System.out.println();

    // tes gauss

    double[][] m1 = {
        {1, 0, 1, 2},
        {0, 1, 1, 3},
        {0, 0, 0, 1}
    };

    // double mgauss[] = SPL.solveCramer(m1);
    // Matrix.DisplayMatrix(mgauss);
    String[] result = SPL.solveEchelon(m1);
    boolean a = SPL.isNoSolution(m1);
    System.out.println(a);
    SPL.OutputSPLInverse(m1);
    for (int i = 0; i < result.length; i++) {
        String elemen = result[i];
        // Lakukan operasi apa pun yang Anda inginkan pada elemen ini
        System.out.println(elemen);
    }

    // System.out.println(2/0 == NaN);

    // for (int i = 0; i < mgauss.length; i++) {
    //     for (int j = 0; j < mgauss[i].length; j++) {
    //         System.out.print(mgauss[i][j] + " ");
    //     }
    //     System.out.println();
    // }
}
}

