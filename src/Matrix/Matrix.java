package Matrix;

import java.util.Scanner;
import Method.OpMatrix;

public class Matrix {
    public double[][] matrix;
    public int nRows;
    public int nCols;

    public static Scanner scan;

    /* SELECTOR */
    public static int getRow(double[][] matrix) {
        return matrix.length;
    }
    
    
    public static int getCol(double[][] matrix) {
        return matrix[0].length;
    }

    public static int getLastIdxRow(double[][] matrix) {
        return (getRow(matrix) - 1);
    }

    public static int getLastIdxCol(double[][] matrix) {
        return (getCol(matrix) - 1);
    }

    /* METHOD */
    public static double[][] ReadMatrixKeyboard() {
        scan = new Scanner(System.in);
        System.out.print("Jumlah baris (row): "); int row = scan.nextInt();
        System.out.print("Jumlah kolom (col): "); int col = scan.nextInt();

        double[][] matrix = new double[row][col];

        System.out.println("Elemen matriks: ");
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < col;j++) {
                matrix[i][j] = scan.nextDouble();
            }
        }

        return matrix;
    }

    public static double[][] ReadMatrixSquare() {
        scan = new Scanner(System.in);
        System.out.print("Jumlah ukuran matrix: "); int row = scan.nextInt();
        

        double[][] matrix = new double[row][row];

        System.out.println("Elemen matriks: ");
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < row;j++) {
                matrix[i][j] = scan.nextDouble();
            }
        }

        return matrix;
    }

    public static String DisplayMatrix(double[][] matrix) {
        String strDisplay = "";
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[i].length;j++) {
                if(j < matrix[i].length-1) {
                    System.out.printf("%.4f ",matrix[i][j]);
                    strDisplay += String.format("%.4f ",matrix[i][j]);
                }
                else {
                    System.out.printf("%.4f\n",matrix[i][j]);
                    strDisplay += String.format("%.4f\n",matrix[i][j]);
                }
            }
        }
        return strDisplay;
    }

   
    public static double[][] copyMatrix(double[][] matrixIn) {
        /* Mengirim matrixOut hasil copy matrixIn*/
        int row = getRow(matrixIn);
        int col = getCol(matrixIn);
        double[][] matrixOut = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrixOut[i][j] = matrixIn[i][j];
            }
        }
        return matrixOut;
    }

    public static double[][] AddMatrix(double[][] matrix1, double[][] matrix2) {
        /* Prekondisi : m1 berukuran sama dengan m2 */
        /* Mengirim hasil penjumlahan matriks: m1 + m2 */
        int row = getRow(matrix1);
        int col = getCol(matrix1);
        double[][] matrix = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix;
    }

    public static double[][] SubtractMatrix(double[][] matrix1, double[][] matrix2) {
        /* Prekondisi : m1 berukuran sama dengan m2 */
        /* Mengirim hasil penjumlahan matriks: m1 + m2 */
        int row = getRow(matrix1);
        int col = getCol(matrix1);
        double[][] matrix = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrix;
    }

    public static double[][] MultiplyMatrix(double[][] matrix1, double[][] matrix2) {
        /* Prekondisi : Ukuran kolom efektif m1 = ukuran baris efektif m2 */
        /* Mengirim hasil perkalian matriks: salinan m1 * m2 */
        int row = getRow(matrix1);
        int col = getCol(matrix2);
        double[][] matrix = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                for(int k = 0; k < getCol(matrix1); k++) {
                    matrix[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        return matrix;
    }

    public static double[][] MultiplyByConst(double[][] matrix, double x) {
        /* Mengirim hasil perkalian setiap elemen m dengan x */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrixR[i][j] = matrix[i][j]*x;
            }
        }
        return matrixR;
    }

    
    public static boolean isMatrixEqual(double[][] matrix1, double[][] matrix2) {
        /* Mengirimkan true jika m1 = m2 */
        if (getRow(matrix1) != getRow(matrix2) || getCol(matrix1) != getCol(matrix2)) {
            return false;
        }
        int i, j;
        for(i = 0; i < getRow(matrix1); i++)
        {
            for(j = 0; j < getCol(matrix1); j++)
            {
                if (matrix1[i][j] != matrix2[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isMatrixSizeEqual(double[][] matrix1, double[][] matrix2) {
        /* True jika ukuran efektif matriks m1 sama dengan ukuran efektif m2 */
        return(getRow(matrix1) == getRow(matrix2) && getCol(matrix1) == getCol(matrix2));
    }   
    
    public static int CountElmt(double[][] matrix) {
        /* Mengirimkan banyaknya elemen m */
        return (getRow(matrix)*getCol(matrix));
    }
    
    public static boolean isSquare(double[][] matrix) {
        /* True jika m adalah matriks dg ukuran baris dan kolom sama */
        return (getRow(matrix) == getCol(matrix));
    }

    public static boolean isSymmetric(double[][] matrix) {
        /* Mengirimkan true jika m adalah matriks simetri : isSquare(m) dan m(i,j)=m(j,i) */ 
        if(!(isSquare(matrix))) {
            return false;
        }
        
        int i, j;
        for(i = 0; i < getRow(matrix); i++)
        {
            for(j = 0; j < getCol(matrix); j++)
            {
                if (matrix[i][j] != matrix[j][i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentity(double[][] matrix) {
        /* Mengirimkan true jika m adalah matriks satuan: isSquare(m) dan elemen diagonal bernilai 1, sisanya 0 */
        if(!(isSquare(matrix))) {
            return false;
        }
        int i, j;
        for(i=0;i<getRow(matrix);i++) {
            for(j=0;j<getCol(matrix);j++) {
                if (i == j) {
                    if (matrix[i][j] != 1) {
                        return false;
                    }
                }
                else {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static double[][] negation(double[][] matrix) {
        /* Mengirim hasil perkalian setiap elemen m dengan x */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row][col];

        matrixR = MultiplyByConst(matrix,(-1));
        return matrixR;
    }

    public static double[][] transpose(double[][] matrix) {
        /* Mengirim hasil perkalian setiap elemen m dengan x */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrixR[i][j] = matrix[j][i];
            }
        }
        return matrixR;
    }

    public static double[][] minorMatrix(double[][] matrix, int rowIn, int colIn) {
        /* Mengirim hasil matrix minor (submatrix) */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row-1][col-1];
        int i = 0, j = 0;
        for(int baris=0; baris<row; baris++) {
            for(int kolom=0; kolom<col; kolom++) {
                if(baris != rowIn && kolom != colIn) {
                    matrixR[i][j++] = matrix[baris][kolom];
                    if(j == col-1) {
                        i++; j = 0;
                    }
                }
            }
        }
        return matrixR;
    }

    public static double[][] cofactor(double[][] matrix) {
        /* kofaktor aja */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row][col];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                matrixR[i][j] = (OpMatrix.detCofactor(minorMatrix(matrix, i, j)) != 0 ? Math.pow(-1, i+j) : 0) *OpMatrix.detCofactor(minorMatrix(matrix, i, j));
            }
        }
        return matrixR;
    }

    public static double[][] adjoint(double[][] matrix) {
        /* adjoin dari kofaktor */
        return (transpose(cofactor(matrix)));
    }

    public static double[][] slice_b(double[][] matrix) {
        /* slicing matrix augmented Ax = b untuk mendapat matriks b doank */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row][1]; // matrix 1 kolom

        for(int i=0; i<row; i++) {
            matrixR[i][0] = matrix[i][col-1];
        }
        return matrixR;
    }

    public static double[][] slice_a(double[][] matrix) {
        /* slicing matrix augmented Ax = b untuk mendapat matriks A doank */
        int row = getRow(matrix);
        int col = getCol(matrix)-1;
        double [][] matrixR = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                matrixR[i][j] = matrix[i][j];
            }
        }
        return matrixR;
    }

    public static double[][] sliceMatrixLeft(double[][] m1){
        double[][] m2 = new double[getRow(m1)][getCol(m1)/2];
        for (int i=0;i<getRow(m1);i++){
            for (int j=(getCol(m1)/2);j<getCol(m1);j++){
                m2[i][j-getCol(m1)/2] = m1[i][j];
            }

        }
        return m2;
    }
    public static double[][] sliceMatrixRight(double[][] m1){
        double[][] m2 = new double[getRow(m1)][getCol(m1)/2];
        for (int i=0;i<getRow(m1);i++){
            for (int j=0;j<(getCol(m1)/2);j++){
                m2[i][j] = m1[i][j];
            }

        }
        return m2;
    }    
    public static boolean isColZero(double[][] m1, int j){
        boolean zero = true;
        for (int i = 0;i<getRow(m1);i++){
            if(m1[i][j] != 0){
                zero = false;
                break;
            }
        }
        return zero;
    }
    public static boolean isRowZero(double[][] m1, int i){
        boolean zero = true;
        for (int j = 0;j<getCol(m1);j++){
            if(m1[i][j] != 0){
                zero = false;
                break;
            }
        }
        return zero;
    }
    public static void moveUpAddZero(double[][] m1, int i){
        for (int j = 0;j<getCol(m1);j++){
            m1[i][j] = m1[i+1][j];
            m1[getLastIdxRow(m1)][j] = 0;
        }

        
    }
    public static double[][] mergeMatCol(double[][] m1, double[][] m2) {
        int row1 = Matrix.getRow(m1);
        int col1 = Matrix.getCol(m1);
        int col2 = Matrix.getCol(m2);

        double[][] merge = new double[row1][col1+col2];
        for(int i=0; i<row1; i++) {
            System.arraycopy(m1[i], 0, merge[i], 0, col1);
            System.arraycopy(m2[i], 0, merge[i], col1, col2);
        }
        return merge;
    }
   
}