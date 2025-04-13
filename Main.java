import chanllage.*;

public class Main {

  public static void main(String[] args) {
    for (DayOfTheweek dayOfTheweek : DayOfTheweek.values()) {
      System.out.println(dayOfTheweek.name() + " : " + dayOfTheweek.getPrice());
    }
  }
}
