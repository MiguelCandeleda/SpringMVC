/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * JPA implementation of the {@link VetRepository} interface.
 *
 * @author Mike Keith
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Vitaliy Fedoriv
 */
@Repository
@Profile("jpa")
public class JpaVetRepositoryImpl implements VetRepository {

    @PersistenceContext
    private EntityManager em;


	@Override
	public Vet findById(int id) throws DataAccessException {
		return this.em.find(Vet.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Vet> findAll() throws DataAccessException {
		return this.em.createQuery("SELECT vet FROM Vet vet").getResultList();
	}

	@Override
	public void save(Vet vet) throws DataAccessException {
        if (vet.getId() == null) {
            this.em.persist(vet);
        } else {
            this.em.merge(vet);
        }
	}

	@Override
	public void delete(Vet vet) throws DataAccessException {
		this.em.remove(this.em.contains(vet) ? vet : this.em.merge(vet));
	}

//    Lista Vets filtrados por lastName
    public List findVetByLastName (String lastName) {

        Query query = this.em.createQuery("SELECT last_name FROM Vets");
        query.setParameter("lastName", lastName + "%");
        return query.getResultList();
    }
// //    Lista Vets filtrados por first_name y lastName
    public List findVetByFirstNameLastName (String firstName,String lastName) {

        Query query = this.em.createQuery("SELECT first_name, last_name FROM Vets");
        query.setParameter("firstName", firstName + "%");
        query.setParameter("lastName", lastName + "%");
        return query.getResultList();
    }



}
