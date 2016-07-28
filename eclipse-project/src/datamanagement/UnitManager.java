package datamanagement;

import java.util.List;
import org.jdom.*;

public class UnitManager {

    private final static UnitManager instance_ = new UnitManager();

    private UnitMap unitMap;

    public static UnitManager getInstance() {
        return instance_;
    }

    private UnitManager() {
        unitMap = new UnitMap();
    }

    public IUnit getUnit(String unitCode) {
        
        IUnit unitLikeObject = unitMap.get(unitCode);

        if (unitLikeObject == null) {
            unitLikeObject = createUnit(unitCode);
        }

        return unitLikeObject;
    }

    private IUnit createUnit(String unitCode) {
        
        IUnit unitLikeObject;
        List<Element> elementList = (List<Element>) XMLManager.getInstance()
                                                        .getDocument()
                                                        .getRootElement()
                                                        .getChild("unitTable")
                                                        .getChildren("unit");
        
        for (Element el : elementList)
            if (unitCode.equals(el.getAttributeValue("uid"))) {
                unitLikeObject = new Unit(el.getAttributeValue("uid"),
                        el.getAttributeValue("name"),
                        Float.valueOf(el.getAttributeValue("ps")).floatValue(),
                        Float.valueOf(el.getAttributeValue("cr")).floatValue(),
                        Float.valueOf(el.getAttributeValue("di")).floatValue(),
                        Float.valueOf(el.getAttributeValue("hd")).floatValue(),
                        Float.valueOf(el.getAttributeValue("ae")).floatValue(),
                        Integer.valueOf(el.getAttributeValue("asg1wgt"))
                                .intValue(),
                        Integer.valueOf(el.getAttributeValue("asg2wgt"))
                                .intValue(),
                        Integer.valueOf(el.getAttributeValue("examwgt"))
                                .intValue(),
                        StudentUnitRecordManager.instance()
                                .getRecordsByUnit(unitCode));
                unitMap.put(unitLikeObject.getUnitCode(), unitLikeObject);
                
                return unitLikeObject;
            }

        throw new RuntimeException("DBMD: createUnit : unit not in file");
    }

    public UnitMap getUnits() {
        
        IUnit unitLikeObject;
        UnitMap unitMap           = new UnitMap();
        List<Element> elementList = (List<Element>) XMLManager.getInstance()
                                                        .getDocument()
                                                        .getRootElement()
                                                        .getChild("unitTable")
                                                        .getChildren("unit");
        
        for (Element el : elementList) {
            unitLikeObject = new UnitProxy(el.getAttributeValue("uid"),
                                           el.getAttributeValue("name"));
            unitMap.put(unitLikeObject.getUnitCode(), unitLikeObject);
        } // unit maps are filled with PROXY units
        
        return unitMap;
    }
}
