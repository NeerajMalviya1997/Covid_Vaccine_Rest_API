package com.masai.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.masai.model.IDCard;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;

@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {
  

	public Member findByIdCard(Optional<IDCard> idcard);

	


	public Member findByvaccineRegistration(VaccineRegistration vr);
}
