package storage;

import model.Resume;

import java.util.*;


public class MapStorage extends AbstractStorage {

    Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey((String) searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void insertResume(Resume r, Object searchKey) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResumeFromStorage(Object searchKey) {
        return storage.get((String)searchKey);
    }

    @Override
    protected void deleteFromStorage(Object searchKey) {
        storage.remove((String)searchKey);
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected List<Resume> getCopyResumeList() {
        return new ArrayList<>(storage.values());
    }
}
