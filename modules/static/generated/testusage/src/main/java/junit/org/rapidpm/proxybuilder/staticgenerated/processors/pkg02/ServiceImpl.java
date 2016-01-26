package junit.org.rapidpm.proxybuilder.staticgenerated.processors.pkg02;

import org.rapidpm.proxybuilder.staticgenerated.annotations.StaticMetricsProxy;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sven Ruppert on 09.12.15.
 */
@StaticMetricsProxy
public class ServiceImpl {

  public String doWork(String txt) {
    return txt + LocalDateTime.now();
  }


  public void doNothing() {
  }

  public List<String> createList() throws NegativeArraySizeException {
    return Collections.emptyList();
  }

  public List<String> createListA() throws Exception {
    return Collections.emptyList();
  }


}
