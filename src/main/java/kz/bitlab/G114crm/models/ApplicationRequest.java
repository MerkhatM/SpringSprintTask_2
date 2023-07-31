package kz.bitlab.G114crm.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "application_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userName;
  private String courseName;
  private String commentary;
  private String phone;
  private boolean handled; //обработано или нет
}
