package com.javier.codigo.codigopostal.models.response;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

@Service
public class CodigoPostalMap {

	private Map<String, ResponseGeneric> codigoPostal = new HashMap<>();

	public Map<String, ResponseGeneric> getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Map<String, ResponseGeneric> codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	private CodigoPostalMap() {

	}
//	public CodigoPostalMap getInstance() {
//        if (codigoPostalMap == null) {
//        	codigoPostalMap = new CodigoPostalMap();
//        }
//        return codigoPostalMap;
//	}

	public ResponseGeneric getResponceGeneric(String codigoPostal) {
		codigoPostal();
		if (this.codigoPostal.containsKey(codigoPostal)) {
			return this.codigoPostal.get(codigoPostal);
		}
		return null;
	}

	public void codigoPostal() {
		if (codigoPostal == null || codigoPostal.size() == 0) {
			generateMap(codigoPostal);
		}

	}

	private void generateMap(Map<String, ResponseGeneric> codPostal) {
		try {
			WorkbookSettings settings = new WorkbookSettings();
			settings.setEncoding("iso8859-1");
			Workbook workbook = Workbook
					.getWorkbook(new File(this.getClass().getResource("/static/CPdescarga.xls").getPath()), settings);

			String[] nombres = workbook.getSheetNames();

			loadMap(nombres, workbook, codPostal);

		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}

	}

	private void loadMap(String[] nombres, Workbook workbook, Map<String, ResponseGeneric> codPostal) {
		for (int i = 1; i < nombres.length; i++) {
			Sheet sheet = workbook.getSheet(nombres[i]);
			int totalRows = sheet.getRows();
			for (int numRenglon = 1; numRenglon < totalRows; numRenglon++) {

				Cell[] celdas = sheet.getRow(numRenglon);
				if (celdas.length != 0) {
					String codigoPosta = celdas[0].getContents();
					String localidad = celdas[1].getContents();
					String asentamiento = celdas[2].getContents();
					String municipio = celdas[3].getContents();
					String estado = celdas[4].getContents();
					String ciudad = celdas[5].getContents();
					String zona = celdas[13].getContents();

					if (!codigoPosta.equals("")) {
						ResponseGeneric generic = new ResponseGeneric();
						Settlement settlement = new Settlement();
						List<Settlement> settlements = new ArrayList<>();

						if (codPostal.containsKey(codigoPosta)) {

							generic = codPostal.get(codigoPosta);
							settlement.setName(localidad);
							settlement.setSettlement_type(asentamiento);
							settlement.setZone_type(zona);
							settlements = generic.getSettlements();
							settlements.add(settlement);
							generic.setSettlements(settlements);
							codPostal.put(codigoPosta, generic);

						} else {
							settlement.setName(localidad);
							settlement.setSettlement_type(asentamiento);
							settlement.setZone_type(zona);
							settlements.add(settlement);

							generic.setZip_code(codigoPosta);
							generic.setLocality(estado);
							generic.setFederal_entity(ciudad);
							generic.setMunicipality(municipio);
							generic.setSettlements(settlements);

							codPostal.put(codigoPosta, generic);
//						System.out.println("agregado");
						}
					}
				}
			}
		}

	}

}
