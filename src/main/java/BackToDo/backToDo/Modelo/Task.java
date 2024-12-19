package BackToDo.backToDo.Modelo;

import jakarta.persistence.*;


@Entity
@Table(name="tasks")  //Nombre tabla en la bd

public class Task {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(nullable = false)
        private String nombre;


        @Column(nullable = false)
        private String fechaInicio;


        @Column(nullable = false)
        private String estatus;

        // Constructor vacío
        public Task() {
        }

        // Constructor con parámetros
        public Task(Long id, String nombre, String fechaInicio, String estatus) {
            this.id = id;
            this.nombre = nombre;
            this.fechaInicio = fechaInicio;
            this.estatus = estatus;
        }

        // Getters y Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getFechaInicio() {
            return fechaInicio;
        }

        public void setFechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public String getEstatus() {
            return estatus;
        }

        public void setEstatus(String estatus) {
            this.estatus = estatus;
        }
}
