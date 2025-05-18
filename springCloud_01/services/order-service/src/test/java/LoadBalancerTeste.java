import com.alibaba.nacos.shaded.io.grpc.LoadBalancer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalancerTeste {

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Test
    public void test01(){
        String serviceName="product-service";
        ServiceInstance instance1=loadBalancer.choose("product-service");
        System.out.println(instance1.getHost()+":"+instance1.getPort());
    }



}
