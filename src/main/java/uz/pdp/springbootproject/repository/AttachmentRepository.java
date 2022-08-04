package uz.pdp.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootproject.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
