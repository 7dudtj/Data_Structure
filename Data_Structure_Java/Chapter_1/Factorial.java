public class Main {
  public static void main(String[] args) {
    Factorial f = new Factorial();
    f.factorial(5);
    }
}

class Factorial{
  public void factorial(int n){
    int result = 1;
    for (int i = 1; i <= n; i++) result = result * i;
    System.out.println("Factorial " + n + " : " + result);
  }
}
