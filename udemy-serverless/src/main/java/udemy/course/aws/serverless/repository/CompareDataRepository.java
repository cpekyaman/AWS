package udemy.course.aws.serverless.repository;

import udemy.course.aws.serverless.domain.CompareData;

import java.util.List;

/**
 * Created by raistlin on 9/14/2017.
 */
public interface CompareDataRepository {
    CompareData findOne(String userId);

    List<CompareData> findAll();

    void save(CompareData data);

    void delete(String userId);
}
