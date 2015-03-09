package DatabaseIO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Girish on 09-03-2015.
 */
public class SetHashRepository implements HashRepository{

    private Set<String> setRepo;

    public SetHashRepository(){
        setRepo = new HashSet<String>(10,20);
    }


    @Override
    public int addData(byte[] data) {
        setRepo.add(new String(data));
        return 1;

    }

    @Override
    public String toString() {
        return setRepo.toString();
    }

    @Override
    public boolean present(byte[] data) {
        return setRepo.contains(new String(data));
    }

    @Override
    public void removeAll() {
        setRepo.removeAll(setRepo);

    }
}
