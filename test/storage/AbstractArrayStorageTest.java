package storage;

import exception.ExistResumeStorage;
import exception.NotExistResumeStorage;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {

    private static final String UUID_1 = "UUID_1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "UUID_2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "UUID_3";
    public static final Resume RESUME_3 = new Resume(UUID_3);


    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }


    @Before
    public void setUp(){
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void save() throws Exception {
        Resume saveResume = new Resume();
        storage.save(saveResume);
        assertSize(4);
        Assert.assertSame(saveResume, storage.get(saveResume.getUuid()));

    }

    @Test
    public void update() throws Exception {
        Resume updateResume = new Resume(UUID_2);
        storage.update(updateResume);
        assertSize(3);
        Assert.assertSame(updateResume, storage.get(updateResume.getUuid()));

    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_2);
        storage.get(UUID_3);
    }

    @Test
    public void clear() throws Exception { storage.clear();
       assertSize(0);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void get() throws Exception {
        Resume resume = storage.get(UUID_3);
        Assert.assertSame(RESUME_3, resume);
    }

    @Test
    public void getAll() throws Exception {
        Resume[] all = storage.getAll();
        assertSize(all.length);
        Assert.assertSame(RESUME_1, all[0]);
        Assert.assertSame(RESUME_2, all[1]);
        Assert.assertSame(RESUME_3, all[2]);

    }

    @Test(expected = NotExistResumeStorage.class)
    public void getNotExist(){
        storage.get("notexist");
    }


    @Test(expected = ExistResumeStorage.class)
    public void saveExist(){
        storage.save(RESUME_1);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow(){
        try {
            for (int i = 3; i < AbstractArrayStorage.MAX_CAPACITY; i++) {
                storage.save(new Resume());
            }
        }catch (StorageException e){
            Assert.fail();
        }
        storage.save(new Resume());

    }

    @Test(expected = NotExistResumeStorage.class)
    public void updateNotExist(){
        storage.update(new Resume());
    }

    @Test(expected = NotExistResumeStorage.class)
    public void deleteNotExist(){
        storage.delete("dummy");
    }

    private void assertSize(int size){
        Assert.assertEquals(size, storage.size());
    }
}