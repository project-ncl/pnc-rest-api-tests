package org.jboss.pnc.restapitests.orchestrator.scenarios;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testcase description:
 * 1) Find any BC with successful build
 * 2) Clone BC
 * 3) Add generic parameter CUSTOM_PME_PARAMETERS   with value -DdependencyManagement=org.jboss.eap:jboss-eap-parent:7.0.2.GA-redhat-100 -DdependencySource=BOM
 * 4) Verify that PME step fails and human-readable error log is obtained with message, that artifact org.jboss.eap:jboss-eap-parent:7.0.2.GA-redhat-100 couldn't be found"
 *
 * @author <a href="mailto:pkocandr@redhat.com">Petr Kocandrle</a>
 */
public class PmeCustomParametersTest {

    @BeforeClass
    public static void initScenario() {
        //TODO drop the data and restart the services/pods
    }

    @Test
    public void shouldExecuteRemoteCommandAndGetTheResult() {
        //createConfiguration
        //executeTheBuild
        //waitForCompletion
        //inspectTheResults
    }

}
