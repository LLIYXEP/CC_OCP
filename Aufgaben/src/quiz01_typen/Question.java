package quiz01_typen;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String themes;
	
	private String formulierung;
	
	private List<Answer> antworts = new ArrayList<Answer>();
	
	private String komment;


	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	public String getFormulierung() {
		return formulierung;
	}

	public void setFormulierung(String formulierung) {
		this.formulierung = formulierung;
	}

	public List<Answer> getAntworts() {
		return antworts;
	}

	public void setAntworts(List<Answer> antworts) {
		this.antworts = antworts;
	}

	public String getKomment() {
		return komment;
	}

	public void setKomment(String komment) {
		this.komment = komment;
	}



	public Question(String themes, String formulierung, List<Answer> antworts, String komment) {
		super();
		this.themes = themes;
		this.formulierung = formulierung;
		this.antworts = antworts;
		this.komment = komment;
	}

	@Override
	public String toString() {
		return "Question [themes=" + themes + ", formulierung=" + formulierung + ", antworts=" + antworts + ", komment="
				+ komment + "]";
	}
	
	
	
}
