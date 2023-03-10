package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Responsible;
import com.example.demo.repository.ResponsibleRepository;

//yassinTalssis
@Service
public class ResponsibleServiceImpl implements ResponsibleService {
	
	private ResponsibleRepository responsibleRepository;

	public ResponsibleServiceImpl(ResponsibleRepository responsibleRepository) {
		super();
		this.responsibleRepository = responsibleRepository;
	}

	@Override
	public List<Responsible> getAllResponsibles() {
		return responsibleRepository.findAll();
	}

	@Override
	public Responsible saveResponsible(Responsible student) {
		return responsibleRepository.save(student);
	}

	@Override
	public Responsible getResponsibleById(long id) {
		return responsibleRepository.findById(id).get();
		//return null;
	}

	@Override
	public Responsible updateResponsible(Responsible student) {
		return responsibleRepository.save(student);
	}
//yassinTalssis
	@Override
	public void deleteResponsibleById(long id) {
		responsibleRepository.deleteById(id);	
	}

	@Override
	public void deleteResponsibleById(Long id) {
		// TODO Auto-generated method stub
		
	}
}
