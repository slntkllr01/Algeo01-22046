package Method;
import java.util.Scanner;

import Matrix.Matrix;

public class Interpolation {
    public static Scanner scan;

    
    public static double[][] InterpolasiFile(double[][] point) {
        int n = point.length-2;
        int row = n+1, col = n+1;

        
        // matriks b (ordinat dari titik)
        double[][] b = new double[row][1]; 
        for(int i=0; i<row; i++) {
            b[i][0] = point[i][1];
        }
        
        // matriks polinom
        double[][] mat = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] = Math.pow(point[i][0], j);
            }
        }

        // mendapat hasil SPL (a0 s.d. an)
        double [][] result = new double[row][1];
        double [][] temp = Matrix.MultiplyMatrix(OpMatrix.inverseGauss(mat), b);
        
        for(int i=0; i<temp.length; i++) {
            result[i][0] = OpMatrix.rounding(temp[i][0]);
        }
        return result;
    }

    public static double[][] InterpolasiKeyboard() {
        // input n
        int n;
        System.out.print("Masukkan derajat polinom (n) : ");
        scan = new Scanner(System.in);
        n = scan.nextInt();
        
        // input titik
        int row = n+1, col = n+1;
        System.out.printf("Masukkan %d titik (x y), tanpa tanda '('')' : \n",row);
        double[][] point = new double[row][2];
        for(int p=0; p<row; p++) {
            for(int q=0; q<2; q++) {
                point[p][q] = scan.nextDouble();
            }
        }
        System.out.println();
        
        // matriks b (ordinat dari titik)
        double[][] b = new double[row][1]; //0 atau 1
        for(int i=0; i<row; i++) {
            b[i][0] = point[i][1];
        }
        
        // matriks polinom
        double[][] mat = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] = Math.pow(point[i][0], j);
            }
        }
        
        // mendapat hasil SPL (a0 s.d. an)
        double [][] result = new double[row][1];
        double [][] temp = Matrix.MultiplyMatrix(OpMatrix.inverseGauss(mat), b);
        
        for(int i=0; i<temp.length; i++) {
            result[i][0] = OpMatrix.rounding(temp[i][0]);
        }
        return result;
    }

    public static String outputInterpolasi(double[][] result) {
        String strResult = "f(x) = ";
        System.out.print("f(x) = ");
        for(int i=result.length-1; i>=0; i--) { 
            if ((result[i][0]) != 0) {
                if(i > 0) {
                    if(result[i][0] < 0) {
                        System.out.printf("(%.4fx^%d) + ", result[i][0], i);
                        strResult += String.format("(%.4fx^%d) + ", result[i][0], i);
                        
                    }
                    else {
                        System.out.printf("%.4fx^%d + ", result[i][0], i);
                        strResult += String.format("%.4fx^%d + ", result[i][0], i);
                    }
                }
                else {
                    if(result[i][0] < 0) {
                        System.out.printf("(%.4f)",result[i][0]);
                        strResult += String.format("(%.4f)",result[i][0]);
                    }
                    else {
                        System.out.printf("%.4f",result[i][0]);
                        strResult += String.format("%.4f",result[i][0]);
                    }
                }
                
            } 
        }
        System.out.println();
        return strResult;
    }

    public static double X(double x) {
        if(x == -9999) {
            // double x;
            System.out.print("\nMasukkan X yang akan ditaksir: ");
            scan = new Scanner(System.in);
            x = scan.nextDouble();
        }
        return x;
    }

    public static String outputFungsi(double[][] result, double x) {
        double hasilx = 0;
        for(int loop=result.length-1; loop>=0; loop--) { 
            hasilx += result[loop][0]*Math.pow(x,loop);
        }
        System.out.printf("f(%.4f) = %.4f\n", x, hasilx);
        String strResult = String.format("f(%.4f) = %.4f\n", x, hasilx);
        return strResult;
    }
}
