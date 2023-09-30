import java.lang.Math;
import java.util.Scanner;

public class Bicubic {
    public static void bicubicSI(double [][] matrix) {
        int i,j;
        // // hapus
        // Matrix.DisplayMatrix(matrix);

        double[][] mat4x4 = slice4x4(matrix);

        // Y = Xa
        // ###### matrix X (16x16)
        double[][] matX = generateMatX();

        // ###### matrix Y adalah matrix asal 4x4 diubah ke 16x1
        double[][] Y = changeSize(mat4x4, 16, 1);

        // ###### matrix untuk vektor a dari Y = Xa, maka a = X^-1 Y
        double[][] inversX = OpMatrix.inverseGauss(matX);
        double[][] a = Matrix.MultiplyMatrix(inversX, Y);
        a = changeSize(a, 4, 4);
        // // display a
        // System.out.println("a: "); Matrix.DisplayMatrix(a);

        // gunakan vektor a untuk mencari nilai f(x,y), jadi fungsi interpolasi bicubic sesuai model
        double[][] nilaiAB = sliceAB(matrix);
        double fungsiInterpolasi = 0;
        double x_fxy = nilaiAB[0][0];
        double y_fxy = nilaiAB[0][1];
        // Scanner scan = new Scanner(System.in);
        // System.out.println("[f(x,y)] masukkan nilai x: ");
        // double x_fxy = scan.nextDouble();
        // System.out.println("[f(x,y)] masukkan nilai y: ");
        // double y_fxy = scan.nextDouble();

        for(j=0; j<4; j++) {
            for(i=0; i<4; i++) {
                fungsiInterpolasi += a[i][j]*((Math.pow(x_fxy,i))*(Math.pow(y_fxy,j)));
            }
        }
        System.out.println("hasil f(x,y) = "+fungsiInterpolasi);
    }

    public static double[][] changeSize(double[][] matrix, int row, int col) {
        /* pengubah ukuran matrix */
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

    /* matrix X generator */
    public static double F(int x, int y, int i, int j) {
        return ((Math.pow(x,i))*(Math.pow(y,j)));
    }
    public static double FX(int x, int y, int i, int j) {
        if(i==0 && x==0){
            return 0;
        }
        return i*((Math.pow(x,i-1))*(Math.pow(y,j)));
    }
    public static double FY (int x, int y, int i, int j) {
        if(j==0 && y==0) {
            return 0;
        }
        return j*((Math.pow(x,i))*(Math.pow(y,j-1)));
    }
    public static double FXY (int x, int y, int i, int j) {
        if((i==0 && x == 0) || (j==0 && y==0)) {
            return 0;
        }
        return i*j*((Math.pow(x,i-1))*(Math.pow(y,j-1)));
    }

    public static double[][] generateMatX() {
        double[][] MatX = new double[16][16];

        int turunan,y,x,j,i;
        int row = 0; // baris untuk index matrix X
        for(turunan=0; turunan<4; turunan++) {
            for(y=0; y<=1; y++) {
                for(x=0; x<=1; x++) {
                    int col = 0; // kolom untuk index matrix X
                    // loop sesuai model di spek, j dulu baru i
                    for(j=0; j<=3; j++) {
                        for(i=0; i<=3; i++) {
                            if(turunan == 0) {
                                MatX[row][col] = F(x, y, i, j);
                            }
                            else if(turunan == 1) {
                                MatX[row][col] = FX(x, y, i, j);
                            }
                            else if(turunan == 2) {
                                MatX[row][col] = FY(x, y, i, j);
                            }
                            else if(turunan == 3) {
                                MatX[row][col] = FXY(x, y, i, j);
                            }
                            col++;
                        }
                    }
                    row++;
                }
            }
        }
        // Matrix.DisplayMatrix(MatX);
        return MatX;
    }

    /* tools pemotong matrix input (masih mengandung nilai a dan b) */
    public static double[][] slice4x4(double[][] matrix) {
        int row = Matrix.getRow(matrix)-1;
        int col = Matrix.getCol(matrix);
        double [][] matrixR = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                matrixR[i][j] = matrix[i][j];
            }
        }
        return matrixR;
    }

    public static double[][] sliceAB(double[][] matrix) {
        int row = Matrix.getRow(matrix);
        // int col = Matrix.getCol(matrix);
        double[][] matrixR = new double[1][2]; // matrix 1 kolom

        for(int j=0; j<2; j++) {
            matrixR[0][j] = matrix[row-1][j];
        }
        return matrixR;
    }
}

// hapus yo ntar
// double[][] matXX =
//         {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
//         {1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
//         {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//         {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},
//         {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3},
//         {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
//         {0,0,0,0,1,0,0,0,2,0,0,0,3,0,0,0},
//         {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3},
//         {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,1,0,0,0,2,0,0,0,3,0,0},
//         {0,0,0,0,0,1,2,3,0,2,4,6,0,3,6,9}};

//         double[][] matXInv = 
//         {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
//         {-3,3,0,0,-2,-1,0,0,0,0,0,0,0,0,0,0},
//         {2,-2,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
//         {0,0,0,0,0,0,0,0,-3,3,0,0,-2,-1,0,0},
//         {0,0,0,0,0,0,0,0,2,-2,0,0,1,1,0,0},
//         {-3,0,3,0,0,0,0,0,-2,0,-1,0,0,0,0,0},
//         {0,0,0,0,-3,0,3,0,0,0,0,0,-2,0,-1,0},
//         {9,-9,-9,9,6,3,-6,-3,6,-6,3,-3,4,2,2,1},
//         {-6,6,6,-6,-3,-3,3,3,-4,4,-2,2,-2,-2,-1,-1},
//         {2,0,-2,0,0,0,0,0,1,0,1,0,0,0,0,0},
//         {0,0,0,0,2,0,-2,0,0,0,0,0,1,0,1,0},
//         {-6,6,6,-6,-4,-2,4,2,-3,3,-3,3,-2,-1,-2,-1},
//         {4,-4,-4,4,2,2,-2,-2,2,-2,2,-2,1,1,1,1}};