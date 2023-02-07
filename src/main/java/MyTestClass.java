import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentialsProvider;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import io.swagger.client.ApiClient;
import io.swagger.client.api.SellersApi;

public class MyTestClass {

    public static void main(String[] args) {


        AWSAuthenticationCredentials awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
                .accessKeyId("myAccessKeyId")
                .secretKey("mySecretId")
                .region("us-east-1")
                .build();

        AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider=AWSAuthenticationCredentialsProvider.builder()
                .roleArn("myroleARN")
                .roleSessionName("myrolesessioname")
                .build();

        LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
                .clientId("myClientId")
                .clientSecret("myClientSecret")
                .refreshToken("Aztr|...")
                .endpoint("https://api.amazon.com/auth/o2/token")
                .build();

        SellersApi sellersApi = new SellersApi.Builder()
                .awsAuthenticationCredentials(awsAuthenticationCredentials)
                .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
                .awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
                .endpoint("https://sellingpartnerapi-na.amazon.com")
                .build();

        ApiClient x = sellersApi.getApiClient();

        System.out.println(x.getBasePath());
        System.out.println(x.getJSON());
        System.out.println(x.getAuthentications());

        System.out.println(sellersApi);
    }

}
