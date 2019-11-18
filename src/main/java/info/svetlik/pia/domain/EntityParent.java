package info.svetlik.pia.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class EntityParent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
