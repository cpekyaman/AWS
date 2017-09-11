package udemy.course.aws.serverless.assignment1.store;

/**
 * Created by raistlin on 8/19/2017.
 */
public class StoreApiResponse {
    private String name;
    private Integer age;

    public StoreApiResponse() {
    }

    public StoreApiResponse(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
