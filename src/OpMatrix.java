
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

        public static double[][] oBe (double[][] m1, int n, int j){ /* n adalah baris */
            for(int i=1+n;i<Matrix.getRow(m1);i++){
                double obe = m1[i][j]; /* angka yang akan menjadikan 0 */
                if (m1[n][j] == 0){ /* jika elemen pada baris dan kolom tersebut 0 */
                    continue; /* lanjut ke baris berikutnya */
                } else {
                    for (int k = 0;k<Matrix.getCol(m1);k++){ /* k sebagai iterator kolom saat melakukan obe */
                        m1[i][k] -= (obe)/(m1[n][j]) * m1[n][k]; /* operasi obe pada baris tersebut dengan baris pivot */
                    }
                }
            }
            return m1;
        }

        public static double[][] Gauss(double[][] m1){
            /* switch sampai menemukan element yang tidak 0 pada baris pertama */
            for (int j=0;j<Matrix.getCol(m1);j++){
                if (m1[0][j] == 0){
                    if(Matrix.isColZero(m1, j)){
                        continue;
                    } else {
                        for (int i = 1;i<Matrix.getRow(m1);i++){
                            if (m1[i][j] != 0){
                                switchRow(m1, i, 0);
                            }
                            
                        }
                    }
                } 
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
    }

    public double[][] GaussJordan(double[][] m1){
        m1 = Gaussian.Gauss(m1);
        for (int j=0;j<Matrix.getCol(m1);j++){
            for (int i=0+j;i<Matrix.getRow(m1);i++){
                
            }
        }
        return m1;
    }

    
}
