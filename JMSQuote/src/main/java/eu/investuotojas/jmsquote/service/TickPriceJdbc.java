package eu.investuotojas.jmsquote.service;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;


public class TickPriceJdbc extends BatchSqlUpdate implements TickPriceJdbcService 
{
	
	//@Autowired
	protected DataSource dataSource;
	
	public TickPriceJdbc(DataSource dataSource)
	{
		super(dataSource, SQL);
		declareParameter(new SqlParameter(Types.INTEGER));
		declareParameter(new SqlParameter(Types.DOUBLE));
		declareParameter(new SqlParameter(Types.INTEGER));
		declareParameter(new SqlParameter(Types.BIGINT));
		setBatchSize(100);
	}
	
	private static final String SQL = "insert into tickprice (tickerid,price,field,ts) values(?,?,?,?)";
	
	

	public void save(Integer tickerId, Double price, Integer field,
			long timestamp) {
		//log.debug("tickerId "+tickerId+" price "+price+" field "+field+"timestamp "+timestamp);
		update(new Object[] { tickerId, price, field, timestamp });
	}

}
