import java.util.Arrays;
// nyoba akses method dari Matrix.java
public class MainTemp {
    public static void main(String[] args) {
        // double[][] Matrix1, Matrix2, Matrix3;
        // Matrix1 = Matrix.ReadMatrixKeyboard();
        // Matrix2 = OpMatrix.Gaussian.Gauss(Matrix1);
        // Matrix.DisplayMatrix(Matrix2);
        // System.out.println();
        // Matrix3 = OpMatrix.Gaussian.GaussJordan(Matrix1);
        // Matrix.DisplayMatrix(Matrix3);
        
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
        {1, 1, 1, 0},
        {2, 3, 1, 1},
        {3, 1, 2, 1}
    };

    m1 = OpMatrix.Gaussian.Gauss(m1);

    boolean m2 = OpMatrix.isNoSolution(m1);

    double[] solution = OpMatrix.SolveGauss(m1);
    
    System.out.println(m2);

    System.out.println(Arrays.toString(solution));


    // Mencetak hasil return m1
    for (int i = 0; i < m1.length; i++) {
        for (int j = 0; j < m1[i].length; j++) {
            System.out.print(m1[i][j] + " ");
        }
        System.out.println();
    }
}
}
