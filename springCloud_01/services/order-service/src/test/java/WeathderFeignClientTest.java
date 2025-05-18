import com.njupt.order.OrderApplication;
import com.njupt.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OrderApplication.class)
public class WeathderFeignClientTest {
    @Autowired
    WeatherFeignClient weatherFeignClient;
    @Test
    public void test() {
        String result=weatherFeignClient.aliCityWeather(
                "1045",
                "50b53ff8dd7d9fa320d3d3ca32cf8ed1",
                "APPCODE 93b7e19861a24c519a7548b17dc16d75"
        );
        System.out.println(result);
    }
}
