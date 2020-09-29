package ssm.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import ssm.springframework.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
