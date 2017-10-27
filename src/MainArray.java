import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) throws Exception {

        ArrayStorage storage = new ArrayStorage(10);

        storage.save(new Summary("1", "1", "1"));
        //storage.saveSummary(new Summary("2", "2", "2"));
        //storage.saveSummary(new Summary("3", "3", "3"));
        System.out.println(storage);
        System.out.println(storage.size());

        System.out.println(storage.get(0));

        storage.delete(0);
        System.out.println(storage);
        System.out.println(storage.size());
        storage.save(new Summary("2", "2", "2"));
        System.out.println(storage);
        System.out.println(storage.size());
        storage.clear();
        System.out.println(storage);
    }
}
