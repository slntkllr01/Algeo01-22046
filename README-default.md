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
diikuti dengan path file .jar yang telah dicopy (gantikan <pathfilejar>).
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
│   ├───Method
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
│   ├───Method                      # Method package
│           Bicubic.java
│           Interpolation.java
│           MultipleLinearRegression.java
│           OpMatrix.java
│           OpMatrix$Gaussian.java
│           SPL.java
│
└───test   
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
    │         7_4.txt                     # Test
    ├───output                     
    │   
    │
    └───result                      # Result file directory
```






A quick introduction of the minimal setup you need to get a hello world up &
running.

```shell
packagemanager install awesome-project
awesome-project start
awesome-project "Do something!"  # prints "Nah."
```

Here you should say what actually happens when you execute the code above.

### Initial Configuration

Some projects require initial configuration (e.g. access tokens or keys, `npm i`).
This is the section where you would document those requirements.

## Developing

Here's a brief intro about what a developer must do in order to start developing
the project further:

```shell
git clone https://github.com/your/awesome-project.git
cd awesome-project/
packagemanager install
```

And state what happens step-by-step.

### Building

If your project needs some additional steps for the developer to build the
project after some code changes, state them here:

```shell
./configure
make
make install
```

Here again you should state what actually happens when the code above gets
executed.

### Deploying / Publishing

In case there's some step you have to take that publishes this project to a
server, this is the right time to state it.

```shell
packagemanager deploy awesome-project -s server.com -u username -p password
```

And again you'd need to tell what the previous code actually does.

## Features

What's all the bells and whistles this project can perform?
* What's the main functionality
* You can also do another thing
* If you get really randy, you can even do this

## Configuration

Here you should write what are all of the configurations a user can enter when
using the project.

#### Argument 1
Type: `String`  
Default: `'default value'`

State what an argument does and how you can use it. If needed, you can provide
an example below.

Example:
```bash
awesome-project "Some other value"  # Prints "You're nailing this readme!"
```

#### Argument 2
Type: `Number|Boolean`  
Default: 100

Copy-paste as many of these as you need.

## Contributing

When you publish something open source, one of the greatest motivations is that
anyone can just jump in and start contributing to your project.

These paragraphs are meant to welcome those kind souls to feel that they are
needed. You should state something like:

"If you'd like to contribute, please fork the repository and use a feature
branch. Pull requests are warmly welcome."

If there's anything else the developer needs to know (e.g. the code style
guide), you should link it here. If there's a lot of things to take into
consideration, it is common to separate this section to its own file called
`CONTRIBUTING.md` (or similar). If so, you should say that it exists here.

## Links

Even though this information can be found inside the project on machine-readable
format like in a .json file, it's good to include a summary of most useful
links to humans using your project. You can include links like:

- Project homepage: https://your.github.com/awesome-project/
- Repository: https://github.com/your/awesome-project/
- Issue tracker: https://github.com/your/awesome-project/issues
  - In case of sensitive bugs like security vulnerabilities, please contact
    my@email.com directly instead of using issue tracker. We value your effort
    to improve the security and privacy of this project!
- Related projects:
  - Your other project: https://github.com/your/other-project/
  - Someone else's project: https://github.com/someones/awesome-project/


## Licensing

One really important part: Give your project a proper license. Here you should
state what the license is and how to find the text version of the license.
Something like:

"The code in this project is licensed under MIT license."
