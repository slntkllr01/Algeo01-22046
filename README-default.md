# Tugas Besar I ALJABAR LINEAR DAN GEOMETRI (IF2123)
## Kelompok Cuanki

## Program Cuanki Matrix Calculator
- Mengeluarkan solusi atas Sistem Persamaan Linear menggunakan pilihan metode Gauss, Gauss-Jordan, Matriks Balikan, dan Cramer.
- Menghitung determinan matriks menggunakan pilihan metode ekspansi kofaktor atau matriks balikan.
- Mengeluarkan hasil balikan dari sebuah matriks.
- Melakukan penyelesaian interpolasi polinom.
- Melakukan penyelesaian interpolasi Bicubic Spline.
- Melakukan penyelesaian regresi linear.


## Cara Menjalankan Program
1. Clone repository ini ke dalam local machine Anda.
2. Select file bernama "Algeo01-22046.jar", klik kanan, klik "Copy as path" atau menggunakan shortcut Ctrl+Shift+C.
3. Buka terminal di perangkat Anda, ketikan command seperti berikut:  

    ```shell
    java --enable-preview -jar <pathfilejar>
    ```
    diikuti dengan path file .jar yang telah dicopy (gantikan `<pathfilejar>`).

4. Klik enter. Program akan berjalan.
5. Untuk menggunakan matriks dari file .txt, copy absolute path dari file yang ingin dibaca, paste di program tanpa tanda kutip "".
6. Untuk menulis hasil ke file .txt, ketik absolute path untuk menempatkan file disertai nama file dan ekstensi .txt



## Struktur Program
```bash
.
│   README.md
│
├───bin                                     # Bytecode
│   ├───Main
│   │       Main.class
│   │
│   ├───Matrix
│   │       InputOutput.class
│   │       Matrix.class
│   │
│   └───Method
│           Bicubic.class
│           Interpolation.class
│           MultipleLinearRegression.class
│           OpMatrix.class
│           OpMatrix$Gaussian.class
│           SPL.class
│
├───doc                             # Documentation
├───src                             # Source code
│   ├───Main                        # Main package
│   │       Main.java
│   │
│   ├───Matrix                      # Matrix package   
│   │       InputOutput.java
│   │       Matrix.java
│   │
│   └───Method                      # Method package
│           Bicubic.java
│           Interpolation.java
│           MultipleLinearRegression.java
│           OpMatrix.java
│           OpMatrix$Gaussian.java
│           SPL.java
│
└───test                            # Test
    ├───input
    │        1_a.txt
    │         1_b.txt
    │         1_c.txt
    │         1_d6.txt
    │         1_d10.txt
    │         2_a.txt
    │         2_b.txt
    │         3_a.txt
    │         3_b.txt
    │         5_a_0.2.txt
    │         5_a_0.55.txt
    │         5_a_0.85.txt
    │         5_a_1.28.txt
    │         5_b_a.txt
    │         5_b_b.txt
    │         5_b_c.txt
    │         5_b_d.txt
    │         5_c_0.txt
    │         5_c_1.txt
    │         6.txt
    │         7_1.txt
    │         7_2.txt
    │         7_3.txt
    │         7_4.txt                     
    └───output                     
```