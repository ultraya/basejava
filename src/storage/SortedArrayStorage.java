package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteAndReplace(int index) {
        System.arraycopy(storage, index+1, storage, index, size - (index + 1));
    }

    @Override
    protected void insertResume(Resume r, int index) {
        if(size() == MAX_CAPACITY) {
            throw new StorageException(r.getUuid(), "Storage is overflow");
        }

        index = (index * -1) -1;

        System.arraycopy(storage, index, storage,index +1, size - index);

        storage[index] = r;
        size++;

    }

    @Override
    protected int getIndex(Resume r) {

        return Arrays.binarySearch(storage, 0, size, r);
    }
}
