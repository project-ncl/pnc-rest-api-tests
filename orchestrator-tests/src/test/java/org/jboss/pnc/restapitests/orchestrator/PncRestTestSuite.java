package org.jboss.pnc.restapitests.orchestrator;

import org.jboss.pnc.restapitests.orchestrator.scenarios.PmeCustomParametersTest;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {
        PmeCustomParametersTest.class,
    }
)
public class PncRestTestSuite {

    @ClassRule
    public static ExternalResource testResources = new ExternalResource() {

        @Override
        protected void before() throws Throwable {
            PncRestTestRunner.getInstance(new PncRestTestConfig());
        }

        @Override
        protected void after() {
            PncRestTestRunner.dropInstance();
        }
    };
}
