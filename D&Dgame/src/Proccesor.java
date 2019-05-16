import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Proccesor {
    public static GUnit[][] levelProccesor(File file , int height){
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int length = st.length();
        GUnit[][] result = new char[height][length];
        for(int i = 0; i < height ; i++) {
            st = br.readLine();
        }
        return result;

    }

    public String lifeBar(int HP , int currHp){
        int Hpresentage = 100*(currHp/HP);
        String output = "";
        for(int i = 0;i<100-Hpresentage-1;i++){
            output = output + ".";
        }
        output = output + "]";
        for(int i=0; i<Hpresentage -1;i++){
            output = "|" + output;
        }
        output= "[" + output;
    }


}
