package DatabaseIO;

/**
 * Created by Girish on 09-03-2015.
 */
public interface HashRepository {

    public int addData(byte[] data);
    public boolean present(byte[] data);
    public void removeAll();

}
