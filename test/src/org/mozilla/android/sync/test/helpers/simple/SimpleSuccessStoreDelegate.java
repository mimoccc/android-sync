/* Any copyright is dedicated to the Public Domain.
   http://creativecommons.org/publicdomain/zero/1.0/ */

package org.mozilla.android.sync.test.helpers.simple;

import java.util.concurrent.ExecutorService;

import org.mozilla.android.sync.test.helpers.DefaultDelegate;
import org.mozilla.gecko.sync.repositories.delegates.RepositorySessionStoreDelegate;

public abstract class SimpleSuccessStoreDelegate extends DefaultDelegate implements RepositorySessionStoreDelegate {
  @Override
  public void onRecordStoreFailed(Exception ex, String guid) {
    performNotify("Store failed", ex);
  }

  @Override
  public RepositorySessionStoreDelegate deferredStoreDelegate(ExecutorService executor) {
    return this;
  }
}
