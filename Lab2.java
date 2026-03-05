import java.util.Scanner;

public class Lab2 {
  public static void main(String[] args) {
    final String[] MONTHS = { "January", "February", "March", "April",
        "May", "June", "July", "August",
        "September", "October", "November",
        "December" };

    Scanner sc = new Scanner(System.in);

    int a, b, c, d, e, f, g, h, i, k, l, m;
    int mon;

    int myYear, myDay;
    String myMonth;

    System.out.print("Please enter the year: ");
    myYear = -sc.nextInt();

    a = myYear % 19;
    b = myYear / 100;
    c = myYear % 100;
    d = b / 4;
    e = b % 4;
    f = (b + 8) / 25;
    g = (b - f + 1) / 3;
    h = (19 * a + b - d - g + 15) % 30;
    i = c / 4;
    k = c % 4;
    l = (32 + 2 * e + 2 * i - h - k) % 7;
    m = (a + 11 * h + 22 * l) / 451;

    mon = (h + l - 7 * m + 114) / 31;
    myMonth = MONTHS[mon - 1];
    myDay = ((h + l - 7 * m + 114) % 31) + 1;

    System.out.println("Easter Sunday in " + myDay + " is/was " +
        myMonth + " " + myDay);

    sc.close();
  }
}
