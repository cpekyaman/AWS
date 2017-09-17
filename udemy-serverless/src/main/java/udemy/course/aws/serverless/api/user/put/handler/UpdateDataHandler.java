package udemy.course.aws.serverless.api.user.put.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import udemy.course.aws.serverless.api.common.model.CompareDataModel;
import udemy.course.aws.serverless.api.common.response.SavedDataResponse;
import udemy.course.aws.serverless.api.user.put.model.UpdateDataRequest;
import udemy.course.aws.serverless.core.PersistenceManager;
import udemy.course.aws.serverless.domain.CompareData;

/**
 * Created by raistlin on 9/14/2017.
 */
public class UpdateDataHandler implements RequestHandler<UpdateDataRequest, SavedDataResponse> {
    private static final Logger LOG = Logger.getLogger(UpdateDataHandler.class);

    @Override
    public SavedDataResponse handleRequest(UpdateDataRequest input, Context context) {
        LOG.info("Received user data to update : " + input);
        CompareData data = mapRequestToDomain(input);

        LOG.info("updating data in db");
        PersistenceManager.repository().save(data);

        LOG.info("returning response");
        return new SavedDataResponse(data.getUserId(), data.getVersion());
    }

    private CompareData mapRequestToDomain(UpdateDataRequest input) {
        CompareDataModel dataModel = input.getData();
        return new CompareData(input.getUserId(), dataModel.getAge(), dataModel.getHeight(), dataModel.getIncome(), input.getVersion());
    }
}
