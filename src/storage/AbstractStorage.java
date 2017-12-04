package storage;


import exception.ExistResumeStorage;
import exception.NotExistResumeStorage;
import model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {


    public Resume get(String uuid){

        Object searchKey = getExistedSearchKey(uuid);
        return getResumeFromStorage(searchKey);
    }


    public void save(Resume r){
        Object searchKey = getSearchKey(r.getUuid());
        if(isExist(searchKey)){
            throw new ExistResumeStorage(r.getUuid(), "Resume already exist");
        }else{
            insertResume(r, searchKey);
        }

    }


    public void delete(String uuid){

        Object searchKey = getExistedSearchKey(uuid);
        deleteFromStorage(searchKey);
    }

    public void update(Resume r){
        Object searchKey = getExistedSearchKey(r.getUuid());

        updateResume(r, searchKey);

    }

    public List<Resume> getAllSorted(){
        List<Resume> list = getCopyResumeList();
        Collections.sort(list);
        return list;
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if(!isExist(searchKey)) {
            throw new NotExistResumeStorage(uuid, "Resume notFound");
        }
        return searchKey;
    }

    protected abstract boolean isExist(Object searchKey);

    protected abstract Object getSearchKey(String uuid);
    protected abstract void insertResume(Resume r, Object searchKey);
    protected abstract Resume getResumeFromStorage(Object searchKey);
    protected abstract void deleteFromStorage(Object searchKey);
    protected abstract void updateResume(Resume r, Object searchKey);
    protected abstract List<Resume> getCopyResumeList();
}
