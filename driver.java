import java.util.Arrays;
import java.util.Random;
public class driver{
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tRadix/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  Random r = new Random();
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long rtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = r.nextInt(MAX * 2) - MAX;
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Radix.radixsort(data2);
        t2 = System.currentTimeMillis();
        rtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime += t2 - t1;
        //System.out.println(Arrays.toString(data2));
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*rtime/btime);
    }
    System.out.println();
  }
}
}
