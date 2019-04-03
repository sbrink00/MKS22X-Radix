import java.util.Arrays;
public class Radix{

  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    if (data.length <= 1) return;
    //int[] ary = Arrays.copyOf(data, data.length);
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
