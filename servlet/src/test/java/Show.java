import dao.Dao;
import org.junit.Test;

public class Show {
    @Test
    public  void test1(){
        Dao dao = new Dao();
        String pathbyid = dao.findPathbyid(2);
        System.out.println(pathbyid);

    }
}
