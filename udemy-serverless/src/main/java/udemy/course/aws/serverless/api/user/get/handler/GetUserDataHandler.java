package udemy.course.aws.serverless.api.user.get.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import udemy.course.aws.serverless.api.common.request.UserByIdRequest;
import udemy.course.aws.serverless.api.user.get.model.GetUserDataResponse;
import udemy.course.aws.serverless.core.PersistenceManager;

/**
 * Created by raistlin on 9/13/2017.
 */
public class GetUserDataHandler implements RequestHandler<UserByIdRequest, GetUserDataResponse> {
    private static final Logger LOG = Logger.getLogger(GetUserDataHandler.class);

    @Override
    public GetUserDataResponse handleRequest(UserByIdRequest input, Context context) {
        LOG.info("Received request to return info for user : " + input.getUserId());
        return new GetUserDataResponse(PersistenceManager.repository().findOne(input.getUserId()));
    }
}
