package udemy.course.aws.serverless.api.common.model;

/**
 * Created by raistlin on 9/14/2017.
 */
public class CompareDataModel {
    private Integer age;

    private Integer height;

    private Integer income;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompareDataModel{");
        sb.append("age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", income=").append(income);
        sb.append('}');
        return sb.toString();
    }
}
