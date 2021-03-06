package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Proccesor {

	//receives file path and returns array of numbers
    public static int[] tickProccesor(String path) {
        Path P = Paths.get(path);
        File file = new File(path);
        int[] output = null;
        try {
            long lines = Files.lines(P).count();
            BufferedReader br = new BufferedReader(new FileReader(file));
            output = new int[(int) lines];
            for (int i = 0; i < lines; i++) output[i] = Integer.parseInt(br.readLine());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
	//receives file path and returns array of strings
    public static String[] moveProccesor(String path) {
        Path P = Paths.get(path);
        File file = new File(path);
        String[] output = null;
        try {
            long lines = Files.lines(P).count();
            BufferedReader br = new BufferedReader(new FileReader(file));
            output = new String[(int) lines];
            for (int i = 0; i < lines; i++) output[i] = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }


    public static String lifeBar(double HP, double currHp) {
        double Hpresentage = 100 * currHp / HP;
        String output = "";
        for (int i = 0; i < 100 - Hpresentage - 1; i++) {
            output = output + ".";
        }
        output = output + "]";
        for (int i = 0; i < Hpresentage - 1; i++) {
            output = "|" + output;
        }
        output = "[" + output;
        return output.substring(0, 48) + (int) Hpresentage + "%" + output.substring(51);
    }
    //recives a file and return array represent a board
    public static char[][] boardProccesor(File level , int height) {
        char[][] result = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(level));
            String st = br.readLine();
            int length = st.length();
            result = new char[height][length];
            for (int i = 0; i < height; i++) {
                result[i] = st.toCharArray();
                st = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transpose(result);
    }
    
    private static char[][] transpose(char[][] input){
    	char[][] output = new char[input[0].length][input.length];
    	for(int i=0 ; i<input.length ; i++) {
    		for( int j=0 ; j<input[0].length ; j++) {
    			output[j][i] = input[i][j];
    		}
    	}
    	return output;
    }
    

    

}
