package storage;


import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {


    private List<Resume> storage = new ArrayList<>();


    @Override
    protected void deleteFromStorage(int index, String uuid) {
        storage.remove(index);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int getIndex(Resume r) {
        return storage.indexOf(r);
    }

    @Override
    protected void insertResume(Resume r, int index) {
        storage.add(r);
    }

    @Override
    protected Resume getElement(int index, String uuid) {
        return storage.get(index);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.set(index, r);
    }

    @Override
    protected Resume[] getResumeArray(Resume[] result) {
        return storage.toArray(result);
    }


}
