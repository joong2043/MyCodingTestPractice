import java.io.*;
import java.util.*;

// baekjoon_1918

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a;
        a = br.readLine();
        String temp = a;
        char[] arr = temp.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        // aekjoon
        // baekjoon
        // ekjoon
        // joon
        // 사전순이면 정렬 개념이 들어가야 하고

        for(int i = a.length()-1 ; i>=0; i--){
            list.add(a.substring(i,a.length()));
        }

        Collections.sort(list);

        for (int i =0 ; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}import java.io.*;
        import java.util.*;

// baekjoon_1918

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a;
        a = br.readLine();
        String temp = a;
        char[] arr = temp.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        // aekjoon
        // baekjoon
        // ekjoon
        // joon
        // 사전순이면 정렬 개념이 들어가야 하고

        for(int i = a.length()-1 ; i>=0; i--){
            list.add(a.substring(i,a.length()));
        }

        Collections.sort(list);

        for (int i =0 ; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}