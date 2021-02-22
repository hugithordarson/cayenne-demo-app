package demo.app;

import javax.sql.DataSource;

import org.apache.cayenne.configuration.DataNodeDescriptor;
import org.apache.cayenne.configuration.server.DataSourceFactory;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.configuration.server.ServerRuntimeBuilder;
import org.apache.cayenne.reflect.NonPrefixedBeanAccessor;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class CDCore {

	static {
		NonPrefixedBeanAccessor.register();
	}

	private static ServerRuntime _serverRuntime;

	public static ServerRuntime serverRuntime() {
		if( _serverRuntime == null ) {
			_serverRuntime = createServerRuntime();
		}

		return _serverRuntime;
	}

	public static ServerRuntime createServerRuntime() {
		final ServerRuntimeBuilder builder = ServerRuntime.builder();

		builder.addConfig( "cayenne-core/cayenne-project.xml" );

		builder.addModule( b -> b.bind( DataSourceFactory.class ).toInstance( new DataSourceFactory() {
			@Override
			public DataSource getDataSource( DataNodeDescriptor nodeDescriptor ) throws Exception {
				final HikariConfig config = new HikariConfig();
				config.setMaximumPoolSize( 2 );
				config.setDriverClassName( "org.h2.Driver" );
				config.setJdbcUrl( "jdbc:h2:mem:netbokhald" );
				config.setUsername( "testing" );
				config.setPassword( "testing" );
				return new HikariDataSource( config );
			}
		} ) );

		return builder.build();
	}
}