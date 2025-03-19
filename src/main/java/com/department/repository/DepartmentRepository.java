package com.department.repository;

import com.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "select * from department where department_code = ?1",nativeQuery = true)
    Optional<Department> getByDepartmentCode(String departmentCode);
}
