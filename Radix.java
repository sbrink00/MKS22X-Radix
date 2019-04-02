public class Radix{

  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    if (data.length <= 1) return;
    int[] ary = data;
    MyLinkedList<Integer> temp;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for (int idx = 0; idx < 10; idx ++) buckets[idx] = new MyLinkedList<Integer>();
    int largest = Math.abs(data[0]);
    for (int idx:data) if (Math.abs(idx) > largest) largest = Math.abs(idx);
    String num = largest + "";
    int loopLength = num.length();
    for (int idx = 1; idx <= loopLength; idx ++){
      for (int i:data){
        int val = (int)((i % (Math.pow(10, idx))) / Math.pow(10, idx - 1));
        if (i < 0){
          buckets[val].addFirst(i);
        }
        else buckets[val].addLast(i);
      }
      for (int idx2 = 1; idx2 < buckets.length; idx2 ++) buckets[0].extend(buckets[idx2]);
      temp = buckets[0];
      buckets[0].clear();
      ary = temp.toArray();
    }
  }



}
