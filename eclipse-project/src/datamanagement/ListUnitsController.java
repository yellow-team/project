package datamanagement;

/**
 * Controller class that sources (proxy) Unit objects for the UI.
 *
 */
public class ListUnitsController
{
    private UnitManager unitManager;

    public ListUnitsController()
    {
        unitManager = UnitManager.getInstance();
    }

    /**
     * Retrieves a map of proxied Units from the UnitManager singleton
     * and provides them to the UI through the IUnitLister interface.
     * @param unitLister
     */
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
