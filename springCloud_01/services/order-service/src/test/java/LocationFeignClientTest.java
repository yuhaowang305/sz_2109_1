import com.njupt.order.OrderApplication;
import com.njupt.order.feign.LocationFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootTest(classes = OrderApplication.class)
public class LocationFeignClientTest {
    @Autowired
    LocationFeignClient locationFeignClient;
    @Test
    public void test() {
        try {
            String ip=
                    InetAddress.getLocalHost().getHostAddress();
            String result=
                    locationFeignClient.getLocation("112.36.236.188","APPCODE 513b2bdd6fc041a59654ff76c55122a5");
            System.out.println(result);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
