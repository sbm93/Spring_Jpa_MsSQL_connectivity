# Spring_Jpa_MsSQL_connectivity
Connecting JPA - MS SQL server using datasource can be problematic. i faced this problem during my task and i work hard to find out the solution. 

Microsoft SQL have already provided default driver to connect with database. but it did not work for me during my task implemetation. besides microsoft's get started document provides great explaination for jdbc and hibernate. but connecting using datasource was harded to implements as driver does not supports many datasources method like entityManagerFactory. 
While facing this issue, i learned about *jtds* driver. it is JDBC driver for microsoft SQL server provided by sourceforge. 

pom.xml contains jtds dependency and ./resource/Application.properties has jdbc driver and dialect.
