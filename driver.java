public class driver{
  public static void main(String[]args){
    MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
    ll.add(9);
    System.out.println(ll);
    ll.set(0, 17);
    System.out.println(ll);
    ll.clear();
    System.out.println(ll);
  }
}
