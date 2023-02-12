package tn.esprit.jmlessous.gestionuser.Service.Implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.UtilisateurRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UtilisateurRepository utilisateurRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    Utilisateur user = utilisateurRepository.findByLogin(login)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));

    return UserDetailsImpl.build(user);
  }

}
