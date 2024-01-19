Function createwaypoint.waypoints(arg0#, arg1#, arg2#, arg3.doors, arg4.rooms)
    Local local0.waypoints
    local0 = (New waypoints)
    local0\Field0 = createpivot($00)
    positionentity(local0\Field0, arg0, arg1, arg2, $00)
    entityparent(local0\Field0, arg4\Field2, $01)
    local0\Field2 = arg4
    local0\Field1 = arg3
    Return local0
    Return Null
End Function
