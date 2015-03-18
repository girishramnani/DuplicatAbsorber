package Model;

public interface HashRepository {
/**
*  Interface required to be implemented by all the repositories, eg- Hashset , H2 database , redis , simpleFile
* */
    public int addData(String data);
    public boolean present(String data);
    public void removeAll();

}
