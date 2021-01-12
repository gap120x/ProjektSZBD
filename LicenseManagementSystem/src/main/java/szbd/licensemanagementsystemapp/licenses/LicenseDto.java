package szbd.licensemanagementsystemapp.licenses;

import java.time.LocalDate;

public class LicenseDto {
	private Long licenseId;
	private String licenseKey;
	private LocalDate releaseDate;
	private LocalDate expirationDate;
	private String softwareName;
	public LicenseDto(Long licenseId, String licenseKey, LocalDate releaseDate, LocalDate expirationDate,
			String softwareName) {
		super();
		this.licenseId = licenseId;
		this.licenseKey = licenseKey;
		this.releaseDate = releaseDate;
		this.expirationDate = expirationDate;
		this.softwareName = softwareName;
	}
	public Long getLicenseid() {
		return licenseId;
	}
	public void setLicenseid(Long licenseId) {
		this.licenseId = licenseId;
	}
	public String getLicensekey() {
		return licenseKey;
	}
	public void setLicensekey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	public LocalDate getReleasedate() {
		return releaseDate;
	}
	public void setReleasedate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public LocalDate getExpirationdate() {
		return expirationDate;
	}
	public void setExpirationdate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getSoftwarename() {
		return softwareName;
	}
	public void setSoftwarename(String softwareName) {
		this.softwareName = softwareName;
	}
	
	

}
