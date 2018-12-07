package com.techfirebase.spring.smartdustbin.repository;

import com.techfirebase.spring.smartdustbin.domain.DustbinDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 14:10:37)
 */
@Repository
public interface DustbinDetailRepository extends JpaRepository<DustbinDetail, Integer> {}
