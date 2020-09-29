package ssm.springframework.springpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ssm.springframework.springpetclinic.model.Speciality;
import ssm.springframework.springpetclinic.repositories.SpecialityRepository;
import ssm.springframework.springpetclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService{
	
	private final SpecialityRepository specialityRepository;

	public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		specialityRepository.deleteById(id);
	}
	
}
