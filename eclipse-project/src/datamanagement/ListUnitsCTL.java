package datamanagement;

/**
 * Controller class that sources (proxy) Unit objects for the UI.
 *
 */
public class ListUnitsCTL
{
    private UnitManager unitManager;

    public ListUnitsCTL()
    {
        unitManager = UnitManager.getInstance();
    }

    /**
     * Retrieves a map of proxied Units from the UnitManager singleton
     * and provides them to the UI through the IUnitLister interface.
     * @param unitLister The object implementing unitListing (i.e. the UI).
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
