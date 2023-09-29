import java.lang.Math;
import java.util.Scanner;

public class Bicubic {
    public static void bicubicSI(double [][] matrix) {
        double[][] matXX =
        {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},
        {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,2,0,0,0,3,0,0,0},
        {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,2,0,0,0,3,0,0},
        {0,0,0,0,0,1,2,3,0,2,4,6,0,3,6,9}};
        
        // display matrix asal (param)
        Matrix.DisplayMatrix(matXX);
        // display matrix asal (param)
        Matrix.DisplayMatrix(matrix);

        // Y = Xa
        // ###### untuk matrix X (16x16), mengisi elemen:
        double[][] matX = new double[16][16];
        int x,y,i,j;
        
        int row = 0; // baris untuk index matrix X
        for(y=-1; y<=2; y++) {
            for(x=-1; x<=2; x++) {
                int col = 0; // kolom untuk index matrix X
                // loop sesuai model di spek, j dulu baru i
                for(j=0; j<=3; j++) {
                    for(i=0; i<=3; i++) {
                        matX[row][col] = Math.pow(x,i)*Math.pow(y,j);
                        col++;
                    }
                }
                row++;
            }
        }
        // display matrix X
        Matrix.DisplayMatrix(matX);

        // Y = Xa
        // ##### matrix Y adalah matrix asal 4x4 diubah ke 16x1
        double[][] Y = new double[16][1];
        Y = changeSize(matrix, 16, 1);

        // ##### mencari matrix untuk vektor a dari Y = Xa, maka a = X^-1 Y
        double[][] inversX = new double[16][16];
        inversX = Matrix.inverseGJ(matXX);
        // display inverse matrix X
        System.out.println("inverse: ");Matrix.DisplayMatrix(inversX);

        double[][] a = new double[16][1];
        a = Matrix.MultiplyMatrix(inversX, Y);
        a = changeSize(a, 4, 4);
        // display a
        System.out.println("a: "); Matrix.DisplayMatrix(a);

        // gunakan vektor a untuk mencari nilai f(x,y), jadi fungsi interpolasi bicubic sesuai model
        double fungsiInterpolasi = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("[f(x,y)] masukkan nilai x: ");
        double x_fxy = scan.nextDouble();
        System.out.println("[f(x,y)] masukkan nilai y: ");
        double y_fxy = scan.nextDouble();

        for(j=0; j<4; j++) {
            for(i=0; i<4; i++) {
                fungsiInterpolasi += a[i][j]*((Math.pow(x_fxy,i))*(Math.pow(y_fxy,j)));
            }
        }
        System.out.println("hasil f(x,y) = " +fungsiInterpolasi);
    }

    public static void bicubicSPL(double [][] matrix) {
        double[][] matXX =
        {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},
        {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,2,0,0,0,3,0,0,0},
        {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,2,0,0,0,3,0,0},
        {0,0,0,0,0,1,2,3,0,2,4,6,0,3,6,9}};
        
        // display matrix asal (param)
        Matrix.DisplayMatrix(matXX);
        // display matrix asal (param)
        Matrix.DisplayMatrix(matrix);

        // Y = Xa
        // ###### untuk matrix X (16x16), mengisi elemen:
        // double[][] matX = new double[16][16];
        int x,y,i,j;
        
        // int row = 0; // baris untuk index matrix X
        // for(y=-1; y<=2; y++) {
        //     for(x=-1; x<=2; x++) {
        //         int col = 0; // kolom untuk index matrix X
        //         // loop sesuai model di spek, j dulu baru i
        //         for(j=0; j<=3; j++) {
        //             for(i=0; i<=3; i++) {
        //                 matX[row][col] = Math.pow(x,i)*Math.pow(y,j);
        //                 col++;
        //             }
        //         }
        //         row++;
        //     }
        // }
        // // display matrix X
        // Matrix.DisplayMatrix(matX);

        // Y = Xa
        // ##### matrix Y adalah matrix asal 4x4 diubah ke 16x1
        double[][] Y = new double[16][1];
        Y = changeSize(matrix, 16, 1);

        // merge Y augmented
        double[][] augmentedXY = new double[16][17];
        augmentedXY = Matrix.mergeMatCol(matXX, Y);
        System.out.println("ni augmented: ");Matrix.DisplayMatrix(augmentedXY);

        // ##### matriks vektor a
        double[][] a = new double[16][1];
        a = SPL.SPLinverse(augmentedXY);
        a = changeSize(a, 4, 4);
        // display a
        System.out.println("a: "); Matrix.DisplayMatrix(a);

        // gunakan vektor a untuk mencari nilai f(x,y), jadi fungsi interpolasi bicubic sesuai model
        double fungsiInterpolasi = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("[f(x,y)] masukkan nilai x: ");
        double x_fxy = scan.nextDouble();
        System.out.println("[f(x,y)] masukkan nilai y: ");
        double y_fxy = scan.nextDouble();

        for(j=0; j<4; j++) {
            for(i=0; i<4; i++) {
                fungsiInterpolasi += a[i][j]*((Math.pow(x_fxy,i))*(Math.pow(y_fxy,j)));
            }
        }
        System.out.println("hasil f(x,y) = " +fungsiInterpolasi);
    }

    public static double[][] changeSize(double[][] matrix, int row, int col) {
        // int rowOrigin = Matrix.getRow(matrix);
        int colOrigin = Matrix.getCol(matrix);
        double[][] result = new double[row][col];

        int k = 0, l = 0;
        for (int i=0; i<row; i++) {
            for (int j = 0; j<col; j++) {
                result[i][j] = matrix[k][l++];
                if(l == colOrigin) {// mentok kolom matrix asal
                    k++; l = 0;
                }
                // l++;
            }
        }
        return result;
    }

    public static void bicunadil(double [][] mat) {
        double[][] matrix = new double[16][16];

        for (int y = -1; y <= 2; y++) {
            for (int x = -1; x <= 2; x++) {
                int row = (x + 1) + (y + 1) * 4;

                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 4; i++) {
                        int col = i + j * 4;
                        matrix[row][col] = (Math.pow(x, i) * Math.pow(y, j));
                    }
                }
            }
        }
        Matrix.DisplayMatrix(matrix);  
    }
}
