package storage;

import exception.StorageException;
import model.Resume;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteAndReplace(Object searchKey) {
        //add last element to deleted element
        storage[(Integer) searchKey] = storage[size - 1];
    }


    @Override
    protected void insertResume(Resume r, Object searchKey) {
        if(size() == MAX_CAPACITY) {
            throw new StorageException(r.getUuid(), "Storage is overflow");
        }
        storage[size] = r;
        size++;
    }

    protected Object getSearchKey(String uuid) {
        for(int i = 0; i < size; i++){
            String uuidCurrent = storage[i].getUuid();
            if(uuidCurrent.equals(uuid)){
                return i;
            }
        }
        return -1;
    }



}
