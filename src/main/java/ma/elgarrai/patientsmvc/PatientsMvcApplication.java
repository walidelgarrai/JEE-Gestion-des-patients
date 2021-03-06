package ma.elgarrai.patientsmvc;

//import com.sun.tools.javac.main.CommandLine;
import ma.elgarrai.patientsmvc.entities.Patient;
import ma.elgarrai.patientsmvc.repositories.PatientRepository;
import ma.elgarrai.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"Oualid",new Date(),false,122));
            patientRepository.save(
                    new Patient(null,"Mehdi",new Date(),true,321));
            patientRepository.save(
                    new Patient(null,"Yassine",new Date(),true,165));
            patientRepository.save(
                    new Patient(null,"maroune",new Date(),false,123));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("mohamed","1234","1234");
            securityService.saveNewUser("ali","1234","1234");
            securityService.saveNewUser("hassan","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("mohamed","USER");
            securityService.addRoleToUser("mohamed","ADMIN");
            securityService.addRoleToUser("ali","USER");
            securityService.addRoleToUser("hassan","USER");
        };
    }



}
