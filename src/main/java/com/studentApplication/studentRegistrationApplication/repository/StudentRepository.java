package com.studentApplication.studentRegistrationApplication.repository;

import com.studentApplication.studentRegistrationApplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Bu annotasyon, bir sınıfın veritabanı işlemlerini gerçekleştiren bir veri erişim bileşeni olduğunu belirtir.
//@Repository, Spring Boot uygulamalarında veri erişim katmanı (Data Access Layer) için kullanılan bir annotasyondur.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByLastName(String lastName);

    Optional<Student> findByEmail(String email);

    Optional<Student> findByName(String name);

}
