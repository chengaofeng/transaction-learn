package test;


import com.chengf.transaction.multidb.TransactionMultiDbApp;
import com.chengf.transaction.multidb.domain.Department;
import com.chengf.transaction.multidb.domain.User;
import com.chengf.transaction.multidb.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chengaofeng
 * @date 2020年10月13日 下午12:01
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionMultiDbApp.class)
public class TransactionTest {

    @Autowired
    DbService dbService;

    @Test
    public void test() {

        User user = new User();

        user.setName("cc");
        user.setAge(20);

        Department department = new Department();

        department.setName("dd");

        department.setId("1");
        dbService.commit(user,department);


    }

}
