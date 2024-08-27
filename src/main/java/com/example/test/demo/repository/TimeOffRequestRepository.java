package com.example.test.demo.repository;

import com.example.test.demo.entity.TimeOffRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TimeOffRequestRepository extends JpaRepository<TimeOffRequest, Long> {

    @Query("SELECT tor FROM TimeOffRequest tor JOIN RequestCategory rc ON tor.requestCategory.id = rc.id " +
            "WHERE tor.employeeId = :employeeId AND tor.startDate <= :endDate AND tor.endDate >= :startDate " +
            "AND rc.name != 'Work Remotely' AND :newCategoryName != 'Work Remotely'")
    List<TimeOffRequest> findOverlappingRequests(@Param("employeeId") Long employeeId,
                                                 @Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate,
                                                 @Param("newCategoryName") String newCategoryName);
}
