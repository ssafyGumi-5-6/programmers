import java.util.Arrays;

public class Solution_Programers_μκΆλν {
    public static void main(String[] args) {

    }
}

class Solution {
    int max;
    int[] res;
    boolean canWin;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        max = 0;
        res = new int[11];
        canWin = false;
        dfs(n, info, 0, 0, 0, new int[11]);
        if (canWin)
            return res;
        else
            return new int[]{ -1 };
    }

    void dfs(int n, int[] info, int goal, int mine, int start, int[] my) {
        if (n == 0 || start == 11) {
            for (int i = start; i < 11; i++) {
                if (info[i] > 0)
                    goal += 10 - i;
            }
            my[10] = n;
            if (mine - goal > max) {
                max = mine - goal;
                canWin = true;
                res = Arrays.copyOf(my, 11);
            } else if (mine - goal == max) {
                for (int i = 10; i >= 0; i--) {
                    if (res[i] < my[i]) {
                        res = Arrays.copyOf(my, 11);
                        break;
                    } else if(res[i] > my[i]){
                        break;
                    }
                }
            }
            return;
        }
        if (info[start] + 1 <= n) {
            my[start] = info[start] + 1;
            dfs(n - (info[start] + 1), info, goal, mine + (10 - start), start + 1, my);
        }
        my[start] = 0;
        int pgoal = goal;
        if(info[start] > 0) pgoal = goal + (10 - start);
        dfs(n, info, pgoal, mine, start + 1, my);
    }
}

class Solution2 {
    int max;
    int[] res;
    boolean canWin;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        max = 0;
        res = new int[11];
        canWin = false;
        dfs(n, info, 0, 0, 0, new int[11]);
        if (canWin)
            return res;
        else
            return new int[]{ -1 };
    }

    void dfs(int n, int[] info, int goal, int mine, int start, int[] my) {
        if (n == 0 || start == 11) {
            // startκ° 11μ΄λ©΄ μλ λ°λ³΅λ¬Έμ μλ μ ν¨
            for (int i = start; i < 11; i++) {
                if (info[i] > 0)
                    goal += 10 - i;
            }
            my[10] = n; // λ¨λ νμ΄ λ£μ΄μ£ΌκΈ° n==0μ΄λ©΄ 0λ€μ΄κ°
            if (mine - goal > max) {
                max = mine - goal;
                canWin = true;
                res = Arrays.copyOf(my, 11);
            } else if(mine - goal == max) { // μ°¨μ΄κ° κ°μΌλ©΄ λ λ?μ μ μλ₯Ό λ§μΆ νμ΄μ΄ λ§μκ² μΈμ λλ€.
                for (int i = 10; i >= 0; i--) {
                    if (res[i] > my[i])
                        break;
                    if(res[i] < my[i]) {
                        res = Arrays.copyOf(my, 11);
                        return;
                    }
                    
                }
            }
            return;
        }

        if (info[start] + 1 <= n) {
            my[start] = info[start] + 1;
            dfs(n - (info[start] + 1), info, goal, mine + (10 - start), start + 1, my);
        }
        my[start] = 0;
        //μ΄νΌμΉ νμ΄μ΄ μμΌλ©΄ μ μλ₯Ό λμ ν΄μ€λ€.
        if(info[start] > 0)  dfs(n, info, goal + (10 - start), mine, start + 1, my);
        else dfs(n, info, goal, mine, start + 1, my);
    }
}