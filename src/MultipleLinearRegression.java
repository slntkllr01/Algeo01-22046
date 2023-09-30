import java.util.Scanner;
/* tinggal bikin persamaannya dari spl hasil gauss */
public class MultipleLinearRegression {
    static Scanner scanner = new Scanner(System.in);
    public static double[][] ReadMatrix() {
        System.out.println("Masukkan jumlah peubah: ");int n = scanner.nextInt();
        System.out.println("Masukkan jumlah data sampel:  "); int m = scanner.nextInt();
        double[][] matrix = new double[m][n+1];

        System.out.println("Masukkan data: ");
        for(int i = 0;i < Matrix.getRow(matrix);i++) {
            for(int j = 0;j < Matrix.getCol(matrix);j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }
    public static double[][] ReadMatrix2(int n) {
        System.out.println("Masukkan data yang akan ditaksir: ");
        double[][] matrix = new double[1][n];
        System.out.println("Masukkan data: ");
        for(int i = 0;i < Matrix.getRow(matrix);i++) {
            for(int j = 0;j < Matrix.getCol(matrix);j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }
    public static double[][] regression(){
        double[][] m1 = ReadMatrix(); /* m1 adalah matrix yang menampung data masukkan */
        double[][] m2 = new double[Matrix.getCol(m1)][Matrix.getCol(m1)+1]; /* m2 adalah matrix yang menampung Normal Estimation 
        Equation for Multiple Linear Regression */
        double[][] m3 = ReadMatrix2(Matrix.getCol(m1)-1); /* m3 adalah matrix yang menampung data yang akan ditaksir menggunakan multipleregression */
        int n = Matrix.getRow(m1);
        m2[0][0] = n;
        for (int i=0;i<Matrix.getRow(m1);i++){
            m2[0][Matrix.getCol(m2)-1] += m1[i][Matrix.getCol(m1)-1];
        }
        for(int i=1;i<Matrix.getRow(m2);i++){
            for(int k=0;k<n;k++){
                m2[i][0] += m1[k][i-1];
                m2[0][i] += m1[k][i-1];
            }
        }
        for (int i=1;i<Matrix.getRow(m2);i++){
            for (int j = 1;j<Matrix.getCol(m2);j++){
                
                for(int k = 0;k<Matrix.getRow(m1);k++){
                    m2[i][j] += m1[k][i-1]*m1[k][j-1];
                }
            }
        }

        return m2;
    }
}
