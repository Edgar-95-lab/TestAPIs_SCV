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

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia/postFVCambioFolioXCancelacion'))

/**
 * Evaluación para códigos de estado de respuesta HTTP
 * */
if (WS.verifyResponseStatusCodeInRange(response, 200, 204) == true) {
	/**
	 * Evaluar la respuesta booleana de acuerdo al estado de consulta
	 * */
	if (WS.getElementPropertyValue(response, 'bResultado') == true) {
		/**
		 * Verificar la existencia de mensaje
		 * */
		if(WS.getElementPropertyValue(response, 'vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchMensaje', 'No se muestra mensaje')
		}
		/**
		 * Verificar que el código de error se encuentre en 0
		 * */
		WS.verifyElementPropertyValue(response, 'iError', 0)
		/**
		 * Verificar la relación entre tiOficina y vchOficina
		 * */
		if(WS.getElementPropertyValue(response, 'tiOficina') < 0 || WS.getElementPropertyValue(response, 'vchOficina').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'tiOficina', 'Verificar número de oficina')
			
			WS.verifyElementPropertyValue(response, '.vchOficina', 'verificar vchOficina')
			
		}
		/**
		 * Verificar que exista un nombre asignado
		 * */
		if(WS.getElementPropertyValue(response, 'vchNombre').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchNombre', 'No se muestra el nombre')
		}

		/**
		 * Verificar longitud del RFC
		 * */
		if(!(WS.getElementPropertyValue(response, 'vchRFC').toString().length() == 12 || WS.getElementPropertyValue(response, 'vchRFC').toString().length() == 13))
		{
			WS.verifyElementPropertyValue(response, 'vchRFC', 'Longitud incorrecta en el RFC')
		
		}
		
		/**
		 * Verificar que la fehca asignada sea correcta
		 * */
		if(WS.getElementPropertyValue(response, 'iNumeroForma') < 0 || WS.getElementPropertyValue(response, '[0].vchDescripcionForma').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'iNumeroForma', 'Verificar número en iNumeroForma')
			
			WS.verifyElementPropertyValue(response, 'vchDescripcionForma', 'Falta decripción en la forma')
			
		}
		
		/**
		 * Verificar el estatus
		 * */
		if(WS.getElementPropertyValue(response, 'iIdEstatus') <= 0 || WS.getElementPropertyValue(response, 'vchEstatus').toString().equals('0'))
		{
			WS.verifyElementPropertyValue(response, 'iIdEstatus', 'verificar el id asignado')
			WS.verifyElementPropertyValue(response, 'vchEstatus', 'Falta mostrar mensaje en estatus')
		}
		
	} else {
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
} else {
	WS.verifyResponseStatusCode(response, 'Error en la petición, verifique el número correspondiente')
}