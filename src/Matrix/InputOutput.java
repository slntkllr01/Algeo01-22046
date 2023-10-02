package Matrix;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
public class InputOutput {
    public static double[][] readMatrixFile(double[][] m1, String filenames){ /* untuk spl, determinan, interpolasi, regresi, dan bicubic */
        String line;
        String[] substrings;
        int i = 0,j = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filenames));
            line = reader.readLine();
            while(line != null){
                substrings = line.split(" ");
                j = 0;
                while(j<substrings.length){
                    m1[i][j] = Double.parseDouble(substrings[j]);
                    j++;
                }
                i++;
                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        double[][] m2 = new double[i][j];
            for(int k=0;k<Matrix.getRow(m2);k++){
                for(int l=0;l<Matrix.getCol(m2);l++){
                    m2[k][l] = m1[k][l];

                }
            }
        return m2;
    }

    public static double[][] readPointFile(double[][] m1, String filenames){ /* untuk interpolasi, pake yang atas sama aja*/ 
        String line;
        String[] substrings;
        int i = 0,j = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filenames));
            line = reader.readLine();
            while(line != null){
                substrings = line.split(" ");
                j = 0;
                while(j<substrings.length){
                    m1[i][j] = Double.parseDouble(substrings[j]);
                    j++;
                }
                i++;
                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        double[][] m2 = new double[i][j+1];
            for(int k=0;k<Matrix.getRow(m2);k++){
                for(int l=0;l<Matrix.getCol(m2);l++){
                    m2[k][l] = m1[k][l];

                }
            }
        return m2;
    }
    
    public static void outputFile(String x, String filenames){
        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filenames));
                writer.write(x);
                writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
