package ssm.springframework.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ssm.springframework.springpetclinic.model.Owner;
import ssm.springframework.springpetclinic.model.Pet;
import ssm.springframework.springpetclinic.model.PetType;
import ssm.springframework.springpetclinic.model.Speciality;
import ssm.springframework.springpetclinic.model.Vet;
import ssm.springframework.springpetclinic.model.Visit;
import ssm.springframework.springpetclinic.services.OwnerService;
import ssm.springframework.springpetclinic.services.PetTypeService;
import ssm.springframework.springpetclinic.services.SpecialityService;
import ssm.springframework.springpetclinic.services.VetService;
import ssm.springframework.springpetclinic.services.VisitService;
import ssm.springframework.springpetclinic.services.map.OwnerMapService;
import ssm.springframework.springpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		// TODO Auto-generated constructor stub
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int count = petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality saveRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		Speciality saveSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality saveDentistry = specialityService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("San San");
		owner1.setLastName("Moe");
		owner1.setAddress("Padauk St. Night Market");
		owner1.setCity("Yangon");
		owner1.setTelephone("09402630854");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Lisa");
		owner2.setLastName("MaNoBa");
		owner1.setAddress("Padauk St. Night Market");
		owner1.setCity("Yangon");
		owner1.setTelephone("09402630854");
		
		Pet fionasCat = new Pet();
		fionasCat.setName("Puci");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setPetType(savedCatPetType);
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");
		
		visitService.save(catVisit);
		
		System.out.println("Loaded owners ...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(saveDentistry);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Nyaung");
		vet2.setLastName("Nyaung");
		vet2.getSpecialities().add(saveSurgery);
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets ...");
	}

}
