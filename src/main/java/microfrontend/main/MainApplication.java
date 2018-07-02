package microfrontend.main;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Service;
import io.kubernetes.client.models.V1ServiceList;
import io.kubernetes.client.util.Config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiClient client = Config.defaultClient();
		Configuration.setDefaultApiClient(client);
		CoreV1Api api = new CoreV1Api();
        V1ServiceList list = api.listServiceForAllNamespaces(null,
                null,
                false,
                null,
                null,
                null,
                null,
                null,
                null);

        for(V1Service service : list.getItems()){
            System.out.println(service.getMetadata());
        }

	}
}
