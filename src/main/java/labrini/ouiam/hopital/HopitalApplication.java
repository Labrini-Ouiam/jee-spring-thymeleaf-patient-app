package labrini.ouiam.hopital;

import labrini.ouiam.hopital.entities.Patient;
import labrini.ouiam.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {

        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setMalade(true);
        patient.setName("Mohammed");
        patient.setDateNaissance(new Date());
        patient.setScore(23);
        patientRepository.save(patient);

        Patient patient1 = new Patient();
        patient1.setMalade(false);
        patient1.setName("hajar");
        patient1.setDateNaissance(new Date());
        patient1.setScore(53);
        patientRepository.save(patient1);


        Patient patient2 = new Patient();
        patient2.setMalade(true);
        patient2.setName("ghita");
        patient2.setDateNaissance(new Date());
        patient2.setScore(100);
        patientRepository.save(patient2);


//        patientRepository.save(new Patient(2,"ghita",new Date(),false, 67));

        //En utilisant Builder
//        Patient patient2 =Patient.builder()
//                .malade(true)
//                .name("hajar")
//                .dateNaissance(new Date())
//                .score(43)
//                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
