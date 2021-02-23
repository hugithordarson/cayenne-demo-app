package demo.components;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import com.webobjects.appserver.WOContext;

import demo.app.CDComponent;

public class CDMavenPage extends CDComponent {

	public CDMavenPage( WOContext context ) {
		super( context );
	}

	public String renderedTestText() {
		final List<Extension> extensions = Arrays.asList( TablesExtension.create() );

		final Parser parser = Parser.builder()
				.extensions( extensions )
				.build();

		final HtmlRenderer renderer = HtmlRenderer.builder()
				.extensions( extensions )
				.attributeProviderFactory( new AttributeProviderFactory() {
					@Override
					public AttributeProvider create( AttributeProviderContext context ) {
						return new AttributeProvider() {
							@Override
							public void setAttributes( Node node, String tagName, Map<String, String> attributes ) {
								if( node instanceof TableBlock ) {
									attributes.put( "class", "table table-striped table-condensed" );
								}
							}
						};
					}
				} )
				.build();

		final Node document = parser.parse( readStringFromResource( "/pages/maven.md" ) );
		return renderer.render( document );
	}

	/**
	 * @return The named resource as a string
	 */
	private static String readStringFromResource( final String resourcePath ) {
		try {
			return new String( Files.readAllBytes( Paths.get( CDMavenPage.class.getResource( resourcePath ).toURI() ) ), "utf-8" );
		}
		catch( IOException | URISyntaxException e ) {
			throw new RuntimeException( e );
		}
	}
}