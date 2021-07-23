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
import java.util.Date as Date

int operation = 21022095

int valor = 0

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia/getConsultaReferencia'))

/**
 * Obtener la fecha para evaluar posteriormente la asignación deseada.
 * */
Date fecha = new Date()

String hoy = fecha.format('yyyy-MM-dd') + 'T00:00:00'

/**
 * Evaluación para códigos de estado de respuesta HTTP
 * */
if (WS.getResponseStatusCode(response) == 200) {
	/**
	 * Evaluar la respuesta booleana de acuerdo al estado de consulta
	 * */
    if (WS.getElementPropertyValue(response, '[0].bResultado') == true) {
		/**
		 * Condición para verificar la asignación correcta de un mensaje.
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].vchMensaje', 'No existe mensaje asignado')
			
		}
		/**
		 * Ciclo para verificar que el parámetro a evaluar realmenete se está actualizando.
		 * */
        for (int i = operation; i <= WS.getElementPropertyValue(response, '[0].iNoOperacionModificacion'); i++) {
            valor = i
        }
        
        WS.verifyElementPropertyValue(response, '[0].iNoOperacionModificacion', valor)
		/**
		 * Evaluar que el código de error sea siempre = 0. Ya que [0].bResultado se encuentra en true.
		 * */
        WS.verifyElementPropertyValue(response, '[0].iError', 0)
		/**
		 * Verificar que la longitud de la referencia sea igual a 20.
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchReferencia').toString().length() != 20)
		{
			WS.verifyElementPropertyValue(response, '[0].vchReferencia', 'La longitud en vchReferencia es incorrecta')
			
		}
		/**
		 * Verificar la relación entre tiOficina y vchOficina
		 * */
		if(WS.getElementPropertyValue(response, '[0].tiOficina') < 0 || WS.getElementPropertyValue(response, '[0].vchOficina').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].tiOficina', 'Verificar número de oficina')
			
		    WS.verifyElementPropertyValue(response, '[0].vchOficina', 'verificar vchOficina')
			
		}
		/**
		 * Verificar la relación entre smTipoMovimiento y vchMovimiento
		 * */
		if(WS.getElementPropertyValue(response, '[0].smTipoMovimiento') < 0 || WS.getElementPropertyValue(response, '[0].vchMovimiento').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].smTipoMovimiento', 'Verificar número en Tipo de movimiento')
				
			WS.verifyElementPropertyValue(response, '[0].vchMovimiento', 'verificar vchMovimiento')
				
		}
		/**
		 * Verificar que exista contenido en vchPlaca
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchPlaca').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].vchPlaca', 'No hay registro de placa')
		}
		/**
		 * Verificar que exista un nombre asignado
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchNombre').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].vchNombre', 'No se muestra el nombre')
		}

		/**
		 * Verificar longitud del RFC
		 * */
		if(!(WS.getElementPropertyValue(response, '[0].vchRFC').toString().length() == 12 || WS.getElementPropertyValue(response, '[0].vchRFC').toString().length() == 13))
		{
			WS.verifyElementPropertyValue(response, '[0].vchRFC', 'Longitud incorrecta en el RFC')
		}

		/**
		 * Verificar que la fehca asignada sea correcta 
		 * */
        if (WS.getElementPropertyValue(response, '[0].dFechaExpedicion').equals('1900-01-01T00:00:00')) {
            WS.verifyElementPropertyValue(response, '[0].dFechaExpedicion', 'La fecha no se encuentra correcta: 1900-01-01T00:00:00')
			
        } 
        
		/**
		 * Verificar que la fehca asignada sea correcta
		 * */
		if(WS.getElementPropertyValue(response, '[0].iNumeroForma') < 0 || WS.getElementPropertyValue(response, '[0].vchDescripcionForma').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].iNumeroForma', 'Verificar número en iNumeroForma')
			
			WS.verifyElementPropertyValue(response, '[0].vchDescripcionForma', 'Falta decripción en la forma')
			
		}
        
		/**
		 * Verificar el estatus
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchEstatus').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].vchEstatus', 'Falta mostrar mensaje en estatus')
		}
		
		/**
		 * Verificar relación entre vchIdentificacion y vchFolioIdentificacion
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchIdentificacion').toString().equals('') || WS.getElementPropertyValue(response, '[0].vchFolioIdentificacion').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].vchIdentificacion', 'Verificar vchIdentificacion')
			
			WS.verifyElementPropertyValue(response, '[0].vchFolioIdentificacion', 'Falta folio en vchFolioIdentificacion')
			
		}
		
		/**
		 * Verificar clave vehicular
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchClaveVehicular').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].vchClaveVehicular', 'Falta mostrar clave vehicular')
		}

		/**
		 * Verificar longitud de la CURP
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchCURP').toString().length() != 18)
		{
			WS.verifyElementPropertyValue(response, '[0].vchCURP', 'Longitud incorrecta en CURP')
		}
        
    } else {
		/**
		 * Condición para verificar la asignación correcta de un mensaje.
		 * */
		if(WS.getElementPropertyValue(response, '[0].vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, '[0].vchMensaje', 'No existe mensaje asignado')
			
		}
		
		/**
		 * Verificar la asignación de código de error
		 * */
		if(WS.getElementPropertyValue(response, '[0].iError') <= 0)
		{
			WS.verifyElementPropertyValue(response, '[0].iError', 'No existe código de error asignado')
			
		}

            
    }
} else if (WS.getResponseStatusCode(response) == 401) {
    println('Acceso no autorizado')
} else {
    WS.verifyResponseStatusCode(response, 'Nuevo error encontrado')
}

