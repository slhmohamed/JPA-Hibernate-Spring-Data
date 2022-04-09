package com.example.jpadata;

import com.example.jpadata.entities.Patient;
import com.example.jpadata.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaDataApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaDataApplication.class, args);
	}
	 @Override
	public void run (String... args)throws Exception{
		for (int i=0;i<50;i++){
			patientRepository.save(new Patient(null,"Salah",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*10)));

		}
		//patientRepository.save(new Patient(null,"Salah",new Date(),false,50));
		 //patientRepository.save(new Patient(null,"Mohamed",new Date(),true,20));
		 //patientRepository.save(new Patient(null,"Maissa",new Date(),false,52));
		//List<Patient> patientList=	patientRepository.findAll();
		 Page<Patient> patientPage=patientRepository.findAll(PageRequest.of(0,5));
			System.out.println("Total pages : "+patientPage.getTotalPages());
		 System.out.println("Total elements : "+patientPage.getTotalElements());
		 System.out.println("Numero de page : "+patientPage.getNumber());
		 List <Patient> content=patientPage.getContent();
		 //List <Patient> byMalade=patientRepository.findByMalade(true);
		//Page <Patient> byMalade=patientRepository.findByMalade(true,PageRequest.of(0,5));
		 List <Patient> patients=patientRepository.chercherPatients("%S%",50);

		 patients.forEach(patient->{
			System.out.println("-------------------------");
			System.out.println(patient.getId());
			System.out.println(patient.getNom());
			 System.out.println(patient.isMalade());
			System.out.println(patient.getScore());
		});
		//Patient patient= (Patient) patientRepository.findById(1L).orElseThrow(()->new RuntimeException("Patient not found"));

		/*if(patient!=null)
		{
			System.out.println(patient.getId());
			System.out.println(patient.isMalade());
			System.out.println(patient.getNom());
			System.out.println(patient.getScore());
			System.out.println(patient.getDateNaissance());

		}*/
		//patient.setScore(0);
		//patientRepository.save(patient);
		//patientRepository.deleteById(1L);
		 }
}
