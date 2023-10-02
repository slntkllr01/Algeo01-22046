package Method;
import java.util.Scanner;

import Matrix.Matrix;
/* tinggal bikin persamaannya dari spl hasil gauss */
public class MultipleLinearRegression {
    static Scanner scanner = new Scanner(System.in);
    public static double[][] ReadMatrix() {
        System.out.println("Masukkan jumlah peubah: ");int n = scanner.nextInt();
        System.out.println("Masukkan jumlah data sampel:  "); int m = scanner.nextInt();
        double[][] matrix = new double[m][n+2];

        System.out.println("Masukkan data sampel: ");
        for(int i = 0;i < Matrix.getRow(matrix);i++) {
            for(int j = 0;j < Matrix.getCol(matrix)-1;j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Masukkan data yang akan ditaksir: ");
        for(int i = 0;i < Matrix.getRow(matrix);i++) {
            matrix[i][Matrix.getCol(matrix)-1] = scanner.nextDouble();
        }

        return matrix;
    }
    public static double[][] regression(){
        double[][] m1 = ReadMatrix(); /* m1 adalah matrix yang menampung data masukkan */
        double[][] m2 = Matrix.slice_a(m1);
        double[][] m3 = Matrix.slice_b(m1);
        double[][] m4 = new double[Matrix.getCol(m2)][Matrix.getCol(m2)+1]; /* m4 adalah matrix yang menampung Normal Estimation 
        Equation for Multiple Linear Regression */
        int n = Matrix.getRow(m2);
        m4[0][0] = n;
        for (int i=0;i<Matrix.getRow(m2);i++){
            m4[0][Matrix.getCol(m4)-1] += m1[i][Matrix.getCol(m2)-1];
        }
        for(int i=1;i<Matrix.getRow(m4);i++){
            for(int k=0;k<n;k++){
                m4[i][0] += m2[k][i-1];
                m4[0][i] += m2[k][i-1];
            }
        }
        for (int i=1;i<Matrix.getRow(m4);i++){
            for (int j = 1;j<Matrix.getCol(m4);j++){
                
                for(int k = 0;k<Matrix.getRow(m2);k++){
                    m4[i][j] += m2[k][i-1]*m2[k][j-1];
                }
            }
        }
        return m4;
    }
}
