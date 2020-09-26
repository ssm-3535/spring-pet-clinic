package ssm.springframework.springpetclinic.services;

import ssm.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
}
