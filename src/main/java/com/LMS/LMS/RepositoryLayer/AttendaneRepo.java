package com.LMS.LMS.RepositoryLayer;

import com.LMS.LMS.ModelLayer.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendaneRepo extends JpaRepository<Attendance , Integer> {
}
