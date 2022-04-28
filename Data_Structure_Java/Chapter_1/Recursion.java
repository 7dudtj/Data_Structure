public class Main {
  public static void main(String[] args) {
    Recursion r = new Recursion();
    r.recurse(5);
  }
}

class Recursion {
  public void recurse(int count) {
    if (count <= 0)
      System.out.println(".");
    else {
      System.out.println(count + " *");
      recurse(count - 1);
    }
  }
}
