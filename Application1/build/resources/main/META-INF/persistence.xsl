<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="pu1" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>entity.Film</class>
        <!--<class>entity.Order</class>-->
        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/filmstore" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="password" />

            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />
            <!-- Echo all executed SQL to stdout -->
            <property name="hibernate.show_sql" value="true" />

            <!-- Drop and re-create the database schema on startup -->
            <!--create-drop creates the tables when the SessionFactory is created.
                and drops them when the SessionFactory is closed explicitly. Other properties
                are update, create, validate -->
            <!--<property name="hibernate.hbm2ddl.auto" value="create" />-->
            <property name="hibernate.hbm2ddl.auto" value="validate" />
        </properties>
    </persistence-unit>

    <persistence-unit name="pu2" transaction-type="JTA">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <jta-data-source>jdbc/filmstore</jta-data-source>
        <properties>
            <property name="hibernate.transaction.jta.platform" value="org.hibernate.service.jta.platform.internal.SunOneJtaPlatform"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />
            <property name="hibernate.hbm2ddl.auto" value="validate"/>
        </properties>
    </persistence-unit>

</persistence>