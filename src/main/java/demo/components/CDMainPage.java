//package demo.components;
//
//import java.util.List;
//
//import org.apache.cayenne.ObjectContext;
//import org.apache.cayenne.query.ObjectSelect;
//
//import com.webobjects.appserver.WOContext;
//
//import demo.app.CDComponent;
//import demo.app.CDCore;
//
//public class CDMainPage extends CDComponent {
//
//	public Person current;
//
//	public CDMainPage( WOContext context ) {
//		super( context );
//	}
//
//	public List<Person> people() {
//		final ObjectContext oc = CDCore.createServerRuntime().newContext();
//		return ObjectSelect
//				.query( Person.class )
//				.select( oc );
//	}
//}