package com.devops.dockerDemo.dao;

import com.devops.dockerDemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(String status);

    @Query("SELECT t FROM Task t WHERE (:status IS NULL OR lower(t.status) = :status) ORDER BY t.dueDate ASC")
    List<Task> findTasksByStatusSorted(@Param("status") String status);
}
