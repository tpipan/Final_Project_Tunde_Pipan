package Tests;

import ObjectModel.RegisterModel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterXMLTest extends BaseTest{
    @DataProvider(name = "xmlDp")
    public Iterator<Object[]> xmlDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
        File file = new File("src\\test\\resources\\Data\\testdata.xml");
        RegisterModel registerModel = unMarshalRegisterModel(file);
        dp.add(new Object[]{registerModel});
        return dp.iterator();
    }

    private RegisterModel unMarshalRegisterModel(File f) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RegisterModel.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            return (RegisterModel) jaxbUnMarshaller.unmarshal(f);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test(dataProvider = "xmlDp")
    public void RegisterWithXMLAsDataSource(RegisterModel lm) {
        registerLm(lm);

    }

    private void registerLm(RegisterModel lm) {
    }


}
