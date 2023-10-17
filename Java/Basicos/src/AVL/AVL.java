package AVL;
import java.util.LinkedList;
import java.util.Queue;

public class AVL<T> {
    private static class Node<E> {
        public E value;
        public String id;
        public int height;
        public Node<E> left;
        public Node<E> right;
        Node(String id, E value) {
            this.value = value;
            this.id = id;
            height = 1;
            left = null;
            right = null;
        }
    }
    private Node<T> raiz;
    private int size;

    public AVL(){
        raiz = null;
        size = 0;
    }
    public AVL(String id, T value){
        raiz = new Node<T>(id, value);
        size = 1;
    }
    private int max(int a,int b){
        if(a>b)return a;
        return b;
    }
    private int getHeight(Node<T> node){
        if(node == null) return 0;
        return node.height;
    }
    private void updateHeight(Node<T> node){
        if(node != null){
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            node.height = 1+ max(leftHeight, rightHeight);
        }
    }
    private int getBalance(Node<T>node){
        if(node ==null)return 0;
        return getHeight(node.left)-getHeight(node.right);
    }
    private Node<T> successorInOrder(Node<T> node){
        Node<T> actualNode = node;
        while(actualNode != null && actualNode.left != null){
            actualNode = actualNode.left;
        }
        return actualNode;
    }
    private Node<T> leftRotation(Node<T> node){
        Node<T> rightNode = node.right;
        Node<T> subNode = rightNode.left;
        rightNode.left = node;
        node.right = subNode;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }
    private Node<T> rightRotation(Node<T> node){
        Node<T> leftNode = node.left;
        Node<T> subNode = leftNode.right;
        leftNode.right = node;
        node.left = subNode;
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }
    private void preOrderAlgorithm(Node<T> node, LinkedList<T> list){
        if(node!=null){
            list.add(node.value);
            preOrderAlgorithm(node.left, list);
            preOrderAlgorithm(node.right, list);
        }
    }
    public LinkedList<T> preOrderRoute(){
        LinkedList<T> list = new LinkedList<>();
        preOrderAlgorithm(raiz, list);
        return list;
    }
    private void inOrderAlgorithm(Node<T> node, LinkedList<T> list){
        if(node!=null){
            inOrderAlgorithm(node.left, list);
            list.add(node.value);
            inOrderAlgorithm(node.right, list);
        }
    }
    public LinkedList<T> inOrderRoute(){
        LinkedList<T> list = new LinkedList<>();
        inOrderAlgorithm(raiz, list);
        return list;
    }
    private void postOrderAlgorithm(Node<T> node, LinkedList<T> list){
        if(node!=null){
            postOrderAlgorithm(node.left, list);
            postOrderAlgorithm(node.right, list);
            list.add(node.value);
        }
    }
    public LinkedList<T> postOrderRoute(){
        LinkedList<T> list = new LinkedList<>();
        postOrderAlgorithm(raiz, list);
        return list;
    }
    private void levelOrderAlgorithm(Node<T> node, LinkedList<T> list) {
        if (node == null) return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<T> newNode = queue.poll();
            list.add(newNode.value);
            if (newNode.left != null) queue.offer(newNode.left);
            if (newNode.right != null) queue.offer(newNode.right);
        }
    }
    public LinkedList<T> levelOrderRoute() {
        LinkedList<T> list = new LinkedList<>();
        levelOrderAlgorithm(raiz, list);
        return list;
    }
    private Node<T> addAlgorithm(Node<T> node,Node<T> newNode){
        if(node == null) return newNode;
        if(node.id.compareTo(newNode.id)>0){
            node.left = addAlgorithm(node.left, newNode);
        }
        else if(node.id.compareTo(newNode.id)<0){
            node.right = addAlgorithm(node.right, newNode);
        }
        else{
            size--;
            return node;
        }
        updateHeight(node);
        int balanceFactor = getBalance(node);
        if(balanceFactor > 1 && node.left.id.compareTo(newNode.id)>0){
            return rightRotation(node);
        }
        else if(balanceFactor < -1 && node.right.id.compareTo(newNode.id)<0){
            return leftRotation(node);
        }
        else if(balanceFactor > 1 && node.left.id.compareTo(newNode.id)<0){
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        else if(balanceFactor < -1 && node.right.id.compareTo(newNode.id)>0){
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }
        return node;
    }
    public void add(String id, T value){
        Node<T> newNode = new Node<T>(id, value);
        size++;
        raiz = addAlgorithm(raiz, newNode);
    }
    private Node<T> searchAlgorithm(Node<T> node,String id){
        if(node==null) return null;
        if(node.id.equals(id)) return node;
        if(node.id.compareTo(id)>0) return searchAlgorithm(node.left, id);
        return searchAlgorithm(node.right, id);
    }
    public T get(String id){
        Node<T> node = searchAlgorithm(raiz, id);
        if(node == null) return null;
        return node.value;
    }
    private Node<T> popAlgorithm(Node<T> node,String id){
        if(node == null){
            size++;
            return node;
        }
        if(node.id.compareTo(id)<0){
            node.right = popAlgorithm(node.right, id);
        }
        else if(node.id.compareTo(id)>0){
            node.left = popAlgorithm(node.left, id);
        }
        else{
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            Node<T> successor = successorInOrder(node.right);
            node.value = successor.value;
            node.id = successor.id;
            node.right = popAlgorithm(node.right, node.id);
        }
        updateHeight(node);
        int balanceFactor = getBalance(node);

        if(balanceFactor >1 && getBalance(node.left)>=0){
            return rightRotation(node);
        }
        else if(balanceFactor <-1 && getBalance(node.right)<=0){
            return leftRotation(node);
        }
        else if(balanceFactor > 1 && getBalance(node.left)<0){
            node.left = rightRotation(node.left);
            return rightRotation(node);
        }
        else if(balanceFactor < -1 && getBalance(node.right)>0){
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }
        return node;
    }

    public void pop(String id){
        size--;
        popAlgorithm(raiz, id);
    }
    public void clear(){
        raiz = null;
        size = 0;
    }
    public int size(){
        return size;
    }
}