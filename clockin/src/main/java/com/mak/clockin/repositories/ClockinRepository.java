package com.mak.clockin.repositories;

import com.mak.clockin.models.Clockin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockinRepository extends JpaRepository<Clockin, Integer> {

    public List<Clockin> findAllByUserId(int userId);
}
