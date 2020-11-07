/**
 * Serializable interface
 */

import java.io.Serializable;
/**
 *  ArrayList interface
 */
import java.util.ArrayList;
/**
 * Comparator interface
 */
import java.util.Comparator;

/**
 * this class has an inner class(AgeData)
 * heap of key number of people of that ages
 * @param <E> is generic
 */
public class MaxHeap<E> {
    /**
     * AgeData class is inner class
     * and implements Comparator for compare method
     * @param <E> is generic
     */
    protected static class AgeData<E> implements Comparator {
        /**
         * age
         */
        protected E data;
        /**
         * number of people of that age
         */
        protected int numberOfPeople=1;

        /**
         * no parameter constructor
         */
        public AgeData(){

        }

        /**
         * getter metod for number of people
         * @return number of people of AgeData
         */
        public int getNumberOfPeople() {
            return numberOfPeople;
        }
        /**
         * getter metod for data
         * @return data of AgeData
         */
        public E getData() {
            return data;
        }

        /**
         * update age
         * @param data is age
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * update number of peopşe
         * @param numberOfPeople is number of people of that age
         */
        public void setNumberOfPeople(int numberOfPeople) {
            this.numberOfPeople = numberOfPeople;
        }

        /**
         * constructor
         * @param data is age
         */

        public AgeData(E data){
            this.data=data;

        }

        /**
         * constructor
         * @param data is age
         * @param size is number of people
         */
        public AgeData(E data,int size){
            this.data=data;
            this.numberOfPeople=size;

        }

        /**
         * compare to data of item and AgeData
         * @param item is generic ,specificly age
          * @return boolean
         */
        public boolean compareTo(E item){
            if(data == item){
                return true;
            }
            else{
                return false;
            }
        }

        /**
         * show age and number of people of age
         * @return string
         */
        public String toString(){
            return data.toString() + " " + numberOfPeople;
        }

        /**
         * compare two Object
         * @param o1 object1
         * @param o2 object2
         * @return if equal 0,> 1 ,< -1
         */
        @Override
        public int compare(Object o1, Object o2) {
            AgeData<E> s1=(AgeData<E>) o1;
            AgeData<E> s2=(AgeData<E>)o2;

            if(s1.data==s2.data)
                return 0;
            else if((Integer)s1.data > (Integer)s2.data)
                return 1;
            else
                return -1;
        }


    }


    /**
     * Heap arrayList
     */
    private ArrayList<AgeData<E>> maxHeap = new ArrayList<AgeData<E>>();

    /**
     * no paramter constructor
     */
    public MaxHeap(){

    }

    /**
     * find out which index of the given AgeData
     * @param item is AgeData
     * @return integer index
     */
    public int findIndex(AgeData item){
        for(int i = 0 ; i< maxHeap.size();i++)
        {
            if((item.data.equals(maxHeap.get(i).data))){
                return i;
            }
        }
        return -1;
    }

    /**
     * If there is agedata item, it increases 1 numberOfPeople, otherwise it creates AgeData item
     * @param item is AgeData
     * @return AgeData
     */
    public AgeData add(AgeData<E> item){
        AgeData<E> check = find(item);
        if(check!=null){
          check.numberOfPeople++;
            int child = findIndex(item);
            int parent = (child-1)/2;
            int childPeople = -1;
            int parentPeople = -1;
            if((child>=0) && (parent>=0)){
                childPeople = maxHeap.get(child).numberOfPeople;
                parentPeople=maxHeap.get(parent).numberOfPeople;
            }

            while((parent>=0) && (parentPeople<childPeople)) {
                AgeData<E> temp = new AgeData<>();
                temp.setData((E) maxHeap.get(child).getData());
                temp.setNumberOfPeople((Integer) maxHeap.get(child).getNumberOfPeople());

                maxHeap.get(child).setData(maxHeap.get(parent).getData());
                maxHeap.get(child).setNumberOfPeople(maxHeap.get(parent).getNumberOfPeople());
                maxHeap.get(parent).setNumberOfPeople(temp.getNumberOfPeople());
                maxHeap.get(parent).setData(temp.getData());

                child = parent;
                parent = (child - 1) / 2;


                if ((child >= 0 )&& (parent >= 0)) {
                    childPeople = maxHeap.get(child).numberOfPeople;
                    parentPeople = maxHeap.get(parent).numberOfPeople;
                }
            }
            return check;
        }
        else{
            maxHeap.add(item);
            int child = maxHeap.size()-1;
            int parent = (child-1)/2;
            int childPeople = -1;
            int parentPeople = -1;
            if(child>=0 && parent>=0){
                childPeople = maxHeap.get(child).numberOfPeople;
                parentPeople=maxHeap.get(parent).numberOfPeople;
            }
            while((parent>=0) && (parentPeople<childPeople)){
                AgeData<E> temp = new AgeData<>();
                temp.setData((E) maxHeap.get(child).getData());
                temp.setNumberOfPeople((Integer) maxHeap.get(child).getNumberOfPeople());
                maxHeap.get(child).setData(maxHeap.get(parent).getData());
                maxHeap.get(child).setNumberOfPeople(maxHeap.get(parent).getNumberOfPeople());
                maxHeap.get(parent).setNumberOfPeople(temp.getNumberOfPeople());
                maxHeap.get(parent).setData(temp.getData());
                child=parent;
                parent=(child-1)/2;
                if(child>=0 && parent>=0){
                    childPeople = maxHeap.get(child).numberOfPeople;
                    parentPeople=maxHeap.get(parent).numberOfPeople;
                }
            }
            return maxHeap.get(parent);
        }
    }

