package storage;


import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {


    private List<Resume> storage = new ArrayList<>();


    @Override
    protected void deleteFromStorage(Object searchKey) {
        storage.remove(((Integer)searchKey).intValue());
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
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {

        for(Resume r: storage){
            if(r.getUuid().compareTo(uuid) == 0){
                return storage.indexOf(r);
            }
        }
        return null;
    }

    @Override
    protected void insertResume(Resume r, Object searchKey) {
        //param: searchKey always = null
        storage.add(r);
    }

    @Override
    protected Resume getResumeFromStorage(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        storage.set((Integer) searchKey, r);
    }

    @Override
    protected List<Resume> getCopyResumeList() {

        return new ArrayList<>(storage);
    }


}
