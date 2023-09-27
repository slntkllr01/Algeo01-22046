public class test {
    public static void main(String[] args) {
        // Matriks koefisien SPL
        double[][] matriks = {
            {1, 3, -2, 0, 2, 0, 0},
            {0, 0, 1, 2, 0, 3, 1},
            {0, 0, 0, 0, 0, 1, 0.33},
            {0, 0, 0, 0, 0, 0, 0}
        };

        // Menentukan jumlah variabel
        int jumlahVariabel = matriks[0].length - 1;

        // Inisialisasi array untuk menyimpan variabel dan solusi
        double[] variabel = new double[jumlahVariabel];

        // Langkah 1: Mencari variabel-variabel yang dikenal
        for (int i = 0; i < jumlahVariabel; i++) {
            boolean variabelDikenal = false;
            for (int j = 0; j < matriks.length; j++) {
                if (matriks[j][i] != 0) {
                    variabelDikenal = true;
                    break;
                }
            }
            if (variabelDikenal) {
                variabel[i] = Double.NaN; // Tandai variabel yang dikenal
            }
        }

        // Langkah 2: Mencari solusi
        for (int i = jumlahVariabel - 1; i >= 0; i--) {
            if (Double.isNaN(variabel[i])) {
                continue; // Skip variabel yang sudah dikenal
            }
            double hasil = matriks[i][jumlahVariabel];
            for (int j = i + 1; j < jumlahVariabel; j++) {
                hasil -= matriks[i][j] * variabel[j];
            }
            variabel[i] = hasil / matriks[i][i];
        }

        // Menampilkan hasil SPL parametrik
        System.out.println("Solusi SPL Parametrik:");
        for (int i = 0; i < jumlahVariabel; i++) {
            if (Double.isNaN(variabel[i])) {
                System.out.println("x" + i + " = r" + i);
            } else {
                System.out.println("x" + i + " = " + variabel[i]);
            }
        }
    }
}
