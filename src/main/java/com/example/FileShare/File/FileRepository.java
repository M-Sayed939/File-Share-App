package com.example.FileShare.File;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface FileRepository  extends JpaRepository<FileEntity, Long> {

}
