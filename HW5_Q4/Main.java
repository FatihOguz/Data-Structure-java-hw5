import jdk.swing.interop.SwingInterOpUtils;

/**
 * testing MaxHeap metods
 */
public class Main {
    public static void main(String[] args){

        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(new MaxHeap.AgeData<>(26));
        maxHeap.add(new MaxHeap.AgeData<>(6));
        maxHeap.add(new MaxHeap.AgeData<>(18));
        maxHeap.add(new MaxHeap.AgeData<>(20));
        maxHeap.add(new MaxHeap.AgeData<>(28));
        maxHeap.add(new MaxHeap.AgeData<>(39));
        maxHeap.add(new MaxHeap.AgeData<>(66));
        System.out.println(maxHeap);
        maxHeap.add(new MaxHeap.AgeData<>(39));
        System.out.println(maxHeap);
        maxHeap.add(new MaxHeap.AgeData<>(37));
        maxHeap.add(new MaxHeap.AgeData<>(29));
        maxHeap.add(new MaxHeap.AgeData<>(76));
        maxHeap.add(new MaxHeap.AgeData<>(32));
        maxHeap.add(new MaxHeap.AgeData<>(74));
        maxHeap.add(new MaxHeap.AgeData<>(89));
        maxHeap.add(new MaxHeap.AgeData<>(8));
        maxHeap.add(new MaxHeap.AgeData<>(74));
        maxHeap.add(new MaxHeap.AgeData<>(89));
        maxHeap.add(new MaxHeap.AgeData<>(8));
        maxHeap.add(new MaxHeap.AgeData<>(0,89));
        System.out.println(maxHeap);
        System.out.println("youngerThan(29) --> " + maxHeap.youngerThan(29));
        System.out.println("olderThan(32) --> " + maxHeap.olderThan(32));
        System.out.println("find(37) --> " + maxHeap.find(new MaxHeap.AgeData<>(37)));
        System.out.println("find(0) --> " + maxHeap.find(new MaxHeap.AgeData<>(0)));
        maxHeap.remove();
        System.out.println(maxHeap);
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        System.out.println(maxHeap);
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        System.out.println("remove all AgeData");
        System.out.println(maxHeap);
        maxHeap.add(new MaxHeap.AgeData<>(10));
        maxHeap.add(new MaxHeap.AgeData<>(5));
        maxHeap.add(new MaxHeap.AgeData<>(70));
        maxHeap.add(new MaxHeap.AgeData<>(10));
        maxHeap.add(new MaxHeap.AgeData<>(50));
        maxHeap.add(new MaxHeap.AgeData<>(50));
        maxHeap.add(new MaxHeap.AgeData<>(50));
        maxHeap.add(new MaxHeap.AgeData<>(5));
        maxHeap.add(new MaxHeap.AgeData<>(15));
        System.out.println(maxHeap);
        System.out.println("youngerThan(70) --> " + maxHeap.youngerThan(70));
        System.out.println("olderThan(50) --> " + maxHeap.olderThan(50) );
        System.out.println(maxHeap);
        System.out.println("remove");
        maxHeap.remove();
        System.out.println(maxHeap);


    }
}
