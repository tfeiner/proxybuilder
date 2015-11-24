package org.rapidpm.proxybuilder.type.dymamic.virtual.creationstrategy;


import org.rapidpm.proxybuilder.type.dymamic.virtual.VirtualDynamicProxyInvocationHandler;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by svenruppert on 06.11.15.
 */
public class ServiceStrategyFactoryNoDuplicates<T> implements VirtualDynamicProxyInvocationHandler.ServiceStrategyFactory<T> {

  private volatile T realSubject;
  private final Lock initializationLock = new ReentrantLock();

  @Override
  public T realSubject(VirtualDynamicProxyInvocationHandler.ServiceFactory<T> factory) {
    T result = realSubject;
    if (result == null) {
      initializationLock.lock();
      try {
        result = realSubject;
        if (result == null) {
          result = realSubject = factory.createInstance();
        }
      } finally {
        initializationLock.unlock();
      }
    }
    return result;
  }
}
