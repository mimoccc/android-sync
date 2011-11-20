package org.mozilla.android.sync.test.helpers;

import static org.junit.Assert.fail;

import org.mozilla.android.sync.repositories.RepositorySession;
import org.mozilla.android.sync.repositories.RepositorySessionCreationDelegate;

public class DefaultSessionCreationDelegate implements RepositorySessionCreationDelegate {
  protected WaitHelper testWaiter() {
    return WaitHelper.getTestWaiter();
  }
  private void sharedFail(String message) {
    try {
      fail(message);
    } catch (AssertionError e) {
      testWaiter().performNotify(e);
    }
  }
  public void onSessionCreateFailed(Exception ex) {
    sharedFail("Should not fail.");
  }

  public void onSessionCreated(RepositorySession session) {
    sharedFail("Should not have been created.");
  }
}