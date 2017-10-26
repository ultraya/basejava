import java.util.Arrays;


public class ArrayStorage {

    private int capacity;
    private int size = 0;
    private Summary[] summaries;

    public ArrayStorage() {
        this.capacity = 10000;
        this.summaries = new Summary[capacity];
    }

    public ArrayStorage(int capacity) {
        this.capacity = capacity;
        this.summaries = new Summary[capacity];
    }

    public void clearStorage(){
        if(size == 0){
            return;
        }
        summaries = new Summary[capacity];
        size = 0;

    }

    public Summary getSummary(int index) throws Exception {
        if(index >= size || index < 0){
            throw new Exception("IndexOutOfBounds");
        }
        return summaries[index];
    }
    public void saveSummary(Summary summary) throws Exception {
        if(size == capacity){
            throw new Exception("sizeOufOfCapacity");
        }
        summaries[size++] = summary;
    }
    public void deleteSummary(int index) throws Exception {
        if(index >= size || index < 0){
            throw new Exception("IndexOutOfBounds");
        }
        if(size == 0){
            return;
        }
        summaries[index] = null;
        Summary[] newSummaries = new Summary[capacity];
        System.arraycopy(summaries,0, newSummaries, 0, index);
        System.arraycopy(summaries, index +1, newSummaries, index, size - (index + 1) );
        summaries = newSummaries;

        size--;
    }

    public Summary[] getAllSummaries() {
        return summaries;
    }
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(summaries);
    }
}
