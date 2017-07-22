package com.whatsHapp.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component("customHibernateDaoSupport")
@Qualifier("customHibernateDaoSupport")
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport
{    
	@Autowired
	@Qualifier("sessionFactory")
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
}