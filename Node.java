public class Node<E>{
  private E data;
  private Node<E> next,prev;

  public Node(E val, Node<E> behind, Node<E> ahead){
    data = val;
    next = ahead;
    prev = behind;
  }

  public Node<E> next(){
    return next;
  }

  public Node<E> prev(){
    return prev;
  }

  public void setNext(Node<E> other){
    next = other;
  }

  public void setPrev(Node<E> other){
    prev = other;
  }

  public E getData(){
    return data;
  }

  public E setData(E newVal){
    E output = data;
    data = newVal;
    return output;
  }
}
