public class SPL {

    // SPL dengan metode matriks balikan
    public static double[][] SPLinverse(double[][] matrix) {
        double [][] b = Matrix.slice_b(matrix);
        double [][] a = Matrix.slice_a(matrix);
        
        double [][] result = new double[Matrix.getRow(matrix)][0];
        result = Matrix.MultiplyMatrix(OpMatrix.inverseGauss(a), b); // pakenya inverse gauss
        return result;
    }

    // SPL dengan metode cramer
    public static double[] solveCramer(double[][] matrix) {
        int n = matrix.length;
        double det = Matrix.detCofactor(Matrix.slice_a(matrix));
        double[] x = new double[n];
    
        if (det != 0) {
            for (int i = 0; i < n; i++) {
                double[][] Ai = Matrix.slice_a(matrix);
                for (int j = 0; j < n; j++) {
                    Ai[j][i] = Matrix.slice_b(matrix)[j][0];
                }
                x[i] = Matrix.detCofactor(Ai) / det;
            }
        }
        return x;
    }
}
