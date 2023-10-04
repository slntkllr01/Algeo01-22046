package Method;
import java.util.Scanner;

import Matrix.Matrix;
/* tinggal bikin persamaannya dari spl hasil gauss */
public class MultipleLinearRegression {
    static Scanner scanner = new Scanner(System.in);
    public static double[][] ReadMatrix() {
        System.out.println("Masukkan jumlah peubah: ");int n = scanner.nextInt();
        System.out.println("Masukkan jumlah data sampel:  "); int m = scanner.nextInt();
        double[][] matrix = new double[m][n+1];

        System.out.println("Masukkan nilai y dan data sampel: ");
        for(int i = 0;i < Matrix.getRow(matrix);i++) {
            for(int j = 0;j < Matrix.getCol(matrix);j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        
        return matrix;
    }
    public static double[] ReadTaksir(double[][] m1){
        System.out.println("Masukkan data yang akan ditaksir: ");
        double[] array = new double[Matrix.getCol(m1)-1];
        for(int i = 0;i < Matrix.getCol(m1)-1;i++) {
            array[i] = scanner.nextDouble();
        }
        return array;
    }
    public static String regression(){
        double[][] m1 = ReadMatrix(); /* m1 adalah matrix yang menampung data masukkan */
        double[][] m2 = Matrix.slice_col1(m1); /* menampung nilai y */
        double[][] temp = Matrix.slice_col1rest(m1); /* menampung sisanya */
        m2 = Matrix.mergeMatCol(temp, m2); /* menampung matrix yang akan dihitung */
        
        double[] m3 = ReadTaksir(m1);
        double[][] m4 = new double[Matrix.getCol(m1)][Matrix.getCol(m2)+1]; /* m4 adalah matrix yang menampung Normal Estimation 
        Equation for Multiple Linear Regression */
        double[] solusi;
        double result;
        int n = Matrix.getRow(m2);
        m4[0][0] = n;
        for (int i=0;i<Matrix.getRow(m2);i++){
            m4[0][Matrix.getCol(m4)-1] += m2[i][Matrix.getCol(m2)-1];
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
        m4 = OpMatrix.Gaussian.GaussJordan(m4);
        solusi = SPL.backwardSubstitution(m4);
        result = solusi[0];
        for (int i=1;i<solusi.length;i++){
            result += solusi[i] * m3[i-1]; 
        }
        String strresult;
        if(solusi[0]<0){
            strresult = String.format("f(x) = (%.4f)", solusi[0]);
            System.out.printf("f(x) = ");
            System.out.printf("(%.4f)", solusi[0]);
        }else{
            strresult = String.format("f(x) = %.4f", solusi[0]);
            System.out.printf("f(x) = ");
            System.out.printf("%.4f", solusi[0]);
        }
        for (int i=1;i<solusi.length;i++){
            if(solusi[i]<0){
                strresult += String.format(" + (%.4f x%d)", solusi[i],i);
                System.out.printf(" + ");
                System.out.printf("(%.4f", solusi[i]);
                System.out.printf(" x%d)",i);
            } else{
                strresult += String.format(" + %.4f x%d", solusi[i],i);
                System.out.printf(" + ");
                System.out.printf("%.4f", solusi[i]);
                System.out.printf(" x%d",i);
            }
            
            
        }
        strresult += String.format(" = %.4f",result);
        System.out.printf(" = ");
        System.out.printf("%.4f\n", result);
        return strresult;
    }
}
