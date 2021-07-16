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

int operation = 21021588

int valor = 0

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia_SU/getConsultaReferencia_SU'))

Date fecha = new Date()

String hoy = fecha.format('yyyy-MM-dd') + 'T00:00:00'


if(WS.getResponseStatusCode(response) == 200)
{
	if (WS.getElementPropertyValue(response, '[0].bResultado') == true) {
		WS.verifyElementPropertyValue(response, '[0].vchMensaje', 'Consulta de referencia correcta')
	
		for (int i = operation; i <= WS.getElementPropertyValue(response, '[0].iNoOperacionModificacion'); i++) {
			valor = i
		}
		
		WS.verifyElementPropertyValue(response, '[0].iNoOperacionModificacion', valor)
	
		WS.verifyElementPropertyValue(response, '[0].iError', 0)
	
		WS.verifyElementPropertyValue(response, '[0].vchReferencia', 11125120071631703225)
	
		WS.verifyElementPropertyValue(response, '[0].tiOficina', 0)
	
		WS.verifyElementPropertyValue(response, '[0].vchOficina', 'PUEBLA I FINANZAS')
	
		WS.verifyElementPropertyValue(response, '[0].smTipoMovimiento', 1)
	
		WS.verifyElementPropertyValue(response, '[0].vchMovimiento', 'ALTA VEHICULO')
	
		WS.verifyElementPropertyValue(response, '[0].iNoOperacion', 21019796)
	
		WS.verifyElementPropertyValue(response, '[0].iControl', 200002523)
	
		WS.verifyElementPropertyValue(response, '[0].vchPlaca', '13DGS2')
	
		WS.verifyElementPropertyValue(response, '[0].vchNombre', 'SANTOS CAZARIN CRUZ DAVID ESTUARDO')
	
		WS.verifyElementPropertyValue(response, '[0].vchRFC', 'SACC790503PC6')
	
		WS.verifyElementPropertyValue(response, '[0].iModelo', 2020)
	
		WS.verifyElementPropertyValue(response, '[0].tiClaseTipo', 71)
	
		WS.verifyElementPropertyValue(response, '[0].vchSerie', 'F25BKFA4903')
	
		WS.verifyElementPropertyValue(response, '[0].tiCilindros', 0)
	
		WS.verifyElementPropertyValue(response, '[0].vchNoMotor', 'MOTORNO')
	
		WS.verifyElementPropertyValue(response, '[0].tiCombustible', 77)
	
		WS.verifyElementPropertyValue(response, '[0].tiTipoServicio', 86)
	
		WS.verifyElementPropertyValue(response, '[0].vchProcedencia', 'NACIONAL')
		
		if(WS.getElementPropertyValue(response, '[0].dFechaExpedicion').equals('1900-01-01T00:00:00'))
		{
			WS.verifyElementPropertyValue(response, '[0].dFechaExpedicion', 'Error: 1900-01-01T00:00:00')
			
		}else {
			
			WS.verifyElementPropertyValue(response, '[0].dFechaExpedicion', WS.getElementPropertyValue(response, '[0].dFechaExpedicion'))
		}
		
		
	
		WS.verifyElementPropertyValue(response, '[0].vchVigencia', 'PERMANENTE')
	
		WS.verifyElementPropertyValue(response, '[0].tiTramite', 2)
	
		WS.verifyElementPropertyValue(response, '[0].vchCalcomania', '')
	
		WS.verifyElementPropertyValue(response, '[0].vchUsoVehiculo', '01')
	
		WS.verifyElementPropertyValue(response, '[0].iNumeroForma', 12)
	
		WS.verifyElementPropertyValue(response, '[0].vchDescripcionForma', 'TARJETA DE CIRCULACION')
		
		if(WS.getElementPropertyValue(response, '[0].iFolio') == -1)
		{
			WS.verifyElementPropertyValue(response, '[0].iIdEstatus', 1)
			
				WS.verifyElementPropertyValue(response, '[0].vchEstatus', 'REGISTRADO')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreTramite', 'SANTOS CAZARIN CRUZ DAVID ESTUARDO')
			
				WS.verifyElementPropertyValue(response, '[0].vchIdentificacion', 'I.F.E.                                  ')
			
				WS.verifyElementPropertyValue(response, '[0].vchFolioIdentificacion', 'NA')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalcomaniaAlfanumerica', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchToneladas', '2500')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalle', '221')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoExterior', '22211')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoInterior', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLetra', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchColonia', 'LAS CANOAS                                                                                          ')
			
				WS.verifyElementPropertyValue(response, '[0].vchLocalidad', 'APATAUYAN                                                                                           ')
			
				WS.verifyElementPropertyValue(response, '[0].vchMunicipio', 'ATEMPAN                                                                                             ')
			
				WS.verifyElementPropertyValue(response, '[0].vchComplemento', 'PLACA= 13DGS2 #NIV= F25BKFA4903')
			
				WS.verifyElementPropertyValue(response, '[0].vchDescCombustible', 'GASOLINA  ')
			
				WS.verifyElementPropertyValue(response, '[0].tiFirma', 1)
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma', 'SECRETARIA DE PLANEACION Y FINANZAS')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma', 'ACT.  MARIA TERESA CASTRO CORRO')
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma2', 'SECRETARIO DE MOVILIDAD Y TRANSPORTE')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma2', 'MTRO. GUILLERMO ARECHIGA SANTAMARIA')
			
				WS.verifyElementPropertyValue(response, '[0].vchClaveVehicular', '2020517')
			
				WS.verifyElementPropertyValue(response, '[0].vchEmpresa', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCURP', 'SACC790503HVZNZR00')
			
				WS.verifyElementPropertyValue(response, '[0].tiBan_cve_veh', 2)
			
				WS.verifyElementPropertyValue(response, '[0].vchDesc_uso', 'PARTICULAR                                        ')
			
				WS.verifyElementPropertyValue(response, '[0].tiAsignacion', 1)
			
				WS.verifyElementPropertyValue(response, '[0].vchMarca2', 'FORD           ')
			
				WS.verifyElementPropertyValue(response, '[0].vchLinea2', 'F - 700                  ')
			
				WS.verifyElementPropertyValue(response, '[0].vchTipo2', '153 LPG 28000 L')
		}else {
				
				WS.verifyElementPropertyValue(response, '[0].iIdEstatus', 3)
			
				WS.verifyElementPropertyValue(response, '[0].vchEstatus', 'ENTREGADO')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreTramite', 'SANTOS CAZARIN CRUZ DAVID ESTUARDO')
			
				WS.verifyElementPropertyValue(response, '[0].vchIdentificacion', 'I.F.E.                                  ')
			
				WS.verifyElementPropertyValue(response, '[0].vchFolioIdentificacion', 'NA')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalcomaniaAlfanumerica', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchToneladas', '2500')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalle', '221')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoExterior', '22211')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoInterior', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLetra', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchColonia', 'LAS CANOAS                                                                                          ')
			
				WS.verifyElementPropertyValue(response, '[0].vchLocalidad', 'APATAUYAN                                                                                           ')
			
				WS.verifyElementPropertyValue(response, '[0].vchMunicipio', 'ATEMPAN                                                                                             ')
			
				WS.verifyElementPropertyValue(response, '[0].vchComplemento', 'PLACA= 13DGS2 #NIV= F25BKFA4903')
			
				WS.verifyElementPropertyValue(response, '[0].vchDescCombustible', 'GASOLINA  ')
			
				WS.verifyElementPropertyValue(response, '[0].tiFirma', 1)
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma', 'SECRETARIA DE PLANEACION Y FINANZAS')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma', 'ACT.  MARIA TERESA CASTRO CORRO')
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma2', 'SECRETARIO DE MOVILIDAD Y TRANSPORTE')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma2', 'MTRO. GUILLERMO ARECHIGA SANTAMARIA')
			
				WS.verifyElementPropertyValue(response, '[0].vchClaveVehicular', '2020517')
			
				WS.verifyElementPropertyValue(response, '[0].vchEmpresa', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCURP', 'SACC790503HVZNZR00')
			
				WS.verifyElementPropertyValue(response, '[0].tiBan_cve_veh', 2)
			
				WS.verifyElementPropertyValue(response, '[0].vchDesc_uso', 'PARTICULAR                                        ')
			
				WS.verifyElementPropertyValue(response, '[0].tiAsignacion', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchMarca2', 'FORD           ')
			
				WS.verifyElementPropertyValue(response, '[0].vchLinea2', 'F - 700                  ')
			
				WS.verifyElementPropertyValue(response, '[0].vchTipo2', '153 LPG 28000 L')
		}
	
		
	} else {
		
		if(WS.getElementPropertyValue(response, '[0].vchMensaje').equals('La referencia no se encuentra autorizada o pagada por lo que no se puede realizar la asignación de formas valoradas'))
		{
			WS.verifyElementPropertyValue(response, '[0].iNoOperacionModificacion', 0)
			
				WS.verifyElementPropertyValue(response, '[0].iError', 67112)
			
				WS.verifyElementPropertyValue(response, '[0].vchReferencia', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiOficina', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchOficina', '')
			
				WS.verifyElementPropertyValue(response, '[0].smTipoMovimiento', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchMovimiento', '')
			
				WS.verifyElementPropertyValue(response, '[0].iNoOperacion', -1)
			
				WS.verifyElementPropertyValue(response, '[0].iControl', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchPlaca', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombre', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchRFC', '')
			
				WS.verifyElementPropertyValue(response, '[0].iModelo', 0)
			
				WS.verifyElementPropertyValue(response, '[0].tiClaseTipo', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchSerie', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiCilindros', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchNoMotor', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiCombustible', 0)
			
				WS.verifyElementPropertyValue(response, '[0].tiTipoServicio', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchProcedencia', '')
			
				WS.verifyElementPropertyValue(response, '[0].dFechaExpedicion', '1900-01-01T00:00:00')
			
				WS.verifyElementPropertyValue(response, '[0].vchVigencia', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiTramite', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchCalcomania', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchUsoVehiculo', '')
			
				WS.verifyElementPropertyValue(response, '[0].iNumeroForma', -1)
			
				WS.verifyElementPropertyValue(response, '[0].vchDescripcionForma', '')
			
				WS.verifyElementPropertyValue(response, '[0].iFolio', 0)
			
				WS.verifyElementPropertyValue(response, '[0].iIdEstatus', -1)
			
				WS.verifyElementPropertyValue(response, '[0].vchEstatus', '0')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreTramite', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchIdentificacion', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchFolioIdentificacion', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalcomaniaAlfanumerica', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchToneladas', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalle', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoExterior', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoInterior', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLetra', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchColonia', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLocalidad', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchMunicipio', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchComplemento', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchDescCombustible', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiFirma', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchClaveVehicular', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchEmpresa', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCURP', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiBan_cve_veh', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchDesc_uso', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiAsignacion', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchMarca2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLinea2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchTipo2', '')
			
		}else if(WS.getElementPropertyValue(response, '[0].vchMensaje').equals('El usuario no tiene activo un rol de entregador.'))
		{
				WS.verifyElementPropertyValue(response, '[0].iNoOperacionModificacion', 0)
			
				WS.verifyElementPropertyValue(response, '[0].iError', 67104)
			
				WS.verifyElementPropertyValue(response, '[0].vchReferencia', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiOficina', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchOficina', '')
			
				WS.verifyElementPropertyValue(response, '[0].smTipoMovimiento', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchMovimiento', '')
			
				WS.verifyElementPropertyValue(response, '[0].iNoOperacion', -1)
			
				WS.verifyElementPropertyValue(response, '[0].iControl', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchPlaca', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombre', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchRFC', '')
			
				WS.verifyElementPropertyValue(response, '[0].iModelo', 0)
			
				WS.verifyElementPropertyValue(response, '[0].tiClaseTipo', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchSerie', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiCilindros', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchNoMotor', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiCombustible', 0)
			
				WS.verifyElementPropertyValue(response, '[0].tiTipoServicio', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchProcedencia', '')
			
				WS.verifyElementPropertyValue(response, '[0].dFechaExpedicion', '1900-01-01T00:00:00')
			
				WS.verifyElementPropertyValue(response, '[0].vchVigencia', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiTramite', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchCalcomania', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchUsoVehiculo', '')
			
				WS.verifyElementPropertyValue(response, '[0].iNumeroForma', -1)
			
				WS.verifyElementPropertyValue(response, '[0].vchDescripcionForma', '')
			
				WS.verifyElementPropertyValue(response, '[0].iFolio', 0)
			
				WS.verifyElementPropertyValue(response, '[0].iIdEstatus', -1)
			
				WS.verifyElementPropertyValue(response, '[0].vchEstatus', '0')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreTramite', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchIdentificacion', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchFolioIdentificacion', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalcomaniaAlfanumerica', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchToneladas', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCalle', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoExterior', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNoInterior', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLetra', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchColonia', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLocalidad', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchMunicipio', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchComplemento', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchDescCombustible', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiFirma', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchPuestoFirma2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchNombreFirma2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchClaveVehicular', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchEmpresa', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchCURP', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiBan_cve_veh', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchDesc_uso', '')
			
				WS.verifyElementPropertyValue(response, '[0].tiAsignacion', 0)
			
				WS.verifyElementPropertyValue(response, '[0].vchMarca2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchLinea2', '')
			
				WS.verifyElementPropertyValue(response, '[0].vchTipo2', '')
			
		}else {
			
				WS.verifyElementPropertyValue(response, '[0].vchMensaje', '0')
		}
	
	}
	
}else if(WS.getResponseStatusCode(response) == 401)
{
	println "Acceso no autorizado"
	
}else {
	WS.verifyResponseStatusCode(response, 200)
	WS.verifyResponseStatusCode(response, 401)
	println "Nuevo error encontrado"
	
}



