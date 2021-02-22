package demo.data;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import demo.data.auto._Page;

public class Page extends _Page {

	public String renderedText() {
		Parser parser = Parser.builder().build();
		Node document = parser.parse( "This is *Sparta*" );
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return renderer.render( document );
	}
}