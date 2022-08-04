package uz.pdp.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootproject.entity.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
}
