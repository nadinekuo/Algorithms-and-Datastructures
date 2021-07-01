public class CloneSLL {

    // The nodes of the cloned list are new, while the elements are the same. This means that
    //   replacing the nodes or the elements of the cloned list does not have an eect on the original list
    //   (note that the element objects are the same, but the references of the nodes to the element objects
    //   are independent), while changing instance fields of an element will change in the original element as well

//    public ObjectSLList clone() throws CloneNotSupportedException {
//
//        ObjectSLList other = (ObjectSLList) super.clone();
//        if (size > 0) {
//            other.head = new Node<>(head.getElement(), null);
//            Node<E> walk = head.getNext();
//            Node<E> otherTail = other.head;
//            while (walk != null) {
//                Node<E> newest = new Node<>(walk.getElement(), null);
//                otherTail.setNext(newest);
//                otherTail = newest;
//                walk = walk.getNext();
//            }
//        }
//        return other;
//    }

}
