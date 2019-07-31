import com.modest.service.impl.CategoryServiceImpl;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;

import java.util.Objects;

/**
 * description
 *
 * @author modest
 * @date 2019/07/31
 */
public class CategoryTest {

    @Test
    public void test() {
        CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));

        //通过缓存文件中的标识名称来获取缓存对象
        Cache cache = cacheManager.getCache("categoryCache");

        Element element = cache.get("cList");
        System.out.println(Objects.isNull(element));
    }
}
