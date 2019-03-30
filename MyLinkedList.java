public class MyLinkedList<E>{
  private int length;
  private Node<E> start,end;

  @SuppressWarnings("unchecked")
  public MyLinkedList(){
    start = null;
    end = null;
    length = 0;
  }
  @SuppressWarnings("unchecked")
  public void clear(){
    start = null;
    end = null;
    length = 0;
  }
  @SuppressWarnings("unchecked")
  public boolean add(E value){
    if (length == 0){
      Node<E> n = new Node(value, null, null);
      start = n;
      end = n;
    }
    else{
      Node<E> n = new Node(value, end, null);
      end = n;
      n.prev().setNext(n);
    }
    length ++;
    return true;
  }

  public int size(){return length;}
  @SuppressWarnings("unchecked")
  public E get(int index){
    int idx = 0;
    Node<E> current = start;
    while (idx != index){
      current = current.next();
      idx ++;
    }
    return current.getData();
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E value){
    int idx = 0;
    Node<E> current = start;
    while (idx != index){
      current = current.next();
      idx ++;
    }
    return current.setData(value);
  }

  @SuppressWarnings("unchecked")
  public String toString(){
    if (length == 0) return "[]";
    String output = "[";
    Node current = start;
    while (current != null){
      output += current.getData() + ", ";
      current = current.next();
    }
    return output.substring(0, output.length() - 2) + "]";
  }
}
