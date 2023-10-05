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
                    while (kIdx < Matrix.getCol(matrix) - 1 && matrix[k][kIdx] != 1) {
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
                } else {
                    if (temp[i][j] > 0) {
                        result[idx] += " + ";
                    } else {
                        result[idx] += " - ";
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

    public static String OutputSPLInverse(double[][] matrix) {
        String output = "";
        double[][] result = SPL.SPLinverse(matrix);
        int count = 0;
        for (int j = 0; j < result.length; j++) {
            if (!Double.isFinite(result[j][0]) || (result[j][0] == 999.0) || (result[j][0] == 0.0)) {
                count++;
            }
        }
    
        if (count == result.length) {
            output += "Maaf, SPL tidak dapat dipecahkan melalui metode inverse.\n";
        } else {
            output += "Solusi SPL adalah :\n";
            for (int i = 0; i < result.length; i++) {
                output += "X" + Integer.toString(i+1) + " : " + String.format("%.4f", result[i][0]) + "\n";
            }
        }
        return output;
    }
    

    public static String OutputSPLCramer(double[][] matrix) {
        String output = "";
        double[] result = SPL.solveCramer(matrix);
        int count = 0;

        for (int j = 0; j < result.length; j++) {
            if (result[j] == 0.0) {
                count++;
            }
        }

        if (count == result.length) {
            output += "Maaf, SPL tidak dapat dipecahkan melalui metode inverse.\n";
        } else {
            output += "Solusi SPL adalah :\n";
            for (int i = 0; i < result.length; i++) {
                output += "X" + Integer.toString(i+1) + " : " + String.format("%.4f", result[i]) + "\n";

            }
        }
        return output;
    } 

    public static String OutputSPLGauss(double[][] matrix) {
        String output = "";
        double[][] Echelon = OpMatrix.Gaussian.Gauss(matrix);

        if (isNoSolution(Echelon)) {
            output += "Maaf, SPL tidak memiliki solusi.\n";
        } else {
            String[] result = SPL.solveEchelon(matrix);
            output += "Solusi SPL adalah :\n";
            for (int i = 0; i < result.length; i++) {
                output += "X" + Integer.toString(i+1) + " : " + result[i] + "\n";
            }
        }
        return output;
    }

    public static String OutputSPLGaussJordan(double[][] matrix) {
        String output = "";
        double[][] Echelon = OpMatrix.Gaussian.GaussJordan(matrix);

        if (isNoSolution(Echelon)) {
            output += "Maaf, SPL tidak memiliki solusi.\n";
        } else {
            String[] result = SPL.solveEchelon(matrix);
            output += "Solusi SPL adalah :\n";
            for (int i = 0; i < result.length; i++) {
                output += "X" + Integer.toString(i+1) + " : " + result[i] + "\n";
            }
        }
        return output;
    }

    public static boolean isNoSolution(double[][] matrix) {
        for (int i = Matrix.getRow(matrix)-1; i >= 0; i--) {
            for (int j = 0; j < Matrix.getCol(matrix) - 1; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
            if (matrix[i][Matrix.getCol(matrix)-1] != 0) {
                return true;
            }
        }
        return false;
    }

    public static double DecimalFormatting(double nominal) {
        double result = Math.floor(nominal * 10000) / 10000.0;
        return result;
    }

    public static double[] backwardSubstitution(double[][] matrix) {
        int length = Matrix.getRow(matrix);
        double[] solutions = new double[length];
    
        for (int i = length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < length; j++) {
                sum += matrix[i][j] * solutions[j];
            }
            solutions[i] = (matrix[i][length] - sum) / matrix[i][i];
        }
    
        return solutions;
    }
}