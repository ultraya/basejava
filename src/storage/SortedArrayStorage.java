package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteAndReplace(int index) {
        System.arraycopy(storage, index+1, storage, index, size - (index + 1));
    }

    @Override
    protected void insertResume(Resume resume, int index) {
        index = (index * -1) -1;

        System.arraycopy(storage, index, storage,index +1, size - index);

        storage[index] = resume;

    }

    @Override
    protected int getIndex(String uuid) {

        Resume keySearch = new Resume();
        keySearch.setUuid(uuid);

        return Arrays.binarySearch(storage, 0, size, keySearch);
    }
}
