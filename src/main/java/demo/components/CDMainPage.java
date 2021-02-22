package demo.components;

import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

import demo.app.CDComponent;
import demo.app.CDCore;
import demo.data.Person;

public class CDMainPage extends CDComponent {

	public Person current;
	public String newPersonName;

	public CDMainPage( WOContext context ) {
		super( context );
	}

	public WOActionResults createPerson() {
		final ObjectContext oc = CDCore.serverRuntime().newContext();

		final Person person = oc.newObject( Person.class );
		person.setName( newPersonName );

		oc.commitChanges();
		return null;
	}
	public List<Person> people() {
		final ObjectContext oc = CDCore.serverRuntime().newContext();

		return ObjectSelect
				.query( Person.class )
				.select( oc );
	}
}