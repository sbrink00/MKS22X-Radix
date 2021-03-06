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
  public boolean addLast(E value){
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

  @SuppressWarnings("unchecked")
  public E removeFirst(){
    E output = (E)start.getData();
    if (length == 1) clear();
    else {
      start = start.next();
      start.setPrev(null);
      length --;
    }
    return output;
  }

  @SuppressWarnings("unchecked")
  public boolean addFirst(E value){
    if (length == 0){
      Node<E> n = new Node(value, null, null);
      start = n;
      end = n;
    }
    else{
      Node<E> n = new Node(value, null, start);
      start = n;
      n.next().setPrev(n);
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
  public void extend(MyLinkedList<E> other){
    if (other.length == 0) return;
    else if (this.length == 0) {
      this.start = other.start;
      this.end = other.end;
      other.clear();
      return;
    }
    else{
      int s = other.size();
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
      length += s;
      other.clear();
    }
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(){
    E[] output = (E[])new Object[length];
    Node current = start;
    int idx = 0;
    while (current != null){
      output[idx] = (E)current.getData();
      current = current.next();
      idx ++;
    }
    return output;
  }

  @SuppressWarnings("unchecked")
  public String toString(){
    if (length == 0) return "[]";
    String output = "[";
    Node<E> current = start;
    while (current != null){
      output += current.getData() + ", ";
      current = current.next();
    }
    return output.substring(0, output.length() - 2) + "]";
  }
}
