
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pilMenu = """
                1. Sistem Persamaaan Linier
                    a. Metode eliminasi Gauss
                    b. Metode eliminasi Gauss-Jordan
                    c. Metode matriks balikan
                    d. Kaidah Cramer                 
                2. Determinan
                    a. Metode eliminasi Gauss (Reduksi Baris)?
                    b. Metode ekspansi kofaktor
                3. Matriks balikan
                    a. Metode eliminasi Gauss-Jordan
                    b. Metode adjoint
                4. Interpolasi Polinom
                5. Interpolasi Bicubic Spline
                6. Regresi linier berganda
                7. Keluar
                """;

        String kelompok = """
                
                ░█████╗░██╗░░░██╗░█████╗░███╗░░██╗██╗░░██╗██╗
                ██╔══██╗██║░░░██║██╔══██╗████╗░██║██║░██╔╝██║
                ██║░░╚═╝██║░░░██║███████║██╔██╗██║█████═╝░██║
                ██║░░██╗██║░░░██║██╔══██║██║╚████║██╔═██╗░██║
                ╚█████╔╝╚██████╔╝██║░░██║██║░╚███║██║░╚██╗██║
                ░╚════╝░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚═╝
                """;
        String kelompok2 = """
                █▀▀ █░█ ▄▀█ █▄░█ █▄▀ █
                █▄▄ █▄█ █▀█ █░▀█ █░█ █
                matrix calculator
                """;
        
        String judul = """
                
                █▀▀ █░█ ▄▀█ █▄░█ █▄▀ █ █▄▀ █░█ █░░ ▄▀█ ▀█▀ █▀█ █▀█
                █▄▄ █▄█ █▀█ █░▀█ █░█ █ █░█ █▄█ █▄▄ █▀█ ░█░ █▄█ █▀▄
                """;
        
        Scanner sc = new Scanner(System.in);
        int choiceMenu;
        System.out.print(kelompok2);

        do {
            System.out.println("\nMENU: ");
            System.out.println(pilMenu);

            System.out.print("Masukan pilihan menu: ");
            
            choiceMenu = sc.nextInt();  
            while (choiceMenu < 1 || choiceMenu > 7) {
                System.out.println("Pilihan tidak tersedia, mohon ulangi.");
                System.out.print("Masukan pilihan menu: ");
                choiceMenu = sc.nextInt();  
            }
            System.out.println();

            if(choiceMenu == 7) {
                System.out.println("Keluar dari program...");
            }

            switch (choiceMenu) {
                case 1:
                    System.out.println("== SISTEM PERSAMAAN LINEAR ==");
                    break;
                case 2:
                    System.out.println("== DETERMINAN ==");
                    break;
                case 3:
                    System.out.println("== MATRIKS BALIKAN ==");
                    break;
                case 4:
                    System.out.println("== INTERPOLASI POLINOM ==");
                    break;
                case 5:
                    System.out.println("== INTERPOLASI BICUBIC SPLINE ==");
                    break;
                case 6:
                    System.out.println("== REGRESI LINEAR BERGANDA ==");
                    break; 
            }

        } while (choiceMenu < 7);
        sc.close(); // close Scanner (input)
    }
}
