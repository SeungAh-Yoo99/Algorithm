import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<String> graphs = new LinkedList<>();

        String input;
        while(true) {
            input = br.readLine();

            if(input.equals("end")) break;
            graphs.add(input);
        }

        StringBuilder answer = new StringBuilder();
        for(String g : graphs) {
            if(play(g)) answer.append("valid\n");
            else answer.append("invalid\n");
        }
        System.out.print(answer);
    }

    static private boolean play(String graph) {

        int emptyPlace = 0, xPlace = 0, oPlace = 0;
        for (int i = 0; i < 9; i++) {
            if(graph.charAt(i) == '.') emptyPlace++;
            else if(graph.charAt(i) == 'X') xPlace++;
            else oPlace++;
        }

        // X가 먼저 말을 놓기 때문에, O의 개수가 더 많을 수는 없음
        if((oPlace != xPlace) && (oPlace != xPlace - 1)) return false;

        // 가로, 세로, 대각선이 동일한 줄이 몇 개인지 확인
        int xWin = 0, oWin = 0;

        // 가로줄 확인
        if(graph.substring(0, 3).equals("XXX")) xWin++;
        if(graph.substring(3, 6).equals("XXX")) xWin++;
        if(graph.substring(6, 9).equals("XXX")) xWin++;
        if(graph.substring(0, 3).equals("OOO")) oWin++;
        if(graph.substring(3, 6).equals("OOO")) oWin++;
        if(graph.substring(6, 9).equals("OOO")) oWin++;

        // 세로줄 확인
        if(graph.charAt(0) == 'X' && graph.charAt(3) == 'X' && graph.charAt(6) == 'X') xWin++;
        if(graph.charAt(1) == 'X' && graph.charAt(4) == 'X' && graph.charAt(7) == 'X') xWin++;
        if(graph.charAt(2) == 'X' && graph.charAt(5) == 'X' && graph.charAt(8) == 'X') xWin++;
        if(graph.charAt(0) == 'O' && graph.charAt(3) == 'O' && graph.charAt(6) == 'O') oWin++;
        if(graph.charAt(1) == 'O' && graph.charAt(4) == 'O' && graph.charAt(7) == 'O') oWin++;
        if(graph.charAt(2) == 'O' && graph.charAt(5) == 'O' && graph.charAt(8) == 'O') oWin++;

        // 대각선 확인
        if(graph.charAt(0) == 'X' && graph.charAt(4) == 'X' && graph.charAt(8) == 'X') xWin++;
        if(graph.charAt(2) == 'X' && graph.charAt(4) == 'X' && graph.charAt(6) == 'X') xWin++;
        if(graph.charAt(0) == 'O' && graph.charAt(4) == 'O' && graph.charAt(8) == 'O') oWin++;
        if(graph.charAt(2) == 'O' && graph.charAt(4) == 'O' && graph.charAt(6) == 'O') oWin++;

        if(xWin == 1 && oWin == 0 && (xPlace - 1 == oPlace)) return true;
        if(xWin == 0 && oWin == 1 && (xPlace == oPlace)) return true;
        if(emptyPlace == 0) {
            if(xWin == 0 && oWin == 0) return true;
            if(xWin == 2) return true;
        }
        return false;
    }
}
