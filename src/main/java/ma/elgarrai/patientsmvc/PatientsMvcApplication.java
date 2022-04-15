package ma.elgarrai.patientsmvc;

//import com.sun.tools.javac.main.CommandLine;
import ma.elgarrai.patientsmvc.entities.Patient;
import ma.elgarrai.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"Oualid",new Date(),false,12));
            patientRepository.save(
                    new Patient(null,"Mehdi",new Date(),true,123));
            patientRepository.save(
                    new Patient(null,"Yassine",new Date(),true,1234));
            patientRepository.save(
                    new Patient(null,"maroune",new Date(),false,12345));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

}
