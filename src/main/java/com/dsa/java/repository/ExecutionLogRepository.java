package com.dsa.java.repository;
import com.dsa.java.model.ExecutionLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExecutionLogRepository extends MongoRepository<ExecutionLog, String> {

}
