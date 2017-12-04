package storage;

import model.Resume;

import java.util.Arrays;
import java.util.List;

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
    protected void deleteFromStorage(Object searchKey) {
        deleteAndReplace(searchKey);
        storage[size - 1] = null;
        size--;
    }

    protected Resume getResumeFromStorage(Object searchKey){
        return storage[(Integer) searchKey];
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    @Override
    protected List<Resume> getCopyResumeList() {
        List<Resume> copyStorage =Arrays.asList(Arrays.copyOfRange(storage, 0, size));
        return copyStorage;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >=0;
    }

    protected abstract void deleteAndReplace(Object searchKey);
}
