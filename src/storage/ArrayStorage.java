package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteAndReplace(int index) {
        storage[index] = storage[size - 1];
    }


    @Override
    protected void insertResume(Resume r, int index) {
        if(size() == MAX_CAPACITY) {
            throw new StorageException(r.getUuid(), "Storage is overflow");
        }
        storage[size] = r;
        size++;
    }

    protected int getIndex(Resume r) {
        for(int i = 0; i < size; i++){
            String uuidCurrent = storage[i].getUuid();
            if(uuidCurrent.equals(r.getUuid())){
                return i;
            }
        }
        return -1;
    }



}
