package ssm.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;

import ssm.springframework.springpetclinic.model.Owner;
import ssm.springframework.springpetclinic.model.Vet;
import ssm.springframework.springpetclinic.services.OwnerService;
import ssm.springframework.springpetclinic.services.PetService;
import ssm.springframework.springpetclinic.services.VetService;
import ssm.springframework.springpetclinic.services.map.OwnerServiceMap;
import ssm.springframework.springpetclinic.services.map.VetServiceMap;

public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader() {
		// TODO Auto-generated constructor stub
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("******win lar************");
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("San San");
		owner1.setLastName("Moe");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Lisa");
		owner2.setLastName("MaNoBa");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners ...");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Nyaung");
		vet2.setLastName("Nyaung");
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets ...");
	}

}
