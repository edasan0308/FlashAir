/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashair;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
 


public class Flashair {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // URLを作成してGET通信を行う
        URL url = new URL("https://player.vimeo.com/play/319750599?s=115212585_1558119400_8244e9b8d4a3e9f1db9a605e5e37f38a&loc=external&context=Vimeo%5CController%5CClipController.main&download=1");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        http.connect();

        // サーバーからのレスポンスを標準出力へ出す
        try {

            // Shift_JISのファイルから文字コード変換して読み込む例
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(),"utf-8"));
            // Shift_JISのファイルから文字コード変換して書き込む例
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("test.mp4"),"utf-8"));
            
            int data;
            while ((data = br.read()) != -1) {
                pw.write(data);
                //System.out.println(data);
            }
            System.out.println("END");
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
