public class Radix{

  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    if (data.length == 0) return;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for (int idx = 0; idx < 10; idx ++) buckets[idx] = new MyLinkedList<Integer>();
    int largest = Math.abs(data[0]);
    for (int idx:data) if (Math.abs(idx) > largest) largest = Math.abs(idx);
    String num = largest + "";
    int loopLength = largest.length();
    for (int idx = 0; idx < loopLength; idx ++){
      for (int i:data){
        
      }
    }
  }



}
