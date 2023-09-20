import java.util.Scanner;

public class Matrix {
    public double[][] matrix;
    public int nRows;
    public int nCols;

    public static Scanner scan;

    // constructor? belom
    public static void CreateMatrix(int row, int col, double[][] matrix) {
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < col;j++) {
                matrix[i][j] = 0;
            }
        }
    }

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

    public static void DisplayMatrix(double[][] matrix) {
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[i].length;j++) {
                if(j < matrix[i].length-1) {
                    System.out.print(matrix[i][j] + " ");
                }
                else {
                    System.out.println(matrix[i][j]);
                }
            }
        }
    }

    // public static void copyMatrix(double[][] matrixIn, double[][] matrixOut) {
    //     for(int i = 0;i < getRow(matrixIn);i++) {
    //         for(int j = 0;j < getCol(matrixIn);j++) {
    //             matrixOut[i][j] = matrixIn[i][j];
    //         }
    //     }
    // }

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

    public static double[][] MultiplyByConst(double[][] matrix, int x) {
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

    public static int CountElmt(double[][] matrix) {
        return (getRow(matrix)*getCol(matrix));
    }

    public static boolean isSquare(double[][] matrix) {
        return (getRow(matrix) == getCol(matrix));
    }

}