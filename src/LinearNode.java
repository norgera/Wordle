/**
 * LinearNode represents a node in a linked list.
 */
public class LinearNode<E> {
    private LinearNode<E> next;
    private E element;
    
    // Creates an empty node.
    public LinearNode() {
        next = null;
        element = null;
    }
    
    // Creates a node with the given element.
    public LinearNode(E elem) {
        next = null;
        element = elem;
    }
    
    // Gets the next node.
    public LinearNode<E> getNext() {
        return next;
    }
    
    // Sets the next node.
    public void setNext(LinearNode<E> node) {
        next = node;
    }
    
    // Gets the element stored in the node.
    public E getElement() {
        return element;
    }
    
    // Sets the element stored in the node.
    public void setElement(E elem) {
        element = elem;
    }
}
