package demo.components;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import com.webobjects.appserver.WOContext;

import demo.app.CDComponent;

public class CDMavenPage extends CDComponent {

	public CDMavenPage( WOContext context ) {
		super( context );
	}

	public String renderedTestText() {
		Parser parser = Parser.builder().build();
		Node document = parser.parse( "This is *Sparta*" );
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return renderer.render( document );
	}
}