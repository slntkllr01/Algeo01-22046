import java.lang.Math;
import java.util.Scanner;

public class Bicubic {
    public static void bicubicSI(double [][] matrix) {
        double[][] mat4 = new double[4][4];
        
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
        inversX = Matrix.inverseAdjoint(matX);
        // display matrix X
        System.out.println("inverse: ");Matrix.DisplayMatrix(matX);

        double[][] a = new double[16][1];
        a = Matrix.MultiplyMatrix(inversX, Y);
        // display a
        System.out.println("a: "); Matrix.DisplayMatrix(a);

        // gunakan vektor a untuk mencari nilai f(x,y), jadi fungsi interpolasi bicubic sesuai model
        float fungsiInterpolasi = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("[f(x,y)] masukkan nilai x: ");
        float x_fxy = scan.nextFloat();
        System.out.println("[f(x,y)] masukkan nilai y: ");
        float y_fxy = scan.nextFloat();
        for(j=0; j<16; j++) {
            for(i=0; i<1; i++) {
                fungsiInterpolasi += a[i][j]*Math.pow(x_fxy,i)*Math.pow(y_fxy,j);
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

    public static void bicunadil(double [][] matrix) {
        double[][] matrix16x16 = new double[16][16];
        int i,j,x,y;
        int row = 0;
        for (y = -1; y < 3; y++) {
            for (x = -1; x < 3; x++) {
                int col = 0;
                for (j = 0; j < 4; j++) {
                    for (i = 0; i < 4; i++) {
                        matrix16x16[row][col] = ((float) Math.pow(x, i) * (float) Math.pow(y, j));
                        col++; 
                    }
                }
                row++;
            }
        }  
        Matrix.DisplayMatrix(matrix16x16);  
    }
}
