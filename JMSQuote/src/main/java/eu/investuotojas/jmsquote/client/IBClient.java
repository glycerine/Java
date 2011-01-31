package eu.investuotojas.jmsquote.client;

import java.util.Calendar;

import org.apache.log4j.Logger;

import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.UnderComp;

import eu.investuotojas.jmsquote.jms.QueueSender;

public class IBClient implements EWrapper, Runnable
{
	private Logger log = Logger.getLogger(getClass());
	private QueueSender sender;
	
	public QueueSender getSender() {
		return sender;
	}

	public void setSender(QueueSender sender) {
		this.sender = sender;
	}

	public void accountDownloadEnd(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void bondContractDetails(int arg0, ContractDetails arg1) {
		// TODO Auto-generated method stub
		
	}

	public void contractDetails(int arg0, ContractDetails arg1) {
		// TODO Auto-generated method stub
		
	}

	public void contractDetailsEnd(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void currentTime(long arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deltaNeutralValidation(int arg0, UnderComp arg1) {
		// TODO Auto-generated method stub
		
	}

	public void execDetails(int arg0, Contract arg1, Execution arg2) {
		// TODO Auto-generated method stub
		
	}

	public void execDetailsEnd(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void fundamentalData(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void historicalData(int arg0, String arg1, double arg2, double arg3,
			double arg4, double arg5, int arg6, int arg7, double arg8,
			boolean arg9) {
		// TODO Auto-generated method stub
		
	}

	public void managedAccounts(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void nextValidId(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void openOrder(int arg0, Contract arg1, Order arg2, OrderState arg3) {
		// TODO Auto-generated method stub
		
	}

	public void openOrderEnd() {
		// TODO Auto-generated method stub
		
	}

	public void orderStatus(int arg0, String arg1, int arg2, int arg3,
			double arg4, int arg5, int arg6, double arg7, int arg8, String arg9) {
		// TODO Auto-generated method stub
		
	}

	public void realtimeBar(int arg0, long arg1, double arg2, double arg3,
			double arg4, double arg5, long arg6, double arg7, int arg8) {
		// TODO Auto-generated method stub
		
	}

	public void receiveFA(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void scannerData(int arg0, int arg1, ContractDetails arg2,
			String arg3, String arg4, String arg5, String arg6) {
		// TODO Auto-generated method stub
		
	}

	public void scannerDataEnd(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void scannerParameters(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void tickEFP(int arg0, int arg1, double arg2, String arg3,
			double arg4, int arg5, String arg6, double arg7, double arg8) {
		// TODO Auto-generated method stub
		
	}

	public void tickGeneric(int arg0, int arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	public void tickOptionComputation(int arg0, int arg1, double arg2,
			double arg3, double arg4, double arg5, double arg6, double arg7,
			double arg8, double arg9) {
		// TODO Auto-generated method stub
		
	}

	public void tickPrice(int tickerId, int field, double price,
			int canAutoExecute) {
		log.debug("tickerId "+tickerId+" price "+price+" field "+field);
		sender.sendPrice(tickerId, field, price, Calendar.getInstance().getTimeInMillis());
		
	}

	public void tickSize(int tickerId, int field, int size) 
	{
		sender.sendVolume(tickerId, field, size, Calendar.getInstance().getTimeInMillis());
		
	}

	public void tickSnapshotEnd(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void tickString(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void updateAccountTime(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void updateAccountValue(String arg0, String arg1, String arg2,
			String arg3) {
		// TODO Auto-generated method stub
		
	}

	public void updateMktDepth(int arg0, int arg1, int arg2, int arg3,
			double arg4, int arg5) {
		// TODO Auto-generated method stub
		
	}

	public void updateMktDepthL2(int arg0, int arg1, String arg2, int arg3,
			int arg4, double arg5, int arg6) {
		// TODO Auto-generated method stub
		
	}

	public void updateNewsBulletin(int arg0, int arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		
	}

	public void updatePortfolio(Contract arg0, int arg1, double arg2,
			double arg3, double arg4, double arg5, double arg6, String arg7) {
		// TODO Auto-generated method stub
		
	}

	public void connectionClosed() {
		// TODO Auto-generated method stub
		
	}

	public void error(Exception arg0) {
		
		
	}

	public void error(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void error(int id, int errorCode, String errorMsg) {
		log.error ("errorCode "+errorCode+" error "+errorMsg);
		
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
