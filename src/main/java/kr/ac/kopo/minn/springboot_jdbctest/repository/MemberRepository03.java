package kr.ac.kopo.minn.springboot_jdbctest.repository;

import jakarta.transaction.Transactional;
import kr.ac.kopo.minn.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository03 {
    @Transactional
    @Query(value="SELECT * FROM Member", nativeQuery = true)
    public List<Member> selectMethod();

    @Transactional
    @Query(value = "SELECT * FROM Member WHERE id = ?", nativeQuery = true)
    public Member selectMethodById(@Param("e_id") int id);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO Member(name, age, email) VALUES(?,?,?)", nativeQuery = true)
    public int insertMethod(@Param("e_name") String name, @Param("e_age") int age, @Param("e_email") String email);

    @Transactional
    @Modifying
    @Query(value="UPDATE Member SET name=?, age=?, email=? WHERE id = ?", nativeQuery = true)
    public int updateMethod(@Param("e_name") String name, @Param("e_age") int age, @Param("e_email") String email , @Param("e_id") int id);

    @Transactional
    @Modifying
    @Query(value="DELETE FROM Member WHERE id=?", nativeQuery = true)
    public int deleteMethod(@Param("e_id") int id);
}