public class driver{
  public static void main(String[]args){
    MyLinkedList<Integer> m1 = new MyLinkedList<Integer>();
    MyLinkedList<Integer> m2 = new MyLinkedList<Integer>();
    m1.addLast(2);
    m1.addFirst(1);
    System.out.println(m1);
    m2.addLast(4);
    m2.addFirst(3);
    System.out.println(m2);
    m1.extend(m2);
    System.out.println(m1);
    System.out.println(m2);
  }
}
