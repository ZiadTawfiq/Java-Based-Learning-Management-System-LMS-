package com.LMS.LMS.RepositoryLayer;

import com.LMS.LMS.ModelLayer.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
