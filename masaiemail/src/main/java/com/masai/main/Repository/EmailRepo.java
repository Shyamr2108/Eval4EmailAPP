package com.masai.main.Repository;


import com.masai.main.entity.Email;
import com.masai.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmailRepo extends JpaRepository<Email, Integer> {
    public List<Email> findByTo(User user);
    public List<Email> findByToAndStarred(User user,boolean starred);


}
