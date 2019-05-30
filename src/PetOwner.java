public class PetOwner {
	private String name;
	private String surName;
	private String petName;
	private int petAge;
	private int petCount;
	private String typeOfPet;
	private String genderOfPet;

	public static class Builder {
		private PetOwner newPetOwner;

		public Builder() {
			newPetOwner = new PetOwner();
		}

		public Builder withName(String name) {
			newPetOwner.name = name;
			return this;
		}

		public Builder withSurname(String surName) {
			newPetOwner.surName = surName;
			return this;
		}

		public Builder petName(String petName) {
			newPetOwner.petName = petName;
			return this;
		}

		public Builder petAge(int petAge) {
			newPetOwner.petAge = petAge;
			return this;
		}

		public Builder petCount(int petCount) {
			newPetOwner.petCount = petCount;
			return this;
		}

		public Builder petType(String petTipe) {
			newPetOwner.typeOfPet = petTipe;
			return this;
		}

		public Builder petGender(String petGender) {
			newPetOwner.genderOfPet = petGender;
			return this;
		}

		public PetOwner build() {
			return newPetOwner;
		}

	}

	@Override
	public String toString() {
		return "PetOwner{" +
				"name='" + name + '\'' +
				", surName='" + surName + '\'' +
				", petName='" + petName + '\'' +
				", petAge=" + petAge +
				", petCount=" + petCount +
				", typeOfPet='" + typeOfPet + '\'' +
				", genderOfPet='" + genderOfPet + '\'' +
				'}';
	}
}
