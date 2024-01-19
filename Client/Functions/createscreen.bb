Function createscreen.screens(arg0#, arg1#, arg2#, arg3$, arg4.rooms)
    Local local0.screens
    local0 = (New screens)
    local0\Field0 = createpivot($00)
    entitypickmode(local0\Field0, $01, $01)
    entityradius(local0\Field0, 0.1, 0.0)
    positionentity(local0\Field0, arg0, arg1, arg2, $00)
    local0\Field1 = arg3
    local0\Field3 = arg4
    entityparent(local0\Field0, arg4\Field2, $01)
    Return local0
    Return Null
End Function
