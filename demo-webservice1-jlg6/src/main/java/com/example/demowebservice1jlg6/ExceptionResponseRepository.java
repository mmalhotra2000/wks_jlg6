package com.example.demowebservice1jlg6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionResponseRepository  extends JpaRepository<ExceptionResponse, Long>{

}
