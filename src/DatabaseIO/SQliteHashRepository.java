package DatabaseIO;

/**
 * Created by Girish on 09-03-2015.
 */

public class SQliteHashRepository implements HashRepository{
    @Override
    public int addData(byte[] data) {
        return 0;
    }

    @Override
    public boolean present(byte[] data) {
        return false;
    }

    @Override
    public void removeAll() {

    }
}
