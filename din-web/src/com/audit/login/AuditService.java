package com.audit.login;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

 // private static Logger logger = LoggerFactory.getLogger(AuditService.class);

/**
   * Audit this screen against the current user name
   * 
   * It's more useful to put this info into a database so that that you can count visits to
   * pages and figure out how often they're used. That way, you can focus your design on the
   * popular parts of your application. The logger is just for demo purposes.
   */
  public void audit(String screenName) {

    String userName = getCurrentUser();
    System.out.println("screen name"+screenName);

  //  logger.info("Audit: {} - {}", userName, screenName);

  }

  /**
   * Get the current logged on user name by whatever mechanism available
   */
  private String getCurrentUser() {
    return "Fred";
  }

}