package demo.app;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import demo.components.CDMainPage;
import er.extensions.appserver.ERXDirectAction;

public class DirectAction extends ERXDirectAction {

	public DirectAction( WORequest request ) {
		super( request );
	}

	@Override
	public WOActionResults defaultAction() {
		return pageWithName( CDMainPage.class );
	}
}