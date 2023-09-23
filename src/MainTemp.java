
// nyoba akses method dari Matrix.java
public class MainTemp {
    public static void main(String[] args) {
        double[][] Matrix1, Matrix2, Matrix3;
        Matrix1 = Matrix.ReadMatrixKeyboard();
        Matrix.DisplayMatrix(Matrix1);
        System.out.println();
        Matrix2 = Matrix.ReadMatrixKeyboard();
        Matrix.DisplayMatrix(Matrix2);

        int baris = Matrix.getRow(Matrix1);
        int kolom = Matrix.getCol(Matrix1);
        System.out.println("baris: " + baris);
        System.out.println("kolom: " + kolom + "\n");

        Matrix3 = Matrix.AddMatrix(Matrix1, Matrix2);
        Matrix.DisplayMatrix(Matrix3); System.out.println();
        
        Matrix3 = Matrix.MultiplyMatrix(Matrix1, Matrix2);
        Matrix.DisplayMatrix(Matrix3);

        System.out.println("countelmt: " + Matrix.CountElmt(Matrix3));
        System.out.println(Matrix.isSquare(Matrix3));
    }
}
