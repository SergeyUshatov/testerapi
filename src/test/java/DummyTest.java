import org.junit.jupiter.api.Test;
import petstore.Pet;
import petstore.PetStore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DummyTest {

    @Test
    public void dummyTest() {
        PetStore petStore = new PetStore();
        Pet pet = new Pet();
        Pet newPet = petStore.addPet(pet);

        assertThat(newPet.getKind(), equalTo(pet.getKind()));
    }
}
