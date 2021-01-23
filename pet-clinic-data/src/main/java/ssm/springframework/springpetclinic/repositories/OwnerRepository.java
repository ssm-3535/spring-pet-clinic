package ssm.springframework.springpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ssm.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
