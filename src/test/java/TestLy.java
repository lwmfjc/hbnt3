import fife.ly.config.ConfigShop;
import fife.ly.dao.ShoesDao;
import fife.ly.entity.Shoes;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestLy {
    @Test
    public void findAll(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ConfigShop.class);
        ShoesDao shoesDao = context.getBean(ShoesDao.class);
        for (Shoes s :
                shoesDao.findAll()) {
            System.out.println(s);
        }
    }
}
