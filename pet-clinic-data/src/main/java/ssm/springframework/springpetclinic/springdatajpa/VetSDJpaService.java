package ssm.springframework.springpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ssm.springframework.springpetclinic.model.Vet;
import ssm.springframework.springpetclinic.repositories.VetRepository;
import ssm.springframework.springpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{
	
	private final VetRepository vetRepository;

	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long aLong) {
		// TODO Auto-generated method stub
		return vetRepository.findById(aLong).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		// TODO Auto-generated method stub
		vetRepository.deleteById(aLong);
	}

}
