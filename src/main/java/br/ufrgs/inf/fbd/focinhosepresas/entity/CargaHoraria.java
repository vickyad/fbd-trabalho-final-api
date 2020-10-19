package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "carga_horaria", uniqueConstraints=
@UniqueConstraint(columnNames={"cpf_funcionario", "id_horario_trab"}))
public class CargaHoraria {
    private static final String SEQUENCE_NAME = "carga_horaria_id_ch_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name = "id_ch")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cpf_funcionario", nullable = false)
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "id_horario_trab", nullable = false)
    private HorarioTrabalho horarioTrabalho;

}
