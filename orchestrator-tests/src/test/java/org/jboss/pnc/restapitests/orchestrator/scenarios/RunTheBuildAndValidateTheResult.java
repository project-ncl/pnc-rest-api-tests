package org.jboss.pnc.restapitests.orchestrator.scenarios;

import org.jboss.pnc.restapitests.orchestrator.operations.UserOperations;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <a href="mailto:matejonnet@gmail.com">Matej Lazar</a>
 */
public class RunTheBuildAndValidateTheResult {

    UserOperations userOperations = new UserOperations();

    @BeforeClass
    public static void initScenario() {
        //TODO drop the data and restart the services/pods
    }

    @Test
    public void shouldExecuteRemoteCommandAndGetTheResult() {
        userOperations.createUser();
        //createConfiguration
        //executeTheBuild
        //waitForCompletionWithTimeout
        //inspectTheResults
    }

}
