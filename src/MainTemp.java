
// nyoba akses method dari Matrix.java
public class MainTemp {
    public static void main(String[] args) {
        double[][] Matrix1, Matrix2, Matrix3, result;
        Matrix1 = Matrix.ReadMatrixKeyboard();
        Matrix.DisplayMatrix(Matrix1);
        System.out.println();
        // Matrix2 = Matrix.ReadMatrixKeyboard();
        // Matrix.DisplayMatrix(Matrix2);
        
        int baris = Matrix.getRow(Matrix1);
        int kolom = Matrix.getCol(Matrix1);
        System.out.println("baris: " + baris);
        System.out.println("kolom: " + kolom + "\n");

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
        
        // // tes determinan
        // double det = Matrix.detCofactor(Matrix1);
        // System.out.println("det: " +det);
        
        // // tes inverseAdjoint
        // System.out.println("\ninverse: ");
        // Matrix2 = Matrix.inverseAdjoint(Matrix1);
        // Matrix.DisplayMatrix(Matrix2);System.out.println();
        
        Matrix2 = Matrix.slice_b(Matrix1);
        Matrix.DisplayMatrix(Matrix2);System.out.println();

        // tes SPL 
        result = Matrix.SPLinverse(Matrix1);
        for(int i=0; i<result.length; i++) { 
            System.out.printf("X%d = %.3f\n", i+1, result[i][0]);
        }

// TESTCASE SPL
/*  
2 -1 3 4 9
1 0 -2 7 11
3 -3 1 5 8
2 1 4 4 10

hasil = -1.000
        0.000
        1.000
        2.000
    */
    }
}
