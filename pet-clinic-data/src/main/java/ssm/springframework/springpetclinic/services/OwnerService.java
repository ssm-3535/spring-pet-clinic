package ssm.springframework.springpetclinic.services;

import java.util.List;

import ssm.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
	
}
