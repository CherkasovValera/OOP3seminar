import java.util.Iterator;

public class LinkedCase <N> implements LinkedL<N>, Iterable<N>, DescendingIt<N>{
    private Node<N> fNode;
    private Node<N> lNode;
    private int size = 0;
    public  LinkedCase(){
        lNode = new Node<N>(null,fNode,null);
        fNode = new Node<N>(null,null,lNode);
    }

    @Override
    public void addLast(N n) {
        Node<N> prev = lNode;
        prev.setPresentNumber(n);
        lNode = new Node<N>(null,prev,null);
        prev.setNextNumber(lNode);
        size++;
    }

    @Override
    public void addFirst(N n) {
        Node<N> next = fNode;
        next.setPresentNumber(n);
        fNode = new Node<N>(null,null,next);
        next.setPrevNumber(fNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public N getNumberByIndex(int cont) {
        Node<N> target = fNode.getNextNumber();
        for (int i = 0;i<cont; i++){
            target = getNextNumber(target);
        }
        return target.presentNumber;
    }
    private Node<N> getNextNumber(Node<N>present){
        return present.getNextNumber();
    }

    @Override
    public Iterator<N> iterator() {
        return new Iterator<N>() {
            int counter =0;
            @Override
            public boolean hasNext() {
                return counter<size;
            }

            @Override
            public N next() {
                return getNumberByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<N> descendingIt() {
        return new Iterator<N>() {
            int counter = size-1;
            @Override
            public boolean hasNext() {
                return counter>=0;
            }

            @Override
            public N next() {
                return getNumberByIndex(counter--);
            }
        };
    }

    private class Node <N>{
        private N presentNumber;
        private Node<N> nextNumber;
        private Node<N> prevNumber;
        private Node(N presentNumber, Node<N> prevNumber,Node<N> nextNumber){
            this.presentNumber = presentNumber;
            this.nextNumber = nextNumber;
            this.prevNumber = prevNumber;
        }
        public N getPresentNumber(){
            return presentNumber;
        }
        public Node<N> getNextNumber() {
            return nextNumber;
        }

        public void setPresentNumber(N presentNumber) {
            this.presentNumber = presentNumber;
        }

        public void setNextNumber(Node<N> nextNumber) {
            this.nextNumber = nextNumber;
        }

        public void setPrevNumber(Node<N> prevNumber) {
            this.prevNumber = prevNumber;
        }
    }

}
