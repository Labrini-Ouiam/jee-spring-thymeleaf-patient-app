package labrini.ouiam.hopital.repository;

import labrini.ouiam.hopital.entities.Patient;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNameContaining(String name, Pageable pageable);

//    @Query("select p from Patient p where p.name like :x")
//    Page<Patient> chercher(@Param("x") String name);

}
