package com.model;

  

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pojo.Feedback;
import com.pojo.Patient;
import com.pojo.User;

public class BLManager {
SessionFactory sf=new Configuration().configure().buildSessionFactory();

public User search(String email,String password)
{
	Session s = sf.openSession();
	Criteria cr = s.createCriteria(User.class);
	cr.add(Restrictions.eq("email", email));
	cr.add(Restrictions.eq("password", password));
	User r = (User) cr.uniqueResult();
	return r;
}

public void saveUser(User u)
{
	Session s1 = sf.openSession();
	Transaction tr = s1.beginTransaction();
	s1.save(u);
	tr.commit();
	s1.close();
}
public void savePatient(Patient p)
{
	Session s1 = sf.openSession();
	Transaction tr = s1.beginTransaction();
	s1.save(p);
	tr.commit();
	s1.close();
}

public void saveFeedback(Feedback p)
{
	Session s1 = sf.openSession();
	Transaction tr = s1.beginTransaction();
	s1.save(p);
	tr.commit();
	s1.close();
}
public Patient searchbyId(String id) {
	Session s1 = sf.openSession();
	Criteria cr = s1.createCriteria(Patient.class);
	cr.add(Restrictions.eq("pid", id));
	Patient c = (Patient) cr.uniqueResult();
	return c;
}

public Patient searchbyType(String ptype) {
	Session s1 = sf.openSession();
	Criteria cr = s1.createCriteria(Patient.class);
	cr.add(Restrictions.eq("ptype", ptype));
	Patient c = (Patient) cr.uniqueResult();
	return c;
}
public List<Patient> getAllPatient() {
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Patient.class);
    List<Patient> a=cr.list();
	return a;
}
public List<Feedback> getAllFeedback() {
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Feedback.class);
    List<Feedback> a=cr.list();
	return a;
}
public void count()
{
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Feedback.class);
	//String hql = "SELECT q1,count(q1) FROM Feedback group by q1";
//	Query query = s1.createQuery(hql);
	cr.setProjection(Projections.count("q2"));
	
	       
	//List l = query.list();
	
	System.out.println(cr.list());
	
}

public Feedback searchbyFeedbackId(int i) {
	Session s1 = sf.openSession();
	Criteria cr = s1.createCriteria(Feedback.class);
	cr.add(Restrictions.eq("feedid", i));
	Feedback c = (Feedback) cr.uniqueResult();
	return c;
}

public void deleteFeedback(Feedback f) {
	Session s1 = sf.openSession();
	Transaction tr = s1.beginTransaction();
	s1.delete(f);
	tr.commit();
	s1.close();
	
}

public void updateFeedback(Feedback f) {
	Session s1 = sf.openSession();
	Transaction tr = s1.beginTransaction();
	s1.update(f);
	tr.commit();
	s1.close();
	

}

public Patient searchbyPatientId(String id) {
	Session s1 = sf.openSession();
	Criteria cr = s1.createCriteria(Patient.class);
	cr.add(Restrictions.eq("pid", id));
	Patient p = (Patient) cr.uniqueResult();
	return p;
	
}

public void deletePatient(Patient p) {
	Session s1 = sf.openSession();
	Transaction tr = s1.beginTransaction();
	s1.delete(p);
	tr.commit();
	s1.close();
	
}


}
