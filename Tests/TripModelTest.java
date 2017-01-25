import DAO.TripDAO;
import Model.TripModel;
import POJO.Trip;
import Util.DatabaseUtil;
import javafx.collections.ObservableList;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripModelTest {

    int beforeLength;
    TripModel tripModel;

    @Before
    public void setUp(){
        tripModel = new TripModel();
        beforeLength = tripModel.getTrips().size();
    }

    @Test
    public void addTripLengthTest() throws Exception {
        tripModel.addTrip(new Trip());
        assertEquals(beforeLength + 1, tripModel.getTrips().size());
    }

}