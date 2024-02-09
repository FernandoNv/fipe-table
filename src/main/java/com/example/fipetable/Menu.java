package com.example.fipetable;

import com.example.fipetable.dto.ModelsDTO;
import com.example.fipetable.dto.DataDTO;
import com.example.fipetable.dto.VehicleDTO;
import com.example.fipetable.model.Data;
import com.example.fipetable.service.APIConsumer;
import com.example.fipetable.service.DataParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final APIConsumer api = new APIConsumer();
    private final DataParser dataParser = new DataParser();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() throws IOException, InterruptedException {
        System.out.println("OPÇÕES DE VEICULOS");
        String[] options = { "carros", "motos", "caminhoes" };

        for(String option : options){
            System.out.println(option);
        }
        String option = scanner.nextLine().trim() + "/marcas";

        String json = api.getData(option);
        List<Data> dataList = dataParser.parseListData(json, DataDTO.class).stream()
                .map(Data::new)
                .sorted(Comparator.comparing(Data::getCode))
                .toList();

        System.out.println("MARCAS");
        dataList.forEach(System.out::print);

        System.out.println("Selecione o codigo da marca");
        int codeBrand = scanner.nextInt();
        scanner.nextLine();
        option = option + "/" + codeBrand + "/modelos";

        json = api.getData(option);

        ModelsDTO modelsDTO = dataParser.parseData(json, ModelsDTO.class);
        List<Data> vehicleList = modelsDTO.dataDTOList().stream()
                .map(Data::new)
                .sorted(Comparator.comparing(Data::getCode))
                .toList();

        System.out.println("Lista de veiculos");
        vehicleList.forEach(System.out::print);

        System.out.println("Digite o veiculo que você deseja comprar");
        String vehicle = scanner.nextLine().trim();

        List<Data> vehiclesFiltered = vehicleList.stream()
                .filter(v -> v.getName().toUpperCase().contains(vehicle.toUpperCase()))
                .toList();

        System.out.println();
        System.out.println("Veiculos encontrados");
        vehiclesFiltered.forEach(System.out::print);

        System.out.println("Informe o codigo do modelo desejado");
        int code = scanner.nextInt();
        scanner.nextLine();

        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        String url = option + "/" + code + "/anos";
        String jsonReq = api.getData(url);
        List<DataDTO> listVehiclesPerYears = dataParser.parseListData(jsonReq, DataDTO.class);
        for (DataDTO years : listVehiclesPerYears){
            String jsonReqYear = api.getData(url + "/" + years.code());
            VehicleDTO vehicleDTO = dataParser.parseData(jsonReqYear, VehicleDTO.class);

            vehicleDTOList.add(vehicleDTO);
        }

        vehicleDTOList.forEach(System.out::println);

    }
}
