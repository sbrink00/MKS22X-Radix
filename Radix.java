import java.util.Arrays;
public class Radix{

  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    if (data.length <= 1) return;
    int[] ary = Arrays.copyOf(data, data.length);
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for (int idx = 0; idx < 10; idx ++) buckets[idx] = new MyLinkedList<Integer>();
    int largest = Math.abs(ary[0]);
    for (int idx:ary) if (Math.abs(idx) > largest) largest = Math.abs(idx);
    String num = largest + "";
    int loopLength = num.length();
    //System.out.println(loopLength);
    for (int idx = 1; idx <= loopLength; idx ++){
      for (int i:ary){
        int val = (int)(Math.abs((i % (Math.pow(10, idx))) / Math.pow(10, idx - 1)));
        //System.out.println(val);
        if (i < 0){
          buckets[val].addFirst(i);
        }
        else buckets[val].addLast(i);
      }
      for (int idx2 = 1; idx2 < buckets.length; idx2 ++){
        //System.out.println(bts(buckets));
        buckets[0].extend(buckets[idx2]);
      }
      ary = toArray(buckets[0]);
    }
    for (int idx = 0; idx < data.length; idx ++) data[idx] = ary[idx];
  }

  public static int[] toArray(MyLinkedList<Integer> list){
    int[] output = new int[list.size()];
    int idx = 0;
    while (list.size() > 0){
      output[idx] = list.removeFirst();
      idx ++;
    }
    //System.out.println(Arrays.toString(output));
    return output;
  }

  public static String bts(MyLinkedList<Integer>[] list){
    String output = "";
    for (int idx = 0; idx < list.length; idx ++){
      output += list[idx] + "\n";
    }
    return output;
  }



}
