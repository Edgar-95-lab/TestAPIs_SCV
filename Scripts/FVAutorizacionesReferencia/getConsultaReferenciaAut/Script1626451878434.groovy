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

int operation = 21022144

int valor = 0

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia/getConsultaReferenciaAut'))

/**
 * Evaluación para códigos de estado de respuesta HTTP
 * */
if (WS.getResponseStatusCode(response) == 200) {
	/**
	 * Evaluar la respuesta booleana de acuerdo al estado de consulta
	 * */
	if(WS.getElementPropertyValue(response, 'bResultado') == true)
	{
		/**
		 * Evaluar que la fecha se muestre correctamente
		 * */
		if(WS.getElementPropertyValue(response, 'dFechaEmision').toString().equals('1900-01-01T00:00:00') || WS.getElementPropertyValue(response, 'dFechaVigencia').toString().equals('1900-01-01T00:00:00'))
		{
			WS.verifyElementPropertyValue(response, 'dFechaEmision', 'La fecha no se encuentra correcta: 1900-01-01T00:00:00')
			WS.verifyElementPropertyValue(response, 'dFechaVigencia', 'La fecha no se encuentra correcta: 1900-01-01T00:00:00')
			
		}
		/**
		 * Evaluar que el código de error sea siempre = 0.
		 * */
		WS.verifyElementPropertyValue(response, 'iError', 0)
		/**
		 * Verificar la existencia de estatusReferencia
		 * */
		if(WS.getElementPropertyValue(response, 'vchDescEstatusRef').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchDescEstatusRef', 'No se muestra estatus')
		}
		/**
		 * Verificar la existencia de estatusAut
		 * */
		if(WS.getElementPropertyValue(response, 'vchDescEtatusAut').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchDescEtatusAut', 'No se muestra estatus')
		}
		/**
		 * Verificar la existencia de mensaje 
		 * */
		if(WS.getElementPropertyValue(response, 'vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchMensaje', 'No se muestra mensaje')
		}
		/**
		 * Verificar nombre registrado
		 * */
		if(WS.getElementPropertyValue(response, 'vchNombre').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchClaveVehicular', 'Falta mostrar el nombre')
		}

		/**
		 * Verificar la longitud de la referencia
		 * */
		if(WS.getElementPropertyValue(response, 'vchReferencia').toString().length() != 20)
		{
			WS.verifyElementPropertyValue(response, 'vchReferencia', 'Longitud incorrecta en Referencia')
		}
		
		
	}else
	{
		/**
		 * Condición para verificar la asignación correcta de un mensaje.
		 * */
		if(WS.getElementPropertyValue(response, 'vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchMensaje', 'No existe mensaje asignado')
			
		}
		
		/**
		 * Verificar la asignación de código de error
		 * */
		if(WS.getElementPropertyValue(response, 'iError') <= 0)
		{
			WS.verifyElementPropertyValue(response, 'iError', 'No existe código de error asignado')
			
		}
		
	}
	
} else if (WS.getResponseStatusCode(response) == 401) {
	println('Acceso no autorizado')
} else {
	WS.verifyResponseStatusCode(response, 'Nuevo error encontrado')
}

