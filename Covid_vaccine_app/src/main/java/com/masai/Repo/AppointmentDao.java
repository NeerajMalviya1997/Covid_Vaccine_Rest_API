package com.masai.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.masai.model.Appointment;
import com.masai.model.Member;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {
	List<Appointment> findByMember(Member member);
}
