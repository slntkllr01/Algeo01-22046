
public class OpMatrix {
    public class Gaussian{

        public static double[][] switchRow(double[][] m1, int r1, int r2){
        double[][] m2 = new double[Matrix.getRow(m1)][Matrix.getCol(m1)];
        m2 = Matrix.copyMatrix(m1);
        for (int j=0;j < Matrix.getCol(m1);j++){
            m1[r1][j] = m2[r2][j];
            m1[r2][j] = m2[r1][j];  
        }
        return m1;
        }

        public static double[][] oBe (double[][] m1, int i, int j){ /* n adalah baris */
            for(int n=1+i;n<Matrix.getRow(m1);n++){
                double obe = m1[n][j]; /* angka yang akan menjadikan 0 */
                if (m1[i][j] == 0){ /* jika elemen pada baris dan kolom tersebut 0 */
                    continue; /* lanjut ke baris berikutnya */
                } else {
                    for (int k = 0;k<Matrix.getCol(m1);k++){ /* k sebagai iterator kolom saat melakukan obe */
                        m1[n][k] -= (obe)/(m1[i][j]) * m1[i][k]; /* operasi obe pada baris tersebut dengan baris pivot */
                    }
                }
            }
            return m1;
        }

        public static double[][] Gauss(double[][] m1){
            /* switch jika element pertama pada baris pertama adalah 0 atau tidak 1 */
            for (int j=0;j<Matrix.getCol(m1);j++){
                if (m1[0][j] == 0){ /* kalo 0 */
                    if(Matrix.isColZero(m1, j)){ /* kalo 1 kolom 0 semua */
                        continue; /* kita pindah kolom */
                    } else {
                        boolean switched = false;
                        for (int i = 1;i<Matrix.getRow(m1);i++){ /* kita mencari 1 pada kolom tersebut */
                            if (m1[i][j] == 1){
                                switchRow(m1, i, 0); /* jika ada kita switch */
                                switched = true;
                                break;
                            }
                        }
                        if (switched == false){ /* jika ternyata tidak ada yang 1 */
                            for (int i = 1;i<Matrix.getRow(m1);i++){ /* kita switch dengan yang tidak 0 */
                                if (m1[i][j] != 0){
                                switchRow(m1, i, 0);
                                break;
                                }   
                            }
                        }
                        
                    }
                } else { /* kalo tidak 0 dan tidak 1 */
                    for (int i = 1;i<Matrix.getRow(m1);i++){
                        if (m1[i][j] == 1){ /* kita cari yang 1 pada kolom tersebut dan kita switch */
                            switchRow(m1, i, 0);
                            break;
                        }
                    }
                } 
                break;
            }
            
            /* menjadikan elemen tidak 0 pertama pada suatu barus menjadi 1 */
            for(int i=0;i<Matrix.getRow(m1);i++){
                for (int j=0;j<Matrix.getCol(m1);j++){
                    if (m1[i][j] == 0){
                        continue;
                    } else {
                        double div = m1[i][j]; /* pembuat 1 */
                        for (int k=0;k<Matrix.getCol(m1);k++){
                            m1[i][k] /= div; /* dibagi dengan pembuat 1 */
                            if (m1[i][k] == -0.0) {
                                m1[i][k] = 0.0;
                            }
                        }
                        /* lakukan obe */
                        m1 = oBe(m1, i, j);
                        /* setelah obe langsung lanjut ke baris berikutnya */
                        break;
                    }  
                }
            }

            /* jika ada baris yang elemennya 0 semua */
            /* pindahkan ke bagian paling bawah */
            for (int i=0;i<Matrix.getRow(m1)-1;i++){
                if(Matrix.isRowZero(m1, i)){
                    Matrix.moveUpAddZero(m1, i);
                }
            }

            return m1;
        }      

        public static double[][] GaussJordan(double[][] m1){
            m1 = Gaussian.Gauss(m1); /* memanggil fungsi gauss untuk mendapat matrix eselon baris */
            for (int i=1;i<Matrix.getRow(m1);i++){
                for (int j=0+i;j<Matrix.getCol(m1);j++){
                    if (m1[i][j] == 0){ /* cari kolom yang tidak 0 pada baris ke dua dan seterusnya */
                        continue;
                    }
                    else{
                        double pivot = m1[i][j];
                        for (int n = 0; n<Matrix.getRow(m1);n++){
                            double obe = m1[n][j]; /* variabel untuk menyimpan elemen yang akan di 0 kan,  */
                            for (int k = 0; k<Matrix.getCol(m1);k++){
                                if (n != i){ /* bisa dibuat lebih efektif lagi */
                                m1[n][k] -= (obe)/(pivot) * m1[i][k]; /* melakukan obe */
                                }
                            }
                        }
                        break;
                        
                    }
                
                }
            }
            return m1;
        }
    }

        public static void CetakSolution(double[][] matriks) {
            
            // double[] solution = new double[Matrix.getCol(matriks) - 1];

            // Mengecek apakah tidak punya solusi
            if (isNoSolution(matriks)) {
                System.out.println("Persamaan ini tidak memiliki solusi yang valid");
            } else {
                
            }
        }

        

        public static boolean isNoSolution(double[][] matrix) {
            for (double[] row : matrix) {
                boolean isValid = true;
                for (int j = 0; j < row.length - 1; j++) {
                    if (row[j] != 0.0) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid && row[row.length - 1] != 0.0) {
                    return true;
                }
            }
            return false;
        }
    
        public static double[] SolveGauss(double[][] matrix) {
            int n = matrix.length;
            double[] solution = new double[n];
        
            for (int i = n - 1; i >= 0; i--) {
                double sum = 0.0;
                for (int j = i + 1; j < n; j++) {
                    sum += matrix[i][j] * solution[j];
                }
                solution[i] = (matrix[i][n] - sum) / matrix[i][i];
            }
        
            return solution;
        }
        
        public static double[] Parametric(double[][] matrix) {
            double[] solution = new double[Matrix.getCol(matrix) - 1];

            return solution;
        }
        
}
