package udemy.course.aws.serverless.assignment2;

/**
 * Created by raistlin on 9/12/2017.
 */
public class ApiResponse {
    private Integer outputIncome;

    public ApiResponse(Integer outputIncome) {
        this.outputIncome = outputIncome;
    }

    public Integer getOutputIncome() {
        return outputIncome;
    }

    public void setOutputIncome(Integer outputIncome) {
        this.outputIncome = outputIncome;
    }
}
