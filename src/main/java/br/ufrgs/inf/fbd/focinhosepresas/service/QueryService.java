package br.ufrgs.inf.fbd.focinhosepresas.service;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Funcionario;
import br.ufrgs.inf.fbd.focinhosepresas.entity.Pedido;
import br.ufrgs.inf.fbd.focinhosepresas.model.AvailableStaff;
import br.ufrgs.inf.fbd.focinhosepresas.model.OrderInfo;
import br.ufrgs.inf.fbd.focinhosepresas.model.PetInfo;
import br.ufrgs.inf.fbd.focinhosepresas.model.TotalSpentByClient;
import br.ufrgs.inf.fbd.focinhosepresas.repository.*;
import br.ufrgs.inf.fbd.focinhosepresas.utils.DateUtils;
import br.ufrgs.inf.fbd.focinhosepresas.view.PetCliente;
import br.ufrgs.inf.fbd.focinhosepresas.view.TotalGasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QueryService {

    private final PetClienteRepository petClienteRepository;

    private final FuncionarioRepository funcionarioRepository;

    private final TotalGastoRepository totalGastoRepository;

    private final PedidoRepository pedidoRepository;
    
    private final ClienteRepository clienteRepository;

    @Autowired
    public QueryService(
            PetClienteRepository petClienteRepository,
            FuncionarioRepository funcionarioRepository,
            TotalGastoRepository totalGastoRepository,
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository
    ) {
        this.petClienteRepository = petClienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.totalGastoRepository = totalGastoRepository;
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<?> getPetInfo(String nomePet, Long cpf) {
        final Optional<PetCliente> petClienteSearch = this.petClienteRepository.getPetInfo(nomePet, cpf);

        if (petClienteSearch.isEmpty()) {
            return new ResponseEntity<>("Nada encontrado.", HttpStatus.NO_CONTENT);
        } else {
            final PetCliente petCliente = petClienteSearch.get();
            final PetInfo petInfo = new PetInfo(petCliente);
            return new ResponseEntity<>(petInfo, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<String>> getClientByPet(String nomeEspecie) {
        final List<String> clientNameList = this.petClienteRepository.getClientByPet(nomeEspecie);

        return new ResponseEntity<>(clientNameList, HttpStatus.OK);
    }

    public ResponseEntity<List<AvailableStaff>> getAvailableStaff(LocalDateTime dateTime) {
        final LocalDate date = dateTime.toLocalDate();
        final LocalTime initHour = dateTime.toLocalTime();
        final LocalTime endHour = DateUtils.addHours(initHour, 1);
        final LocalTime preHour = DateUtils.addHours(initHour, -2);
        final String dayOfWeekPt = DateUtils.getDowPt(date);

        final List<Funcionario> funcionarioList = this.funcionarioRepository.getAvailableStaff(date, dayOfWeekPt, initHour, endHour, preHour);

        final List<AvailableStaff> availableStaffList = funcionarioList.stream().map(AvailableStaff::new).collect(Collectors.toList());

        return new ResponseEntity<>(availableStaffList, HttpStatus.OK);
    }

    public ResponseEntity<List<TotalGasto>> getClienteWithSpendingAboveAverage() {
        final List<TotalGasto> totalGastoList = this.totalGastoRepository.getClienteWithSpendingAboveAverage();

        return new ResponseEntity<>(totalGastoList, HttpStatus.OK);
    }

    public ResponseEntity<List<?>> getClientsWithNoDelivers() {
        final List<?> clienteList = this.clienteRepository.getClientsWithNoDelivers();

        return new ResponseEntity<>(clienteList, HttpStatus.OK);
    }

    public ResponseEntity<?> getPetAppointmentsByClientAndDate(Long cpf, LocalDate data) {
        final Optional<Integer> petAppointments = this.clienteRepository.getPetAppointmentsByClientAndDate(cpf, data);
    
        if (petAppointments.isPresent()) {
            return new ResponseEntity<>(petAppointments.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nada encontrado.", HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<List<TotalSpentByClient>> getTotalSpentByClient() {
        final List<TotalSpentByClient> totalSpentByClientList = this.clienteRepository.getTotalSpentByClients();
        return new ResponseEntity<>(totalSpentByClientList, HttpStatus.OK);
    }

    public ResponseEntity<List<OrderInfo>> getOrderInfo(Long nroPed) {
        final List<OrderInfo> orderList = this.pedidoRepository.getOrderInfo(nroPed);

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    public ResponseEntity<?> getDelivermanDelivers() {
        return new ResponseEntity<>("deliverman_delivers", HttpStatus.OK);
    }

    public ResponseEntity<?> getAppointmentsByDate() {
        return new ResponseEntity<>("appointments_by_date", HttpStatus.OK);
    }

    public ResponseEntity<?> getTreatmentsByDate() {
        return new ResponseEntity<>("treatments_by_date", HttpStatus.OK);
    }

    public ResponseEntity<?> getDeliversNotDelivered() {
        return new ResponseEntity<>("delivers_not_delivered", HttpStatus.OK);
    }

    public ResponseEntity<?> getPetRecords() {
        return new ResponseEntity<>("pet_records", HttpStatus.OK);
    }
}
