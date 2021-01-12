package szbd.licensemanagementsystemapp.customers;

public class CustomerDto {
	
		private Long userid; 
	    private String nickname;
	    private String password;
	    private String email;
	    private String firstname;
	    private String surname;  
	    private String role;
	    private boolean enabled;
	    private String vat;
	  	private String nip;
	  	private float discount;
	  	private String companyName;
		public Long getUserid() {
			return userid;
		}
		public void setUserid(Long userid) {
			this.userid = userid;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public String getVat() {
			return vat;
		}
		public void setVat(String vat) {
			this.vat = vat;
		}
		public String getNip() {
			return nip;
		}
		public void setNip(String nip) {
			this.nip = nip;
		}
		public float getDiscount() {
			return discount;
		}
		public void setDiscount(float discount) {
			this.discount = discount;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getFirstnameandsurname()
		{
			return firstname+" "+surname;
		}
		public CustomerDto(Long userid, String nickname, String password, String email, String firstname,
				String surname, String role, boolean enabled, String vat, String nip, float discount,
				String companyName) {
			super();
			this.userid = userid;
			this.nickname = nickname;
			this.password = password;
			this.email = email;
			this.firstname = firstname;
			this.surname = surname;
			this.role = role;
			this.enabled = enabled;
			this.vat = vat;
			this.nip = nip;
			this.discount = discount;
			this.companyName = companyName;
		}	
	  	
	  	

}
