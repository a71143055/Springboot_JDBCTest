package kr.ac.kopo.minn.springboot_jdbctest.repository;

import kr.ac.kopo.minn.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository02 extends JpaRepository<Member, Integer> {

}
