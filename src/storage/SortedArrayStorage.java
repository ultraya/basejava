package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR
            = Comparator.comparing(Resume::getUuid);

    @Override
    protected void deleteAndReplace(Object searchKey) {

        System.arraycopy(storage, (Integer) searchKey +1,
                storage, (Integer) searchKey, size - ((Integer) searchKey + 1));
    }

    @Override
    protected void insertResume(Resume r, Object searchKey) {
        if(size() == MAX_CAPACITY) {
            throw new StorageException(r.getUuid(), "Storage is overflow");
        }
        Integer key = (Integer) searchKey;
        key = (key * -1) -1;

        System.arraycopy(storage, key, storage, key +1, size - key);

        storage[key] = r;
        size++;

    }

    @Override
    protected Object getSearchKey(String uuid) {

        Resume searchKey = new Resume(uuid, "dummy");

        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
