import java.util.*;

public class Lambda {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>(List.of("alpha","bravo","charlie","delta"));
    for (String s : list) {
      System.out.println(s);
    }
  }
}
