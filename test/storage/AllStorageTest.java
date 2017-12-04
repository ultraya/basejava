package storage;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedStorageTest.class,
                ListStorageTest.class,
                MapStorageTest.class,
        }
)
public class AllStorageTest {
}
