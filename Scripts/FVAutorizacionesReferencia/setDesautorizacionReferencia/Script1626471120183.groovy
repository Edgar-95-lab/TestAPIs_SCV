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

int operation = 21022164

int valor = 0

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia/setDesautorizacionReferencia'))

if (WS.verifyResponseStatusCodeInRange(response, 200, 204) == true) {
    if (WS.getElementPropertyValue(response, 'bResultado') == true) {
		/**
		 * Evaluar que la fecha se muestre correctamente
		 * */
		if(WS.getElementPropertyValue(response, 'dFechaEmision').toString().equals('1900-01-01T00:00:00') || WS.getElementPropertyValue(response, 'dFechaVigencia').toString().equals('1900-01-01T00:00:00'))
		{
			WS.verifyElementPropertyValue(response, 'dFechaEmision', 'La fecha no se encuentra correcta: 1900-01-01T00:00:00')
			WS.verifyElementPropertyValue(response, 'dFechaVigencia', 'La fecha no se encuentra correcta: 1900-01-01T00:00:00')
			
		}
		/**
		 * Verificar que el c??digo de error se encuentre en 0
		 * */
		WS.verifyElementPropertyValue(response, 'iError', 0)
		/**
		 * Verificar el valor cambiante mediante el ciclo siguiente
		 * */
		for (int i = operation; i <= WS.getElementPropertyValue(response, 'iNoOperacionModificacion'); i++) {
			valor = i
		}
		
		WS.verifyElementPropertyValue(response, 'iNoOperacionModificacion', valor)
		/**
		 * Verificar que el monto sea mayor a 0
		 * */
		if(WS.getElementPropertyValue(response, 'mTotalReferencia') == 0)
		{
			WS.verifyElementPropertyValue(response, 'mTotalReferencia', 'El monto es 0')
			
		}
		
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
		
    } else {
		/**
		 * Ciclo para evaluar el cambio en modificaci??n
		 * */
		for (int i = operation; i <= WS.getElementPropertyValue(response, 'iNoOperacionModificacion'); i++) {
			valor = i
		}
		
		WS.verifyElementPropertyValue(response, 'iNoOperacionModificacion', valor)
		/**
		 * Condici??n para verificar la asignaci??n correcta de un mensaje.
		 * */
		if(WS.getElementPropertyValue(response, 'vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchMensaje', 'No existe mensaje asignado')
			
		}
		
		/**
		 * Verificar la asignaci??n de c??digo de error
		 * */
		if(WS.getElementPropertyValue(response, 'iError') <= 0)
		{
			WS.verifyElementPropertyValue(response, 'iError', 'No existe c??digo de error asignado')
			
		}
		
    }
} else {
    WS.verifyResponseStatusCode(response, 'Error en la petici??n, verifique el n??mero correspondiente')

}

