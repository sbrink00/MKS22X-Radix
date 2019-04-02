import java.util.Arrays;
public class driver{
  public static void main(String[]args){
    MyLinkedList<Integer> mll = new MyLinkedList<Integer>();

    Integer[] ary = mll.toArray();
    System.out.println(Arrays.toString(ary));
  }
}
