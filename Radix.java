import java.util.Arrays;
public class Radix{

  public static void main(String[]args){
    int[] ary = {2, 3, 5, 43241, 45, 1, 5, 4, 3, 21};
    radixsort(ary);
    System.out.println(Arrays.toString(ary));
  }

  @SuppressWarnings("unchecked")
  public static void radixsortTwo(int[] data){
    if (data.length <= 1) return;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for (int idx = 0; idx < 10; idx ++) buckets[idx] = new MyLinkedList<Integer>();
    int largest = Math.abs(data[0]);
    for (int idx:data) if (Math.abs(idx) > largest) largest = Math.abs(idx);
    String num = largest + "";
    int loopLength = num.length();
    for (int idx = 1; idx <= loopLength; idx ++){
      for (int i:data){
        int val = (int)(Math.abs((i % (Math.pow(10, idx))) / Math.pow(10, idx - 1)));
        if (i < 0){
          buckets[val].addFirst(i);
        }
        else buckets[val].addLast(i);
      }
      for (int idx2 = 1; idx2 < buckets.length; idx2 ++) buckets[0].extend(buckets[idx2]);
      modArray(buckets[0], data);
    }
  }

  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    if (data.length <= 1) return;
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for (int idx = 0; idx < 10; idx ++) buckets[idx] = new MyLinkedList<Integer>();
    int largest = Math.abs(data[0]);
    for (int idx:data) if (Math.abs(idx) > largest) largest = Math.abs(idx);
    String s = largest + "";
    int loopLength = s.length() - 1;
    //System.out.println(loopLength);
    int modThing = 1;
    for (int i:data){
      int val = (int)(Math.abs((i % (Math.pow(10, modThing))) / Math.pow(10, modThing - 1)));
      if (i < 0){
        buckets[val].addFirst(i);
      }
      else buckets[val].addLast(i);
    }
    //System.out.println(bts(buckets));
    modThing ++;
    temp.addFirst(0);
    for (int idx2 = 0; idx2 < 10; idx2 ++){
      //System.out.println(temp);
      temp.extend(buckets[idx2]);
    }
    temp.removeFirst();
    //System.out.println(temp);
    for (int idx = 0; idx < loopLength; idx ++){
      //System.out.println("inside loop");
      while (temp.size() != 0){
        int num = temp.removeFirst();
        //System.out.println(temp.size());
        int val = (int)(Math.abs((num % (Math.pow(10, modThing))) / Math.pow(10, modThing - 1)));
        if (num < 0){
          buckets[val].addFirst(num);
        }
        else buckets[val].addLast(num);
        //System.out.println("reached");
      }
      temp.addFirst(0);
      for (int idx2 = 0; idx2 < 10; idx2 ++) temp.extend(buckets[idx2]);
      temp.removeFirst();
      modThing ++;
    }
    modArray(temp, data);
  }

  public static void modArray(MyLinkedList<Integer> list, int[] data){
    int idx = 0;
    while (list.size() > 0){
      data[idx] = list.removeFirst();
      idx ++;
    }
  }

  public static String bts(MyLinkedList<Integer>[] list){
    String output = "";
    for (int idx = 0; idx < list.length; idx ++){
      output += list[idx] + "\n";
    }
    return output;
  }
}
