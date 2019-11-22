import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Horloge {

	public Date getTemps() {
		return new Date();
	}
}
