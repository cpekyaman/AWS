package udemy.course.aws.serverless.repository.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.apache.log4j.Logger;
import udemy.course.aws.serverless.domain.CompareData;
import udemy.course.aws.serverless.repository.CompareDataRepository;

import java.util.List;

/**
 * Created by raistlin on 9/14/2017.
 */
public class CompareDataDynamoDBImpl implements CompareDataRepository {
    private static final Logger LOG = Logger.getLogger(CompareDataRepository.class);

    private final DynamoDBMapper mapper;

    public CompareDataDynamoDBImpl(DynamoDBMapper mapper) {
        LOG.info("requesting a mapper from PersistenceManager");
        this.mapper = mapper;
    }

    @Override
    public List<CompareData> findAll() {
        LOG.info("findAll scan");
        return mapper.scan(CompareData.class, new DynamoDBScanExpression().withLimit(25));
    }

    @Override
    public CompareData findOne(String userId) {
        LOG.info("findOne load");
        return mapper.load(CompareData.class, userId);
    }

    @Override
    public void save(CompareData data) {
        LOG.info("saving data ...");
        mapper.save(data);
        LOG.info("data saved");
    }

    @Override
    public void delete(String userId) {
        LOG.info("deleting " + userId);
        CompareData existing = findOne(userId);
        if(existing != null) {
            LOG.info("existing user found for " + userId);
            mapper.delete(existing);
        } else {
            LOG.warn("existing user not found for " + userId);
        }
    }
}
