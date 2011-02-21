package eu.investuotojas.jmsquote;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
public class AppTest extends AbstractJUnit4SpringContextTests
{
   

    
    @Test
    public void testApp()
    {
       // assertTrue( true );
    }
}
