package datamanagement;

public class ListUnitsController {
    private UnitManager unitManager_;

    public ListUnitsController() {
        unitManager_ = UnitManager.getInstance();
    }

    public void listUnits(IUnitLister unitLister) {
        unitLister.clearUnits();
        UnitMap unitMap = unitManager_.getUnits();
        for (String unitCode : unitMap.keySet()) {
            unitLister.addUnit(unitMap.get(unitCode));
        }
    }
}
