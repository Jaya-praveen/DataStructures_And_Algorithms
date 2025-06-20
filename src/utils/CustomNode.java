package utils;

public class CustomNode<E> {

    private E obj;
    private CustomNode<E> next;
    private CustomNode<E> previous;

    public CustomNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(CustomNode<E> previous) {
        this.previous = previous;
    }

    public CustomNode(E obj) {
        this.obj = obj;

    }

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public CustomNode<E> getNext() {
        return next;
    }

    public void setNext(CustomNode<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" +
                obj +
                '}';
    }
}
