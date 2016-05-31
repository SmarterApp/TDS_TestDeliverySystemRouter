package tds.router.services;


import org.springframework.security.saml.SAMLCredential;

public interface ProctorRouteService {

    String routeProctor(SAMLCredential credential);

}
