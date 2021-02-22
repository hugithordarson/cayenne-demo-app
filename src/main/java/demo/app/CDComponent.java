package demo.app;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

/**
 * Just an abstract class for our components
 */

public abstract class CDComponent extends ERXComponent {

	public CDComponent( WOContext context ) {
		super( context );
	}
}