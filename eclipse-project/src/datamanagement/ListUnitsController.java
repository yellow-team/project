package datamanagement;

public class ListUnitsController
{
    private UnitManager unitManager;

    public ListUnitsController()
    {
        unitManager = UnitManager.getInstance();
    }

    public void listUnits(IUnitLister unitLister)
    {
        unitLister.clearUnits();
        UnitMap unitMap = unitManager.getUnits();
        for (String unitCode : unitMap.keySet())
        {
            unitLister.addUnit(unitMap.get(unitCode));
        }
    }
}