    /**
     * search AgeData target,if find return target
     * @param target is AgeData
     * @return target
     */
    public AgeData<E> find(AgeData<E> target){

        for(int i  = 0 ; i< maxHeap.size();i++){

            if(target.data.equals(maxHeap.get(i).data)){
                return  maxHeap.get(i);
            }
        }
        return null;
    }


    /**
     * In removing elements from a heap, we must always remove and save the element at the top
     * of the heap, which is the smallest element
     * then fix heap
     * @return AgeData
     */
    public AgeData<E> remove(){
        if(maxHeap.size()==1){
            maxHeap.remove(0);
            return null;
        }
        else if(maxHeap.size()==0){
            return null;
        }
        else{
            AgeData<E> temp = new AgeData<>();
            temp.setNumberOfPeople(maxHeap.get(maxHeap.size()-1).getNumberOfPeople());
            temp.setData(maxHeap.get(maxHeap.size()-1).getData());
            maxHeap.remove(maxHeap.size()-1);
            maxHeap.get(0).setData(temp.getData());
            maxHeap.get(0).setNumberOfPeople(temp.getNumberOfPeople());
            int parent = 0;
            int leftChild=0;
            int rightChild = 0;
            int maxChild=0;
            while(parent<maxHeap.size()){
                leftChild = (2*parent)+1;
                rightChild = leftChild+1;
                if(leftChild>=maxHeap.size()){
                    break;
                }
                maxChild=leftChild;
                if((rightChild<maxHeap.size()) && ((Integer)maxHeap.get(rightChild).getNumberOfPeople()>(Integer)maxHeap.get(leftChild).getNumberOfPeople())){
                    maxChild=rightChild;
                }
                if(maxHeap.get(parent).getNumberOfPeople()<maxHeap.get(maxChild).getNumberOfPeople()){
                    AgeData<E> tempLocal = new AgeData<>();
                    tempLocal.setData(maxHeap.get(parent).getData());
                    tempLocal.setNumberOfPeople((maxHeap.get(parent).getNumberOfPeople()));
                    maxHeap.get(parent).setNumberOfPeople(maxHeap.get(maxChild).getNumberOfPeople());
                    maxHeap.get(parent).setData(maxHeap.get(maxChild).getData());
                    maxHeap.get(maxChild).setData(tempLocal.getData());
                    maxHeap.get(maxChild).setNumberOfPeople(tempLocal.getNumberOfPeople());

                }
                else{
                    parent++;
                }
            }
            return temp;
        }
    }

    /**
     * number of minors from item
     * @param item is age
     * @return integer --> number of minors from item
     */
    public int youngerThan(E item){
        AgeData<E> target = new AgeData<>();
        target.setData(item);
        return youngerThan(target);
    }

    /**
     * helping metod youngerThan(item)
     * @param item is age
     * @return  integer --> number of minors from item
     */
    private int youngerThan(AgeData<E> item){
        int res = 0  ;
            for(int i = 0 ; i< maxHeap.size();i++)
            {
                if(compare(item,maxHeap.get(i))>0){
                    res = res + maxHeap.get(i).getNumberOfPeople();
                }
            }
            return res;
    }

    /**
     * number of adults from item
     * @param item is age
     * @return integer --> number of adults from item
     */
    public int olderThan(E item){
        AgeData<E> target = new AgeData<>();
        target.setData(item);
        return olderThan(target);
    }

    /**
     * helping metod for olderThan(E item) metod
     * number of adults from item
     * @param item is age
     * @return integer --> number of adults from item
     */
    private int olderThan(AgeData<E> item){
        int res = 0  ;
        for(int i = 0 ; i< maxHeap.size();i++)
        {
            if(compare(item,maxHeap.get(i))<0){
                res = res + maxHeap.get(i).getNumberOfPeople();
            }
        }
        return res;
    }

    /**
     * compare two AgeData
     * @param item is object1
     * @param eAgeData is object2
     * @return integer(== 0, > 1, < -1)
     */
    private int compare(AgeData<E> item, AgeData<E> eAgeData) {
        AgeData<E> s1=(AgeData<E>) item;
        AgeData<E> s2=(AgeData<E>) eAgeData;

        if(s1.data==s2.data)
            return 0;
        else if((Integer)s1.data > (Integer)s2.data)
            return 1;
        else
            return -1;
    }

    /**
     * show heap
     * @return string --> heap
     */
    @Override
    public String toString() {
      String res ="MaxHeap--->\n";
      for(int i = 0 ; i< maxHeap.size();i++){
          res = res + " " + maxHeap.get(i).data + " " + maxHeap.get(i).numberOfPeople+"\n";
      }
           return res ;
    }



}
