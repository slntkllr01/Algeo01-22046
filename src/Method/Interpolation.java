package Method;
import java.util.Scanner;

import Matrix.Matrix;

public class Interpolation {
    public static Scanner scan;

    public static double[][] contohMat() { //NANTI HAPUS
        double[][] mat = new double[4][2];
        mat[0][0] = 8.0;
        mat[0][1] = 2.0794;
        mat[1][0] = 9.0;
        mat[1][1] = 2.1972;
        mat[2][0] = 9.5;
        mat[2][1] = 2.2513;
        mat[3][0] = 8.3;
        mat[3][1] = 0;
        // 8.0 2.0794
        // 9.0 2.1972
        // 9.5 2.2513
        // 8.3
        return mat;
    }
    
    public static double[][] InterpolasiFile(double[][] point) {
        int n = point.length-2;
        int row = n+1, col = n+1;

        // // print titik
        // System.out.println("point: ");Matrix.DisplayMatrix(point);System.out.println();
        // // x = point[i][0], y = point[i][1]
        
        // matriks b (ordinat dari titik)
        double[][] b = new double[row][1]; //0 atau 1
        for(int i=0; i<row; i++) {
            b[i][0] = point[i][1];
        }
        // print b
        System.out.println("b: ");Matrix.DisplayMatrix(b);System.out.println();
        
        // matriks polinom
        double[][] mat = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] = Math.pow(point[i][0], j);
            }
        }
        // print hasil polinom
        System.out.println("mat: ");Matrix.DisplayMatrix(mat);System.out.println();

        
        // mendapat hasil SPL (a0 s.d. an)
        double [][] result = new double[row][1];
        double [][] temp = Matrix.MultiplyMatrix(OpMatrix.inverseGauss(mat), b);
        
        for(int i=0; i<temp.length; i++) {
            result[i][0] = OpMatrix.rounding(temp[i][0]);
        }

        // Matrix.DisplayMatrix(result);
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
        
        // // print titik
        // System.out.println("point: ");Matrix.DisplayMatrix(point);System.out.println();
        // // x = point[i][0], y = point[i][1]
        
        // matriks b (ordinat dari titik)
        double[][] b = new double[row][1]; //0 atau 1
        for(int i=0; i<row; i++) {
            b[i][0] = point[i][1];
        }
        // // print b
        // System.out.println("b: ");Matrix.DisplayMatrix(b);System.out.println();
        
        // matriks polinom
        double[][] mat = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] = Math.pow(point[i][0], j);
            }
        }
        // // print hasil polinom
        // System.out.println("mat: ");Matrix.DisplayMatrix(mat);System.out.println();

        
        // mendapat hasil SPL (a0 s.d. an)
        double [][] result = new double[row][1];
        double [][] temp = Matrix.MultiplyMatrix(OpMatrix.inverseGauss(mat), b);
        
        for(int i=0; i<temp.length; i++) {
            result[i][0] = OpMatrix.rounding(temp[i][0]);
        }

        // Matrix.DisplayMatrix(result);
        return result;
    }

    public static String outputInterpolasi(double[][] result) {
        // f(x) = -0.0064x2 + 0.2266x + 0.6762
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
        // hasil taksiran nilai fungsi
        // double x;
        // System.out.print("\nMasukkan X yang akan ditaksir: ");
        // scan = new Scanner(System.in);
        // x = scan.nextDouble();

        double hasilx = 0;
        for(int loop=result.length-1; loop>=0; loop--) { 
            hasilx += result[loop][0]*Math.pow(x,loop);
        }
        System.out.printf("f(%.4f) = %.4f\n", x, hasilx);
        String strResult = String.format("f(%.4f) = %.4f\n", x, hasilx);
        return strResult;
    }

    // public static double tanggalDesimal() {
    //     double tgl, bln, tahun, hari;
    //     scan = new Scanner(System.in);
    //     System.out.print("Masukkan tanggal bulan tahun (pisah dengan spasi) : ");
    //     tgl = scan.nextInt();
    //     bln = scan.nextInt();
    //     tahun = scan.nextInt();
        
    //     if(bln == 1 || bln == 3 || bln == 5 || bln == 7 || bln == 8 || bln == 10 || bln == 12) {
    //         hari = 31;
    //     }
    //     else if(bln == 2) {
    //         hari = 28;
    //     }
    //     else {
    //         hari = 30;
    //     }

    //     System.out.println(bln + (tgl/hari));
    //     return (bln + (tgl/hari));
    // }
}
