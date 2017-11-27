package storage;

import model.Resume;

import java.util.Map;
import java.util.TreeMap;


public class MapStorage extends AbstractStorage {

    Map<String, Resume> storage = new TreeMap<>();

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
        if(storage.containsValue(r)){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    protected void insertResume(Resume r, int index) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getElement(int index, String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void deleteFromStorage(int index, String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume[] getResumeArray(Resume[] result) {
        return storage.values().toArray(result);
    }
}
