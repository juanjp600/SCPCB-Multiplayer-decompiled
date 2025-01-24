Function createwaypoint.waypoints(arg0.doors, arg1.rooms, arg2#, arg3#, arg4#)
    Local local0.waypoints
    local0 = (New waypoints)
    local0\Field0 = createpivot($00)
    positionentity(local0\Field0, arg2, arg3, arg4, $00)
    If (arg1 <> Null) Then
        entityparent(local0\Field0, arg1\Field2, $01)
    EndIf
    local0\Field2 = arg1
    local0\Field1 = arg0
    Return local0
    Return Null
End Function
