package eu.investuotojas.jmsquote.service;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

public class TickVolumeJdbc extends BatchSqlUpdate implements TickVolumeJdbcService
{
	protected DataSource dataSource;
	
	public TickVolumeJdbc(DataSource dataSource)
	{
		super(dataSource, SQL);
		declareParameter(new SqlParameter(Types.INTEGER));
		declareParameter(new SqlParameter(Types.DOUBLE));
		declareParameter(new SqlParameter(Types.INTEGER));
		declareParameter(new SqlParameter(Types.BIGINT));
		setBatchSize(100);
	}
	
	private static final String SQL = "insert into tickvolume (tickerid,size,field,timestamp) values(?,?,?,?)";
	
	
	public void save(Integer tickerId, Integer size, Integer field,
			long timestamp) {
		update(new Object[] { tickerId, size, field, timestamp });
		
	}

}
