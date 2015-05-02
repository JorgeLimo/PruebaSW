package models;

public class TarjetaCredito {

	
	public String validar(String tc, String cvc, String mes, String anno)
	{		
		try
		{
			if(tc.equals("4242424242424242") && cvc.equals("222") && mes.equals("1") && anno.equals(2018))
			{
				return null;
			}
			else if(tc.equals("4242424242424243"))
			{
				return "Saldo insuficiente";
			}
			
			return "Tarjeta denegada. Pruebe con otra tarjeta.";
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
