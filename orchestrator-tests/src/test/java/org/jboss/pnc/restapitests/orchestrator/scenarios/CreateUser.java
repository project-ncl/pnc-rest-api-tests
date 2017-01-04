package org.jboss.pnc.restapitests.orchestrator.scenarios;

import org.jboss.pnc.restapitests.orchestrator.operations.UserOperations;
import org.junit.Test;

/**
 * @author <a href="mailto:matejonnet@gmail.com">Matej Lazar</a>
 */
public class CreateUser {

    UserOperations userOperations = new UserOperations();

    @Test
    public void shouldCreateUser() {
        userOperations.createUser();
    }

}
