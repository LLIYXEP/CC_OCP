package quiz01_typen;

public class Answer {

	private String formulierung;
	
	private Boolean result;

	public String getFormulierung() {
		return formulierung;
	}

	public void setFormulierung(String formulierung) {
		this.formulierung = formulierung;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Answer(String formulierung, Boolean result) {
		super();
		this.formulierung = formulierung;
		this.result = result;
	}

	@Override
	public String toString() {
		return "Answer [formulierung=" + formulierung + ", result=" + result + "]";
	}
	
	
	
}
