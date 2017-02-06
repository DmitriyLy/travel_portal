import com.netcracker.dto.AddressDto;
import com.netcracker.dto.CoordinatesDto;
import com.netcracker.dto.LabelDtoNew;
import com.netcracker.dto.LabelDtoUpdate;
import com.netcracker.entities.Label;
import com.netcracker.entities.User;
import com.netcracker.queries.QueriesSpecification;
import com.netcracker.repositories.impl.UserDAO;
import com.netcracker.services.Converter;
import com.netcracker.services.LabelService;
import com.netcracker.services.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author logariett.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/service-context.xml"})
public class LabelServiceTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LabelService labelService;
    @Autowired
    private TagService tagService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Converter converter;

/*    @Test
    public void addLabelTest() throws Exception {

//        long newId = labelService.getNewLabelId();
        long newId = 0;
        LabelDtoNew labelDto = new LabelDtoNew();

        labelDto.setId(newId);
        labelDto.setReview("do not go gently");
        labelDto.setRating(4);
        labelDto.setCreationDate(new Date());

        List<String> tags = new ArrayList<>(2);
        tags.add("Sea");
        tags.add("poo");
        labelDto.setTags(tags);

        List<String> categories = new ArrayList<>(2);
        categories.add("Medicine");
        categories.add("nonexistent");
        labelDto.setCategories(categories);

        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLatitude(46.49);
        coordinatesDto.setLongitude(30.73);
        labelDto.setCoordinates(coordinatesDto);

        AddressDto addressDto = new AddressDto();
        addressDto.setBuilding("19/1b");
        addressDto.setStreet("Mechta");
        addressDto.setCity("NeOdessa");
        addressDto.setState("NewOne");
        addressDto.setCountry("Neverland");
        labelDto.setAddress(addressDto);


        Label label = labelService.add("8482de9c-1e5d-4db2-9af8-667fdd85f2ec", labelDto);
        System.out.println(label);
    }

    @Test
    public void update() {
        LabelDtoUpdate labelDto = new LabelDtoUpdate();

        labelDto.setReview("do not go gently into that goodnight");
        labelDto.setRating(3);

        List<String> tags = new ArrayList<>(1);
        tags.add("poo");
        labelDto.setTags(tags);

        Label label = labelService.update(324, labelDto);
        System.out.println(label);
    }*/

    @Test
    public void testConverterForLabels() {
        Label label = labelService.getById(324);
        System.out.println("-------------");
        System.out.println(converter.convertLabelToDtoFullInfo(label));
        System.out.println("-------------");
        System.out.println(converter.convertLabelToDtoShortInfo(label));
    }

    @Test
    public void testGetLabelsByAddressParts() throws Exception {

        List<String> addressParts = new ArrayList<>();
        addressParts.add("Pivdenna Rd");

        //System.out.println(labelService.getLabelsByAddressParts(addressParts));
    }
}
