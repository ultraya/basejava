package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage{

    protected static final int MAX_CAPACITY = 10000;
    protected int size = 0;
    protected Resume[] storage = new Resume[MAX_CAPACITY];




    public void clear(){

        Arrays.fill(storage, 0, size, null);
        size = 0;

    }

    public int size() {
        return size;
    }


    @Override
    protected void deleteFromStorage(int index, String uuid) {
        deleteAndReplace(index);
        storage[size - 1] = null;
        size--;
    }

    protected boolean isEmpty(){
        if(size == 0){
            System.out.println("Storage is empty");
            return true;
        }
        return false;
    }
    protected Resume getElement(int index, String uuid){
        return storage[index];
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage[index] = r;
    }

    @Override
    protected Resume[] getResumeArray(Resume[] result) {
        System.arraycopy(storage, 0, result, 0, size);
        return result;
    }

    protected abstract void deleteAndReplace(int index);
}
