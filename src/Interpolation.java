import java.util.Scanner;

public class Interpolation {
    /* dari keyboard adalah n, (x0, y0), (x1, y1), …, (xn, yn), dan nilai x yang akan ditaksir nilai fungsinya. Jika masukannya dari file, maka titik-titik dinyatakan pada setiap baris tanpa koma dan tanda kurung. Misalnya jika titik-titik datanya adalah (8.0, 2.0794), (9.0, 2.1972), dan (9.5, 2.2513), maka di dalam file text ditulis sebagai berikut: */

    // STEP ?
    /* 
    1. input n, (x0, y0), (x1, y1), …, (xn, yn), dan nilai x yang akan ditaksir nilai fungsinya (n = 1 + banyak titik = derajat polinom)
    2. ubah  ke a0 + a1x0 + a2x02 + ... + an x0n = y0 
        contoh: (8.0, 2.0794) jadi a0 + 8.0a1 + 64.00a2 = 2.0794 
    3. 
    */ 
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

        // print titik
        System.out.println("point: ");Matrix.DisplayMatrix(point);System.out.println();
        // x = point[i][0], y = point[i][1]
        
        // matriks point
        double[][] b = new double[row][1]; //0 atau 1
        for(int i=0; i<row; i++) {
            b[i][0] = point[i][1];
        }
        // print b
        System.out.println("b: ");Matrix.DisplayMatrix(b);System.out.println();
        
        // matriks
        double[][] mat = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] = Math.pow(point[i][0], j);
            }
        }
        // print hasil kuadrat
        System.out.println("mat: ");Matrix.DisplayMatrix(mat);System.out.println();

        
        // ######## GAS ######## //
        double [][] result = new double[row][0];
        result = Matrix.MultiplyMatrix(Matrix.inverseAdjoint(mat), b);
        return result;
    }

    public static double[][] InterpolasiKeyboard() {
        int n;
        // titik dulu ambil
        System.out.println("n : ");
        scan = new Scanner(System.in);
        n = scan.nextInt();
        
        int row = n+1, col = n+1;
        System.out.println("elmt : ");
        double[][] point = new double[row][2];
        for(int p=0; p<row; p++) {
            for(int q=0; q<2; q++) {
                point[p][q] = scan.nextDouble();
            }
        }
        
        // print titik
        System.out.println("point: ");Matrix.DisplayMatrix(point);System.out.println();
        // x = point[i][0], y = point[i][1]
        
        // matriks point
        double[][] b = new double[row][1]; //0 atau 1
        for(int i=0; i<row; i++) {
            b[i][0] = point[i][1];
        }
        // print b
        System.out.println("b: ");Matrix.DisplayMatrix(b);System.out.println();
        
        // matriks
        double[][] mat = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] = Math.pow(point[i][0], j);
            }
        }
        // print hasil kuadrat
        System.out.println("mat: ");Matrix.DisplayMatrix(mat);System.out.println();

        
        // ######## GAS ######## //
        double [][] result = new double[row][0];
        result = Matrix.MultiplyMatrix(Matrix.inverseAdjoint(mat), b);
        return result;
    }

    public static void outputInterpolasi(double[][] result) {
        // f(x) = -0.0064x2 + 0.2266x + 0.6762
        System.out.print("f(x) = ");
        for(int i=result.length-1; i>=0; i--) { 
            if(i > 0) {
                System.out.printf("%.4fx^%d + ", result[i][0], i);
            }
            else {
                System.out.printf("%.4f",result[i][0]);
            }
        }
        System.out.println();
    }

    public static void outputFungsi(double[][] result) {
        // hasil taksiran nilai fungsi
        double x;
        System.out.print("\nMasukan X yang akan ditaksir: ");
        scan = new Scanner(System.in);
        x = scan.nextDouble();

        double hasilx = 0;
        for(int loop=result.length-1; loop>=0; loop--) { 
            hasilx += result[loop][0]*Math.pow(x,loop);
        }
        
        System.out.printf("f(%.4f) = %.4f\n", x, hasilx);
    }
}
