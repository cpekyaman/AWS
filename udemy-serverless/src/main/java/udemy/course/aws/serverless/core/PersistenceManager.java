package udemy.course.aws.serverless.core;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.apache.log4j.Logger;
import udemy.course.aws.serverless.repository.CompareDataRepository;
import udemy.course.aws.serverless.repository.impl.CompareDataDynamoDBImpl;

/**
 * Created by raistlin on 9/13/2017.
 */
public class PersistenceManager {
    private static final Logger LOG = Logger.getLogger(PersistenceManager.class);

    private static final AmazonDynamoDB db;
    private static final DynamoDBMapper mapper;
    private static final CompareDataRepository repository;

    static {
        db = createDynamoDB();
        mapper = createDynamoDBMapper();
        repository = createRepository();
    }

    private static AmazonDynamoDB createDynamoDB() {
        LOG.info("Creating DynamoDB configuration");
        ClientConfiguration config = new ClientConfiguration()
                .withMaxConnections(5)
                .withConnectionTimeout(5000)
                .withClientExecutionTimeout(6000)
                .withRequestTimeout(3000)
                .withConnectionMaxIdleMillis(600000)
                .withMaxErrorRetry(2);

        LOG.info("Building DynamoDB");
        return AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).withClientConfiguration(config).build();
    }

    private static DynamoDBMapper createDynamoDBMapper() {
        LOG.info("Creating DynamoDBMapper");
        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES)
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.EVENTUAL)
                .build();
        return new DynamoDBMapper(db, config);
    }

    private static CompareDataRepository createRepository() {
        LOG.info("Creating repository");
        return new CompareDataDynamoDBImpl(mapper);
    }

    public static CompareDataRepository repository() {
        return repository;
    }
}
