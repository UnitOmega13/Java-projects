public class Main {
	public static void main(String[] args) {
		SquareRootFinder squareRootFinder = new SquareRootFinder();
		PetOwner newPetOwner = new PetOwner.Builder()
				.withName("Max")
				.withSurname("Hruslov")
				.petAge(1)
				.petName("Napoleon")
				.petCount(3)
				.petGender("male")
				.petType("cat")
				.build();

		System.out.println(newPetOwner.toString());
		System.out.println(squareRootFinder.findSquareRoot(144));
	}
}
