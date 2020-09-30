package ssm.springframework.springpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ssm.springframework.springpetclinic.model.Owner;
import ssm.springframework.springpetclinic.repositories.OwnerRepository;
import ssm.springframework.springpetclinic.repositories.PetRepository;
import ssm.springframework.springpetclinic.repositories.PetTypeRepository;
import ssm.springframework.springpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long aLong) {
		// TODO Auto-generated method stub
		return ownerRepository.findById(aLong).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub
		ownerRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long aLong) {
		// TODO Auto-generated method stub
		ownerRepository.deleteById(aLong);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(lastName);
	}
	
}