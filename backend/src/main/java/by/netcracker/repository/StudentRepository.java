package by.netcracker.repository;

import by.netcracker.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {
    List<StudentEntity> findAllByGroup(int group);
}