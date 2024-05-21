

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class NQueens51 {

  // so slow
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    if (n < 0) {
      return result;
    }

    List<List<Integer>> trace = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Integer[] now = new Integer[]{i, j};
        if (attacked(trace, now)) {
          if (j == n - 1) {
            List<Integer> last = backtrack(trace, i, j, n);
            i = last.get(0);
            j = last.get(1);
            if (i == 0 && j == n - 1) {
              return result;
            }
            break;
          }
        } else {
          trace.add(Arrays.asList(now));
          if (i == n - 1) {
            List<Integer> first = foundOneSolution(result, trace, n);
            i = first.get(0);
            j = first.get(1);
          }
          if (i == 0 && j > n - 1) {
            return result;
          }
          break;
        }
      }
    }

    return result;
  }

  private List<Integer> backtrack(List<List<Integer>> trace, int inputI, int inputJ, int n) {
    int i = inputI;
    int j = inputJ;

    if (trace.size() == 0) {
      return new ArrayList<Integer>(Arrays.asList(i, j));
    }

    List<Integer> last = trace.get(trace.size() - 1);
    trace.remove(last);


    if (last.get(1) < n - 1 && !attacked(trace, new Integer[]{last.get(0), last.get(1) + 1})) {
      last.set(1, last.get(1) + 1);
      trace.add(last);
      i = i - 1;
      j = 0;
    } else if (last.get(1) < n - 1) {
      int a = last.get(0);
      int b = last.get(1) + 2;
      while (b <= n - 1 && attacked(trace, new Integer[]{a, b})) {
        b++;
      }
      if (b > n - 1) {
        List<Integer> back = backtrack(trace, a, n - 1, n);
        i = back.get(0);
        j = back.get(1);
      } else {
        trace.add(Arrays.asList(a, b));
        i = i - 1;
        j = 0;
      }
    } else {
      List<Integer> back = backtrack(trace, last.get(0), last.get(1), n);
      i = back.get(0);
      j = back.get(1);
    }

    return new ArrayList<Integer>(Arrays.asList(i, j));
  }

  private List<Integer> foundOneSolution(List<List<String>> result, List<List<Integer>> trace, int n) {
    String[][] board = new String[n][n];
    for(String[] row: board){
      Arrays.fill(row, ".");
    }

    for (List<Integer> queen: trace) {
      board[queen.get(0)][queen.get(1)] = "Q";
    }

    List<String> solution = new ArrayList<>();
    for(String[] row: board){
      solution.add(String.join("", row));
    }
    result.add(solution);


    List<Integer> last = trace.get(trace.size() - 1);
    trace.remove(last);

    last.set(1, last.get(1) + 1);
    trace.add(last);

    return new ArrayList<Integer>(Arrays.asList(last.get(0) - 1, 0));
  }

  private boolean attacked(List<List<Integer>> trace, Integer[] point) {
    Integer x = point[0];
    Integer y = point[1];
    for (List<Integer> qPoint: trace) {
      Integer qx = qPoint.get(0);
      Integer qy = qPoint.get(1);

      if (x.equals(qx) || y.equals(qy) || Math.abs(x - qx) == Math.abs(y - qy)) {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    NQueens51 nq = new NQueens51();

    System.out.println("---- 1");
    System.out.println(nq.solveNQueens(1));
    System.out.println("---- 4");
    System.out.println(nq.solveNQueens(4));
    System.out.println("---- 2");
    System.out.println(nq.solveNQueens(2));
    System.out.println("---- 3");
    System.out.println(nq.solveNQueens(3));
    System.out.println("---- 5");
    System.out.println(nq.solveNQueens(5));
    System.out.println("---- 6");
    System.out.println(nq.solveNQueens(6));
  }
}
