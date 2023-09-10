package hellojpa;

public class ValueMain {
  public static void main(String[] args) {

    int a = 10;
    int b = 10;

    Address address1 = new Address();
    address1.setAddress("서울시");

    Address address2 = new Address();
    address2.setAddress("서울시");

    System.out.println(" a == b : " + (a == b));
    System.out.println("address1 == address2 " + (address1 == address2));

  }
}
