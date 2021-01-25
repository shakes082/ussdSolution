package za.co.mamamoney.ussdservice.dtos;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import org.springframework.lang.Nullable;

public final class USSDRequest{

	@NotNull
	@Size(max=12, message="msisdn should not exceed 11 characters")
	@Pattern(regexp = "^(27|0)[0-9]{9}", message="msisdn should be formatted in 27 or 082 formats")
	private String msisdn;
	
	@Positive(message = "userEntry must be a positive integer")
	private int userEntry;

	@Nullable
	private Map<String, String> requestOptions = new HashMap<String, String>();
	
	public USSDRequest() {
	}

	public USSDRequest(
			@NotNull @Size(max = 12, message = "msisdn should not exceed 11 characters") @Pattern(regexp = "^(27|0)[0-9]{9}", message = "msisdn should be formatted in 27 or 082 formats") String msisdn,
			@Positive(message = "userEntry must be a positive integer") int userEntry,
			Map<String, String> requestOptions) {
		super();
		this.msisdn = msisdn;
		this.userEntry = userEntry;
		this.requestOptions = requestOptions;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public int getUserEntry() {
		return userEntry;
	}

	public void setUserEntry(int userEntry) {
		this.userEntry = userEntry;
	}

	public Map<String, String> getRequestOptions() {
		return requestOptions;
	}

	public void setRequestOptions(Map<String, String> requestOptions) {
		this.requestOptions = requestOptions;
	}
}
