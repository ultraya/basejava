package storage;

import exception.ExistResumeStorage;
import exception.NotExistResumeStorage;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AbstractStorageTest {

    private static final String UUID_1 = "UUID_1";
    private static final Resume RESUME_1 = new Resume(UUID_1, "AAA BBB CCC");


    private static final String UUID_2 = "UUID_2";
    private static final Resume RESUME_2 = new Resume(UUID_2, "BBB AAA CCC");

    private static final String UUID_3 = "UUID_3";
    public static final Resume RESUME_3 = new Resume(UUID_3, "BBB CCC AAA");


    protected Storage storage;

    public AbstractStorageTest(Storage storage) {
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
        Resume saveResume = new Resume("1","NewName");
        storage.save(saveResume);
        assertSize(4);
        Assert.assertSame(saveResume, storage.get(saveResume.getUuid()));

    }

    @Test
    public void update() throws Exception {
        Resume updateResume = new Resume(UUID_2, "NewName");
        storage.update(updateResume);
        assertSize(3);
        Assert.assertTrue(updateResume == storage.get(UUID_2));

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
    public void getAllSorted() throws Exception {
        List<Resume> allSorted = storage.getAllSorted();
        assertSize(allSorted.size());
        Assert.assertSame(RESUME_1, allSorted.get(0));
        Assert.assertSame(RESUME_2, allSorted.get(1));
        Assert.assertSame(RESUME_3, allSorted.get(2));

    }

    @Test(expected = NotExistResumeStorage.class)
    public void getNotExist(){
        storage.get("notexist");
    }


    @Test(expected = ExistResumeStorage.class)
    public void saveExist(){
        storage.save(RESUME_1);
    }


    @Test(expected = NotExistResumeStorage.class)
    public void updateNotExist(){
        storage.update(new Resume("Name"));
    }

    @Test(expected = NotExistResumeStorage.class)
    public void deleteNotExist(){
        storage.delete("dummy");
    }

    private void assertSize(int size){
        Assert.assertEquals(size, storage.size());
    }
}