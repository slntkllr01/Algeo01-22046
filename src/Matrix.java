import java.util.Scanner;

public class Matrix {
    public double[][] matrix = new double[100][100];
    public int nRows;
    public int nCols;

    Matrix(int nRows, int nCols){
        int i,j;
        this.nRows = nRows;
        this.nCols = nCols;
        for(i=0;i<nRows;i++){
            for(j=0;j<nCols;j++){
                this.matrix[i][j] = 0;
            }
        }
    }
    // constructor? belom
    // public void CreateMatrix(int row, int col, double[][] matrix) {
    //     // double[][] matrix = new double[row][col];

    //     for(int i = 0;i < row;i++) {
    //         for(int j = 0;j < col;j++) {
    //             matrix[i][j] = 0;
    //         }
    //     }
    // }

    /* SELECTOR */
    public int getRow(double[][] matrix) {
        return matrix.length;
    }
    
    
    public int getCol(double[][] matrix) {
        return matrix[0].length;
    }

    public int getLastIdxRow(double[][] matrix) {
        return (getRow(matrix) - 1);
    }

    public int getLastIdxCol(double[][] matrix) {
        return (getCol(matrix) - 1);
    }

    /* METHOD */
    public void ReadMatrixKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Jumlah baris (row): "); this.nRows = scan.nextInt();
        System.out.print("Jumlah kolom (col): "); this.nCols = scan.nextInt();

        System.out.println("Elemen matriks: ");
        for(int i = 0;i < nRows;i++) {
            for(int j = 0;j < nCols;j++) {
                this.matrix[i][j] = scan.nextDouble();
            }
        }
        scan.close();

    }

    public void DisplayMatrix(Matrix matrix) {
        for(int i = 0;i < nRows;i++) {
            for(int j = 0;j < nCols;j++) {
                if(j < nCols-1) {
                    System.out.print(this.matrix[i][j] + " ");
                }
                else {
                    System.out.println(this.matrix[i][j]);
                }
            }
        }
    }

    // public void copyMatrix(double[][] matrixIn, double[][] matrixOut) {
    //     for(int i = 0;i < getRow(matrixIn);i++) {
    //         for(int j = 0;j < getCol(matrixIn);j++) {
    //             matrixOut[i][j] = matrixIn[i][j];
    //         }
    //     }
    // }

    public double[][] copyMatrix(double[][] matrixIn) {
        /* Mengirim matrixOut hasil copy matrixIn*/
        int row = getRow(matrixIn);
        int col = getCol(matrixIn);
        double[][] matrixOut = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrixOut[i][j] = matrixIn[i][j];
            }
        }
        return matrixOut;
    }

    public double[][] AddMatrix(double[][] matrix1, double[][] matrix2) {
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

    public double[][] SubtractMatrix(double[][] matrix1, double[][] matrix2) {
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

    public double[][] MultiplyMatrix(double[][] matrix1, double[][] matrix2) {
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

    public double[][] MultiplyByConst(double[][] matrix, int x) {
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

    
    public boolean isMatrixEqual(double[][] matrix1, double[][] matrix2) {
        /* Mengirimkan true jika m1 = m2 */
        if (getRow(matrix1) != getRow(matrix2) || getCol(matrix1) != getCol(matrix2)) {
            return false;
        }
        int i, j;
        for(i = 0; i < getRow(matrix1); i++)
        {
            for(j = 0; j < getCol(matrix1); j++)
            {
                if (matrix1[i][j] != matrix2[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isMatrixSizeEqual(double[][] matrix1, double[][] matrix2) {
        /* True jika ukuran efektif matriks m1 sama dengan ukuran efektif m2 */
        return(getRow(matrix1) == getRow(matrix2) && getCol(matrix1) == getCol(matrix2));
    }   
    
    public int CountElmt(double[][] matrix) {
        /* Mengirimkan banyaknya elemen m */
        return (getRow(matrix)*getCol(matrix));
    }
    
    public boolean isSquare(double[][] matrix) {
        /* True jika m adalah matriks dg ukuran baris dan kolom sama */
        return (getRow(matrix) == getCol(matrix));
    }

    public boolean isSymmetric(double[][] matrix) {
        /* Mengirimkan true jika m adalah matriks simetri : isSquare(m) dan m(i,j)=m(j,i) */ 
        if(!(isSquare(matrix))) {
            return false;
        }
        
        int i, j;
        for(i = 0; i < getRow(matrix); i++)
        {
            for(j = 0; j < getCol(matrix); j++)
            {
                if (matrix[i][j] != matrix[j][i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIdentity(double[][] matrix) {
        /* Mengirimkan true jika m adalah matriks satuan: isSquare(m) dan elemen diagonal bernilai 1, sisanya 0 */
        if(!(isSquare(matrix))) {
            return false;
        }
        int i, j;
        for(i=0;i<getRow(matrix);i++) {
            for(j=0;j<getCol(matrix);j++) {
                if (i == j) {
                    if (matrix[i][j] != 1) {
                        return false;
                    }
                }
                else {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public double[][] negation(double[][] matrix) {
        /* Mengirim hasil perkalian setiap elemen m dengan x */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row][col];

        matrixR = MultiplyByConst(matrix,(-1));
        return matrixR;
    }

    public double[][] transpose(double[][] matrix) {
        /* Mengirim hasil perkalian setiap elemen m dengan x */
        int row = getRow(matrix);
        int col = getCol(matrix);
        double[][] matrixR = new double[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrixR[i][j] = matrix[j][i];
            }
        }
        return matrixR;
    }
}