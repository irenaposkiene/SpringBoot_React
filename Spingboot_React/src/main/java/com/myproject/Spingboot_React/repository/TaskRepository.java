package com.myproject.Spingboot_React.repository;

import com.myproject.Spingboot_React.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
