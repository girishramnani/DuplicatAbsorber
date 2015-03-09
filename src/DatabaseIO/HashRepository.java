package DatabaseIO;

public interface HashRepository {
/**
*  Interface required to be implemented by all the repositories, eg- Hashset , H2 database , redis , simpleFile
* */
    public int addData(byte[] data);
    public boolean present(byte[] data);
    public void removeAll();

}
