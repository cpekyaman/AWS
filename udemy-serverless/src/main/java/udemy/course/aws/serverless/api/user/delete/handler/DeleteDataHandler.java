package udemy.course.aws.serverless.api.user.delete.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import udemy.course.aws.serverless.api.common.request.UserByIdRequest;
import udemy.course.aws.serverless.api.user.delete.model.DeleteDataResponse;
import udemy.course.aws.serverless.core.PersistenceManager;

/**
 * Created by raistlin on 9/13/2017.
 */
public class DeleteDataHandler implements RequestHandler<UserByIdRequest, DeleteDataResponse> {
    private static final Logger LOG = Logger.getLogger(DeleteDataHandler.class);

    @Override
    public DeleteDataResponse handleRequest(UserByIdRequest input, Context context) {
        LOG.info("Received user to delete : " + input.getUserId());

        LOG.info("deleting user from db");
        PersistenceManager.repository().delete(input.getUserId());

        LOG.info("returning response");
        return new DeleteDataResponse("Deleted user " + input.getUserId());
    }
}
