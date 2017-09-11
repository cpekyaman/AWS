package udemy.course.aws.serverless.post;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by raistlin on 8/19/2017.
 */
public class StoreDataHandler implements RequestHandler<RequestClass, ResponseClass> {
    @Override
    public ResponseClass handleRequest(RequestClass input, Context context) {
        String fullName = input.getFirstName() + " " + input.getLastName();
        context.getLogger().log("Input: " + fullName);
        return new ResponseClass(fullName, 37);
    }
}
