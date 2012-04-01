package com.page.pagetop.service;

import javax.jws.WebService;

@WebService
public interface NotificationProcess {
  void notify(NotificationMessage order);
}