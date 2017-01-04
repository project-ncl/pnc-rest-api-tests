package org.jboss.pnc.restapitests.orchestrator.operations;

import org.jboss.pnc.rest.restmodel.UserRest;
import org.jboss.pnc.restclient.UserRestClient;

/**
 * @author <a href="mailto:matejonnet@gmail.com">Matej Lazar</a>
 */
public class UserOperations {

    public void createUser() {
        UserRestClient userRestClient = new UserRestClient();
        UserRest user = new UserRest();
        user.setFirstName("Some");
        user.setLastName("One");
        user.setEmail("some.one@jboss.org");
        user.setUsername("someone@jboss.org");
        userRestClient.createNew(user);
    }


}
