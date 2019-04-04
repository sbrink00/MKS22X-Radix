import java.util.Arrays;
import java.util.Random;
public class Radix{

  public static void main(String[]args){
    Random r = new Random();
    int[] a = new int[100];
    int[] ra = new int[100];
    for (int idx = 0; idx < a.length; idx ++){
      a[idx] = r.nextInt(19) - 10;
      ra[idx] = a[idx];
    }
    Arrays.sort(a);
    radixsort(ra);
    System.out.println(Arrays.toString(ra));
    System.out.println(Arrays.equals(a, ra));
    //int[] ary = {-15, 3, 4, 2, -2, -5, 6, -16};
    //radixsort(ary);
    //System.out.println(Arrays.toString(ary));
  }

  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    if (data.length <= 1) return;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[19];
    for (int idx = 0; idx < buckets.length; idx ++) buckets[idx] = new MyLinkedList<Integer>();
    int largest = Math.abs(data[0]);
    //for (int idx:data) if (Math.abs(idx) > largest) largest = Math.abs(idx);
    //String num = largest + "";
    int loopLength = 1000000000;
    for (int idx = 1; idx <= loopLength; idx ++){
      for (int i:data){
        if (idx == 1){
          if (Math.abs(i) > largest) largest = Math.abs(i);
        }
        int val = (int)((i % (Math.pow(10, idx))) / Math.pow(10, idx - 1));
        buckets[val + 9].addLast(i);

      }
      if (idx == 1){
        String s = largest + "";
        loopLength = s.length();
      }
      buckets[0].addFirst(0);
      for (int idx2 = 1; idx2 < buckets.length; idx2 ++) buckets[0].extend(buckets[idx2]);
      buckets[0].removeFirst();
      modArray(buckets[0], data);
    }
  }


  @SuppressWarnings("unchecked")
  public static void radixsortT(int[] data){
    if (data.length <= 1) return;
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();
    MyLinkedList<Integer>[] buckets = new MyLinkedList[19];
    for (int idx = 0; idx < buckets.length; idx ++) buckets[idx] = new MyLinkedList<Integer>();
    int largest = Math.abs(data[0]);
    for (int idx:data) if (Math.abs(idx) > largest) largest = Math.abs(idx);
    String s = largest + "";
    int loopLength = s.length() - 1;
    //System.out.println(loopLength);
    int modThing = 1;
    for (int i:data){
      int val = (int)((i % (Math.pow(10, modThing))) / Math.pow(10, modThing - 1));
      buckets[val + 9].addLast(i);
    }
    modThing ++;
    temp.addFirst(0);
    for (int idx2 = 0; idx2 < 10; idx2 ++) temp.extend(buckets[idx2]);
    temp.removeFirst();
    for (int idx = 1; idx <= loopLength; idx ++){
      while (temp.size() != 0){
        int num = temp.removeFirst();
        int val = (int)((num % (Math.pow(10, modThing))) / Math.pow(10, modThing - 1));
        buckets[val + 9].addLast(num);
      }
      temp.addFirst(0);
      for (int idx2 = 0; idx2 < buckets.length; idx2 ++) temp.extend(buckets[idx2]);
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
