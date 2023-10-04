package Method;
import java.lang.Math;
import Matrix.*;


public class SPL {

    // SPL dengan metode matriks balikan
    public static double[][] SPLinverse(double[][] matrix) {
        double [][] b = Matrix.slice_b(matrix);
        double [][] a = Matrix.slice_a(matrix);
        
        double [][] result = new double[Matrix.getRow(matrix)][0];
        result = Matrix.MultiplyMatrix(OpMatrix.inverseAdjoint(a), b);
        return result;
    }

    // SPL dengan metode cramer
    public static double[] solveCramer(double[][] matrix) {
        double det = OpMatrix.detCofactor(Matrix.slice_a(matrix));
        double[] x = new double[Matrix.getRow(matrix)];
    
        if (det != 0) {
            for (int i = 0; i < Matrix.getRow(matrix); i++) {
                double[][] Ai = Matrix.slice_a(matrix);
                for (int j = 0; j < Matrix.getRow(matrix); j++) {
                    Ai[j][i] = Matrix.slice_b(matrix)[j][0];
                }
                x[i] = OpMatrix.detCofactor(Ai) / det;
            }
        }
        return x;
    }

    public static String[] solveEchelon(double[][] matrix) {

        double temp[][] = new double[Matrix.getRow(matrix)][Matrix.getCol(matrix)];
        String result[] = new String[Matrix.getCol(matrix)-1];

        // inisialisasi array result dengan ""
        for (int i = 0; i < Matrix.getCol(matrix)-1; i++) {
            result[i] = "";
        }

        for (int i = Matrix.getRow(matrix) - 1; i >= 0; i--) {
            int idx = 0;

            while (idx < Matrix.getCol(matrix) && matrix[i][idx] == 0) {
                idx++;
            }

            if (idx >= Matrix.getCol(matrix) - 1) {
                continue;
            }

            temp[i][Matrix.getCol(matrix) - 1] += matrix[i][Matrix.getCol(matrix) - 1];

            for (int j = Matrix.getCol(matrix) - 2; j > idx; j--) {
                temp[i][j] -= matrix[i][j];
            }

            for (int j = idx + 1; j < Matrix.getCol(matrix) - 1; j++) {
                int isRow = i;
                for (int k = i + 1; k < Matrix.getRow(matrix); k++) {
                    int kIdx = 0;
                    while (kIdx < Matrix.getCol(matrix) && matrix[k][kIdx] != 1) {
                        kIdx++;
                    }
                    if (kIdx == j) {
                        isRow = k;
                    }
                }

                if (isRow != i) {
                    double temp2 = temp[i][j];
                    temp[i][j] = 0;

                    for (int l = 0; l < Matrix.getCol(matrix); l++) {
                        temp[i][l] += temp[isRow][l] * temp2;
                    }
                } 
            }
            if (temp[i][Matrix.getCol(matrix) - 1] != 0) {
                result[idx] += DecimalFormatting(temp[i][Matrix.getCol(matrix) - 1]);
            }

            for (int j = idx + 1; j < Matrix.getCol(matrix) - 1; j++) {
                if (temp[i][j] == 0) {
                    continue;
                }

                if (result[idx] == "") {
                    if (temp[i][j] < 0) {
                        result[idx] += "-";
                    }
                else {
                    if (temp[i][j] > 0) {
                        result[idx] += " + ";
                    } else {
                        result[idx] += " - ";
                    }
                }
                }
                if (Math.abs(temp[i][j]) != 1) {
                    result[idx] += DecimalFormatting(Math.abs(temp[i][j]));
                }
                String var = "t" + Integer.toString(j + 1);
                result[idx] += var;
            }

            if (result[idx] == "") {
                result[idx] += "0";
            }
            }

        for (int i = 0; i < Matrix.getCol(matrix) - 1; i++) {
            if (result[i] == "") {
                String var = "t" + Integer.toString(i + 1);
                result[i] += var;
            }
        }
        return result;
    }

    public static void OutputSPLInverse(double[][] matrix) {

        double[][] result = SPL.SPLinverse(matrix);
        int count = 0;
        for (int j = 0; j < result.length; j++) {
            if (!Double.isFinite(result[j][0])) {
                count++;
            }
        }

        if (count == result.length) {
            System.out.println("Maaf, SPL tidak dapat dipecahkan melalui metode inverse.");
        } else {
            System.out.println("Solusi SPL adalah :");
            for (int i = 0; i < result.length; i++) {
                System.out.println("X" + Integer.toString(i+1) + " : " + String.format("%.4f", result[i][0]));

            }
        }
    } 

    public static void OutputSPLCramer(double[][] matrix) {

        double[] result = SPL.solveCramer(matrix);
        int count = 0;
        for (int j = 0; j < result.length; j++) {
            if (result[j] == 0.0) {
                count++;
            }
        }

        if (count == result.length) {
            System.out.println("Maaf, SPL tidak dapat dipecahkan melalui metode inverse.");
        } else {
            System.out.println("Solusi SPL adalah :");
            for (int i = 0; i < result.length; i++) {
                System.out.println("X" + Integer.toString(i+1) + " : " + String.format("%.4f", result[i]));

            }
        }
    } 

    public static void OutputSPLGauss(double[][] matrix) {
    
        double[][] Echelon = OpMatrix.Gaussian.Gauss(matrix);

        if (isNoSolution(Echelon)) {
            System.out.println("Maaf, SPL tidak memiliki solusi.");
        } else {
            String[] result = SPL.solveEchelon(matrix);
            System.out.println("Solusi SPL adalah :");
            for (int i = 0; i < result.length; i++) {
                System.out.println("X" + Integer.toString(i+1) + " : " + result[i]);
            }
        }
    }

    public static boolean isNoSolution(double[][] matrix) {
        for (int j = 0; j < Matrix.getCol(matrix) - 1; j++) {
            if (matrix[Matrix.getRow(matrix)-1][j] != 0) {
                return false;
            }
        if (matrix[Matrix.getRow(matrix)-1][Matrix.getCol(matrix)-1] != 0) {
            return true;
        }
        }
        return true;
    }

    public static double DecimalFormatting(double nominal) {
        double result = Math.floor(nominal * 10000) / 10000.0;
        return result;
    }
}

