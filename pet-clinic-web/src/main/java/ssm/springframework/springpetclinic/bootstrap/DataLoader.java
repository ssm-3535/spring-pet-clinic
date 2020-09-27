package ssm.springframework.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ssm.springframework.springpetclinic.model.Owner;
import ssm.springframework.springpetclinic.model.Pet;
import ssm.springframework.springpetclinic.model.PetType;
import ssm.springframework.springpetclinic.model.Vet;
import ssm.springframework.springpetclinic.services.OwnerService;
import ssm.springframework.springpetclinic.services.PetTypeService;
import ssm.springframework.springpetclinic.services.VetService;
import ssm.springframework.springpetclinic.services.map.OwnerServiceMap;
import ssm.springframework.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		// TODO Auto-generated constructor stub
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("******win lar************");
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
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
		
		System.out.println("Loaded owners ...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Nyaung");
		vet2.setLastName("Nyaung");
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets ...");
	}

}
