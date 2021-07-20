import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

int operation = 21012130

int valor = 0

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia_SU/setDesautorizacionReferencia_SU'))

if(WS.getResponseStatusCode(response) == 200)
	{
		if(WS.getElementPropertyValue(response, 'bResultado') == true)
			{
				WS.verifyElementPropertyValue(response, 'dFechaEmision', '2021-07-09T00:00:00')
				
				WS.verifyElementPropertyValue(response, 'dFechaVigencia', '2021-07-09T00:00:00')
				
				WS.verifyElementPropertyValue(response, 'iError', 0)
				
				for (int i = operation; i <= WS.getElementPropertyValue(response, 'iNoOperacionModificacion'); i++)
					{
					valor = i
					}
					
				WS.verifyElementPropertyValue(response, 'iNoOperacionModificacion', valor)
				
				
				WS.verifyElementPropertyValue(response, 'vchDescEstatusRef', 'EMITIDO')
				
				WS.verifyElementPropertyValue(response, 'vchDescEtatusAut', 'NO AUTORIZADA')
				
				WS.verifyElementPropertyValue(response, 'vchMensaje', 'La referencia se desautorizó correctamente')
				
				
				WS.verifyElementPropertyValue(response, 'vchNombre', 'SANTOS CAZARIN CRUZ DAVID ESTUARDO')
				
				WS.verifyElementPropertyValue(response, 'vchReferencia', '11125120071631703225')
				
			}else {
				
				WS.verifyElementPropertyValue(response, 'dFechaEmision', '1900-01-01T00:00:00')
				
				WS.verifyElementPropertyValue(response, 'dFechaVigencia', '1900-01-01T00:00:00')
				
				
					
					for (int i = operation; i <= WS.getElementPropertyValue(response, 'iNoOperacionModificacion'); i++)
						{
						valor = i
						}
						
					WS.verifyElementPropertyValue(response, 'iNoOperacionModificacion', valor)
					
					if(WS.getElementPropertyValue(response, 'iError') > 0)
						{
							
							
						}else {
							
							WS.verifyElementPropertyValue(response, 'iError', 'No hay un número de error asignado')
						}
						
						if(WS.getElementPropertyValue(response, 'vchMensaje').toString().length() > 0)
						{
							
						}else {
							
							WS.verifyElementPropertyValue(response, 'vchMensaje', 'No hay mensaje asignado para esta operación')
						}
					
				
				
			}
		
	}else if(WS.verifyResponseStatusCode(response, 401))
	{
		println "Acceso no autorizado"
		
	}else {
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyResponseStatusCode(response, 401)
		println "Nuevo error encontrado"
	}



