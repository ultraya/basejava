import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) throws Exception {

        ArrayStorage storage = new ArrayStorage(10);

        storage.saveSummary(new Summary("1", "1", "1"));
        //storage.saveSummary(new Summary("2", "2", "2"));
        //storage.saveSummary(new Summary("3", "3", "3"));
        System.out.println(storage);
        System.out.println(storage.getSize());

        System.out.println(storage.getSummary(0));

        storage.deleteSummary(0);
        System.out.println(storage);
        System.out.println(storage.getSize());
        storage.saveSummary(new Summary("2", "2", "2"));
        System.out.println(storage);
        System.out.println(storage.getSize());
        storage.clearStorage();
        System.out.println(storage);
    }
}
